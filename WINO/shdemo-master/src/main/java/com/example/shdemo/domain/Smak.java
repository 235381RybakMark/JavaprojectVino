package com.example.shdemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
        @NamedQuery(name = "smak.all", query = "Select ser from Smak ser")
})
public class Smak {
  private Long id;
  private String smak = "";

  public Smak() {
  }

  public Smak(String smak) {
    super();
    this.smak = smak;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getSmak() {
    return smak;
  }
  public void setSmak(String smak) {
    this.smak = smak;
  }
}