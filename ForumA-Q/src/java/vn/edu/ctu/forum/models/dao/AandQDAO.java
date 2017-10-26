/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.models.dao;

import java.sql.ResultSet;
import vn.edu.ctu.forum.models.pojos.AandQ;

/**
 *
 * @author PC
 */
public interface AandQDAO extends BaseDAO {
    
    //xoa A & Q
    public boolean delAandQ(String question_id, String answer_id);
    //tim id
    public ResultSet findById(String id);
}
