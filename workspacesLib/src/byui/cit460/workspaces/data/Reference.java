/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jacksonrkj
 */
@Entity
@Table(name = "REFERENCE")
@NamedQueries({
    @NamedQuery(name = "Reference.findAll", query = "SELECT r FROM Reference r")})
public class Reference implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name="PERSON_REFERENCEID_GENERATOR", sequenceName="SEQREFERENCE")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSON_REFERENCEID_GENERATOR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "REFERENCE_ID")
    private BigDecimal referenceId;
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
    @JoinColumn(name = "DOCUMENT_ID", referencedColumnName = "DOCUMENT_ID")
    @ManyToOne(optional = false)
    private Document document;
    @JoinColumn(name = "PERSON_ID", referencedColumnName = "PERSON_ID")
    @ManyToOne
    private Person person;
    @JoinColumn(name = "WORKSPACE_ID", referencedColumnName = "WORKSPACE_ID")
    @ManyToOne
    private Workspace workspace;

    public Reference() {
    }

    public Reference(BigDecimal referenceId) {
        this.referenceId = referenceId;
    }

    public Reference(BigDecimal referenceId, short permission, Date starttime) {
        this.referenceId = referenceId;
        this.permission = permission;
        this.starttime = starttime;
    }

    public BigDecimal getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(BigDecimal referenceId) {
        this.referenceId = referenceId;
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

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Person getPerson() {
        return person;
    }

    public void setPersonId(Person person) {
        this.person = person;
    }

    public Workspace getWorkspaceId() {
        return workspace;
    }

    public void setWorkspace(Workspace workspace) {
        this.workspace = workspace;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (referenceId != null ? referenceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reference)) {
            return false;
        }
        Reference other = (Reference) object;
        if ((this.referenceId == null && other.referenceId != null) || (this.referenceId != null && !this.referenceId.equals(other.referenceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "byui.cit460.workspaces.data.Reference[ referenceId=" + referenceId + " ]";
    }
    
}
