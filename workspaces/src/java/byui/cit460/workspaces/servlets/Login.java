/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.servlets;

import byui.cit460.workspaces.data.Person;
import byui.cit460.workspaces.ejb.PersonFacadeRemote;
import byui.cit460.workspaces.exceptions.WorkspacesException;
import byui.cit460.workspaces.javabeans.DocumentList;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

            // get input parameters from the HttpRequest object
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            // determine and call the business method
            portalInfo = personFacade.authenticate(username, password);
            
            // get the person and documents from portalInfo returned
            Person person = (Person) portalInfo.get("person");
            DocumentList documentList = (DocumentList) portalInfo.get("documents");
            
            // create json string for list of documents.
            json = JSONUtilities.stringify(documentList); 
            
            // save the personId in the session attributes for  authentications 
            // on subsequent HTTPRequest
            request.getSession().setAttribute("personId", person.getPersonId());
            
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
