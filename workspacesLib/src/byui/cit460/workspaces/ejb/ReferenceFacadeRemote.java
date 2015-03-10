/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.ejb;

import byui.cit460.workspaces.data.Reference;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author jacksonrkj
 */
@Remote
public interface ReferenceFacadeRemote {

    void create(Reference reference);

    void edit(Reference reference);

    void remove(Reference reference);

    Reference find(Object id);

    List<Reference> findAll();

    List<Reference> findRange(int[] range);

    int count();
    
}
