package lab7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Analysis {
    
    private static final String COMMA_DELIMITER = ",";
    List<Authentication> authList;
    double lat, lon, lat2, lon2;
    Scanner reader;
    Configuration cfg;
    ServiceRegistry serviceRegistry;
    SessionFactory factory;
    
    Analysis(){
        //Create List for holding City objects
        authList = new ArrayList<Authentication>();
        reader =  new Scanner(System.in);
        cfg = new Configuration();
        //cfg.configure("hibernate.cfg.xml");
        cfg.configure("/main/resources/hibernate.cfg.xml"); 
        //cfg.addClass(Lab6.City);
        cfg.addAnnotatedClass(Authentication.class);
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()). build();
        factory = cfg.buildSessionFactory(serviceRegistry);
    }
    
    void authenticate(){
        BufferedReader br = null;
        try
        {
            //Reading the csv file
            br = new BufferedReader(new FileReader("test_two-anon.csv"));
          
            String line = "";
            //Read to skip the header
            br.readLine();
            //Reading from the second line
            while ((line = br.readLine()) != null) 
            {
                String[] cityDetails = line.split(COMMA_DELIMITER);
                
                if(cityDetails.length > 0 )
                {
                    //creating transaction object
                    try (Session session = factory.openSession()) {
                        //creating transaction object
                        Transaction t=session.beginTransaction();
                        
                        Authentication auth = new Authentication();
                        
                        
                        authList.add(auth);
                        session.save(auth);//saving the object
                        t.commit();//transaction is commited  
                    }
                    
                }
            }
            
        }
        catch(IOException | HibernateException ee)
        {
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
            }
        }
    }
}
