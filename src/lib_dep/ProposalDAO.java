package lib_dep;

import objects.Address;
import objects.Proposal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Gustovs on 06.06.2017.
 */
public class ProposalDAO {

    private static java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }
    private JDBC jdbc = new JDBC();
    private PreparedStatement ps;
    private ResultSet rs;
    private String sqlGetById = "SELECT id, description, idUser, status, answer FROM proposal WHERE idOrganization = ?";
    private String sqlGetUserLust = "SELECT id, idOrganization, description, status, answer FROM proposal WHERE idUser = ?";
    private String sqlAddProposal = "INSERT INTO proposal (idUser, description, dateOpen, status, idOrganization) VALUES (?,?,?,?,?)";
    private String sqlGetZyavka = "SELECT description, idUser, status, answer FROM proposal WHERE id = ?";
    private String sqlUpdate = "UPDATE proposal SET status = ?, answer = ?, responsible = ? WHERE id = ?";

    public int update(int idz, String status, String answer, int worker) throws SQLException{
        ps = jdbc.getCon().prepareStatement(sqlUpdate);
        ps.setString(1, status);
        ps.setString(2, answer);
        ps.setInt(3, worker);
        ps.setInt(4, idz);
        return ps.executeUpdate();
    }

    public Proposal getZyavka(int idz) throws SQLException{
        ps = jdbc.getCon().prepareStatement(sqlGetZyavka);
        ps.setInt(1, idz);
        rs = ps.executeQuery();
        Proposal p = new Proposal();
        if(rs.next()){
            p.setDescription(rs.getString(1));
            p.setIdUser(rs.getInt(2));
            p.setStatus(rs.getString(3));
            p.setAnswer(rs.getString(4));
        }
        return p;
    }

    public ArrayList<Proposal> getListByID(int idOrganization) throws SQLException {
        ArrayList<Proposal> list = new ArrayList<>();
        ps = jdbc.getCon().prepareStatement(sqlGetById);
        ps.setInt(1, idOrganization);
        rs = ps.executeQuery();
        while (rs.next()){
            Proposal p = new Proposal();
            p.setId(rs.getInt(1));
            p.setDescription(rs.getString(2));
            p.setIdUser(rs.getInt(3));
            p.setStatus(rs.getString(4));
            p.setAnswer(rs.getString(5));
            list.add(p);
        }
        return list;
    }

    public String getUserList (String userLog) throws SQLException{

        AccountDAO user = new AccountDAO();
        String result = "";

        ps = jdbc.getCon().prepareStatement(sqlGetUserLust);
        ps.setInt(1, user.getIdUser(userLog));
        rs = ps.executeQuery();

        while (rs.next()){
            String orgName = new OrganizationDAO().getOrganizationById(rs.getInt(2)).getName_Organization();
            Address a = new AddressDAO().getAddressById(new  AccountDAO().getIdUser(userLog));
            String address = a.getCity() +" "+ a.getStreet() +" "+ a.getHome() +" "+ a.getApartment();
            result += rs.getInt(1) +"_"+ orgName +"_"+ rs.getString(3) +"_"+ rs.getString(4) + "_" + address + "_"+ rs.getString(5) + "|";
        }
        return result;
    }

    public boolean addProposal(int user, String description, String status, int idOrganization) throws SQLException{
        ps = jdbc.getCon().prepareStatement(sqlAddProposal);
        ps.setInt(1, user);
        ps.setString(2, description);
        ps.setDate(3, getCurrentDate());
        ps.setString(4, status);
        ps.setInt(5, idOrganization);
        ps.executeUpdate();
        return true;
    }
}
