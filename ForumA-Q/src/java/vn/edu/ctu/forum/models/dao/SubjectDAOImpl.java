/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.edu.ctu.forum.models.pojos.Subject;
import vn.edu.ctu.forum.models.untils.ConnectionPool;

/**
 *
 * @author PC
 */
public class SubjectDAOImpl extends BaseDAOImpl implements SubjectDAO{

    public SubjectDAOImpl(ConnectionPool connectionPool) {
        super(connectionPool);
    }

    @Override
    public boolean addSubject(Subject sb, int image_Id) {
        try {
            String sql = "INSERT INTO `subject`(`subject_id`, `image_id`, `subject_name`) VALUES (?,?,?)";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, sb.getSubjectId());
            pre.setInt(2, image_Id);
            pre.setString(3, sb.getSubjectName());
            return this.add(pre);
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

//    public static void main(String[] args) {
//        SubjectDAO sjDAO = new SubjectDAOImpl(null);
//        Subject sj = new Subject("SJ1", "Test");
//        if(sjDAO.addSubject(sj)) 
//            System.out.println("OK");
//        else
//            System.out.println("fail");
//    }
    
    @Override
    public boolean editSubject(Subject sb) {
        try {
            String sql = "UPDATE `subject` SET `subject_name`=? WHERE `subject_id`=?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, sb.getSubjectId());
            pre.setString(2, sb.getSubjectName());
            return this.edit(pre);
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delSubject(String id) {
        try {
            String sql = "DELETE FROM `subject` WHERE `subject_id`=?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, id);
            return this.del(pre);
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }    

    @Override
    public ResultSet findAll() {
        String sql = "SELECT * FROM `subject`=?";
        return this.get(sql);
    }
    
    @Override
    public ConnectionPool getConnectionPool() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void releaseConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void releaseConnectionPool() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet findByID(String id) {
        try {
            String sql = "SELECT `subject_id`, `subject_name` FROM `subject` WHERE `subject_id`=?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, id);
            return this.get(pre);
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ResultSet findByID(int start, int limit) {
        try {
            String sql = "SELECT * FROM `subject` LIMIT ?, ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, start);
            pre.setInt(2, limit);
            return this.get(pre);
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
