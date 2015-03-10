/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.ejb;

import byui.cit460.workspaces.data.Phone;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author jacksonrkj
 */
@Remote
public interface PhoneFacadeRemote {

    void create(Phone phone);

    void edit(Phone phone);

    void remove(Phone phone);

    Phone find(Object id);

    List<Phone> findAll();

    List<Phone> findRange(int[] range);

    int count();
    
}
