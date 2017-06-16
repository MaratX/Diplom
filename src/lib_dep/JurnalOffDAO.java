package lib_dep;

import objects.Address;
import objects.JurnalOff;
import objects.Organization;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Gustovs on 06.06.2017.
 */
public class JurnalOffDAO {
    private JDBC jdbc = new JDBC();
    private PreparedStatement ps;
    private ResultSet rs;

    private String sqlAddJurnalOff = "INSERT INTO journalOff (address, offStart, offClose, description, idOrganization) VALUES (?,?,?,?,?)";
    private String sqlListJurnalOff = "SELECT idJournalOff, description, address, offStart, offClose FROM journaloff WHERE idOrganization = ?";
    private String sqlUserListJornalOff = "SELECT idJournalOff, description, idOrganization, offStart, offClose FROM journaloff WHERE idOrganization IN  (SELECT idOrganization FROM mycompany WHERE idUser = ?);";
    private String sqlGetJurnal = "SELECT address, offStart, offClose, description FROM journaloff WHERE idJournalOff = ?";
    private String sqlUpdate = "UPDATE journaloff SET offStart = ?, offClose = ?, description = ? WHERE idJournalOff = ?";
    private String sqlGetAddress = "SELECT address FROM journaloff WHERE idJournalOff = ?";

    public int getAddress(int id) throws SQLException{
        ps = jdbc.getCon().prepareStatement(sqlGetAddress);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        if(rs.next()){
            return rs.getInt(1);
        }
        return -1;
    }

    public int updateJurnal(int id, Date start, Date close, String desc) throws SQLException{
        ps = jdbc.getCon().prepareStatement(sqlUpdate);
        ps.setDate(1, start);
        ps.setDate(2, close);
        ps.setString(3, desc);
        ps.setInt(4, id);
        return ps.executeUpdate();
    }

    public String getJurnal (int id) throws SQLException{
        String result = "";
        ps = jdbc.getCon().prepareStatement(sqlGetJurnal);
        ps.setInt(1, id);
        rs = ps.executeQuery();

        if(rs.next()) {
            Address a = new AddressDAO().getAddressById(rs.getInt(1));
            result += id + "_" + a.getCity() + "_" + a.getStreet() + "_" + a.getHome() + "_" + rs.getDate(2) + "_" + rs.getDate(3) + "_" + rs.getString(4);
        }
        return result;
    }

    public int AddJurnalOff(JurnalOff jurnalOff) throws SQLException{
            ps = jdbc.getCon().prepareStatement(sqlAddJurnalOff, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, jurnalOff.getAddress());
            ps.setString(2,  jurnalOff.getOffStart());
            ps.setString(3,  jurnalOff.getOffClose());
            ps.setString(4, jurnalOff.getDescription());
            ps.setInt(5, jurnalOff.getIdOrganization());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if(rs.next()){
                return rs.getInt(1);
            }
        return -1;
    }

    public ArrayList<JurnalOff> getListJurnalOff(int idOrganization) throws SQLException{
        ArrayList<JurnalOff> list = new ArrayList<>();
        ps = jdbc.getCon().prepareStatement(sqlListJurnalOff);
        ps.setInt(1, idOrganization);
        rs = ps.executeQuery();
        while (rs.next()){
            JurnalOff j = new JurnalOff();
            j.setIdJurnalOff(rs.getInt(1));
            j.setDescription(rs.getString(2));
            j.setAddress(rs.getInt(3));
            j.setOffStart(rs.getString(4));
            j.setOffClose(rs.getString(5));
            list.add(j);
        }
        return list;
}

    public String getListUserJurnalOff (String login) throws SQLException{
        AccountDAO accountDAO = new AccountDAO();
        OrganizationDAO organizationDAO = new OrganizationDAO();

        ps = jdbc.getCon().prepareStatement(sqlUserListJornalOff);
        ps.setInt(1, accountDAO.getIdUser(login));
        rs = ps.executeQuery();
        String result = "";
        while (rs.next()){
            Organization or = organizationDAO.getOrganizationById(rs.getInt(3));
            result += (rs.getInt(1) + "_" + rs.getString(2) + "_" + or.getName_Organization() + "_" + rs.getString(4) + "_" + rs.getString(5) + "|");
        }

        return result;
    }


}
