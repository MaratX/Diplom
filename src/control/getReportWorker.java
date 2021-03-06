package control;

import DAO.AccountDAO;
import DAO.MyCompanyDAO;
import DAO.ProposalDAO;
import objects.Proposal;
import objects.reportWorker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Gustovs on 16.06.2017.
 */
@WebServlet(name = "reportWorker", value = "/reportWorker")
public class getReportWorker extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            resp.setCharacterEncoding("UTF-8");
            PrintWriter pw = resp.getWriter();
            String [] idOrg = req.getParameter("idOrg").split("#");
            ArrayList<Integer> worker = new MyCompanyDAO().listWorker(Integer.parseInt(idOrg[0]));
            ArrayList<Proposal> proposalWorker = new ProposalDAO().listProposalWorker(worker, Integer.parseInt(idOrg[0]));
            ArrayList<reportWorker> list = new ArrayList<>();
            for(Proposal p : proposalWorker){
                int userIndex = -1;
                for(int i = 0; i < list.size(); i++){
                    if(list.get(i).getUser() == p.getResposible()){
                        userIndex = i;
                    }
                }
                if(userIndex > -1){
                    reportWorker rp = list.get(userIndex);
                    rp.setCount();
                    if(p.getStatus().equals("закрыт")){
                        rp.setProposalClose();
                    }else{
                        rp.setProposalWork();
                    }
                    list.set(userIndex, rp);
                }else {
                    reportWorker pr = new reportWorker();
                    pr.setUser(p.getResposible());
                    pr.setCount();
                    if(p.getStatus().equals("закрыт")){
                        pr.setProposalClose();
                    }else{
                        pr.setProposalWork();
                    }
                    list.add(pr);
                }
            }
            String result = "";
            for(reportWorker rp : list){
                result += new AccountDAO().getLoginUser(rp.getUser()) + "_" + rp.getCount() + "_" + rp.getProposalWork() + "_" + rp.getProposalClose() + "|";
            }
            pw.print(result);
        }catch (SQLException e){
            System.out.print("Error " + e);
        }
    }
}
