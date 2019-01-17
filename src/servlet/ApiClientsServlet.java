package servlet;

import com.google.gson.Gson;
import service.ClientService;
import service.Fonction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

@WebServlet("/api/clients")
public class ApiClientsServlet extends HttpServlet {
    Fonction fonction = new Fonction();
    ClientService clientService = new ClientService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        try {
            writer.write(new Gson().toJson(clientService.getComptesClients(Long.valueOf(request.getParameter("id")))));
        } catch (Exception e) {
            e.printStackTrace();
        }
        writer.close();
    }
}
