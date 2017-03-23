package lib_dep;

import objects.Organization;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Gustovs on 23.03.2017.
 */
public class OrganizationDAO {
    private JDBC jdbc = new JDBC();
    private PreparedStatement ps;
    private ResultSet rs;
    private String sqlCreateOrganization = "";

    public int createOrganization(Organization organization) throws SQLException{

        return 0;
    }
}
