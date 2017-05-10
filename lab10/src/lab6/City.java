package lab6;
import com.mongodb.BasicDBObject;


public class City extends BasicDBObject {
    int locId;//, metroCode, areaCode;
    String postalCode;
    String country;
    String region;
    String city;
    double latitude;
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
