package DAO;

import objects.Address;
import objects.Organization;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
    private String sqlIsOrganization = "SELECT name FROM organization WHERE name = ?";
    private String sqlGetId = "SELECT id FROM organization WHERE name = ?";
    private String sqlGetNameOrg = "SELECT name FROM organization WHERE id = ?";

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

    public int getIdOrganization(String name) throws SQLException{
        ps = jdbc.getCon().prepareStatement(sqlGetId);
        ps.setString(1, name);
        rs = ps.executeQuery();
        int id = -1;
        if(rs.next()){
            id = rs.getInt(1);
        }
        return id;
    }

    public String getListName (String login) throws SQLException{
        ArrayList<Integer> list = new KlientDAO().getListIdOrganization(login);
        String result = "";
        for(int i : list){
            ps = jdbc.getCon().prepareStatement(sqlGetNameOrg);
            ps.setInt(1, i);
            rs = ps.executeQuery();
            if(rs.next()){
                result += rs.getString(1) + "_";
            }
        }

        return result;
    }

    public boolean isOrganization(String nameOrganization)throws SQLException{
        ps = jdbc.getCon().prepareStatement(sqlIsOrganization);
        ps.setString(1, nameOrganization);
        rs = ps.executeQuery();
        if(rs.next()){
            if(nameOrganization.equals(rs.getString(1))){
                return true;
            }
        }
        return false;
    }

}
