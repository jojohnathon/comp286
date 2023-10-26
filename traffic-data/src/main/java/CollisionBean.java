import java.util.Date;

import com.opencsv.bean.CsvBindByName;

public class CollisionBean {
    @CsvBindByName(column = "DR Number")
    private String drNum;

    @CsvBindByName(column = "Date Occured")
    private Date date;

    @CsvBindByName(column = "Time Occured")
    private Date time;

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

    public Date getDate() {
        return date;
    }

    public Date getTime() {
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
}
