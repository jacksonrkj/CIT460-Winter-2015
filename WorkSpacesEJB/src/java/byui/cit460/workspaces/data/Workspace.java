/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "WORKSPACE")
@NamedQueries({
    @NamedQuery(name = "Workspace.findAll", query = "SELECT w FROM Workspace w")})
public class Workspace implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "WORKSPACE_ID")
    private BigDecimal workspaceId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "GROUP_TYPE")
    private String groupType;
    @Size(max = 254)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "MAX_SIZE")
    private BigInteger maxSize;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workspace")
    private Collection<Reference> referenceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workspace")
    private Collection<Membership> membershipCollection;

    public Workspace() {
    }

    public Workspace(BigDecimal workspaceId) {
        this.workspaceId = workspaceId;
    }

    public Workspace(BigDecimal workspaceId, String groupType) {
        this.workspaceId = workspaceId;
        this.groupType = groupType;
    }

    public BigDecimal getWorkspaceId() {
        return workspaceId;
    }

    public void setWorkspaceId(BigDecimal workspaceId) {
        this.workspaceId = workspaceId;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(BigInteger maxSize) {
        this.maxSize = maxSize;
    }

    public Collection<Reference> getReferenceCollection() {
        return referenceCollection;
    }

    public void setReferenceCollection(Collection<Reference> referenceCollection) {
        this.referenceCollection = referenceCollection;
    }

    public Collection<Membership> getMembershipCollection() {
        return membershipCollection;
    }

    public void setMembershipCollection(Collection<Membership> membershipCollection) {
        this.membershipCollection = membershipCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (workspaceId != null ? workspaceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Workspace)) {
            return false;
        }
        Workspace other = (Workspace) object;
        if ((this.workspaceId == null && other.workspaceId != null) || (this.workspaceId != null && !this.workspaceId.equals(other.workspaceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "byui.cit460.workspaces.data.Workspace[ workspaceId=" + workspaceId + " ]";
    }
    
}
