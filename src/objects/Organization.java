package objects;

/**
 * Created by Gustovs on 22.03.2017.
 */
public class Organization {
    private int id_Organization;
    private String name_Organization;
    private int legalAddressOrganization;
    private int physicalAddressOrganization;
    private int checkingAccountOrganization;

    public Organization(String name_Organization) {
        this.name_Organization = name_Organization;
    }

    public Organization(){

    }


    public int getId_Organization() {
        return id_Organization;
    }

    public String getName_Organization() {
        return name_Organization;
    }

    public int getLegalAddressOrganization() {
        return legalAddressOrganization;
    }

    public int getPhysicalAddressOrganization() {
        return physicalAddressOrganization;
    }

    public int getCheckingAccountOrganization() {
        return checkingAccountOrganization;
    }

    public void setLegalAddressOrganization(int legalAddressOrganization) {
        this.legalAddressOrganization = legalAddressOrganization;
    }

    public void setPhysicalAddressOrganization(int physicalAddressOrganization) {
        this.physicalAddressOrganization = physicalAddressOrganization;
    }

    public void setCheckingAccountOrganization(int checkingAccountOrganization) {
        this.checkingAccountOrganization = checkingAccountOrganization;
    }

    public void setName_Organization(String name_Organization) {
        this.name_Organization = name_Organization;
    }
}
