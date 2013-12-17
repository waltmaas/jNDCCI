/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waltermaas.jnddcci.beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;

/**
 *
 * @author wmaas
 */
@Named
@SessionScoped
public class DashboardController implements Serializable {
  private DashboardModel model;

  public DashboardModel getModel() {
    return model;
  }

  public void setModel(DashboardModel model) {
    this.model = model;
  }
  
  public DashboardController() {
    model = new DefaultDashboardModel();
    
    DashboardColumn column0 = new DefaultDashboardColumn();
    DashboardColumn column1 = new DefaultDashboardColumn();
    DashboardColumn column2 = new DefaultDashboardColumn();
    DashboardColumn column3 = new DefaultDashboardColumn();
    
    column0.addWidget("gegs");
    column1.addWidget("certs");
    column2.addWidget("duiks");
    column3.addWidget("keurs");
    
    model.addColumn(column0);
    model.addColumn(column1);
    model.addColumn(column2);
    model.addColumn(column3);
    
    
  }
  
}
