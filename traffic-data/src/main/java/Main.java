

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import javax.ws.rs.core.Response;

import com.socrata.api.HttpLowLevel;
import com.socrata.api.Soda2Consumer;
import com.socrata.model.soql.SoqlQuery;

import io.github.cdimascio.dotenv.Dotenv;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // Collisions wow = new Collisions();
        Scanner sc;
        try {
            sc = new Scanner(new File("traffic-data\\src\\main\\resources\\Data.csv"));
            sc.useDelimiter(",");
            while(sc.hasNext()) {
                System.out.println(sc.next());
            }
            sc.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            // getData();
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

    public static void getData() throws Exception {

        final Properties config = new Properties();
        config.load(Main.class.getResourceAsStream("config.properties"));
        // Dotenv config = Dotenv.configure().load();
        // Soda2Consumer consumer = Soda2Consumer.newConsumer(null, null, null, null);
        Soda2Consumer consumer = Soda2Consumer.newConsumer(
            "https://data.lacity.org/resource/d5tf-ez2w.json", 
            config.getProperty("USERNAME"), 
            config.getProperty("PASSWORD"), 
            config.getProperty("TOKEN"));
        System.out.println(config.get("URL"));
        // List<Collisions> collisions = consumer.query("d5tf-ez2w", SoqlQuery.SELECT_ALL, Collisions.LIST_TYPE);
        Response response = consumer.query("d5tf-ez2w", HttpLowLevel.JSON_TYPE, SoqlQuery.SELECT_ALL);
        String paylod = response.readEntity(String.class);
        System.out.println(paylod.length());
        // System.out.println(collisions.size());
    }
    
}