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
    
}
