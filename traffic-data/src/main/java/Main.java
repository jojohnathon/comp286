

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


        try {
            List<CollisionBean> reader = new CsvToBeanBuilder(new FileReader("traffic-data\\src\\main\\resources\\Data.csv"))
                .withType(CollisionBean.class)
                .build()
                .parse();
            
            
            // List<CollisionBean> olderThan25 = reader.parallelStream().filter(person -> person.getAge() > 25).collect(Collectors.toList());
            // System.out.println(olderThan25.size());
            
            
            Map<String, CollisionBean> map = reader.parallelStream()
                .filter(i -> i.getAge() > 0)
                .collect(Collectors.toMap(CollisionBean::getDrNum,item -> item));


            int[] time = new int[2400];
            int[] age = new int[100];
            int[] gender = new int[2];
            map.forEach((k,v) -> {
                time[v.getTime()] += 1; 
                age[v.getAge()] += 1;
                if(v.getSex() == 'M') gender[0] += 1;
                if(v.getSex() == 'F') gender[1] += 1;
                // if(v.getAge() == 0) System.out.println(v.getDrNum());
            });
            System.out.println(graph(time));
            System.out.println(graph(age));
            System.out.println(graph(gender, 5000));
        } catch (Exception e) {
            e.printStackTrace();
        }
        


        ///////////
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }

    public static String graph(int[] arr, int scale){
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= scale) {
                str += i + " | ";
            }
            for (int j = 0; j < (arr[i] / scale); j++) {
                str += "+";
            }
            if (arr[i] >= scale) {
                str += "\n";
            }
        }
        return str;
    }

    public static String graph(int[] arr){
        return graph(arr, 100);
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