
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ASUS
 */
public class update_attendence {

    private String id, present, date;

    update_attendence(String id, String present, String date) {
        this.id = id;
        this.present = present;
        this.date = date;

    }

    void update() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student_info_sys", "root", "");
            PreparedStatement pst = con.prepareStatement("UPDATE attendence set present = ?  where (id = ? and date = ?)");

            pst.setString(1, present);
            pst.setString(2, id);
            pst.setString(3, date);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data Updated");

           

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(save_attendence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
