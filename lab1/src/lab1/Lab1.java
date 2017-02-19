package lab1;
import java.util.Scanner;
import javax.Swing.*;
import java.awt.*;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
public class Lab1 extends Application {
    String youtubevid;
    String content_Url = "<iframe src=\"https://www.youtube.com/watch?v=PVbBLp4d1no\"></iframe>";
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TvManager list = new TvManager();         
        int select = 0;
        while(select!=99)
        {
            System.out.println("1. insert channel");
            System.out.println("2. delete channel");
            System.out.println("3. replace channel"); 
            System.out.println("4. print all channels");
            System.out.println("5. play video");
            System.out.println("99. exit");
            list.insertAtEnd("https://www.youtube.com/watch?v=PVbBLp4d1no");
            list.insertAtEnd("https://www.youtube.com/watch?v=zE_CqZYyKP8");
            list.insertAtEnd("https://www.youtube.com/watch?v=4PY6LXHEppA");
            select = scan.nextInt();            
            switch (select)
            {                          
            case 1 : 
                System.out.println("Enter Channel that you want to insert:");
                list.insertAtEnd( scan.next());                     
                break;                                                                  
            case 2 : 
                System.out.println("Enter Channel Number that you want to delete:");
                int x = scan.nextInt() ;
                if (x < 1 || x > list.getSize() ){
                    System.out.println("Invalid position\n");
                }
                else list.deleteAtPos(x);
                break; 
            case 3 :
                System.out.println("Enter Channel Number that you want to replace:");
                int l = scan.nextInt();
                System.out.println("Enter new Channel name:");
                String newCh = scan.next();
                if (l < 1 || l > list.getSize() ){
                    System.out.println("Invalid position\n");
                }
                else list.replace(newCh, l);
                break;
            case 4 :
                System.out.println("List of All Channels:");
                list.printChannel();
                break;
                
            case 5:
            /////////////////////////////////////////////////////
               System.out.println("Enter Channel number to play"); 
               //youtubevid = list.getURL();
               
               launch();
            /////////////////////////////////////////////////////    
             default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }                   
        }
    }
    

    @Override
    public void start(Stage primaryStage) {
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.loadContent(content_Url);

        StackPane root = new StackPane();
        root.getChildren().add(webView);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Youtube Video lab 1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
