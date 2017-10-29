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
import vn.edu.ctu.forum.models.untils.ConnectionPool;

/**
 *
 * @author PC
 */
public class AandQDAOImpl extends BaseDAOImpl implements AandQDAO {

    public AandQDAOImpl(ConnectionPool connectionPool) {
        super(connectionPool);
    }

    @Override
    public boolean delAandQ(String question_id, String answer_id) {
        try {
            String sql = "DELETE FROM `aandq` WHERE `question_id`=? &&`anwser_id`=?" ;
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, question_id);
            pre.setString(2, answer_id);
            return this.del(pre);
        } catch (SQLException ex) {
            Logger.getLogger(AandQDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ResultSet findById(String id) {
        try {
            String sql = "SELECT `anwser_id`, `question_id` FROM `aandq` WHERE `question_id`=?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, id);
            return this.get(pre);
        } catch (SQLException ex) {
            Logger.getLogger(AandQDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
