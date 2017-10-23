/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.edu.ctu.forum.models.untils.ConnectionPool;
import vn.edu.ctu.forum.models.untils.ConnectionPoolImpl;

/**
 *
 * @author NTD
 */
public class BaseDAOImpl implements BaseDAO {

    private ConnectionPool connectionPool;
    protected Connection connection;

    // Contructor co tham so truyen vao la doi tuong ConnectionPool
    public BaseDAOImpl(ConnectionPool cp) {
        // neu ConnectionPool truyen vao la null thi tao moi
        if (cp == null) {
            this.connectionPool = new ConnectionPoolImpl();
        } else {
            this.connectionPool = cp;
        }
        // Lay ket noi tu ConnectionPool
        try {
            // neu connection pool truyen vao la null thi tao moi
            if (connectionPool == null) {
                this.connectionPool = new ConnectionPoolImpl();
            } else {
                this.connectionPool = connectionPool;
            }
            // lay ket noi tu connection pool
            this.connection = connectionPool.getConnectionPool();

            // Set AutoCommit la false de thuc hien commit bang tay
            if (this.connection.getAutoCommit()) {
                this.connection.setAutoCommit(false);
            }
        } catch (SQLException e) {
        }

    }

    public boolean executeUpdate(PreparedStatement pre) {
        if (pre != null) {
            try {

                int numRow = pre.executeUpdate();
                if (numRow == 0) {
                    this.connection.rollback();
                } else {
                    this.connection.commit();
                    return true;
                }
            } catch (SQLException ex) {
                try {
                    this.connection.rollback();
                    Logger.getLogger(BaseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex1) {
                    Logger.getLogger(BaseDAOImpl.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        } else {
            return false;
        }
        return false;
    }

    @Override
    public boolean add(PreparedStatement pre) {
        return executeUpdate(pre);
    }

    @Override
    public boolean edit(PreparedStatement pre) {
        return executeUpdate(pre);
    }

    @Override
    public boolean del(PreparedStatement pre) {
        return executeUpdate(pre);
    }

    @Override
    public ResultSet get(PreparedStatement pre) {
        try {
            return pre.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(BaseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ResultSet get(String sql) {
        try {
            PreparedStatement pre = this.connection.prepareStatement(sql);
            return this.get(pre);
        } catch (SQLException ex) {
            Logger.getLogger(BaseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

//    public static void main(String[] args) throws SQLException {
//        BaseDAO b = new BaseDAOImpl(null);
//        PreparedStatement pre = b.getConnectionPool().getConnectionPool().prepareStatement("SELECT `member_id`, `member_name`, `member_email`, `member_pass`, "
//                + "`member_sex`, `member_birthday`, `member_isAdmin`, `member_date_register`, "
//                + "`member_introduce`, `member_accept` FROM `member`"
//                + " WHERE `member_id`=?");
//        pre.setInt(1, 2);
//        ResultSet rs = b.get(pre);
//        while (rs.next()) {
//            System.out.println(rs.getInt(1));
//        }        
//    }
    @Override
    public ConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    @Override
    public void releaseConnection() {

        try {
            this.connectionPool.releaseConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(BaseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void refreshConnectionPool() {
        this.connectionPool.refreshConnectionPool();
    }

//    public static void main(String[] args) {
//        BaseDAOImpl base = new BaseDAOImpl(null);
//        System.out.println(base);
//    }
    //ResultSet rs = pre.getGeneratedKeys();
    @Override
    public Integer addGetLastID(PreparedStatement pre) {
        if (pre != null) {
            try {
                int numRow = pre.executeUpdate();
                if (numRow == 0) {
                    this.connection.rollback();
                } else {
                    this.connection.commit();
                    ResultSet rs = pre.getGeneratedKeys();
                    while(rs.next()){
                        return rs.getInt(1);
                    }
                }
            } catch (SQLException ex) {
                try {
                    this.connection.rollback();
                    Logger.getLogger(BaseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex1) {
                    Logger.getLogger(BaseDAOImpl.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        } else {
            return 0;
        }
        return 0;
    }
}
