/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.ejb;

import byui.cit460.workspaces.data.Workspace;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author jacksonrkj
 */
@Remote
public interface WorkspaceFacadeRemote {

    void create(Workspace workspace);

    void edit(Workspace workspace);

    void remove(Workspace workspace);

    Workspace find(Object id);

    List<Workspace> findAll();

    List<Workspace> findRange(int[] range);

    int count();

    public String getWorkSpaceDocuments(BigDecimal workspaceId);

    public String getPortalDocuments(BigDecimal personId);
    
}
