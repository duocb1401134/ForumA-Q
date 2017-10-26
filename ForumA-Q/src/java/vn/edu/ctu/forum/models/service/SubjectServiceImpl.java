/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.models.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.edu.ctu.forum.models.pojos.Subject;
import vn.edu.ctu.forum.models.untils.ConnectionPool;
import vn.edu.ctu.forum.models.dao.SubjectDAO;
import vn.edu.ctu.forum.models.dao.SubjectDAOImpl;
import vn.edu.ctu.forum.models.pojos.Member;

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
    
    public void refreshConnectionPool() {
        this.subjectDAO.refreshConnectionPool();
    }
    
    @Override
    public boolean addSubject(Subject sj) {
        return this.subjectDAO.addSubject(sj);
    }

    @Override
    public boolean edtSubject(Subject sj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delSubject(Subject sj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public List<Subject> find(int start, int limit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    public static void main(String[] args) {
//        SubjectService sbs = new SubjectServiceImpl(null);
//         if(sbs.findById("2")!=null){
//            System.out.println("oke");
//            System.out.println(sbs.findById("2").getSubjectName());
//        }
//        else{
//            System.out.println("eo");
//        }
//    }
    
    @Override
    public Subject findById(String id) {
         try {
            ResultSet rs = subjectDAO.findByID(id);
            Subject b = new Subject();
            if (rs.next()) {
                
                String 	subject_id = rs.getString("subject_id");
                String subject_name = rs.getString("subject_name");
                
                b = new Subject(subject_id,subject_name);
                return b;
            } else {
                return b;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
