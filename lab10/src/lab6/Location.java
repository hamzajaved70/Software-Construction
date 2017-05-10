package lab6;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.bson.types.ObjectId;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.DB;

public class Location {
    private static final String COMMA_DELIMITER = ",";
    List<City> cityList;
    double lat, lon, lat2, lon2;
    Scanner reader;
    
    Mongo mongo;
	DB db;
	DBCollection city;

    
    Location(){
        //Create List for holding City objects
        cityList = new ArrayList<City>();
        reader =  new Scanner(System.in);
        Mongo mongo = new Mongo();
    	DB db = mongo.getDB("admin");
    	DBCollection city = db.getCollection("city");
        
    }
    
    void findLocation(){
        BufferedReader br = null;
        try
        {
            //Reading the csv file
            br = new BufferedReader(new FileReader("GeoLiteCity-Location.csv"));
          
            String line = "";
            //Read to skip the header
            br.readLine();
            //Reading from the second line
            while ((line = br.readLine()) != null) 
            {
                String[] cityDetails = line.split(COMMA_DELIMITER);
                
                if(cityDetails.length > 0 )
                { 
                	City c = new City(Integer.parseInt(cityDetails[0]),
                            cityDetails[1],cityDetails[2],cityDetails[3],
                            cityDetails[4],
                            Double.parseDouble(cityDetails[5]),
                            Double.parseDouble(cityDetails[6])
                            //,Integer.parseInt(employeeDetails[7]),
                            //Integer.parseInt(employeeDetails[8])
                    );
                    cityList.add(c);
                	DBCollection employeeCollection = null ;
                    employeeCollection = db.getCollection(City.c);

                    employeeCollection.save(c);

                    System.err.println(employeeCollection.findOne());
                    //Save the city details in city object
                    
                    
                }
            }
            
            //Lets print the Employee List
            //for(City c : cityList)
            //{
            //    System.out.println(c.getLocId()+"   "+c.getCountry()+"   "
            //    		+c.getRegion()+"   "+c.getCity()+"   "+c.getPostalCode()+"   "
            //                    +c.getLatitude()+"   "+c.getLongitude()+"   "/*+c.getMetroCode()+"   "+c.getAreaCode()*/);
            //}
        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
        finally
        {
            try
            {
                br.close();
            }
            catch(IOException ie)
            {
                System.out.println("Error occured while closing the BufferedReader");
                ie.printStackTrace();
            }
        }
        
        System.out.println("Enter 1 to search by longitude/latitude");
        System.out.println("Enter 2 to search by name:");
        int n = reader.nextInt();
        if (n == 1){
            //String city = "city";
            System.out.println("Enter latitude: ");
            lat = reader.nextFloat();
            System.out.println("Enter longitude: ");
            lon = reader.nextFloat();
            lat = Math.toRadians(lat);
            lon = Math.toRadians(lon);
        }
        if (n == 2){
            System.out.println("Enter the name of the city that you want to search:");
            String city = reader.next();
            for(City c : cityList){
                if (city.equals(c.city)){
                    lat = c.latitude;
                    lon = c.longitude;
                }
            }
            lat = Math.toRadians(lat);
            lon = Math.toRadians(lon);
        }        
        if (n == 1 || n == 2){
            System.out.println("Enter the number of cities that you want in your city's vicinity:");
            int limit = reader.nextInt();
            //int limit = 5;
            int count = 0;
            for(City c : cityList){
                lat2 = c.latitude;
                lon2 = c.longitude;
                double dist = Distance(lon,lat,lon2,lat2);
                if(dist < 2000 && count < limit){
                    count++;
                    System.out.println("Distance from "+c.country+" "+c.city+ "is "+ dist);
                }
            }
        }
    }
    
    double Distance(double lon1, double lat1, double lon2, double lat2){
        double dlon, dlat, a, b, c, d, e, f, g;
        dlon = lon2 - lon1;
        dlat = lat2 - lat1; 
        a = Math.pow(Math.sin(dlat/2),2);
        b = Math.cos(lat1);
        c = Math.cos(lat2);
        d = Math.pow(Math.sin(dlon/2),2);
        e = b * c * d;
        f = a + e;
        g = 2 * Math.asin(Math.sqrt(f))* 6371;
        return g;
    }
    
}
