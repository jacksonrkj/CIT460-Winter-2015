/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Preston
 */
@Entity
@Table(name = "DOCUMENT")
@NamedQueries({
    @NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d")})
public class Document implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOCUMENT_ID")
    private BigDecimal documentId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "DOC_TYPE")
    private String docType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "CONTEXT_TYPE")
    private String contextType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "SHORT_DESCR")
    private String shortDescr;
    @Lob
    @Column(name = "DOC_TEXT")
    private String docText;
    @Size(max = 2083)
    @Column(name = "DOC_URL")
    private String docUrl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 38)
    @Column(name = "VERSION_NO")
    private String versionNo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "document")
    private Collection<Reference> referenceCollection;

    public Document() {
    }

    public Document(BigDecimal documentId) {
        this.documentId = documentId;
    }

    public Document(BigDecimal documentId, String docType, String contextType, String shortDescr, String versionNo) {
        this.documentId = documentId;
        this.docType = docType;
        this.contextType = contextType;
        this.shortDescr = shortDescr;
        this.versionNo = versionNo;
    }

    public BigDecimal getDocumentId() {
        return documentId;
    }

    public void setDocumentId(BigDecimal documentId) {
        this.documentId = documentId;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getContextType() {
        return contextType;
    }

    public void setContextType(String contextType) {
        this.contextType = contextType;
    }

    public String getShortDescr() {
        return shortDescr;
    }

    public void setShortDescr(String shortDescr) {
        this.shortDescr = shortDescr;
    }

    public String getDocText() {
        return docText;
    }

    public void setDocText(String docText) {
        this.docText = docText;
    }

    public String getDocUrl() {
        return docUrl;
    }

    public void setDocUrl(String docUrl) {
        this.docUrl = docUrl;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public Collection<Reference> getReferenceCollection() {
        return referenceCollection;
    }

    public void setReferenceCollection(Collection<Reference> referenceCollection) {
        this.referenceCollection = referenceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentId != null ? documentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Document)) {
            return false;
        }
        Document other = (Document) object;
        if ((this.documentId == null && other.documentId != null) || (this.documentId != null && !this.documentId.equals(other.documentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "byui.cit460.workspaces.data.Document[ documentId=" + documentId + " ]";
    }
    
}
