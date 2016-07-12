package com.waltermaas.jndcci.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author wmaas
 */
public class Database {

  public static Connection getConnection() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.
              getConnection("jdbc:mysql://192.168.1.200/duikerlogboek", "wmaas", "jeju0044");
      return con;
    } catch (Exception ex) {
      System.out.println("Database getConnection ERROR ==> " + ex.getMessage());
      return null;
    }
  }

  public static void close(Connection con) {
    try {
      con.close();
    } catch (Exception ex) {
      //
    }
  }

}
