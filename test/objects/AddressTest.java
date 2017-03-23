package objects;


import lib_dep.AddressDAO;
import org.junit.*;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Gustovs on 23.03.2017.
 */
public class AddressTest {

    @Test
    public void createAddressTest(){
        Address address = new Address();
        address.setCountry("rus");
        address.setRegion("tat");
        address.setCity("nab");
        address.setDistrict("new");
        address.setStreet("usman");
        address.setHome("129");
        address.setApartment("12");
        AddressDAO addressDAO = new AddressDAO();
        assertNotNull(addressDAO.createAddress(address));
    }

    @Test
    public void getAddressByIdTest(){
        AddressDAO addressDAO = new AddressDAO();
        Address address = addressDAO.getAddressById(13);
        assertEquals("rus",address.getCountry());

    }

    @Test
    public void updateAddressByIdTest(){
        Address address = new Address();
        address.setIdAddress(1);
        AddressDAO addressDAO = new AddressDAO();
        assertEquals(1, addressDAO.updateAddressById(address));
    }

    @Test
    public void deleteAddressById(){
        AddressDAO addressDAO = new AddressDAO();
        try {
            assertEquals(1, addressDAO.deleteAddressById(1));
        }catch (SQLException e){
            System.out.println("ERROR + " + e);
        }
    }
}
