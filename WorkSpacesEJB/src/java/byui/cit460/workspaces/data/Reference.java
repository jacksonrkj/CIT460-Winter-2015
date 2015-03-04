/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Preston
 */
@Entity
@Table(name = "REFERENCE")
@NamedQueries({
    @NamedQuery(name = "Reference.findAll", query = "SELECT r FROM Reference r")})
public class Reference implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReferencePK referencePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERMISSION")
    private short permission;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STARTTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date starttime;
    @Column(name = "ENDTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endtime;
    @Column(name = "SCORE")
    private Long score;
    @Column(name = "DISPLAY_ORDER")
    private Long displayOrder;
    @JoinColumn(name = "WORKSPACE_ID", referencedColumnName = "WORKSPACE_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Workspace workspace;
    @JoinColumn(name = "PERSON_ID", referencedColumnName = "PERSON_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;
    @JoinColumn(name = "DOCUMENT_ID", referencedColumnName = "DOCUMENT_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Document document;

    public Reference() {
    }

    public Reference(ReferencePK referencePK) {
        this.referencePK = referencePK;
    }

    public Reference(ReferencePK referencePK, short permission, Date starttime) {
        this.referencePK = referencePK;
        this.permission = permission;
        this.starttime = starttime;
    }

    public Reference(BigInteger personId, BigInteger documentId, BigInteger workspaceId) {
        this.referencePK = new ReferencePK(personId, documentId, workspaceId);
    }

    public ReferencePK getReferencePK() {
        return referencePK;
    }

    public void setReferencePK(ReferencePK referencePK) {
        this.referencePK = referencePK;
    }

    public short getPermission() {
        return permission;
    }

    public void setPermission(short permission) {
        this.permission = permission;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Long getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Long displayOrder) {
        this.displayOrder = displayOrder;
    }

    public Workspace getWorkspace() {
        return workspace;
    }

    public void setWorkspace(Workspace workspace) {
        this.workspace = workspace;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (referencePK != null ? referencePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reference)) {
            return false;
        }
        Reference other = (Reference) object;
        if ((this.referencePK == null && other.referencePK != null) || (this.referencePK != null && !this.referencePK.equals(other.referencePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "byui.cit460.workspaces.data.Reference[ referencePK=" + referencePK + " ]";
    }
    
}
