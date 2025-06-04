/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thinhthutha.registration;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import thinhthutha.util.DBHelper;

/**
 *
 * @author ADMIN
 */
public class RegistrationDAO implements Serializable {

    //buoc dau tien phai implements Serializable
    //viet method checkLogin
    //de check tai khoan co ton tai chua 
    public boolean checkLogin(String username, String password)
            throws SQLException, ClassNotFoundException {
        //tao bien chot ha cua phuong thuc 
        boolean result = false;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        //tao thang con nay de hung tu makeConnection vi makeConnection tra ra con

        try {
            //Buoc 13 va 14 da xong 12
            //1. model connects DB
            //1.1. khai bao bien va gan null
            //1.2. phai dong tat cac doi tuong bang moi cach
            //1.3. thuc hien xu ly
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. model truy van du lieu tu DB
                //2.1. tao cau lenh SQL
                //+Moi menh de cua cau lenh SQL phai duoc viet tren 1 dong
                //+Truoc khi xuong dong phai chen 1 khoang trang neu khong se
                //co loi syntaxFromNere
                //+Tat cac cac table ten cot phai copy tu DB neu k se co 
                //loi ObjectNotFound
                String sql = "Select username "
                        + "From Registration "
                        + "Where username = ? "
                        + "And password = ?";
                //2.2 to den cau lenh goi la qua trinh nap
                //vao trong create Statement Objects
                stm = con.prepareStatement(sql);
                //co bao nhieu dau ? truyen het vao va bat dau tu so 1 
                stm.setString(1, username);
                stm.setString(2, password);
                //2.3. exucte query
                rs = stm.executeQuery();
                //voi cau lenh CUD -> thi tra ve int >= 0
                //voi cau lenh CUD -> thi tra ve int >= 0
                //R -> ResultSet: la mot Object dac biet co 1 con tro dang tro den 1 danh sach va moi phan tu tuong ung voi
                //1 dong trong table, dong dau chua chu BOF dong cuoi chua chu EOF, con tro luon luon tro dong dau tien
                //muon dich chuyen con tro nay thi dung method next, khi next con chua du lieu thi ra ra true 
                //k con du lieu thi false 
                //Dac tinh: forward-only di thang k di nguoc lai
                //Khong bao h la null 
                //dung phuong thuc next de kiem tra co du lieu hay k
                //3. model gets du lieu tu ...
                //model set du lieu vao properties cua model
                if(rs.next()){
                    result = true;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
}
