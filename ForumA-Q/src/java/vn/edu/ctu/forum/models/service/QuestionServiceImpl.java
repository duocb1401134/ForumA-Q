/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.models.service;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.edu.ctu.forum.models.pojos.Question;
import vn.edu.ctu.forum.models.dao.QuestionDAO;
import vn.edu.ctu.forum.models.dao.QuestionDAOImpl;
import vn.edu.ctu.forum.models.dao.SubjectDAO;
import vn.edu.ctu.forum.models.dao.SubjectDAOImpl;
import vn.edu.ctu.forum.models.pojos.Member;
import vn.edu.ctu.forum.models.pojos.Subject;
import vn.edu.ctu.forum.models.untils.ConnectionPool;

/**
 *
 * @author Administrator
 */
public class QuestionServiceImpl implements QuestionService{

    private SubjectService subjectService;
    private MemberService memberService;
    private final  QuestionDAO questionDAO;
    public QuestionServiceImpl(ConnectionPool cp) {
          this.questionDAO = new QuestionDAOImpl(cp);
    }
    
    
    @Override
    public boolean addQuestion(Question question) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editQuetion(Question question) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editQuestionAccept(int id) {
        boolean rs = this.editQuestionAccept(id);
        return  rs;
    }

    @Override
    public boolean delQuetion(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Question> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Question findById(int id) {
        Question rs = (Question) this.questionDAO.findById(id);
        return rs;
    }

    @Override
    public List<Question> findByIdMember(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Question> findByAccect() {
        ResultSet rs = (ResultSet) this.findByAccect();
        List<Question> listQuestion = new ArrayList<>();
        try {            
            while (rs.next()) {
                try {
                    MemberService mb = new MemberServiceImpl(this.questionDAO.getConnectionPool());
                    SubjectService ss = new SubjectServiceImpl(this.questionDAO.getConnectionPool());
                    Subject subject = ss.findById(rs.getString("suject_id"));
                    Member member = mb.findById(rs.getInt("member_id"));
                    Question qt = new Question(rs.getInt("question_id"),subject,
                    member,rs.getString("question_name"),rs.getString("question_decription"),
                    rs.getString("question_content"),rs.getDate("question_date"),rs.getBoolean("question_accept"));
                    listQuestion.add(qt);
                } catch (SQLException ex) {
                    Logger.getLogger(MemberServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listQuestion;
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
    public void refreshConnectionPool() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}