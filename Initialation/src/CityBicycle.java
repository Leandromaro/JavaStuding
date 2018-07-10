import java.time.LocalDate;

public class CityBicycle extends Bicycle {

    public static int numberOfCityBycycle;
    public static LocalDate lastCreationalByciceDate;


    static {
        Bicycle.bycicleQuantity++;
        numberOfCityBycycle++;
        lastCreationalByciceDate = LocalDate.now();
    }
}
