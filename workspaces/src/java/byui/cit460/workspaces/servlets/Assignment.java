/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import byui.cit460.workspaces.data.Person;
import byui.cit460.workspaces.ejb.PersonFacadeRemote;
import byui.cit460.workspaces.ejb.DocumentFacadeRemote;
import byui.cit460.workspaces.exceptions.WorkspacesException;
import byui.cit460.workspaces.javabeans.DocumentList;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.quickconnect.json.JSONException;
import org.quickconnect.json.JSONUtilities;
/**
 *
 * @author starr_000
 */
@WebServlet(name = "Assignment", urlPatterns = {"/Assignment"})
public class Assignment extends HttpServlet {
    
    private DocumentFacadeRemote documentFacade;
    

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
        
        response.setContentType("text/html;charset=UTF-8");
        
        HashMap<String, Object> portalInfo;
        String json = null;

       
        try {  

            // get session from user
             HttpSession session = request.getSession();
             
             BigDecimal personId = (BigDecimal)session.getAttribute("PersonId");
             BigDecimal workspaceId = new BigDecimal(request.getParameter("workspaceId"));
             

            // determine and call the business method
            List<Object>documents = documentFacade.retrieveAssignments(personId, workspaceId);

            JSONUtilities jsonUtil = new JSONUtilities();
            try {
                json = jsonUtil.stringify((Serializable) documents);
            } catch (JSONException ex) {
                ex.printStackTrace();
            }            
            // save the document list in the request attributes to be retrieved
            // by the jsp page building the next view (portal view)
            request.setAttribute("documents", json);
            
            // get a dispatcher for the url of the portal page and forward the
            // the request and response objects to the specified url
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/jsp/portal.jsp");
            dispatcher.forward(request, response);
            
        } catch (WorkspacesException wse) {
            // Error logging in (invalid username and/or password.
            // Save error message as an attribute in the request object
            request.setAttribute("errorMsg", wse.getMessage());
            System.out.println(wse.getMessage());
            
            // get dispatcher for the url of the login page and forward on to that page
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
            
        } catch (Exception jse) { // Unexpected error
            System.out.println(jse.getMessage());
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, jse);
            jse.printStackTrace();
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
