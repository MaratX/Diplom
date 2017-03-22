package lib_dep;

import objects.Address;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Gustovs on 22.03.2017.
 */
public class AddressDAO {
    private JDBC jdbc = new JDBC();
    private PreparedStatement ps;
    private ResultSet rs;
    private String sqlGreatAddress = "INSERT INTO address (country, region, city, district, street, home, apartment) VALUES (?,?,?,?,?,?,?)";
    private String sqlGetAddressById = "SELECT country, region, city, district, street, home, apartment FROM address WHERE id = ?";

    public void greatAddress(Address address){
        try {
            ps = jdbc.getCon().prepareStatement(sqlGreatAddress);
            ps.setString(1, address.getCountry());
            ps.setString(2, address.getRegion());
            ps.setString(3, address.getCity());
            ps.setString(4, address.getDistrict());
            ps.setString(5, address.getStreet());
            ps.setString(6, address.getHome());
            ps.setString(7, address.getApartment());
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println("ERROR : " + e);
        }
    }
    public Address getAddressById(int id){
        Address address = new Address();
        try{
            ps = jdbc.getCon().prepareStatement(sqlGetAddressById);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()){
                address.setIdAddress(id);
                address.setCountry(rs.getString(1));
                address.setRegion(rs.getString(2));
                address.setCity(rs.getString(3));
                address.setDistrict(rs.getString(4));
                address.setStreet(rs.getString(5));
                address.setHome(rs.getString(6));
                address.setApartment(rs.getString(7));
            }
            rs.close();
            return address;

        }catch (SQLException e){
            System.out.println("ERROR : " + e);
        }
        return null;
    }
}
