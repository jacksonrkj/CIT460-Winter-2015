/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.servlets;

import byui.cit460.workspaces.data.Person;
import byui.cit460.workspaces.ejb.PersonFacadeRemote;
import byui.cit460.workspaces.ejb.javabeans.DocumentList;
import byui.cit460.workspaces.exceptions.WorkspacesException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.quickconnect.json.JSONException;
import org.quickconnect.json.JSONUtilities;

/**
 *
 * @author jacksonrkj
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @EJB
    private PersonFacadeRemote personFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HashMap<String, Object> portalInfo;
        String json = null;
        try {
            portalInfo = personFacade.authenticate("flintstonef", "pebbles");
            Person person = (Person) portalInfo.get("person");
            DocumentList documentList = (DocumentList) portalInfo.get("documents");
            JSONUtilities jsonUtilities = new JSONUtilities();
            json = jsonUtilities.stringify(documentList);
        } catch (WorkspacesException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
            out.println("<p>" + json + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
