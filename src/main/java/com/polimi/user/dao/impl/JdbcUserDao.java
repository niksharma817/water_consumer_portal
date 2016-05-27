package com.polimi.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mkyong.customer.dao.CustomerDAO;
import com.mkyong.customer.model.Customer;

public class JdbcUserDAO implements UserDAO
{
  private DataSource dataSource;
  
  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }
  
  public void insert(User user){
    
    String sql = "INSERT INTO USER " +
        "(OID, USERNAME, EMAIL) VALUES (?, ?, ?)";
    Connection conn = null;
    
    try {
      conn = dataSource.getConnection();
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, user.getUserId());
      ps.setString(2, user.getUserName());
      ps.setInt(3, user.getEmail());
      ps.executeUpdate();
      ps.close();
      
    } catch (SQLException e) {
      throw new RuntimeException(e);
      
    } finally {
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {}
      }
    }
  }
  
  public Customer findByUserId(int userId){
    
    String sql = "SELECT * FROM USER WHERE OID = ?";
    
    Connection conn = null;
    
    try {
      conn = dataSource.getConnection();
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, userId);
      Customer customer = null;
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        customer = new Customer(
          rs.getInt("oid"),
          rs.getString("username"), 
          rs.getString("email")
        );
      }
      rs.close();
      ps.close();
      return customer;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      if (conn != null) {
        try {
        conn.close();
        } catch (SQLException e) {}
      }
    }
  }
}