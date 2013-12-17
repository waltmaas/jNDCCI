/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waltermaas.jndcci.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author wmaas
 */
public class UserDAO {
  public static boolean login(String user, String password) {
    Connection con = null;
    PreparedStatement ps = null;
    try {
      con = Database.getConnection();
      ps = con.prepareStatement("select dkr_email, dkr_PIN from duiker "
              + "where dkr_email = ? and dkr_PIN = ?");
      ps.setString(1, user);
      ps.setString(2, password);
      
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        System.out.println(rs.getString("dkr_email"));
        return true;
      } else {
        return false;
      }
    } catch (Exception ex) {
      System.out.println(" Error login() -->"+ex.getMessage() );
      return false;
    } finally {
      Database.close(con);
    }
      
  }
  
}
