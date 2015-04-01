/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.javabeans;

import java.io.Serializable;
import java.util.HashMap;
import org.quickconnect.json.JSONString;

/**
 *
 * @author jacksonrkj
 */
public class DocItem implements Serializable {
    HashMap<String, Object> document = new HashMap<>();

 
    public DocItem(String shortDescription) {
        this.document.put("shortDescription", shortDescription);
    }
     
    public DocItem(String documentNo, String shortDescription) {
        this.document.put("documentNo", documentNo);
        this.document.put("shortDescription", shortDescription);
    }


    public DocItem(String documentNo, String docType, String shortDescription, String text, String url) {
        if (documentNo != null) {
            this.document.put("documentNo", documentNo);
        }
        if (docType != null) {
            this.document.put("docType", docType);
        }
        if (shortDescription != null) {
            this.document.put("shortDescription", shortDescription);
        }
        if (url != null) {
            this.document.put("url", url);
        }
        if (text != null) {
            if (docType.equals("JSON")) {
                JSONString jsonString = new JSONString(text);
                this.document.put("text", jsonString);
            }
            else {
                this.document.put("text", text);
            }
        }
    }

    public HashMap<String, Object> getDocument() {
        return document;
    }
    
}
