package lib_dep;

import objects.Address;
import objects.Organization;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Gustovs on 23.03.2017.
 */
public class OrganizationDAO {
    private JDBC jdbc = new JDBC();
    private PreparedStatement ps;
    private ResultSet rs;
    private AddressDAO addressDAO = new AddressDAO();
    private String sqlCreateOrganization = "INSERT INTO organization (name, legalAddressOrganization, pshycalAddressOrganization, checkingAccountOrganization) VALUES (?,?,?,?)";
    private String sqlDeleteOrganization = "DELETE FROM organization WHERE id = ?";
    private String sqlGetOrganizationById = "SELECT name, legalAddressOrganization, pshycalAddressOrganization, checkingAccountOrganization FROM organization WHERE id = ?";

    public int createOrganization(String name, int CheckingAccountOrganization) throws SQLException{
        ps = jdbc.getCon().prepareStatement(sqlCreateOrganization, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, name);
        ps.setInt(2, addressDAO.createAddress(new Address()));
        ps.setInt(3, addressDAO.createAddress(new Address()));
        ps.setInt(4, CheckingAccountOrganization);
        ps.executeUpdate();
        rs = ps.getGeneratedKeys();
        if(rs.next()){
            return rs.getInt(1);
        }
        return -1;
    }

    public int deleteOrganization(int id) throws SQLException{
        AddressDAO accountDAO = new AddressDAO();
        Organization organization = getOrganizationById(id);
        accountDAO.deleteAddressById(organization.getLegalAddressOrganization());
        accountDAO.deleteAddressById(organization.getPhysicalAddressOrganization());
        ps = jdbc.getCon().prepareStatement(sqlDeleteOrganization);
        ps.setInt(1, id);
        return ps.executeUpdate();
    }

    public Organization getOrganizationById(int idOrganization) throws SQLException{
        Organization organization = new Organization();
        ps = jdbc.getCon().prepareStatement(sqlGetOrganizationById);
        ps.setInt(1, idOrganization);
        rs = ps.executeQuery();
        if(rs.next()){
            organization.setName_Organization(rs.getString(1));
            organization.setLegalAddressOrganization(rs.getInt(2));
            organization.setPhysicalAddressOrganization(rs.getInt(3));
            organization.setCheckingAccountOrganization(rs.getInt(4));
        }
        return organization;
    }

}
