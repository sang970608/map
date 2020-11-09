package com.example.map.data;

public class SearchItem
{
    private Documents[] documents;

    public Documents[] getDocuments ()
    {
        return documents;
    }

    public void setDocuments (Documents[] documents)
    {
        this.documents = documents;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [documents = "+documents+"]";
    }
}
class Documents
{
    private String place_url;

    private String place_name;

    private String distance;

    private String phone;

    private String x;

    private String y;

    private String address_name;

    public String getPlace_url ()
    {
        return place_url;
    }

    public void setPlace_url (String place_url)
    {
        this.place_url = place_url;
    }

    public String getPlace_name ()
    {
        return place_name;
    }

    public void setPlace_name (String place_name)
    {
        this.place_name = place_name;
    }

    public String getDistance ()
    {
        return distance;
    }

    public void setDistance (String distance)
    {
        this.distance = distance;
    }

    public String getPhone ()
    {
        return phone;
    }

    public void setPhone (String phone)
    {
        this.phone = phone;
    }

    public String getX ()
    {
        return x;
    }

    public void setX (String x)
    {
        this.x = x;
    }

    public String getY ()
    {
        return y;
    }

    public void setY (String y)
    {
        this.y = y;
    }

    public String getAddress_name ()
    {
        return address_name;
    }

    public void setAddress_name (String address_name)
    {
        this.address_name = address_name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [place_url = "+place_url+", place_name = "+place_name+", distance = "+distance+", phone = "+phone+", x = "+x+", y = "+y+", address_name = "+address_name+"]";
    }
}