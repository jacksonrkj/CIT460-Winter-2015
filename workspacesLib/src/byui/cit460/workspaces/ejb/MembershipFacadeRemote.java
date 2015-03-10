/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.ejb;

import byui.cit460.workspaces.data.Membership;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author jacksonrkj
 */
@Remote
public interface MembershipFacadeRemote {

    void create(Membership membership);

    void edit(Membership membership);

    void remove(Membership membership);

    Membership find(Object id);

    List<Membership> findAll();

    List<Membership> findRange(int[] range);

    int count();
    
}
