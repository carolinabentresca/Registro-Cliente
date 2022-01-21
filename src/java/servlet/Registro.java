package servlet;

import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;
import modelo.ClienteDao;

public class Registro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ClienteDao dao = new ClienteDao();
        Cliente cliente = new Cliente();
        List<Cliente> lista = new ArrayList();
        boolean respuesta = true;
        RequestDispatcher rd = null;
        try {
            if (request.getParameter("btnRegistrar") != null) {
                cliente.setUsuario(request.getParameter("usuario"));
                cliente.setMail(request.getParameter("mail"));
                cliente.setPassword(request.getParameter("password"));
                respuesta = dao.registrar(cliente);
                request.setAttribute("respuesta", respuesta);
            }
            rd = request.getRequestDispatcher("index.jsp");
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
