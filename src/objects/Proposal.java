package objects;

/**
 * Created by Gustovs on 06.06.2017.
 */
public class Proposal {
    private int id;
    private String typeProposal;
    private int idUser;
    private String description;
    private int resposible;
    private String dataOpen;
    private String dataClose;
    private String status;
    private String idOrganization;

    public Proposal() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeProposal() {
        return typeProposal;
    }

    public void setTypeProposal(String typeProposal) {
        this.typeProposal = typeProposal;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getResposible() {
        return resposible;
    }

    public void setResposible(int resposible) {
        this.resposible = resposible;
    }

    public String getDataOpen() {
        return dataOpen;
    }

    public void setDataOpen(String dataOpen) {
        this.dataOpen = dataOpen;
    }

    public String getDataClose() {
        return dataClose;
    }

    public void setDataClose(String dataClose) {
        this.dataClose = dataClose;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }
}
