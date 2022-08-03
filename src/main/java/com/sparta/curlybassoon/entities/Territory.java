package com.sparta.curlybassoon.entities;

import javax.persistence.*;

@Entity
@Table(name = "territories")
public class Territory
{
    @Id
    @Column(name = "TerritoryID", nullable = false, length = 20)
    private String id;

    @Column(name = "TerritoryDescription", nullable = false, length = 50)
    private String territoryDescription;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "RegionID", nullable = false)
    private Region regionID;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getTerritoryDescription()
    {
        return territoryDescription;
    }

    public void setTerritoryDescription(String territoryDescription)
    {
        this.territoryDescription = territoryDescription;
    }

    public Region getRegionID()
    {
        return regionID;
    }

    public void setRegionID(Region regionID)
    {
        this.regionID = regionID;
    }

}