

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.ws.rs.core.GenericType;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.socrata.api.Soda2Consumer;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Collisions {

    public static final GenericType<List<Collisions>> LIST_TYPE = new GenericType<List<Collisions>>() {};

    final String drNumber;
    // final Date dateReported;
    final Date dateOccured;
    final Date timeOccured;
    // final String areaID;
    // final String areaName;
    // final String reportingDistrict;
    // final String crimeCode;
    // final String crimeCodeDescription;
    // final String moCodes;
    final int victimAge;
    final char victimSex;
    final String victimDescent;
    // final String premiseCode;
    // final String premiseDescription;
    // final String address;
    // final String crossStreet;
    final String coordinates;

    

    @JsonCreator
    public Collisions(@JsonProperty("dr_no") String drNumber,
                      @JsonProperty("date_occ") Date dateOccured,
                      @JsonProperty("time_occ") Date timeOccured,
                      @JsonProperty("vict_age") int victimAge,
                      @JsonProperty("vict_sex") char victimSex,
                      @JsonProperty("vict_descent") String victimDescent,
                      @JsonProperty("location_1") String coordinates) {
        this.drNumber = drNumber;
        this.dateOccured = dateOccured;
        this.timeOccured = timeOccured;
        this.victimAge = victimAge;
        this.victimSex = victimSex;
        this.victimDescent = victimDescent;
        this.coordinates = coordinates;
    }
}
