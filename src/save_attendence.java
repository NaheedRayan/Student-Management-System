
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
public class save_attendence {

    private String id, present, date;

    save_attendence(String id, String present, String date) {
        this.id = id;
        this.present = present;
        this.date = date;
    }

    void save() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student_info_sys", "root", "");
            PreparedStatement pst = con.prepareStatement("Select * from attendence where id = ? and date = ? ");
            pst.setString(1, id);
            pst.setString(2, date);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                //if the data exist than we will not add anything 
                if (rs.getString("id").equals(id) && rs.getString("date").equals(date)) {
                    JOptionPane.showMessageDialog(null, "User is already present. Try using the update button for updating the data.");
                }
            } else {
                
                PreparedStatement pst1 = con.prepareStatement("INSERT into attendence (id,present,date) values(?,?,?) ");

                pst1.setString(1, id);
                pst1.setString(2, present);
                pst1.setString(3, date);
                if (pst1.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null, "Data saved");

                } else {
                    JOptionPane.showMessageDialog(null, "Something went wrong");
                }

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(save_attendence.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
