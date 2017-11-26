package com.hksapps.nations;

/**
 * Created by Pranav on 26-11-2017.
 */

public class NationObject {


    private String country;
    private String imageUrl;

    public  void setCountry(String country)
    {
        this.country = country;
    }

    public void setimageUrl(String imageUrl)
    {
        this.imageUrl=imageUrl;
    }

    public String getCountry()
    {
        return country;
    }


    public String getImageUrl()
    {
        return imageUrl;
    }

}
