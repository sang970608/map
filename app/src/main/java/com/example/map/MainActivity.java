package com.example.map;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.map.data.SessionCallback;
import com.kakao.auth.AuthType;
import com.kakao.auth.Session;
import com.kakao.auth.StringSet;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.LoginButton;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;
import com.kakao.usermgmt.callback.UnLinkResponseCallback;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private LoginButton btn_custom_login;
    private Button btn_custom_login_out;
    private SessionCallback sessionCallback = new SessionCallback(this);
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_custom_login = findViewById(R.id.btn);
        btn_custom_login_out = (Button) findViewById(R.id.btn_custom_login_out);

        session = Session.getCurrentSession();
        session.addCallback(sessionCallback);
        Map<String, String> extraParams = new HashMap<>();
        extraParams.put(StringSet.auto_login, "true");
        Session.getCurrentSession().open(AuthType.KAKAO_TALK_ONLY, this, extraParams); //자동 로그인

        btn_custom_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                session.open(AuthType.KAKAO_LOGIN_ALL, MainActivity.this);
            }
        });
        btn_custom_login_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserManagement.getInstance()
                        .requestUnlink(new UnLinkResponseCallback() {
                            @Override
                            public void onSuccess(Long result) {
                                Toast.makeText(getApplicationContext(), "회원탈퇴에 성공했습니다.", Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onSessionClosed(ErrorResult errorResult) {
                                Toast.makeText(getApplicationContext(), "로그인 세션이 닫혔습니다. 다시 로그인해 주세요.", Toast.LENGTH_SHORT).show();

                            }
                        });
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // 세션 콜백 삭제
        Session.getCurrentSession().removeCallback(sessionCallback);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        // 카카오톡|스토리 간편로그인 실행 결과를 받아서 SDK로 전달
        if (Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)) {
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}