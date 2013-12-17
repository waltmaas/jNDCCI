/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waltermaas.jndcci.session;

import com.waltermaas.jndcci.entities.Duiknieuws;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author wmaas
 */
@Stateless
public class DuiknieuwsFacade extends AbstractFacade<Duiknieuws> {
  @PersistenceContext(unitName = "com.waltermaas_MavenTestPrime_war_1.0-SNAPSHOTPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public DuiknieuwsFacade() {
    super(Duiknieuws.class);
  }
  
}
