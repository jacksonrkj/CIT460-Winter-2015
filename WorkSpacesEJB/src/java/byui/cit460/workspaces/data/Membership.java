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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Preston
 */
@Entity
@Table(name = "MEMBERSHIP")
@NamedQueries({
    @NamedQuery(name = "Membership.findAll", query = "SELECT m FROM Membership m")})
public class Membership implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MembershipPK membershipPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERMISSION")
    private short permission;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ROLE_TYPE")
    private String roleType;
    @JoinColumn(name = "WORKSPACE_ID", referencedColumnName = "WORKSPACE_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Workspace workspace;
    @JoinColumn(name = "PERSON_ID", referencedColumnName = "PERSON_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;

    public Membership() {
    }

    public Membership(MembershipPK membershipPK) {
        this.membershipPK = membershipPK;
    }

    public Membership(MembershipPK membershipPK, short permission, String roleType) {
        this.membershipPK = membershipPK;
        this.permission = permission;
        this.roleType = roleType;
    }

    public Membership(BigInteger personId, BigInteger workspaceId) {
        this.membershipPK = new MembershipPK(personId, workspaceId);
    }

    public MembershipPK getMembershipPK() {
        return membershipPK;
    }

    public void setMembershipPK(MembershipPK membershipPK) {
        this.membershipPK = membershipPK;
    }

    public short getPermission() {
        return permission;
    }

    public void setPermission(short permission) {
        this.permission = permission;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (membershipPK != null ? membershipPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Membership)) {
            return false;
        }
        Membership other = (Membership) object;
        if ((this.membershipPK == null && other.membershipPK != null) || (this.membershipPK != null && !this.membershipPK.equals(other.membershipPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "byui.cit460.workspaces.data.Membership[ membershipPK=" + membershipPK + " ]";
    }
    
}
