/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.data;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Preston
 */
@Embeddable
public class MembershipPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERSON_ID")
    private BigInteger personId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WORKSPACE_ID")
    private BigInteger workspaceId;

    public MembershipPK() {
    }

    public MembershipPK(BigInteger personId, BigInteger workspaceId) {
        this.personId = personId;
        this.workspaceId = workspaceId;
    }

    public BigInteger getPersonId() {
        return personId;
    }

    public void setPersonId(BigInteger personId) {
        this.personId = personId;
    }

    public BigInteger getWorkspaceId() {
        return workspaceId;
    }

    public void setWorkspaceId(BigInteger workspaceId) {
        this.workspaceId = workspaceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personId != null ? personId.hashCode() : 0);
        hash += (workspaceId != null ? workspaceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MembershipPK)) {
            return false;
        }
        MembershipPK other = (MembershipPK) object;
        if ((this.personId == null && other.personId != null) || (this.personId != null && !this.personId.equals(other.personId))) {
            return false;
        }
        if ((this.workspaceId == null && other.workspaceId != null) || (this.workspaceId != null && !this.workspaceId.equals(other.workspaceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "byui.cit460.workspaces.data.MembershipPK[ personId=" + personId + ", workspaceId=" + workspaceId + " ]";
    }
    
}
