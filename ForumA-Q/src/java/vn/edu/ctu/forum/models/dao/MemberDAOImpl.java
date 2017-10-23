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
import vn.edu.ctu.forum.models.untils.ConnectionPool;

/**
 *
 * @author NTD
 */
public class MemberDAOImpl extends BaseDAOImpl implements MemberDAO {

    public MemberDAOImpl(ConnectionPool connectionPool) {
        super(connectionPool);
    }

    @Override
    public boolean addMember(Member member) {
        try {
            String sql = "INSERT INTO `member`("
                    + "`member_id`, `member_name`, "
                    + "`member_email`, `member_pass`, "
                    + "`member_date_register`) VALUES "
                    + "(null,?,?,?,now())";
            PreparedStatement pre = this.connection.prepareStatement(sql);
            pre.setString(1, member.getMemberName());
            pre.setString(2, member.getMemberEmail());
            pre.setString(3, member.getMemberPass());
            return this.add(pre);
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean editMember(Member member) {
        try {
            String sql = "UPDATE `member` SET `member_name`=?,`member_sex`=?,`member_birthday`=?,`member_introduce`=? WHERE `member_id`=?";
            PreparedStatement pre = this.connection.prepareStatement(sql);
            pre.setString(1, member.getMemberName());
            pre.setString(2, member.getMemberSex());
            pre.setString(3, member.getStrDate());
            pre.setString(4, member.getMemberIntroduce());            
            pre.setInt(5, member.getMemberId());            
            return this.edit(pre);
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
//    public static void main(String[] args) {
//        MemberDAO m = new MemberDAOImpl(null);
//        Member mo = new Member(1, "Nguyễn Tấn Được","Nam","1996-06-01", "Admin 1");
//        System.out.println(m.editMember(mo));
//    }
    
    @Override
    public boolean delMember(int id) {
        try {
            String sql = "DELETE FROM `member` WHERE 0";
            PreparedStatement pre = this.connection.prepareStatement(sql);
            return this.delMember(id);
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ResultSet findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override

    public ResultSet findByEmail(String email) {
        try {
            String sql = "SELECT `member_id`, `member_name`, `member_email`, `member_pass`, "
                    + "`member_sex`, `member_birthday`, `member_isAdmin`, `member_date_register`, "
                    + "`member_introduce`, `member_accept` FROM `member`"
                    + " WHERE `member_email`=?";
            PreparedStatement pre = this.connection.prepareStatement(sql);
            pre.setString(1,email);
            return this.get(pre);
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

//    public static void main(String[] args) throws SQLException {
//        MemberDAO m = new MemberDAOImpl(null);
//        
//        ResultSet rs = m.findById(1);
//        
//        if (rs!=null) {
//            while (rs.next()) {
//                System.out.println(rs.getString("member_email") + "..");
//                System.out.println("none1");
//            }
//            System.out.println("if");
//        } else {
//            System.out.println("none");
//        }
//    }

    @Override
    public ResultSet findByAccept() {
        String sql = "SELECT `member_id`, `member_name`,"
                + " `member_email`, `member_pass`, `member_sex`,"
                + " `member_birthday`, `member_isAdmin`,"
                + " `member_date_register`, `member_introduce`,"
                + " `member_accept` FROM `member` WHERE `member_accept` = 0";
        return this.get(sql);
    }

    @Override
    public boolean editAcceptMember(int id) {
        try {
            Member member = new Member();
            String sql = "UPDATE `member` SET `member_accept`= 1 WHERE `member_id` = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(MemberDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ResultSet findById(int id) {
        try {
            String sql = "SELECT `member_id`, `member_name`, `member_email`, `member_pass`, "
                    + "`member_sex`, `member_birthday`, `member_isAdmin`, `member_date_register`, "
                    + "`member_introduce`, `member_accept` FROM `member`"
                    + " WHERE `member_id`=?";
            PreparedStatement pre = this.connection.prepareStatement(sql);
            pre.setInt(1,id);
            return this.get(pre);
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean changePass(int id, String pass) {
        try {
            String sql = "UPDATE `member` SET `member_pass`=? WHERE `member_id`=?";
            PreparedStatement pre = this.connection.prepareStatement(sql);
            pre.setString(1, pass);
            pre.setInt(2, id);
            return this.edit(pre);
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }    
}