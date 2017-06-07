package lib_dep;

import objects.JurnalOff;

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
}
