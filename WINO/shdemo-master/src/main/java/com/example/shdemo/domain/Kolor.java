package com.example.shdemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
        @NamedQuery(name = "kolor.all", query = "Select g from Kolor g")
})

public class Kolor {

    private Long id;
    private String kolor = "";

    public Kolor() {
    }

    public Kolor(String kolor) {
        super();
        this.kolor = kolor;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getKolor() {
        return kolor;
    }
    public void setKolor(String kolor) {
        this.kolor = kolor;
    }
}
