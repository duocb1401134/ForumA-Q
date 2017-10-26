/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.models.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.edu.ctu.forum.models.pojos.Subject;
import vn.edu.ctu.forum.models.untils.ConnectionPool;
import vn.edu.ctu.forum.models.dao.SubjectDAO;
import vn.edu.ctu.forum.models.dao.SubjectDAOImpl;
import vn.edu.ctu.forum.models.pojos.Image;

/**
 *
 * @author PC
 */
public class SubjectServiceImpl implements SubjectService {

    
    private final SubjectDAO subjectDAO;
    
    public SubjectServiceImpl(ConnectionPool cp) {
        this.subjectDAO = new SubjectDAOImpl(cp);
    }
    
   
    public ConnectionPool getConnection() {
        return this.subjectDAO.getConnectionPool();
    }

    
    public void releaseConnection() {
        this.subjectDAO.releaseConnection();
    }
    
    public void releaseConnectionPool() {
        this.subjectDAO.releaseConnectionPool();
    }
    
    @Override
    public boolean addSubject(Subject sj, Image image) {
        
        ImageService imgs = new ImageServiceImpl(null);
        
        if (findById(sj.getSubjectId())==null) 
            if(this.subjectDAO.addSubject(sj, imgs.addGetLastId(image))){
                return true;
            }
            else return false;
        else
            return false;
    }

//    public static void main(String[] args) {
//        SubjectService sjs = new SubjectServiceImpl(null);
//        Image img = new Image("test", "test");
//        if(sjs.addSubject(new Subject("sj2", "Test"), img))
//            System.out.println("OK");
//        else
//            System.out.println("Not OK");
//    }
    
    @Override
    public boolean edtSubject(Subject sj) {
        return this.subjectDAO.editSubject(sj);
    }

    @Override
    public boolean delSubject(String id) {
        
        Subject sb = new Subject("subject_id", "subject_name");
        
        
        return false;
    }

    @Override
    public List<Subject> findAll() {
        ResultSet rs = this.subjectDAO.findAll();
        List<Subject> listSubject = new ArrayList<>();
        try {            
            while (rs.next()) {
                try {
                    Subject sb = new Subject(rs.getString("subject_id"), rs.getString("subject_name"));
                    listSubject.add(sb);
                } catch (SQLException ex) {
                    Logger.getLogger(SubjectServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSubject;
    }

    @Override
    public Subject findById(String id) {
        ResultSet rs = this.subjectDAO.findByID(id);
        try {
            while (rs.next()) {
                Subject sb = new Subject(rs.getString("subject_id"), rs.getString("subject_name"));
                return sb;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Subject> findLimit(int start, int limit) {
        ResultSet rs = this.subjectDAO.findByID(start, limit);
        List<Subject> listSubject = new ArrayList<>();
        try {
            while(rs.next()) {
                Subject sb = new Subject(rs.getString("subject_id"), rs.getString("subject_name"));
                listSubject.add(sb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSubject;
    }

    @Override
    public ConnectionPool getConnectionPool() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void refreshConnectionPool() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
