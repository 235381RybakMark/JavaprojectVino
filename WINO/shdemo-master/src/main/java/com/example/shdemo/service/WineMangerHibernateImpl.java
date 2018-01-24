package com.example.shdemo.service;

import java.util.List;

import com.example.shdemo.domain.Smak;
import com.example.shdemo.domain.Kolor;
import com.example.shdemo.domain.Wine;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
public class WineMangerHibernateImpl implements WineManager {

  @Autowired
  private SessionFactory sessionFactory;

  public SessionFactory getSessionFactory() {
    return sessionFactory;
  }

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }
  
  @Override
  public void addKolor(Kolor kolor) {
    sessionFactory.getCurrentSession().persist(kolor);
  }

  @Override
  public void deleteKolor(Kolor kolor) {
    sessionFactory.getCurrentSession().delete(kolor);
  }



  @Override
  @SuppressWarnings("unchecked")
  public List<Kolor> getAllKolors() {
    return sessionFactory.getCurrentSession().getNamedQuery("kolor.all").list();
  }

  @Override
  public void addWine(Wine wine) {
    sessionFactory.getCurrentSession().persist(wine);

  }

  @Override
  public void deleteWine(Wine wine) {
    sessionFactory.getCurrentSession().delete(wine);
  }
  
  @Override
  @SuppressWarnings("unchecked")
  public List<Wine> getAllWines() {
    return sessionFactory.getCurrentSession().getNamedQuery("wine.all").list();
  }
  
  @Override
  public void updateWine(Wine oldwine, Wine newwine) {
      oldwine = (Wine) sessionFactory.getCurrentSession().get(Wine.class, oldwine.getId());

      oldwine.setWinename(newwine.getWinename());
      oldwine.setBandname(newwine.getBandname());
      oldwine.setCost(newwine.getCost());
      oldwine.setYor(newwine.getYor());

      sessionFactory.getCurrentSession().update(oldwine);
  }

  @Override
  public void addSmak(Smak smak) {
    sessionFactory.getCurrentSession().persist(smak);
  }

  @Override
  public void deleteSmak(Smak smak) {
    sessionFactory.getCurrentSession().delete(smak);
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Smak> getAllSmaks() {
    return sessionFactory.getCurrentSession().getNamedQuery("smak.all").list();
  }
}