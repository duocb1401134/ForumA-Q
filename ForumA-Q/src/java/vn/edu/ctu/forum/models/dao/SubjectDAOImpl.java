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
    public boolean addSubject(Subject sb) {
        try {
            String sql = "INSERT INTO `subject`(`subject_id`, `subject_name`) VALUES (?,?)";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, sb.getSubjectId());
            pre.setString(2, sb.getSubjectName());
            return this.add(pre);
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

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
        try {
            String sql = "SELECT * FROM `subject`";
            PreparedStatement pre = connection.prepareStatement(sql);
            return this.findAll();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) throws SQLException {
        SubjectDAO m = new SubjectDAOImpl(null);
        
        ResultSet rs = m.findByID("2");
        
        if (rs!=null) {
            
            System.out.println(rs.getString("subject_id"));
        } else {
            System.out.println("none");
        }
                }
    
    @Override
    public ResultSet findByID(String id) {
        try {
            String sql = "SELECT `subject_id`, `subject_name` FROM `subject` WHERE `subject_id`=?";
            PreparedStatement pre = this.connection.prepareStatement(sql);
            pre.setString(1,id);
            return this.get(pre);
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   
        
    
}
