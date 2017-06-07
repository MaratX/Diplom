package objects;

/**
 * Created by Gustovs on 22.03.2017.
 */
public class Address {
    private int idAddress;
    private String Country;
    private String Region;
    private String City;
    private String District;
    private String Street;
    private String Home;
    private String Apartment;

    public Address() {
    }

    public Address(String country, String region, String city, String district, String street, String home, String apartment) {
        Country = country;
        Region = region;
        City = city;
        District = district;
        Street = street;
        Home = home;
        Apartment = apartment;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public String getCountry() {
        return Country;
    }

    public String getRegion() {
        return Region;
    }

    public String getCity() {
        return City;
    }

    public String getDistrict() {
        return District;
    }

    public String getStreet() {
        return Street;
    }

    public String getHome() {
        return Home;
    }

    public String getApartment() {
        return Apartment;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public void setHome(String home) {
        Home = home;
    }

    public void setApartment(String apartment) {
        Apartment = apartment;
    }
}
