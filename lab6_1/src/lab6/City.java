package lab6;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "City")
@XmlRootElement
public class City {
    @Id 
    @Column(name = "locId")
    int locId;//, metroCode, areaCode;
    @Column(name = "postalCode")
    String postalCode;
    @Column(name = "country")
    String country;
    @Column(name = "region")
    String region;
    @Column(name = "city")
    String city;
    @Column(name = "latitude")
    double latitude;
    @Column(name = "longitude")
    double longitude;
    
    public City(){
        
    }
    public City(int locId, String country, String region, String city,
            String postalCode, double latitude, double longitude/*, int metroCode,int areaCode*/){
        
        this.locId = locId;
        //this.areaCode = areaCode;
        this.city = city;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        //this.metroCode = metroCode;
        this.postalCode = postalCode;
        this.region = region;
    }
    
    public int getLocId(){return locId;}
    public String getPostalCode(){return postalCode;}
    //public int getMetroCode(){return metroCode;}
    //public int getAreaCode(){return areaCode;}
    public double getLatitude(){return latitude;}
    public double getLongitude(){return longitude;}
    public String getCountry(){return country;}
    public String getRegion(){return region;}
    public String getCity(){return city;}
    public void setlocId(int locId){this.locId = locId;}
    public void setPostalCode(String postalCode){this.postalCode = postalCode;}
    //public void setMetroCode(int metroCode){this.metroCode = metroCode;}
    //public void setAreaCode(int areaCode){this.areaCode = areaCode;}
    public void setLatitude(double latitude){this.latitude = latitude;}
    public void setLongitude(double longitude){this.longitude = longitude;}
    public void setCountry(String country){this.country = country;}
    public void setRegion(String region){this.region = region;}
    public void setCity(String city){this.city = city;}
}
