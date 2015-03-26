/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.ejb;

import byui.cit460.workspaces.data.Document;
import java.math.BigDecimal;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jacksonrkj
 */
@Stateless
public class DocumentFacade extends AbstractFacade<Document> implements byui.cit460.workspaces.ejb.DocumentFacadeRemote {
    @PersistenceContext(unitName = "WorkSpacesEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocumentFacade() {
        super(Document.class);
    }
    
    
      /**
     * Get all documents defined for the specified workspace
     *
     * @param workspaceId
     * @return A JSON string containing document descriptions for all
 documents found.
     */
    @Override
    public Collection<Object> getAllWorkSpaceDocuments(BigDecimal personId, BigDecimal workspaceId) {
        if (workspaceId == null) {
            throw new IllegalArgumentException("getWorkSpaceDocuments - personId or workspaceId is null");
        }

        Query query = this.em.createQuery(
                "select r.document.contextType, r.document.documentNo, "
                + "r.document.docType, r.document.shortDescr, "
                + "r.document.docText, r.document.docUrl "
                + "from Membership m "
                + "inner join m.workspace AS w "
                + "inner join w.references AS r "
                + "where m.membershipPK.personId = :personId "
                + "AND w.workspaceId = :workspaceId "
                + "ORDER BY r.document.shortDescr"
        );

        query.setParameter("personId", personId);
        query.setParameter("workspaceId", workspaceId);

        Collection<Object> documents = query.getResultList();

        return documents;

    }


    /**
     * Get all documents for the portal for the specified person
     *
     * @param personId
     * @return A JSON string containing document descriptions for all
 documents found.
     */
    public Collection<Object> getPersonalWorkspaceDocuments(BigDecimal personId) {

        if (personId == null) {
            throw new IllegalArgumentException("getPortalDocuments - personId is null");
        }

        Query query = this.em.createQuery(
                "select r.document.contextType, r.document.documentNo, "
                + "r.document.docType, r.document.shortDescr, "
                + "r.document.docText, r.document.docUrl "
                + "from Membership m "
                + "inner join m.workspace AS w "
                + "inner join w.references AS r "
                + "where m.membershipPK.personId = :personId "
                + "AND w.workspaceType = 'GTIG' "
                + "AND r.document.contextType = 'CTSC' "
                + "ORDER BY r.document.shortDescr"
        );

        query.setParameter("personId", personId);
        Collection<Object> documents = query.getResultList();

        return documents;

    }

    /**
     * Get all documents for the portal for the specified person
     *
     * @param personId
     * @return A JSON string containing document descriptions for all
 documents found.
     */
    @Override
    public Collection<Object> getallPersonalEventsAndGrades(BigDecimal personId) {
        if (personId == null) {
            throw new IllegalArgumentException("getallEventsAndGrades - personId is null");
        }

        Query query = this.em.createQuery(
                "select r.document.contextType, r.document.documentNo, "
                + "r.document.docType, r.document.shortDescr, "
                + "r.document.docText, r.document.docUrl "
                + "from Membership m "
                + "inner join m.workspace AS w "
                + "inner join w.references AS r "
                + "where m.membershipPK.personId = :personId "
                + "AND r.document.contextType in ('CTFG', 'CTEV') "
                + "ORDER BY r.document.contextType"
        );

        query.setParameter("personId", personId);
        Collection<Object> documents = query.getResultList();

        return documents;

    }
    
    public String getGUID() {
        Query query = em.createNativeQuery("SELECT SYS_GUID() FROM dual;");
        String guid = (String) query.getSingleResult();
        return guid;
    }
    
}
