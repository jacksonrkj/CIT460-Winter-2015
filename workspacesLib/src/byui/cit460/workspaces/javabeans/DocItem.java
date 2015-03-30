/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.javabeans;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author jacksonrkj
 */
public class DocItem implements Serializable {
    
    private String documentNo;
    private String docType;
    private String description;
    private String text;
    private String url;
    
    public DocItem(String text) {
        this.text = text;
    }
     
    public DocItem(String documentNo, String description) {
        this.documentNo = documentNo;
        this.description = description;
    }


    public DocItem(String documentNo, String docType, String description, String text, String url) {
        this.documentNo = documentNo;
        this.docType = docType;
        this.description = description;
        this.text = text;
        this.url = url;
    }

    
    

    public String getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(String documentNo) {
        this.documentNo = documentNo;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.documentNo);
        hash = 97 * hash + Objects.hashCode(this.docType);
        hash = 97 * hash + Objects.hashCode(this.description);
        hash = 97 * hash + Objects.hashCode(this.text);
        hash = 97 * hash + Objects.hashCode(this.url);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DocItem other = (DocItem) obj;
        if (!Objects.equals(this.documentNo, other.documentNo)) {
            return false;
        }
        if (!Objects.equals(this.docType, other.docType)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.text, other.text)) {
            return false;
        }
        if (!Objects.equals(this.url, other.url)) {
            return false;
        }
        return true;
    }

    
    
    
    
    
}
