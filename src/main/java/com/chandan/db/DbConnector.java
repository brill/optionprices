package com.chandan.db;

import java.sql.*;
public class DbConnector {
  private Connection connection;

  public DbConnector() {

  }

  public void init() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MARKETS?serverTimezone=UTC", "root", "Muktsar123!");
      DatabaseMetaData metaData = con.getMetaData();
      String[] types = {"TABLE"};
      ResultSet tables = metaData.getTables(null, null, "%", types);
      while (tables.next()) {
        System.out.println(tables.getString("TABLE_NAME"));
      }
      Statement stmnt = con.createStatement();
      ResultSet resultSet = stmnt.executeQuery("select * from options");
      ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
      int col_count = resultSetMetaData.getColumnCount();
      for(int i=1;i<=col_count;i++){
        System.out.println(resultSetMetaData.getColumnName(i));
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public static void main(String[] args){
    DbConnector dbConnector = new DbConnector();
    dbConnector.init();
  }
}
