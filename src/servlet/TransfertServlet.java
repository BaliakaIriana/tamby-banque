package servlet;

import model.Client;
import service.ClientService;
import service.Fonction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/transfert")
public class TransfertServlet extends HttpServlet {
    Fonction fonction = new Fonction();
    ClientService clientService = new ClientService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Client client = (Client) request.getSession().getAttribute("user");
        try {
            fonction.transfert(Double.valueOf(request.getParameter("montant")), Long.valueOf(request.getParameter("bsend")), Long.valueOf(request.getParameter("bdest")), client.getId(), Long.valueOf(request.getParameter("dest")));
            response.sendRedirect("/Banque/transfert?err=0");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/Banque/transfert?err=1&msg=" + e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("page", "transfert");
        Client client = (Client) request.getSession().getAttribute("user");
        try {
            request.setAttribute("banques", clientService.getComptesClients(client.getId()));
            request.setAttribute("clients",clientService.getAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/template.jsp").forward(request,response);
    }
}
