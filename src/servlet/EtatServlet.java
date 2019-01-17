package servlet;

import model.Client;
import model.Detailcompte;
import service.ClientService;
import service.Fonction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@WebServlet("/etat")
public class EtatServlet extends HttpServlet {
    Fonction fonction = new Fonction();
    ClientService clientService = new ClientService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("page", "etat");
        String debut = request.getParameter("debut");
        String fin = request.getParameter("fin");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
        Calendar calendar = (Calendar) Calendar.getInstance().clone();
        Date now = calendar.getTime();
        calendar.add(Calendar.YEAR, -1);
        Date before = calendar.getTime();
        Client client = (Client) request.getSession().getAttribute("user");
        if (debut == null) debut = sdf.format(before);
        if (fin == null) fin = sdf.format(now);
        try {
            List<Detailcompte> comptes = clientService.getComptesClients(client.getId());
            if(comptes.isEmpty()){
                throw new Exception("Tsy manana compte ianao");
            }
            request.setAttribute("comptes", comptes);
            Long idcompte;
            if (request.getParameter("compte") != null) {
                idcompte = Long.valueOf(request.getParameter("compte"));
            } else {
                idcompte = comptes.get(0).getId();
            }
            request.setAttribute("solde", fonction.getSoldeBetweenTwoDates(debut, fin, idcompte));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/template.jsp").forward(request, response);
    }
}
