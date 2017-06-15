package objects;

/**
 * Created by Gustovs on 13.06.2017.
 */
public class Klient {
    private int id;
    private int idUser;
    private int idOrganization;

    public Klient() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(int idOrganization) {
        this.idOrganization = idOrganization;
    }
}
