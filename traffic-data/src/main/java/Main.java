

import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.ws.rs.core.Response;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.statistics.HistogramDataset;

import com.opencsv.bean.CsvToBeanBuilder;
import com.socrata.api.HttpLowLevel;
import com.socrata.api.Soda2Consumer;
import com.socrata.model.soql.SoqlQuery;

public class Main {
    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        //////


        int[] time = new int[2400];
        try {
            List<CollisionBean> reader = new CsvToBeanBuilder(new FileReader("traffic-data\\src\\main\\resources\\Data.csv"))
                .withType(CollisionBean.class)
                .build()
                .parse();

    
            List<CollisionBean> olderThan25 = reader.parallelStream().filter(person -> person.getAge() > 25).collect(Collectors.toList());
            System.out.println(olderThan25.size());


            Map<String, CollisionBean> map = reader.parallelStream().collect(Collectors.toMap(CollisionBean::getDrNum,item -> item));
            map.forEach((k,v) -> time[v.getTime()] += 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println(graph(time));


        ///////////
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }

    public static String graph(int[] arr){
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 100) {
                str += i + " | ";
            }
            for (int j = 0; j < (arr[i] / 100); j++) {
                str += "+";
            }
            if (arr[i] >= 100) {
                str += "\n";
            }
        }
        return str;
    }



    // public static void getData() throws Exception {

    //     final Properties config = new Properties();
    //     config.load(Main.class.getResourceAsStream("config.properties"));
    //     // Dotenv config = Dotenv.configure().load();
    //     // Soda2Consumer consumer = Soda2Consumer.newConsumer(null, null, null, null);
    //     Soda2Consumer consumer = Soda2Consumer.newConsumer(
    //         "https://data.lacity.org/resource/d5tf-ez2w.json", 
    //         config.getProperty("USERNAME"), 
    //         config.getProperty("PASSWORD"), 
    //         config.getProperty("TOKEN"));
    //     System.out.println(config.get("URL"));
    //     // List<Collisions> collisions = consumer.query("d5tf-ez2w", SoqlQuery.SELECT_ALL, Collisions.LIST_TYPE);
    //     Response response = consumer.query("d5tf-ez2w", HttpLowLevel.JSON_TYPE, SoqlQuery.SELECT_ALL);
    //     String paylod = response.readEntity(String.class);
    //     System.out.println(paylod.length());
    //     // System.out.println(collisions.size());
    // }

    
    
}