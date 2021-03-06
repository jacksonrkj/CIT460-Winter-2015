/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.data;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author jacksonrkj
 */
@Entity
@Table(name = "LOOKUP")
@NamedQueries({
    @NamedQuery(name = "Lookup.findAll", query = "SELECT l FROM Lookup l")})
public class Lookup implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name="LOOKUP_LOOKUPID_GENERATOR", sequenceName="SEQLOOKUP")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LOOKUP_LOOKUPID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "LOOKUP_ID")
    private BigDecimal lookupId;
    @Basic(optional = false)
    @Column(name = "TABLE_NAME")
    private String tableName;
    @Basic(optional = false)
    @Column(name = "COLUMN_NAME")
    private String columnName;
    @Basic(optional = false)
    @Column(name = "LOOKUP_TYPE")
    private String lookupType;
    @Basic(optional = false)
    @Column(name = "LOOKUP_VALUE")
    private String lookupValue;
    @Column(name = "LOOKUP_CODE")
    private String lookupCode;

    public Lookup() {
    }

    public Lookup(BigDecimal lookupId) {
        this.lookupId = lookupId;
    }

    public Lookup(BigDecimal lookupId, String tableName, String columnName, String lookupType, String lookupValue) {
        this.lookupId = lookupId;
        this.tableName = tableName;
        this.columnName = columnName;
        this.lookupType = lookupType;
        this.lookupValue = lookupValue;
    }

    public BigDecimal getLookupId() {
        return lookupId;
    }

    public void setLookupId(BigDecimal lookupId) {
        this.lookupId = lookupId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getLookupType() {
        return lookupType;
    }

    public void setLookupType(String lookupType) {
        this.lookupType = lookupType;
    }

    public String getLookupValue() {
        return lookupValue;
    }

    public void setLookupValue(String lookupValue) {
        this.lookupValue = lookupValue;
    }

    public String getLookupCode() {
        return lookupCode;
    }

    public void setLookupCode(String lookupCode) {
        this.lookupCode = lookupCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lookupId != null ? lookupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lookup)) {
            return false;
        }
        Lookup other = (Lookup) object;
        if ((this.lookupId == null && other.lookupId != null) || (this.lookupId != null && !this.lookupId.equals(other.lookupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "byui.cit460.workspaces.data.Lookup[ lookupId=" + lookupId + " ]";
    }
    
}
