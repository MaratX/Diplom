package objects;

import java.sql.Date;

/**
 * Created by Gustovs on 06.06.2017.
 */
public class Proposal {
    private int id;
    private String typeProposal;
    private String answer;
    private int idUser;
    private String description;
    private int resposible;
    private Date dataOpen;
    private Date dataClose;
    private String status;
    private String idOrganization;

    public Proposal() {
    }

    public int getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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

    public Date getDataOpen() {
        return dataOpen;
    }

    public void setDataOpen(Date dataOpen) {
        this.dataOpen = dataOpen;
    }

    public Date getDataClose() {
        return dataClose;
    }

    public void setDataClose(Date dataClose) {
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
