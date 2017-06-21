package DAO;

import objects.Address;
import objects.Proposal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    private String sqlWorkerProposal = "SELECT status, responsible, dateOpen, dateClose FROM proposal WHERE responsible = ? AND idOrganization = ?";
    private String sqlKlientProposal = "SELECT status, idUser, dateOpen, dateClose FROM proposal WHERE idUser = ? AND idOrganization = ?";

    public ArrayList<Proposal> listProposalKlient(ArrayList<Integer> listKlient, int idOrg) throws SQLException{
        ArrayList<Proposal> list = new ArrayList<>();
        for(int i : listKlient){
            ps = jdbc.getCon().prepareStatement(sqlKlientProposal);
            ps.setInt(1, i);
            ps.setInt(2, idOrg);
            rs = ps.executeQuery();
            while (rs.next()){
                Proposal p = new Proposal();
                p.setStatus(rs.getString(1));
                p.setIdUser(rs.getInt(2));
                p.setDataOpen(rs.getDate(3));
                p.setDataClose(rs.getDate(4));
                list.add(p);
            }
        }
        return list;
    }

    public ArrayList<Proposal> listProposalWorker(ArrayList<Integer> listWorker, int idOrg) throws SQLException{
        ArrayList<Proposal> list = new ArrayList<>();
        for(int i : listWorker){
            ps = jdbc.getCon().prepareStatement(sqlWorkerProposal);
            ps.setInt(1, i);
            ps.setInt(2, idOrg);
            rs = ps.executeQuery();
            while (rs.next()){
                Proposal p = new Proposal();
                p.setStatus(rs.getString(1));
                p.setResposible(rs.getInt(2));
                p.setDataOpen(rs.getDate(3));
                p.setDataClose(rs.getDate(4));
                list.add(p);
            }
        }
        return list;
    }

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
        int i = user.getIdUser(userLog);

        while (rs.next()){
            String orgName = new OrganizationDAO().getOrganizationById(rs.getInt(2)).getName_Organization();
            Address a = new AddressDAO().getAddressById(new  AccountDAO().getAdress(userLog));
            String address = a.getCity() +" "+ a.getStreet() +" "+ a.getHome() +" "+ a.getApartment();
            String answer = "";
            if(rs.getString(5) != null){
                answer = rs.getString(5);
            }
            result += rs.getInt(1) +"_"+ orgName +"_"+ rs.getString(3) +"_"+ rs.getString(4) + "_" + address + "_"+ answer + "|";
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
