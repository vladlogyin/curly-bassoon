package com.sparta.curlybassoon.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmployeeterritoryId implements Serializable
{
    private static final long serialVersionUID = -2255243482300379028L;
    @Column(name = "EmployeeID", nullable = false)
    private Integer employeeID;

    @Column(name = "TerritoryID", nullable = false, length = 20)
    private String territoryID;

    public Integer getEmployeeID()
    {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID)
    {
        this.employeeID = employeeID;
    }

    public String getTerritoryID()
    {
        return territoryID;
    }

    public void setTerritoryID(String territoryID)
    {
        this.territoryID = territoryID;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EmployeeterritoryId entity = (EmployeeterritoryId) o;
        return Objects.equals(this.territoryID, entity.territoryID) &&
                Objects.equals(this.employeeID, entity.employeeID);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(territoryID, employeeID);
    }

}