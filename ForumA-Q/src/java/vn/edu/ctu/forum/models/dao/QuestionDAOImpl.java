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
import vn.edu.ctu.forum.models.pojos.Member;
import vn.edu.ctu.forum.models.pojos.Question;
import vn.edu.ctu.forum.models.untils.ConnectionPool;

/**
 *
 * @author Ew
 */
public class QuestionDAOImpl extends BaseDAOImpl implements QuestionDAO {

    public QuestionDAOImpl(ConnectionPool connectionPool) {
        super(connectionPool);
    }

    @Override
    public boolean addQuestion(Question question) {
        try {
            String sql = "INSERT INTO `question`("
                    + "`question_id`, "
                    + "`subject_id`, "
                    + "`member_id`, "
                    + "`question_name`, "
                    + "`question_decription`, "
                    + "`question_content`, "
                    + "`question_date`) VALUES (null,?,?,?,?,?,now())";//<====Chua chac dung, Sang dep trai da sua r

            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, question.getSubjectId());
            pre.setInt(2, question.getMemberId());
            pre.setString(3, question.getQuestionName());
            pre.setString(4, question.getQuestionDecription());
            pre.setString(5, question.getQuestionContent());

            this.add(pre);
            return true;
            //Date and accect chua biet lam sao.
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean editQuetion(Question question) {
        try {
            String sql = "UPDATE `question` SET "
                    + "`subject_id`=?,"
                    + "`question_name`=?,"
                    + "`question_decription`=?,"
                    + "`question_content`=?,"
                    + "`question_date`=now(),"
                    + "`question_accept`=0 WHERE "
                    + "`question_id`=?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, question.getSubjectId());
            pre.setString(2, question.getQuestionName());
            pre.setString(3, question.getQuestionDecription());
            pre.setString(4, question.getQuestionContent());
            pre.setInt(5, question.getQuestionId());

            this.edit(pre);
            return true;
            //Date and accect chua biet lam sao.
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delQuetion(int id) {
        try {
            String sql = "DELETE FROM `question` "
                    + "WHERE `question_id`=?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);
            return this.del(pre);
            
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ResultSet findAll() {
        String sql = "SELECT * FROM `question` where `question_accept`=1";
        return this.get(sql);
    }

    @Override
    public ResultSet findByIdMember(int id) {
        try {
            String sql = "SELECT * FROM"
                    + " `question` WHERE"
                    + " `member_id`=?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);
            return this.get(pre);

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ResultSet findByAccect() {
        String sql = "SELECT `question_id`, `subject_id`,"
                + " `member_id`, `question_name`, `question_decription`,"
                + " `question_content`, `question_date`, `question_accept`"
                + " FROM `question` WHERE `question_accept`=0";

        return this.get(sql);
    }

    @Override
    public boolean editQuestionAccept(int id) {
        try {
            Question question = new Question(id);
            String sql = "UPDATE `question` SET `question_accept`= 1 WHERE `question_id` = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);
            return this.edit(pre);

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ResultSet findByidSubject(String id) {
        try {
            String sql = "SELECT * FROM"
                    + " `subject` WHERE"
                    + " `subject_id`=?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, id);
            return this.get(pre);

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean delAcceptQuestion(int id) {
        try {
            String sql = "UPDATE `question` SET `question_accept`=2 WHERE `question_id`=?";
            PreparedStatement pre = this.connection.prepareStatement(sql);
            pre.setInt(1, id);
            return this.edit(pre);
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ResultSet find(int limit, int start) {
        try {
            String sql = "SELECT * FROM `question` where `question_accept` = 1 ORDER BY `question_date` DESC LIMIT ? OFFSET ?";
            PreparedStatement pre = this.connection.prepareCall(sql);
            pre.setInt(1, limit);
            pre.setInt(2, start);
            return this.get(pre);
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ResultSet findById(int id) {
        try {
            String sql = "SELECT * FROM"
                    + " `question` WHERE"
                    + " `question_id`=?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);
            return this.get(pre);

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
