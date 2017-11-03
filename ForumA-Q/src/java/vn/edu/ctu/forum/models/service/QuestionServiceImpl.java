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
public class QuestionServiceImpl implements QuestionService {

    private SubjectService subjectService;
    private MemberService memberService;
    private final QuestionDAO questionDAO;

    public QuestionServiceImpl(ConnectionPool cp) {
        this.questionDAO = new QuestionDAOImpl(cp);
    }

    @Override
    public boolean addQuestion(Question question) {
        return questionDAO.addQuestion(question);
    }

    @Override
    public boolean editQuetion(Question question) {
        return questionDAO.editQuetion(question);
    }

    @Override
    public boolean editQuestionAccept(int id) {
        boolean rs = questionDAO.editQuestionAccept(id);
        Question q = new Question(id);
        return rs;
    }

    @Override
    public boolean delQuetion(int id) {
        boolean rs = questionDAO.delQuetion(id);
        return rs;
    }

    @Override
    public List<Question> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Question findByIdQuestion(int id) {

        ResultSet rs = this.questionDAO.findByIdQuestion(id);
        Question qt = new Question();
        try {
            while (rs.next()) {
                try {
                    MemberService mb = new MemberServiceImpl(this.questionDAO.getConnectionPool());
                    SubjectService ss = new SubjectServiceImpl(this.questionDAO.getConnectionPool());
//                    Subject subject = ss.findById(rs.getString("subject_id")); ham nay bi loi 
                    Member member = mb.findById(rs.getInt("member_id"));
                    qt = new Question(rs.getInt("question_id"),rs.getString("subject_id"),
                            rs.getString("question_name"), rs.getString("question_decription"),
                            rs.getString("question_content"), rs.getDate("question_date"), rs.getInt("question_accept"));
//                    qt.setSubjectId(rs.getString("suject_id"));
                } catch (SQLException ex) {
                    Logger.getLogger(MemberServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return qt;
    }

    @Override
    public List<Question> findByIdMember(int id) {
        ResultSet rs = this.questionDAO.findByIdMember(id);
        List<Question> listQuestion = new ArrayList<>();
        try {
            while (rs.next()) {
                try {
                    MemberService mb = new MemberServiceImpl(this.questionDAO.getConnectionPool());
                    SubjectService ss = new SubjectServiceImpl(this.questionDAO.getConnectionPool());
//                    Subject subject = ss.findById(rs.getString("suject_id"));
                    Member member = mb.findById(rs.getInt("member_id"));
                    Question qt = new Question(rs.getInt("question_id"),
                            member, rs.getString("question_name"), rs.getString("question_decription"),
                            rs.getString("question_content"), rs.getDate("question_date"), rs.getInt("question_accept"));
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
    public List<Question> findByAccect() {
        ResultSet rs = this.questionDAO.findByAccect();
        List<Question> listQuestion = new ArrayList<>();
        try {
            while (rs.next()) {
                try {
                    MemberService mb = new MemberServiceImpl(this.questionDAO.getConnectionPool());
                    SubjectService ss = new SubjectServiceImpl(this.questionDAO.getConnectionPool());
//                    Subject subject = ss.findById(rs.getString("suject_id"));
                    Member member = mb.findById(rs.getInt("member_id"));
                    Question qt = new Question(rs.getInt("question_id"),
                            member, rs.getString("question_name"), rs.getString("question_decription"),
                            rs.getString("question_content"), rs.getDate("question_date"), rs.getInt("question_accept"));
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
//    public static void main(String[] args) {
//        QuestionService qtsv = new QuestionServiceImpl(null);
//        Question question = new Question();
//        List<Question> list = qtsv.findByAccect();
//        
//        for(int i = 0; i< list.size();i++){
//            System.out.println(list.get(i).getQuestionName());
//    }}

//    public static void main(String[] args) {
//        SubjectService sb = new SubjectServiceImpl(null);
//       Subject s =  sb.findById("2");
//        System.out.println(s.getSubjectName());
//    }
    @Override
    public ConnectionPool getConnectionPool() {
        return this.questionDAO.getConnectionPool();
    }

    @Override
    public void releaseConnection() {
        this.questionDAO.releaseConnection();
    }

    @Override
    public void refreshConnectionPool() {
        this.questionDAO.refreshConnectionPool();
    }

    @Override
    public ResultSet findByidSubject(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delAcceptQuestion(int id) {
        boolean rs = questionDAO.delAcceptQuestion(id);
        Question q = new Question(id);
        return rs;
    }

}
