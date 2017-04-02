package com.mycompany.databaseassignment;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author yoyo
 */
public class DAOSQL {

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement stmt = null;
    // StatementResult = null;
    String urlSQL = "jdbc:mysql://localhost:3306/mydb";
    String userSQL = "root";
    String passwordSQL = "";

    public Connection getConnectionSQL() throws ClassNotFoundException, SQLException {

        con = (Connection) DriverManager.getConnection(urlSQL, userSQL, passwordSQL);
        if (con == null) {
           // System.out.println("Connection cannot be null!!! ");
            return null;
        }

      //  System.out.println("Connection obtained from DAO !!! ");
        return con;
    }

    public void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) throws SQLException {

        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }

    }

    public Set<Integer> getOneEndorsment(int id) throws SQLException {
        //long before = System.currentTimeMillis();

        Set<Integer> list = new HashSet<Integer>();
        try {
            String query = "SELECT endorsment.id_endorst from endorsment  where endorsment.id_endorses = ?";
            con = getConnectionSQL();
            stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            //expected 7 results back
            while (rs.next()) {
                int id_endorst = rs.getInt(1);
                list.add(id_endorst);
               // System.out.println(id_endorst);
            }
            // return list;
            return list;//could be null

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, stmt, rs);
        }
//
//        long after = System.currentTimeMillis();
//        System.out.println("The getOneEndorsment took " + (after - before));

        return null;
    }

    public Set<Integer> getTwoEndorsments(int id) throws SQLException {

       // long before = System.currentTimeMillis();

        Set<Integer> list = new HashSet<Integer>();
        try {
            String query = "select * \n"
                    + "from endorsment uf1 inner join endorsment uf2 on uf1.id_endorst = uf2.id_endorses\n"
                    + "where uf1.id_endorses = ?";
            con = getConnectionSQL();
            stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            //expected 7 results back
            while (rs.next()) {
                int id_endorst = rs.getInt(6);
                list.add(id_endorst);
               // System.out.println(id_endorst);
            }
            // return list;
            return list;//could be null

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, stmt, rs);
        }
//
//        long after = System.currentTimeMillis();
//        System.out.println("The getTwoEndorsments took " + (after - before));

        return null;
    }

    public Set<Integer> getThreeEndorsments(int id) throws SQLException {
        //long before = System.currentTimeMillis();

        Set<Integer> list = new HashSet<Integer>();
        try {
            String query = "select * from endorsment uf1\n"
                    + " inner join endorsment uf2 on uf1.id_endorst = uf2.id_endorses\n"
                    + " inner join endorsment uf3 on uf2.id_endorst = uf3.id_endorses\n"
                    + " where uf1.id_endorses = ?";
            con = getConnectionSQL();
            stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            //expected 7 results back
            while (rs.next()) {
                int id_endorst = rs.getInt(9);
                list.add(id_endorst);
               // System.out.println(id_endorst);
            }
            return list;//could be null
            // return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, stmt, rs);
        }

//        long after = System.currentTimeMillis();
//        System.out.println("The getThreeEndorsments took " + (after - before));

        return null;
    }

    public Set<Integer> getFourEndorsments(int id) throws SQLException {
       // long before = System.currentTimeMillis();

        Set<Integer> list = new HashSet<Integer>();
        try {
            String query = "select * from endorsment uf1\n"
                    + " inner join endorsment uf2 on uf1.id_endorst = uf2.id_endorses\n"
                    + " inner join endorsment uf3 on uf2.id_endorst = uf3.id_endorses\n"
                    + " inner join endorsment uf4 on uf3.id_endorst = uf4.id_endorses\n"
                    + " where uf1.id_endorses = ?";
            con = getConnectionSQL();
            stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            //expected 7 results back
            while (rs.next()) {
                int id_endorst = rs.getInt(12);
                list.add(id_endorst);
                //System.out.println(id_endorst);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, stmt, rs);
        }
        //close connection

//        long after = System.currentTimeMillis();
//        System.out.println("The getFourEndorsments took " + (after - before));

        return null;//could be null

    }

    public Set<Integer> getFiveEndorsments(int id) throws SQLException {
//        long before = System.currentTimeMillis();

        Set<Integer> list = new HashSet<Integer>();
        try {
            String query = "select * from endorsment uf1\n"
                    + " inner join endorsment uf2 on uf1.id_endorst = uf2.id_endorses\n"
                    + " inner join endorsment uf3 on uf2.id_endorst = uf3.id_endorses\n"
                    + " inner join endorsment uf4 on uf3.id_endorst = uf4.id_endorses\n"
                    + " inner join endorsment uf5 on uf4.id_endorst = uf5.id_endorses\n"
                    + " where uf1.id_endorses = ?";
            con = getConnectionSQL();
            stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            //expected 7 results back
            while (rs.next()) {
                int id_endorst = rs.getInt(15);
                list.add(id_endorst);
                //System.out.println(id_endorst);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, stmt, rs);
        }

//        long after = System.currentTimeMillis();
//        System.out.println("The getFiveEndorsments took " + (after - before));
        
        return null;//could be null

    }

}
