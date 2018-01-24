package com.example.shdemo.domain;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "wine.all", query = "Select s from Wine s")
})
public class Wine {

    private Long id;

    private String winename;
    private String panstwo;
    private double cost;
    private int yor;

    private Smak smak;
    private Kolor kolor;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWinename() {
        return winename;
    }

    public void setWinename(String winename) {
        this.winename = winename;
    }

    public String getBandname() {
        return panstwo;
    }

    public void setBandname(String panstwo) {
        this.panstwo = panstwo;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getYor() {
        return yor;
    }

    public void setYor(int yor) {
        this.yor = yor;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Smak getSmak() {
        return smak;
    }

    public void setSmak(Smak smak) {
        this.smak = smak;
    }


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Kolor getKolor() {
        return kolor;
    }

    public void setKolor(Kolor kolor) {
        this.kolor = kolor;
    }

}