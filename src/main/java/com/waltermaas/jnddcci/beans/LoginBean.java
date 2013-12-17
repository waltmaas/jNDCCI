package com.waltermaas.jnddcci.beans;

import com.waltermaas.jndcci.dao.UserDAO;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named
@SessionScoped
/**
 *
 * @author wmaas
 */
public class LoginBean implements Serializable {

  private static final long serialversionUID = 1L;
  private String password;
  private String message;
  private String uname;
  private String vnaam, anaam;

  public String getVnaam() {
    return vnaam;
  }

  public void setVnaam(String vnaam) {
    this.vnaam = vnaam;
  }

  public String getAnaam() {
    return anaam;
  }

  public void setAnaam(String anaam) {
    this.anaam = anaam;
  }
  private boolean loggedIn = false;

  public String getPassword() {
    return password;
  }

  public boolean isLoggedIn() {
    return loggedIn;
  }

  public void setLoggedIn(boolean loggedIn) {
    this.loggedIn = loggedIn;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getUname() {
    return uname;
  }

  public void setUname(String uname) {
    this.uname = uname;
  }

  public String loginProject() {
    loggedIn = UserDAO.login(uname, password);
    if (loggedIn) {
      HttpSession session = Util.getSession();
      session.setAttribute("username", uname);
      return "index";
    } else {
      FacesContext.getCurrentInstance().addMessage(null,
              new FacesMessage(FacesMessage.SEVERITY_WARN,
              "Invalid Login", "Probeer opnieuw"));
      return "login";
    }
  }

  public String logout() {
    HttpSession session = Util.getSession();
    session.invalidate();
    loggedIn = false;
    return "index";
  }
}
