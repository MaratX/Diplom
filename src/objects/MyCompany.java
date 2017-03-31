package objects;

/**
 * Created by Gustovs on 31.03.2017.
 */
public class MyCompany {
    private int IdMyCompany = 0;
    private int IdUser = 0;
    private int IdOrganization = 0;

    public MyCompany(){

    }

    public MyCompany(int idMyCompany, int idUser, int idOrganization) {
        IdMyCompany = idMyCompany;
        IdUser = idUser;
        IdOrganization = idOrganization;
    }

    public int getIdMyCompany() {
        return IdMyCompany;
    }

    public void setIdMyCompany(int idMyCompany) {
        IdMyCompany = idMyCompany;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int idUser) {
        IdUser = idUser;
    }

    public int getIdOrganization() {
        return IdOrganization;
    }

    public void setIdOrganization(int idOrganization) {
        IdOrganization = idOrganization;
    }
}
