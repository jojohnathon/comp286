

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
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
        int ageSum = 0;
        final long startTime = System.currentTimeMillis();
        try {
            List<CollisionBean> reader = new CsvToBeanBuilder(new FileReader("traffic-data\\src\\main\\resources\\Data.csv"))
                .withType(CollisionBean.class)
                .build()
                .parse();
            Map<String, CollisionBean> map = new HashMap<String, CollisionBean>(reader.size());

            for (CollisionBean b : reader) {
                map.put(b.getDrNum(), b);
                //TODO generate statistics
                ageSum += b.getAge();
                System.out.println(b.getTime());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(ageSum);
        
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
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