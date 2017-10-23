/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.edu.ctu.forum.models.pojos.Image;
import vn.edu.ctu.forum.models.untils.ConnectionPool;

/**
 *
 * @author NTD
 */
public class ImageDAOImpl extends BaseDAOImpl implements ImageDAO {

    public ImageDAOImpl(ConnectionPool cp) {
        super(cp);
    }

    @Override
    public boolean add(Image im) {
        try {
            String sql = "INSERT INTO `image`(`image_alt`, `image_src`, `image_date_upload`) VALUES (?,?,now())";
            PreparedStatement pre = this.connection.prepareStatement(sql);
            pre.setString(1, im.getImageAlt());
            pre.setString(2, im.getImageSrc());
            return this.add(pre);
        } catch (SQLException ex) {
            Logger.getLogger(ImageDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ResultSet findById(int id) {
        try {
            String sql = "SELECT `image_id`, `image_alt`, `image_src`, `image_date_upload` FROM `image` WHERE `image_id` = ?";
            PreparedStatement pre = this.connection.prepareStatement(sql);
            pre.setInt(1, id);
            return this.get(pre);
        } catch (SQLException ex) {
            Logger.getLogger(ImageDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public Integer getLastID(Image img) {       
        try {
            String sql = "INSERT INTO `image`(`image_alt`, `image_src`, `image_date_upload`) VALUES (?,?,now())";
            PreparedStatement pre = this.connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            pre.setString(1, img.getImageAlt());
            pre.setString(2, img.getImageSrc());
            return this.addGetLastID(pre);
        } catch (SQLException ex) {
            Logger.getLogger(ImageDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

//    public static void main(String[] args) {
//
//        ImageDAO image = new ImageDAOImpl(null);
//        Image img = new Image("test", "test");
//        System.out.println(image.getLastID(img));
//
//    }
//    public static void main(String[] args) {
//        try {
//            ImageDAO imagdao = new ImageDAOImpl(null);
//            ResultSet rs = imagdao.findById(2);
//            while(rs.next()){
//                System.out.println(rs.getString(2));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ImageDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
