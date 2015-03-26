/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.ejb.javabeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author jacksonrkj
 */
public class DocumentList implements Serializable{

    private HashMap<String, ArrayList<DocItem>> documents = null;
    
    public DocumentList() {
        this.documents = new HashMap<>();
    }

    public DocumentList(HashMap<String, String> objectTypes) {
        if (documents == null) {
            this.documents = new HashMap<>();
        } 
        else {
            this.documents = documents;
        }
    }
    

    public void add(Collection<Object> allDocuments) {

        String currentDocType = null;
        ArrayList<DocItem> docList = null;

        if (allDocuments == null) {
            throw new IllegalArgumentException("addToDcoumentMap - documents is null");
        }
        
        for (Object obj : allDocuments) {
            Object[] docValues = (Object[]) obj;

            String contextType = (String) docValues[0];
            if (contextType == null) {
                continue;
            }
            
            if (!this.documents.containsKey(contextType)) {
                docList = new ArrayList<>();
                this.documents.put(contextType, docList);
            }
            
            DocItem document = new DocItem((String) docValues[1],
                    (String) docValues[2],
                    (String) docValues[3],
                    (String) docValues[4],
                    (String) docValues[5]);

            docList = this.documents.get(contextType);
            docList.add(document);

        }

    }

}

