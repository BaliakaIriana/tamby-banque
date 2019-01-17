package servlet;

import dao.GeneriqueDAO;
import model.Client;
import model.Detailcompte;
import model.Mouvement;
import model.ObjetMere;
import service.ClientService;
import service.Fonction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@WebServlet("/depot")
public class DepotServlet extends HttpServlet {

    Fonction fonction = new Fonction();
    ClientService clientService = new ClientService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Client client = (Client) request.getSession().getAttribute("user");
        try {
            fonction.depot(Long.valueOf(request.getParameter("banque")), request.getParameter("montant"), client.getId());
            response.sendRedirect("/Banque/depot");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("page", "depot");
        Client client = (Client) request.getSession().getAttribute("user");
        try {
            request.setAttribute("banques", clientService.getComptesClients(client.getId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/template.jsp").forward(request,response);
    }
}
