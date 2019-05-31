import factory.CountryFactory;
import model.Country;

public class Main02 {
    public static void main(String[] args){
        Country country = CountryFactory.getCountryInstance();
        country.say();
    }
}
