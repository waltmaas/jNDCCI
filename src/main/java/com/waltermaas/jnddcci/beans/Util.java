/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waltermaas.jnddcci.beans;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author wmaas
 */
public class Util {
  
  public static HttpSession getSession() {
    return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  }
  
  public static HttpServletRequest getRequest() {
    return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
  }
  
  public static String getUserName() {
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    return session.getAttribute("username").toString();
  }
  
  public static String getUserID() {
    HttpSession session = getSession();
    if (session != null) {
      return (String) session.getAttribute("userid");
    } else {
      return null;
    }
  }
  
}
