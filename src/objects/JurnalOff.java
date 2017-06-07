package objects;

import java.util.Date;

/**
 * Created by Gustovs on 06.06.2017.
 */
public class JurnalOff {
    private int idJurnalOff;
    private int address;
    private String offStart;
    private String offClose;
    private String description;
    private int idOrganization;

    public JurnalOff() {
    }
    public JurnalOff(int address, String offStart, String offClose, String description) {
        this.address = address;
        this.offStart = offStart;
        this.offClose = offClose;
        this.description = description;

    }

    public JurnalOff(int address, String offStart, String offClose, String description, int idOrganization) {
        this.address = address;
        this.offStart = offStart;
        this.offClose = offClose;
        this.description = description;
        this.idOrganization = idOrganization;
    }

    public int getIdJurnalOff() {
        return idJurnalOff;
    }

    public void setIdJurnalOff(int idJurnalOff) {
        this.idJurnalOff = idJurnalOff;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public String getOffStart() {
        return offStart;
    }

    public void setOffStart(String offStart) {
        this.offStart = offStart;
    }

    public String getOffClose() {
        return offClose;
    }

    public void setOffClose(String offClose) {
        this.offClose = offClose;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(int idOrganization) {
        this.idOrganization = idOrganization;
    }
}
