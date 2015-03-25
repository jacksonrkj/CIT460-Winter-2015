/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.ejb;

import byui.cit460.workspaces.data.Document;
import byui.cit460.workspaces.data.Workspace;
import byui.cit460.workspaces.data.Person;
import byui.cit460.workspaces.exceptions.WorkspacesException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.ejb.Stateless;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.quickconnect.json.JSONException;
import org.quickconnect.json.JSONUtilities;
/**
 *
 * @author jacksonrkj
 */
@Stateless
public class DocumentFacade extends AbstractFacade<Document> implements DocumentFacadeRemote {
    @PersistenceContext(unitName = "WorkSpacesEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocumentFacade() {
        super(Document.class);
    }
 
    public String retrieveAssignments(Person user, Workspace workspace) throws WorkspacesException {
        
        if (workspace == null) {
            throw new WorkspacesException("Invalid section");
        }
        
        ArrayList<Object> assignments;
        
        Query queryAssignments = em.createQuery("SELECT document_id, document_no, short_descr, doc_text, doc_url, version_no FROM Document AS d"
                + "INNER JOIN d.references as r"
                + "INNER JOIN r.workspace as w"
                + "WHERE w.workspace_id = :workspaceId "
                + "AND d.context_type = 'CTAS' "
                + "ORDER BY r.displayOrder");
        
        queryAssignments.setParameter("workspaceId", workspace.getWorkspaceId());
        
        try{
           assignments = (ArrayList<Object>) queryAssignments.getResultList();
        }
        catch (Exception e) { // catch all other exceptions and throw custom exception
            throw new WorkspacesException(e.getMessage());
        }
        
        PortalInfo portalInfo = new PortalInfo();
        portalInfo.setPersonId(user.getPersonId());
        portalInfo.getDocuments().put(workspace.getDescription(), assignments);
        String json;
        try {
            json = portalInfo.toJson();
        } catch (JSONException ex) {
            throw new WorkspacesException(ex.getMessage());
        }
        
        return json;
        
    }
        class PortalInfo implements Serializable {

        private BigDecimal personId; 
        private HashMap<String, ArrayList<Object>> documents = new HashMap<>();     

        public PortalInfo() {
        }

        public BigDecimal getPersonId() {
            return personId;
        }

        public void setPersonId(BigDecimal personId) {
            this.personId = personId;
        }


        

        public HashMap<String, ArrayList<Object>> getDocuments() {
            return documents;
        }

        public void setDocuments(HashMap<String, ArrayList<Object>> documents) {
            this.documents = documents;
        }

        
        public String toJson() throws JSONException {
            JSONUtilities jsonUtiltities = new JSONUtilities();
            String jsonString = jsonUtiltities.stringify(this);
            return jsonString;
        }
        
        
    }
}
