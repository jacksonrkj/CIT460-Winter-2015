/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Objects;

/**
 *
 * @author Preston
 */
public class Workgroup {
    private BigInteger owner; 
    Collection<Membership> groupMember; 
    private String workspaceType;
    private String description;
    private BigInteger maxSize;

    public Workgroup() {
    }

    public Workgroup(BigInteger owner, Collection<Membership> groupMember, String workspaceType, String description, BigInteger maxSize) {
        this.owner = owner;
        this.groupMember = groupMember;
        this.workspaceType = workspaceType;
        this.description = description;
        this.maxSize = maxSize;
    }

    public BigInteger getOwner() {
        return owner;
    }

    public void setOwner(BigInteger owner) {
        this.owner = owner;
    }

    public Collection<Membership> getGroupMember() {
        return groupMember;
    }

    public void setGroupMember(Collection<Membership> groupMember) {
        this.groupMember = groupMember;
    }

    public String getWorkspaceType() {
        return workspaceType;
    }

    public void setWorkspaceType(String workspaceType) {
        this.workspaceType = workspaceType;
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
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.owner);
        hash = 17 * hash + Objects.hashCode(this.groupMember);
        hash = 17 * hash + Objects.hashCode(this.workspaceType);
        hash = 17 * hash + Objects.hashCode(this.description);
        hash = 17 * hash + Objects.hashCode(this.maxSize);
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
        final Workgroup other = (Workgroup) obj;
        if (!Objects.equals(this.owner, other.owner)) {
            return false;
        }
        if (!Objects.equals(this.groupMember, other.groupMember)) {
            return false;
        }
        if (!Objects.equals(this.workspaceType, other.workspaceType)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.maxSize, other.maxSize)) {
            return false;
        }
        return true;
    }

    public void getMaxSize(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
