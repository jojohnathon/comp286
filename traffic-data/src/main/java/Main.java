

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.ws.rs.core.Response;

import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import com.socrata.api.HttpLowLevel;
import com.socrata.api.Soda2Consumer;
import com.socrata.model.soql.SoqlQuery;

import au.com.bytecode.opencsv.CSVReader;
import io.github.cdimascio.dotenv.Dotenv;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        try {
            List<CollisionBean> reader = new CsvToBeanBuilder(new FileReader("traffic-data\\src\\main\\resources\\Data.csv"))
                .withType(CollisionBean.class)
                .build()
                .parse();
            // String[] nextLine;
            // List<String[]> data = reader.readAll();
            // while((nextLine = reader.readNext()) != null) {
            //     for (String token : nextLine) {
            //         System.out.println(token);
            //         System.out.println("\n");
            //     }
            // }
            for (CollisionBean e : reader) {
                System.out.println(e.getDrNum());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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