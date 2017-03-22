package objects;

/**
 * Created by Gustovs on 22.03.2017.
 */
public class Organization {
    private int id_Organization;
    private String name_Organization;
    private Address legalAddressOrganization;
    private Address physicalAddressOrganization;
    private int checkingAccountOrganization;

    public Organization(String name_Organization) {
        this.name_Organization = name_Organization;
    }



    public int getId_Organization() {
        return id_Organization;
    }

    public String getName_Organization() {
        return name_Organization;
    }

    public Address getLegalAddressOrganization() {
        return legalAddressOrganization;
    }

    public Address getPhysicalAddressOrganization() {
        return physicalAddressOrganization;
    }

    public int getCheckingAccountOrganization() {
        return checkingAccountOrganization;
    }

    public void setLegalAddressOrganization(Address legalAddressOrganization) {
        this.legalAddressOrganization = legalAddressOrganization;
    }

    public void setPhysicalAddressOrganization(Address physicalAddressOrganization) {
        this.physicalAddressOrganization = physicalAddressOrganization;
    }

    public void setCheckingAccountOrganization(int checkingAccountOrganization) {
        this.checkingAccountOrganization = checkingAccountOrganization;
    }
}
