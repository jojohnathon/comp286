import java.util.Date;

import com.opencsv.bean.CsvBindByName;

public class CollisionBean {
    @CsvBindByName(column = "DR Number")
    private String drNum;

    @CsvBindByName(column = "Date Occurred")
    private String date;

    @CsvBindByName(column = "Time Occurred")
    private String time;

    @CsvBindByName(column = "Victim Age")
    private int age;

    @CsvBindByName(column = "Victim Sex")
    private char sex;

    @CsvBindByName(column = "Victim Descent")
    private char descent;

    @CsvBindByName(column = "Location")
    private String location;

    public String getDrNum() {
        return drNum;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getAge() {
        return age;
    }

    public char getSex() {
        return sex;
    }

    public char getDescent() {
        return descent;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "";
    }
}
