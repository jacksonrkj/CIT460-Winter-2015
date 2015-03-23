/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.ejb;

import byui.cit460.workspaces.data.Membership;
import byui.cit460.workspaces.data.Workgroup;
import byui.cit460.workspaces.data.Workspace;
import byui.cit460.workspaces.exceptions.WorkspacesException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
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

    public String addGroup(Workgroup newGroup) throws WorkspacesException;

    public String viewGroup(int personId, int workspaceId) throws WorkspacesException;
    
    public String deleteGroup(int personId, int workspaceId) throws WorkspacesException;
    
    public String addMember(int personId, int workspaceId, int newMember) throws WorkspacesException;
    
    public String removeMember(int personId, int workspaceId, int removeMember) throws WorkspacesException;
    
    public String changeDesc(int personId, int workspaceId, String desc) throws WorkspacesException;
    
    public String changeSize(int personId, int workspaceId, Integer maxSize) throws WorkspacesException;
}
