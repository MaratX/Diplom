package objects;

/**
 * Created by Gustovs on 17.06.2017.
 */
public class reportWorker {
    private int user;
    private int count = 0;
    private int proposalWork = 0;
    private int proposalClose = 0;

    public reportWorker() {
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getCount() {
        return count;
    }

    public void setCount() {
        this.count++;
    }

    public int getProposalWork() {
        return proposalWork;
    }

    public void setProposalWork() {
        this.proposalWork++;
    }

    public int getProposalClose() {
        return proposalClose;
    }

    public void setProposalClose() {
        this.proposalClose++;
    }
}
