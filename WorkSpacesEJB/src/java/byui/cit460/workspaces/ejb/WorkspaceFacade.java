/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.ejb;

import byui.cit460.workspaces.data.Workspace;
import com.google.gson.Gson;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jacksonrkj
 */
@Stateless
public class WorkspaceFacade extends AbstractFacade<Workspace> implements byui.cit460.workspaces.ejb.WorkspaceFacadeRemote {
    @PersistenceContext(unitName = "WorkSpacesEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WorkspaceFacade() {
        super(Workspace.class);
    }
    
    
     /**
     * Get all documents defined for the specified workspace
     * @param workspaceId
     * @return A JSON string containg document descriptions for all documents 
     *         found.
     */
    @Override
    public String getWorkSpaceDocuments(BigDecimal workspaceId) {
        if (workspaceId == null) {
            return null;
        }
        
//        Query query = this.em.createQuery(
//                "select DISTINCT d.docType, d.contextType, d.shortDescr from Reference AS r "
//              + "inner join r.document AS d "
//              + "where r.workspace.workspaceId = :workspaceId "
//              + "ORDER BY d.contextType"
//              );
        Query query = this.em.createQuery(
                "select DISTINCT d from ReferenceAS r "
              + "inner join r.document AS d "
              + "where r.workspace.workspaceId = :workspaceId "           
              );
        
        query.setParameter("workspaceId", workspaceId);
        
       Collection<Object> documents = query.getResultList();
        
       String jsonString = createDocumentDescriptions(documents);
       
       return jsonString;
        
    }
    
     /**
     * Get all documents for the portal for the specified person
     * @param personId
     * @return A JSON string containing document descriptions for all documents 
     *         found.
     */
    @Override
    public String getPortalDocuments(BigDecimal personId) {
        if (personId == null) {
            return null;
        }
        
        Query query = this.em.createQuery(
                "select DISTINCT r.document"
              + "from Reference AS r "
              + "inner join r.workspace AS w " 
              + "inner join w.membershipCollection AS m "          
              + "where m.membershipPK.personId = :personId "
              + "AND r.document.contextType in ('CTCO', 'CTEG', 'CTEV', 'CTWS') "             
              + "ORDER BY r.document.contextType"
              );
        
       query.setParameter("personId", personId);
        
       Collection<Object> documents = query.getResultList();
        
       String jsonString = createDocumentDescriptions(documents);
       
       return jsonString;
        
    }
    
    
    
    private String createDocumentDescriptions(Collection<Object> documents) {
        
        if (documents == null ||
            documents.size() < 1) {
            return "";
        }
         
        // It is assumed that all of the documents are sorted by document type
        HashMap<String, ArrayList<DocItem>> docMap = new HashMap<String, ArrayList<DocItem>>();
        
        String currentDocType = null;
        ArrayList<DocItem> currentDocList = null;
        
        for (Object obj : documents) {
            Object[] docValues = (Object[]) obj;
                 
//            String[] values = (String[]) obj;
            DocItem document = new DocItem((String) docValues[1], (String) docValues[2]);
            String documentType = (String) docValues[0];
            // if first item in list
            if (currentDocType == null ||
                !currentDocType.equals(documentType)) {
                currentDocType = documentType;
                currentDocList = new ArrayList<DocItem>();
                docMap.put(currentDocType, currentDocList);
            }
            currentDocList.add(document);
       }
       
       Docs docs = new Docs();
       docs.setDocuments(docMap);
       
       Gson gson =  new Gson();
       String jsonString = gson.toJson(docs);
       
       return jsonString;
    }
    
    
    class Docs {
        String jsonObject = "workSpaceDocuments";
        HashMap<String, ArrayList<DocItem>> documents = new HashMap<String, ArrayList<DocItem>>();

        public String getJsonObject() {
            return jsonObject;
        }

        public void setJsonObject(String jsonObjType) {
            this.jsonObject = jsonObjType;
        }

        public HashMap<String, ArrayList<DocItem>> getDocuments() {
            return documents;
        }

        public void setDocuments(HashMap<String, ArrayList<DocItem>> documents) {
            this.documents = documents;
        }
        
        
    }
    
    
    class DocItem {
        String contextType;
        String shortDescription;  

        public DocItem(String contextType, String shortDescription) {
            this.contextType = contextType;
            this.shortDescription = shortDescription;
        }

        public String getContextType() {
            return contextType;
        }

        public void setContextType(String contextType) {
            this.contextType = contextType;
        }

        public String getShortDescription() {
            return shortDescription;
        }

        public void setShortDescription(String shortDescription) {
            this.shortDescription = shortDescription;
        } 
    }
    
    public String getGUID() {
        Query query = em.createNativeQuery("SELECT SYS_GUID() FROM dual;");
        String guid = (String) query.getSingleResult();
        return guid;
    }

}
