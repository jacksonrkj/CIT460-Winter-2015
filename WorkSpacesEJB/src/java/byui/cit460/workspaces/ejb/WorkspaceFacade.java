/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.ejb;

import byui.cit460.workspaces.data.Workgroup;
import byui.cit460.workspaces.data.Workspace;
import byui.cit460.workspaces.exceptions.WorkspacesException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jacksonrkj
 */
@Stateless
public class WorkspaceFacade extends AbstractFacade<Workspace> implements WorkspaceFacadeRemote {
    @PersistenceContext(unitName = "WorkSpacesEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WorkspaceFacade() {
        super(Workspace.class);
    }

    @Override
    public String addGroup(Workgroup newGroup) throws WorkspacesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String viewGroup(int personId, int workspaceId) throws WorkspacesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String deleteGroup(int personId, int workspaceId) throws WorkspacesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String addMember(int personId, int workspaceId, int newMember) throws WorkspacesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String removeMember(int personId, int workspaceId, int removeMember) throws WorkspacesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String changeDesc(int personId, int workspaceId, String desc) throws WorkspacesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String changeSize(int personId, int workspaceId, Integer maxSize) throws WorkspacesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
