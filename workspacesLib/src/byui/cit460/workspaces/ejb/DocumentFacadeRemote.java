/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.ejb;

import byui.cit460.workspaces.data.Document;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author jacksonrkj
 */
@Remote
public interface DocumentFacadeRemote {

    void create(Document document);

    void edit(Document document);

    void remove(Document document);

    Document find(Object id);

    List<Document> findAll();

    List<Document> findRange(int[] range);

    int count();

    public Collection<Object> getallPersonalEventsAndGrades(BigDecimal personId);

    public Collection<Object> getAllWorkSpaceDocuments(BigDecimal personId, BigDecimal workspaceId);

    public Collection<Object> getPersonalWorkspaceDocuments(BigDecimal personId);
    
}
