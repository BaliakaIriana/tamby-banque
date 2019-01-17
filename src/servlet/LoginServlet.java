package servlet;

import dao.GeneriqueDAO;
import model.Admin;
import model.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("email");
        String mdp = request.getParameter("password");
        Client client = new Client();
        client.setLogin(login);
        client.setMdp(mdp);
        GeneriqueDAO generiqueDAO = new GeneriqueDAO();
        try {
            List<Client> clients = (List<Client>) (List<?>) generiqueDAO.findWhere(client);
            if(clients.size() != 1){
                Admin admin = new Admin();
                admin.setLogin(login);
                admin.setMdp(mdp);
                List<Admin> admins = (List<Admin>) (List<?>) generiqueDAO.findWhere(admin);
                if(admins.size() != 1){
                    response.sendRedirect("/Banque/login?err=0");
                    return;
                }
                request.getSession().setAttribute("admin", admins.get(0));
            } else {
                request.getSession().setAttribute("user", clients.get(0));
            }
            response.sendRedirect("/Banque/home");
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/template-login.jsp").forward(request, response);
    }
}
