

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
        try {
            List<CollisionBean> reader = new CsvToBeanBuilder(new FileReader("traffic-data\\src\\main\\resources\\Data.csv"))
                .withType(CollisionBean.class)
                .build()
                .parse();
            Map<String, CollisionBean> map = new HashMap<String, CollisionBean>(reader.size());
            // DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            HistogramDataset dataset = new HistogramDataset();
            
            List<Double> age = new LinkedList<>();
            for (CollisionBean b : reader) {
                // map.put(b.getDrNum(), b);
                //TODO generate statistics
                // dataset.addValue(4, b.getSex() + "", "Collisions");
                if(b.getAge() > 0) age.add(Double.valueOf(b.getAge()));
            }
            double[] arr = new double[age.size()];
            for (int i = 0; i < arr.length;i++) {
                arr[i] = age.get(i);
            }
            dataset.addSeries("Collisions", arr, 100);

            JFreeChart barChart = ChartFactory.createHistogram("", "Victim Age", "Collisions", dataset, PlotOrientation.VERTICAL, true, false, false);
            File BarChart = new File( "traffic-data\\src\\main\\resources\\BarChart.jpeg");
            ChartUtils.saveChartAsJPEG(BarChart, barChart, 640, 480);
            // System.out.println(map.get("190319680").getDate());
            // System.out.println(map.get("190319680").getTime());
            
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