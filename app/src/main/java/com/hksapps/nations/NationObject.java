package com.hksapps.nations;

/**
 * Created by Pranav on 26-11-2017.
 */

public class NationObject {


    private String country;
    private String imageUrl,borders;
    private String region,population,subregion,callingCode,lat_long,timezone,language,capital,area,nativename,numeric_code,currencies;

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


    public  void setRegion(String region)
    {
        this.region = region;
    }

    public String getRegion()
    {
        return region;
    }




    public void setPopulation(String population)
    {
        this.population=population;
    }


    public String getPopulation()
    {
        return population;
    }





    public  void setSubregion(String subregion)
    {
        this.subregion = subregion;
    }

    public String getSubregion()
    {
        return subregion;
    }




    public void setCallingCode(String callingCode)
    {
        this.callingCode=callingCode;
    }


    public String getCallingCode()
    {
        return callingCode;
    }




    public void setLat_long(String lat_long)
    {
        this.lat_long=lat_long;
    }


    public String getLat_long()
    {
        return lat_long;
    }




    public void setTimezone(String timezone)
    {
        this.timezone=timezone;
    }

    public String getTimezone()
    {
        return timezone;
    }



    public void setLanguage(String language)
    {
        this.language=language;
    }

    public String getLanguage()
    {
        return language;
    }




    public void setCapital(String capital)
    {
        this.capital=capital;
    }

    public String getCapital()
    {
        return capital;
    }


    public void setArea(String area)
    {
        this.area=area;
    }

    public String getArea()
    {
        return area;
    }


    public void setNativename(String nativename)
    {
        this.nativename=nativename;
    }

    public String getNativename()
    {
        return nativename;
    }


    public void setNumeric_code(String numeric_code)
    {
        this.numeric_code=numeric_code;
    }

    public String getNumeric_code()
    {
        return numeric_code;
    }



    public void setCurrencies(String currencies)
    {
        this.currencies=currencies;
    }

    public String getCurrencies()
    {
        return currencies;
    }


    public void setBorders(String borders)
    {
        this.borders=borders;
    }

    public String getBorders()
    {
        return borders;
    }

}
