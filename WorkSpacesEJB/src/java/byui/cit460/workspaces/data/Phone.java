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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "PHONE")
@NamedQueries({
    @NamedQuery(name = "Phone.findAll", query = "SELECT p FROM Phone p")})
public class Phone implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PHONE_ID")
    private BigDecimal phoneId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "PHONE_TYPE")
    private String phoneType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @JoinTable(name = "PERSON_PHONE", joinColumns = {
        @JoinColumn(name = "PHONE_ID", referencedColumnName = "PHONE_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "PERSON_ID", referencedColumnName = "PERSON_ID")})
    @ManyToMany
    private Collection<Person> personCollection;

    public Phone() {
    }

    public Phone(BigDecimal phoneId) {
        this.phoneId = phoneId;
    }

    public Phone(BigDecimal phoneId, String phoneType, String phoneNumber) {
        this.phoneId = phoneId;
        this.phoneType = phoneType;
        this.phoneNumber = phoneNumber;
    }

    public BigDecimal getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(BigDecimal phoneId) {
        this.phoneId = phoneId;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (phoneId != null ? phoneId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phone)) {
            return false;
        }
        Phone other = (Phone) object;
        if ((this.phoneId == null && other.phoneId != null) || (this.phoneId != null && !this.phoneId.equals(other.phoneId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "byui.cit460.workspaces.data.Phone[ phoneId=" + phoneId + " ]";
    }
    
}
