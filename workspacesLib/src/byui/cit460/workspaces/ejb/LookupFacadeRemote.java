/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.ejb;

import byui.cit460.workspaces.data.Lookup;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author jacksonrkj
 */
@Remote
public interface LookupFacadeRemote {

    void create(Lookup lookup);

    void edit(Lookup lookup);

    void remove(Lookup lookup);

    Lookup find(Object id);

    List<Lookup> findAll();

    List<Lookup> findRange(int[] range);

    int count();
    
}
