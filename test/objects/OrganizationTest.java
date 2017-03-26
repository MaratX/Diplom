package objects;

import lib_dep.OrganizationDAO;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
/**
 * Created by Gustovs on 24.03.2017.
 */
public class OrganizationTest {

    @Test
    public void createOrganizationTest(){
        OrganizationDAO organizationDAO = new OrganizationDAO();
        try {
            assertNotNull(organizationDAO.createOrganization("ZAO MurMur", 0000011));
        }catch (SQLException e){
            System.out.println("ERROR " + e);
        }
    }
    @Test
    public void deleteOrganizationTest(){
        OrganizationDAO organizationDAO = new OrganizationDAO();
        try{
            assertEquals(1, organizationDAO.deleteOrganization(2));
        }catch (SQLException e){
            System.out.println("ERROR : " + e);
        }
    }
}
