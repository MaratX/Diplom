package lib_dep;

import objects.Proposal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Gustovs on 06.06.2017.
 */
public class ProposalDAO {

    private JDBC jdbc = new JDBC();
    private PreparedStatement ps;
    private ResultSet rs;
    private String sqlGetById = "SELECT id, description, idUser, status FROM proposal WHERE idOrganization = ?";

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
            list.add(p);
        }
        return list;
    }
}
