
import java.awt.CardLayout;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ASUS
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form New
     */
    CardLayout cardlayout;

    boolean student = false;
    boolean admin = false;

    public MainMenu() {
        initComponents();
        //setting the form at centre
        this.setLocationRelativeTo(null);
        cardlayout = (CardLayout) option_panels.getLayout();
        show_user();
        show_student_attendence();
    }

    MainMenu(String hello) {
//        JOptionPane.showMessageDialog(null, hello);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        initComponents();
        //setting the form at centre
        this.setLocationRelativeTo(null);

        show_user();
        show_student_attendence();

        cardlayout = (CardLayout) option_panels.getLayout();

        //if the admin logins
        if (hello.equals("admin")) {
            admin = true;
        } else if (hello.equals("student")) {
            student = true;
        }

        //test.setText(hello);
    }

    String imagePth = null;

    //for fetching the list of student info
    public ArrayList<user_student_model> userList() {
        ArrayList<user_student_model> userList = new ArrayList<>();
        try {
//            String str = search_bar.getText();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student_info_sys", "root", "");

            String query1 = "SELECT * FROM student";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);

            user_student_model user;

            while (rs.next()) {
                user = new user_student_model(rs.getString("username"), rs.getString("id"), rs.getString("phone_number"), rs.getString("department"), rs.getString("batch"), rs.getString("session"));
                userList.add(user);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            //System.out.println(ex);  
        }
        return userList;
    }

    public void show_user() {
        ArrayList<user_student_model> list = userList();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        //model.fireTableDataChanged();

        Object[] row = new Object[11];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getid();
            row[1] = list.get(i).getusername();
            row[2] = list.get(i).getphone_number();
            row[3] = list.get(i).getdepartment();
            row[4] = list.get(i).getbatch();
            row[5] = list.get(i).getsession();

            model.addRow(row);

        }

        jTable1.setModel(model);
        //for refresh
        //model.fireTableDataChanged();
    }

    //for fetching the list of attendence info table
    public ArrayList<student_attendence_model> attendence_user_List() {
        ArrayList<student_attendence_model> userList = new ArrayList<>();
        try {
//            String str = search_bar.getText();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student_info_sys", "root", "");

            String query1 = "SELECT * FROM attendence";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);

            student_attendence_model obj;

            while (rs.next()) {
                obj = new student_attendence_model(rs.getString("id"), rs.getString("present"), rs.getString("date"));
                userList.add(obj);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            //System.out.println(ex);  
        }
        return userList;
    }

    //this code is for showing student attendence
    public void show_student_attendence() {
        ArrayList<student_attendence_model> list = attendence_user_List();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        //model.fireTableDataChanged();

        Object[] row = new Object[3];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getdate();
            row[1] = list.get(i).getid();
            row[2] = list.get(i).getpresent();

            model.addRow(row);

        }

        jTable2.setModel(model);
//        jTable2.repaint();

        //for refresh
        //model.fireTableDataChanged();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        admin_button = new javax.swing.JButton();
        course_button = new javax.swing.JButton();
        attendence_button = new javax.swing.JButton();
        about_button = new javax.swing.JButton();
        student_button = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        results_button = new javax.swing.JButton();
        add_student_button = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        option_panels = new javax.swing.JPanel();
        student_info = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        username_student = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        email_student = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        address_student = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        phone_number_student = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        id_student = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        search_bar = new javax.swing.JTextField();
        jLabelPic = new javax.swing.JLabel();
        password_student = new javax.swing.JTextField();
        department_student = new javax.swing.JTextField();
        batch_student = new javax.swing.JTextField();
        session_student = new javax.swing.JTextField();
        blood_group_student = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        student_info_save_button = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        admin_info = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        username_admin = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        email_admin = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        address_admin = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        phone_number_admin = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        id_admin = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        password_admin = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        department_admin = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabelPic_admin = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        search_bar_admin = new javax.swing.JTextField();
        occupation_admin = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        add_student = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        username_student1 = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        email_student1 = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        address_student1 = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        phone_number_student1 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        id_student1 = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        password_student1 = new javax.swing.JPasswordField();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel68 = new javax.swing.JLabel();
        re_password_student = new javax.swing.JPasswordField();
        jCheckBox4 = new javax.swing.JCheckBox();
        student_add_button = new javax.swing.JButton();
        department_student1 = new javax.swing.JComboBox<>();
        jLabel69 = new javax.swing.JLabel();
        batch_student1 = new javax.swing.JComboBox<>();
        jLabel70 = new javax.swing.JLabel();
        session_student1 = new javax.swing.JComboBox<>();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        blood_group_student1 = new javax.swing.JComboBox<>();
        jLabel73 = new javax.swing.JLabel();
        jLabelPic1 = new javax.swing.JLabel();
        jButtonBrowse = new javax.swing.JButton();
        courses = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        Subject1 = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        Subject2 = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        Subject3 = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        Subject4 = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        Subject5 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        subject_obtained_gpa1 = new javax.swing.JTextField();
        search_bar_courses_with_id = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        enroll_button = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        student_id_course = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        subject_credit1 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        subject_credit2 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        subject_obtained_gpa2 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        subject_credit3 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        subject_obtained_gpa3 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        subject_credit4 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        subject_obtained_gpa4 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        subject_credit5 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        subject_obtained_gpa5 = new javax.swing.JTextField();
        save_button_for_credit = new javax.swing.JButton();
        results = new javax.swing.JPanel();
        attendence = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        attendence_id = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        attendence_present = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel54 = new javax.swing.JLabel();
        save_attendence = new javax.swing.JButton();
        update_attendence = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel56 = new javax.swing.JLabel();
        attendence_search_box_id = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        days_present = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        days_absent = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        attendence_percentage = new javax.swing.JTextField();
        about = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(32767, 1000));

        jSplitPane1.setDividerLocation(350);
        jSplitPane1.setDividerSize(1);
        jSplitPane1.setPreferredSize(new java.awt.Dimension(1141, 900));

        jPanel2.setBackground(new java.awt.Color(0, 77, 136));
        jPanel2.setMaximumSize(new java.awt.Dimension(32767, 900));
        jPanel2.setLayout(null);

        admin_button.setBackground(new java.awt.Color(255, 255, 255));
        admin_button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        admin_button.setForeground(new java.awt.Color(102, 102, 102));
        admin_button.setText("Admin Info");
        admin_button.setBorder(null);
        admin_button.setBorderPainted(false);
        admin_button.setOpaque(false);
        admin_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_buttonActionPerformed(evt);
            }
        });
        jPanel2.add(admin_button);
        admin_button.setBounds(41, 306, 266, 49);

        course_button.setBackground(new java.awt.Color(255, 255, 255));
        course_button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        course_button.setForeground(new java.awt.Color(102, 102, 102));
        course_button.setText("Courses");
        course_button.setBorder(null);
        course_button.setBorderPainted(false);
        course_button.setOpaque(false);
        course_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course_buttonActionPerformed(evt);
            }
        });
        jPanel2.add(course_button);
        course_button.setBounds(40, 460, 266, 49);

        attendence_button.setBackground(new java.awt.Color(255, 255, 255));
        attendence_button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        attendence_button.setForeground(new java.awt.Color(102, 102, 102));
        attendence_button.setText("Attendence");
        attendence_button.setBorder(null);
        attendence_button.setBorderPainted(false);
        attendence_button.setOpaque(false);
        attendence_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attendence_buttonActionPerformed(evt);
            }
        });
        jPanel2.add(attendence_button);
        attendence_button.setBounds(40, 610, 266, 49);

        about_button.setBackground(new java.awt.Color(255, 255, 255));
        about_button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        about_button.setForeground(new java.awt.Color(102, 102, 102));
        about_button.setText("About");
        about_button.setBorder(null);
        about_button.setBorderPainted(false);
        about_button.setOpaque(false);
        about_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                about_buttonActionPerformed(evt);
            }
        });
        jPanel2.add(about_button);
        about_button.setBounds(40, 690, 266, 49);

        student_button.setBackground(new java.awt.Color(255, 255, 255));
        student_button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        student_button.setForeground(new java.awt.Color(102, 102, 102));
        student_button.setText("Student Info");
        student_button.setBorder(null);
        student_button.setBorderPainted(false);
        student_button.setOpaque(false);
        student_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_buttonActionPerformed(evt);
            }
        });
        jPanel2.add(student_button);
        student_button.setBounds(41, 226, 266, 49);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("STMS");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(125, 83, 100, 44);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Student Management System ");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(87, 133, 172, 14);

        results_button.setBackground(new java.awt.Color(255, 255, 255));
        results_button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        results_button.setForeground(new java.awt.Color(102, 102, 102));
        results_button.setText("Results");
        results_button.setBorder(null);
        results_button.setBorderPainted(false);
        results_button.setOpaque(false);
        results_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                results_buttonActionPerformed(evt);
            }
        });
        jPanel2.add(results_button);
        results_button.setBounds(40, 540, 266, 49);

        add_student_button.setBackground(new java.awt.Color(255, 255, 255));
        add_student_button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        add_student_button.setForeground(new java.awt.Color(102, 102, 102));
        add_student_button.setText("Add Student");
        add_student_button.setBorder(null);
        add_student_button.setBorderPainted(false);
        add_student_button.setOpaque(false);
        add_student_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_student_buttonActionPerformed(evt);
            }
        });
        jPanel2.add(add_student_button);
        add_student_button.setBounds(40, 380, 266, 49);

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/WallX_150440_1080x1920.jpeg"))); // NOI18N
        jLabel51.setText("jLabel51");
        jPanel2.add(jLabel51);
        jLabel51.setBounds(0, -6, 350, 1190);

        jSplitPane1.setLeftComponent(jPanel2);

        option_panels.setMaximumSize(new java.awt.Dimension(2147483647, 900));
        option_panels.setPreferredSize(new java.awt.Dimension(1138, 900));
        option_panels.setLayout(new java.awt.CardLayout());

        student_info.setBackground(new java.awt.Color(255, 255, 255));
        student_info.setMaximumSize(new java.awt.Dimension(32767, 900));
        student_info.setPreferredSize(new java.awt.Dimension(1138, 900));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 153, 153));
        jLabel14.setText("Username");

        username_student.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        username_student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username_studentActionPerformed(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 153, 153));
        jLabel15.setText("email");

        email_student.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        email_student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                email_studentActionPerformed(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 153, 153));
        jLabel16.setText("Address");

        address_student.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        address_student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                address_studentActionPerformed(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(153, 153, 153));
        jLabel17.setText("Phone Number");

        phone_number_student.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        phone_number_student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phone_number_studentActionPerformed(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(153, 153, 153));
        jLabel18.setText("ID");

        id_student.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        id_student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_studentActionPerformed(evt);
            }
        });

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(153, 153, 153));
        jLabel19.setText("Password");

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(153, 153, 153));
        jLabel21.setText("Department");

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(153, 153, 153));
        jLabel22.setText("Batch(University)");

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(153, 153, 153));
        jLabel23.setText("Session");

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(153, 153, 153));
        jLabel24.setText("Blood Group");

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(153, 153, 153));
        jLabel20.setText("Search");

        search_bar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        search_bar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_barActionPerformed(evt);
            }
        });
        search_bar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_barKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search_barKeyTyped(evt);
            }
        });

        jLabelPic.setBackground(new java.awt.Color(204, 204, 204));
        jLabelPic.setOpaque(true);

        password_student.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        password_student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_studentActionPerformed(evt);
            }
        });

        department_student.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        department_student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                department_studentActionPerformed(evt);
            }
        });

        batch_student.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        batch_student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batch_studentActionPerformed(evt);
            }
        });

        session_student.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        session_student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                session_studentActionPerformed(evt);
            }
        });

        blood_group_student.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        blood_group_student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blood_group_studentActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel8.setText("Student Information");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Username", "Phone Number", "Department", "Batch", "Session"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(3).setMinWidth(150);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(4).setMinWidth(30);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        student_info_save_button.setBackground(new java.awt.Color(0, 0, 0));
        student_info_save_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        student_info_save_button.setForeground(new java.awt.Color(255, 255, 255));
        student_info_save_button.setText("Save and Update");
        student_info_save_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        student_info_save_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_info_save_buttonActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Remove");

        javax.swing.GroupLayout student_infoLayout = new javax.swing.GroupLayout(student_info);
        student_info.setLayout(student_infoLayout);
        student_infoLayout.setHorizontalGroup(
            student_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(student_infoLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(student_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(student_infoLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel20)
                        .addGap(284, 284, 284))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, student_infoLayout.createSequentialGroup()
                        .addGroup(student_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phone_number_student, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(email_student, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(address_student, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel18)
                            .addComponent(jLabel24)
                            .addComponent(jLabel23)
                            .addComponent(jLabel19)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(blood_group_student, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(session_student, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(batch_student, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(password_student, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(department_student, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id_student, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(username_student, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addGroup(student_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(student_infoLayout.createSequentialGroup()
                                .addComponent(jLabelPic, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(search_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(student_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(student_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE))
                                .addGroup(student_infoLayout.createSequentialGroup()
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(75, 75, 75)
                                    .addComponent(student_info_save_button, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(19, 19, 19))))
        );
        student_infoLayout.setVerticalGroup(
            student_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(student_infoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(student_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(student_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(student_infoLayout.createSequentialGroup()
                        .addGroup(student_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(username_student, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(search_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(email_student, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(address_student, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phone_number_student, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelPic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(student_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(student_infoLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id_student, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(password_student, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(department_student, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(batch_student, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(session_student, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(blood_group_student, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(34, 34, 34)
                .addGroup(student_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(student_info_save_button, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        option_panels.add(student_info, "student_card");

        admin_info.setBackground(new java.awt.Color(255, 255, 255));
        admin_info.setMaximumSize(new java.awt.Dimension(32767, 900));
        admin_info.setPreferredSize(new java.awt.Dimension(1113, 900));

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(153, 153, 153));
        jLabel35.setText("Username");

        username_admin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        username_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username_adminActionPerformed(evt);
            }
        });

        jLabel36.setBackground(new java.awt.Color(255, 255, 255));
        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(153, 153, 153));
        jLabel36.setText("email");

        email_admin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        email_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                email_adminActionPerformed(evt);
            }
        });

        jLabel37.setBackground(new java.awt.Color(255, 255, 255));
        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(153, 153, 153));
        jLabel37.setText("Address");

        address_admin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        address_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                address_adminActionPerformed(evt);
            }
        });

        jLabel38.setBackground(new java.awt.Color(255, 255, 255));
        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(153, 153, 153));
        jLabel38.setText("Phone Number");

        phone_number_admin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        phone_number_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phone_number_adminActionPerformed(evt);
            }
        });

        jLabel39.setBackground(new java.awt.Color(255, 255, 255));
        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(153, 153, 153));
        jLabel39.setText("ID");

        id_admin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        id_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_adminActionPerformed(evt);
            }
        });

        jLabel40.setBackground(new java.awt.Color(255, 255, 255));
        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(153, 153, 153));
        jLabel40.setText("Password");

        password_admin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        password_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_adminActionPerformed(evt);
            }
        });

        jLabel41.setBackground(new java.awt.Color(255, 255, 255));
        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(153, 153, 153));
        jLabel41.setText("Department");

        department_admin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        department_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                department_adminActionPerformed(evt);
            }
        });

        jLabel42.setBackground(new java.awt.Color(255, 255, 255));
        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(153, 153, 153));
        jLabel42.setText("Occupation");

        jLabelPic_admin.setBackground(new java.awt.Color(204, 204, 204));
        jLabelPic_admin.setOpaque(true);

        jLabel43.setBackground(new java.awt.Color(255, 255, 255));
        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(153, 153, 153));
        jLabel43.setText("Search");

        search_bar_admin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        search_bar_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_bar_adminActionPerformed(evt);
            }
        });
        search_bar_admin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_bar_adminKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search_bar_adminKeyTyped(evt);
            }
        });

        occupation_admin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        occupation_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                occupation_adminActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel10.setText("Admin Information");

        javax.swing.GroupLayout admin_infoLayout = new javax.swing.GroupLayout(admin_info);
        admin_info.setLayout(admin_infoLayout);
        admin_infoLayout.setHorizontalGroup(
            admin_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(admin_infoLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(admin_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(occupation_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(department_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(password_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addGroup(admin_infoLayout.createSequentialGroup()
                        .addGroup(admin_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(admin_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel35)
                                .addComponent(phone_number_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel38)
                                .addComponent(email_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel36)
                                .addComponent(address_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel37)
                                .addComponent(username_admin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, admin_infoLayout.createSequentialGroup()
                                    .addComponent(jLabel42)
                                    .addGap(241, 241, 241)))
                            .addComponent(jLabel39)
                            .addComponent(id_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(admin_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(admin_infoLayout.createSequentialGroup()
                                .addComponent(jLabelPic_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addGroup(admin_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(search_bar_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel43))))))
                .addContainerGap())
        );
        admin_infoLayout.setVerticalGroup(
            admin_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(admin_infoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel10)
                .addGap(28, 28, 28)
                .addGroup(admin_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(admin_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(admin_infoLayout.createSequentialGroup()
                        .addComponent(jLabelPic_admin, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                        .addGap(554, 554, 554))
                    .addGroup(admin_infoLayout.createSequentialGroup()
                        .addComponent(search_bar_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(admin_infoLayout.createSequentialGroup()
                        .addComponent(username_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(email_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(address_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phone_number_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(password_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(department_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(occupation_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        option_panels.add(admin_info, "admin_card");

        add_student.setBackground(new java.awt.Color(255, 255, 255));

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel60.setText("Add Student");

        jLabel61.setBackground(new java.awt.Color(255, 255, 255));
        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(153, 153, 153));
        jLabel61.setText("Enter student details below");

        jLabel62.setBackground(new java.awt.Color(255, 255, 255));
        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(153, 153, 153));
        jLabel62.setText("Username");

        username_student1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        username_student1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username_student1ActionPerformed(evt);
            }
        });

        jLabel63.setBackground(new java.awt.Color(255, 255, 255));
        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(153, 153, 153));
        jLabel63.setText("email");

        email_student1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        email_student1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                email_student1ActionPerformed(evt);
            }
        });

        jLabel64.setBackground(new java.awt.Color(255, 255, 255));
        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(153, 153, 153));
        jLabel64.setText("Address");

        address_student1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        address_student1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                address_student1ActionPerformed(evt);
            }
        });

        jLabel65.setBackground(new java.awt.Color(255, 255, 255));
        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(153, 153, 153));
        jLabel65.setText("Phone Number");

        phone_number_student1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        phone_number_student1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phone_number_student1ActionPerformed(evt);
            }
        });

        jLabel66.setBackground(new java.awt.Color(255, 255, 255));
        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(153, 153, 153));
        jLabel66.setText("ID");

        id_student1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        id_student1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_student1ActionPerformed(evt);
            }
        });

        jLabel67.setBackground(new java.awt.Color(255, 255, 255));
        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(153, 153, 153));
        jLabel67.setText("Password");

        password_student1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        password_student1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_student1ActionPerformed(evt);
            }
        });

        jCheckBox3.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox3.setText("Show password");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jLabel68.setBackground(new java.awt.Color(255, 255, 255));
        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(153, 153, 153));
        jLabel68.setText("Re - Password");

        re_password_student.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        re_password_student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                re_password_studentActionPerformed(evt);
            }
        });

        jCheckBox4.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox4.setText("Show password");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        student_add_button.setBackground(new java.awt.Color(0, 0, 0));
        student_add_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        student_add_button.setForeground(new java.awt.Color(255, 255, 255));
        student_add_button.setText("Add Student");
        student_add_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        student_add_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_add_buttonActionPerformed(evt);
            }
        });

        department_student1.setEditable(true);
        department_student1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        department_student1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dept of Computer Science and Engineering", "Dept of Mathematics", "Dept of Physics", "Dept of Islamic Studies", "Dept of Finance" }));
        department_student1.setBorder(null);
        department_student1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                department_student1ActionPerformed(evt);
            }
        });

        jLabel69.setBackground(new java.awt.Color(255, 255, 255));
        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(153, 153, 153));
        jLabel69.setText("Department");

        batch_student1.setEditable(true);
        batch_student1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        batch_student1.setMaximumRowCount(100);
        batch_student1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", " " }));
        batch_student1.setBorder(null);
        batch_student1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batch_student1ActionPerformed(evt);
            }
        });

        jLabel70.setBackground(new java.awt.Color(255, 255, 255));
        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(153, 153, 153));
        jLabel70.setText("Batch(University)");

        session_student1.setEditable(true);
        session_student1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        session_student1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2018-19", "2019-20", "2020-21", "2021-22", "2022-23", " " }));
        session_student1.setBorder(null);
        session_student1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                session_student1ActionPerformed(evt);
            }
        });

        jLabel71.setBackground(new java.awt.Color(255, 255, 255));
        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(153, 153, 153));
        jLabel71.setText("Session");

        jLabel72.setBackground(new java.awt.Color(255, 255, 255));
        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(153, 153, 153));
        jLabel72.setText("Blood Group");

        blood_group_student1.setEditable(true);
        blood_group_student1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        blood_group_student1.setMaximumRowCount(15);
        blood_group_student1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "O positive", "O negative", "A positive", "A negative", "B positive", "B negative", "AB positive", "AB negative", "other" }));
        blood_group_student1.setBorder(null);
        blood_group_student1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blood_group_student1ActionPerformed(evt);
            }
        });

        jLabel73.setBackground(new java.awt.Color(255, 255, 255));
        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(153, 153, 153));
        jLabel73.setText("Picture");

        jLabelPic1.setBackground(new java.awt.Color(204, 204, 204));
        jLabelPic1.setOpaque(true);

        jButtonBrowse.setBackground(new java.awt.Color(0, 0, 0));
        jButtonBrowse.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonBrowse.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBrowse.setText("Browse");
        jButtonBrowse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBrowseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout add_studentLayout = new javax.swing.GroupLayout(add_student);
        add_student.setLayout(add_studentLayout);
        add_studentLayout.setHorizontalGroup(
            add_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(add_studentLayout.createSequentialGroup()
                .addGroup(add_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(add_studentLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(add_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCheckBox3)
                            .addGroup(add_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(password_student1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel67)
                                .addComponent(username_student1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel62)
                                .addComponent(jLabel61)
                                .addComponent(email_student1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel63)
                                .addComponent(address_student1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel64)
                                .addComponent(phone_number_student1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel65)
                                .addComponent(id_student1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel66))
                            .addComponent(jCheckBox4)
                            .addGroup(add_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(re_password_student, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel68)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                        .addGroup(add_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(add_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(department_student1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel69)
                                .addComponent(batch_student1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel70)
                                .addComponent(session_student1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel71)
                                .addComponent(blood_group_student1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel72)
                                .addComponent(jLabel73)
                                .addComponent(jLabelPic1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(student_add_button, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(add_studentLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel60)
                        .addGap(235, 235, 235)))
                .addGap(243, 243, 243))
        );
        add_studentLayout.setVerticalGroup(
            add_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(add_studentLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel60)
                .addGap(31, 31, 31)
                .addComponent(jLabel61)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(add_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(add_studentLayout.createSequentialGroup()
                        .addComponent(jLabel62)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(username_student1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                    .addGroup(add_studentLayout.createSequentialGroup()
                        .addComponent(jLabel69)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(department_student1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(add_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(add_studentLayout.createSequentialGroup()
                        .addComponent(jLabel70)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(batch_student1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel71)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(session_student1))
                    .addGroup(add_studentLayout.createSequentialGroup()
                        .addComponent(jLabel63)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(email_student1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel64)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(address_student1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(add_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(add_studentLayout.createSequentialGroup()
                        .addComponent(jLabel72)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(blood_group_student1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel73)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPic1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jButtonBrowse))
                    .addGroup(add_studentLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel65)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phone_number_student1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel66)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id_student1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel67)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(password_student1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel68)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(re_password_student, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox4)))
                .addGap(170, 170, 170)
                .addComponent(student_add_button, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );

        option_panels.add(add_student, "add_student_card");

        courses.setBackground(new java.awt.Color(255, 255, 255));
        courses.setMaximumSize(new java.awt.Dimension(32767, 900));
        courses.setPreferredSize(new java.awt.Dimension(1138, 900));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel9.setText("Courses");

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(153, 153, 153));
        jLabel25.setText("Subject 1");

        Subject1.setEditable(true);
        Subject1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Subject1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enroll", "Cancel" }));
        Subject1.setBorder(null);
        Subject1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Subject1ActionPerformed(evt);
            }
        });

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(153, 153, 153));
        jLabel26.setText("Subject 2");

        Subject2.setEditable(true);
        Subject2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Subject2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enroll", "Cancel" }));
        Subject2.setBorder(null);
        Subject2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Subject2ActionPerformed(evt);
            }
        });

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(153, 153, 153));
        jLabel27.setText("Subject 3");

        Subject3.setEditable(true);
        Subject3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Subject3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enroll", "Cancel" }));
        Subject3.setBorder(null);
        Subject3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Subject3ActionPerformed(evt);
            }
        });

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(153, 153, 153));
        jLabel28.setText("Subject 4");

        Subject4.setEditable(true);
        Subject4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Subject4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enroll", "Cancel" }));
        Subject4.setBorder(null);
        Subject4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Subject4ActionPerformed(evt);
            }
        });

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(153, 153, 153));
        jLabel29.setText("Subject 5");

        Subject5.setEditable(true);
        Subject5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Subject5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enroll", "Cancel" }));
        Subject5.setBorder(null);
        Subject5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Subject5ActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setText("ID of the student:");

        subject_obtained_gpa1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        subject_obtained_gpa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subject_obtained_gpa1ActionPerformed(evt);
            }
        });

        search_bar_courses_with_id.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        search_bar_courses_with_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_bar_courses_with_idActionPerformed(evt);
            }
        });
        search_bar_courses_with_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_bar_courses_with_idKeyReleased(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("Search with id:");

        enroll_button.setBackground(new java.awt.Color(0, 0, 0));
        enroll_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        enroll_button.setForeground(new java.awt.Color(255, 255, 255));
        enroll_button.setText("Enroll ");
        enroll_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        enroll_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enroll_buttonActionPerformed(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setText("Subject 1 Credit");

        student_id_course.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        student_id_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_id_courseActionPerformed(evt);
            }
        });

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(153, 153, 153));
        jLabel30.setText("Subject 1 Obtained GPA");

        subject_credit1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        subject_credit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subject_credit1ActionPerformed(evt);
            }
        });

        jLabel31.setBackground(new java.awt.Color(255, 255, 255));
        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(153, 153, 153));
        jLabel31.setText("Subject 2 Credit");

        subject_credit2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        subject_credit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subject_credit2ActionPerformed(evt);
            }
        });

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(153, 153, 153));
        jLabel32.setText("Subject 2 Obtained GPA");

        subject_obtained_gpa2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        subject_obtained_gpa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subject_obtained_gpa2ActionPerformed(evt);
            }
        });

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(153, 153, 153));
        jLabel33.setText("Subject 3 Credit");

        subject_credit3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        subject_credit3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subject_credit3ActionPerformed(evt);
            }
        });

        jLabel34.setBackground(new java.awt.Color(255, 255, 255));
        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(153, 153, 153));
        jLabel34.setText("Subject 3 Obtained GPA");

        subject_obtained_gpa3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        subject_obtained_gpa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subject_obtained_gpa3ActionPerformed(evt);
            }
        });

        jLabel44.setBackground(new java.awt.Color(255, 255, 255));
        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(153, 153, 153));
        jLabel44.setText("Subject 4 Credit");

        subject_credit4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        subject_credit4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subject_credit4ActionPerformed(evt);
            }
        });

        jLabel45.setBackground(new java.awt.Color(255, 255, 255));
        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(153, 153, 153));
        jLabel45.setText("Subject 4 Obtained GPA");

        subject_obtained_gpa4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        subject_obtained_gpa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subject_obtained_gpa4ActionPerformed(evt);
            }
        });

        jLabel46.setBackground(new java.awt.Color(255, 255, 255));
        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(153, 153, 153));
        jLabel46.setText("Subject 5 Credit");

        subject_credit5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        subject_credit5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subject_credit5ActionPerformed(evt);
            }
        });

        jLabel47.setBackground(new java.awt.Color(255, 255, 255));
        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(153, 153, 153));
        jLabel47.setText("Subject 5 Obtained GPA");

        subject_obtained_gpa5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        subject_obtained_gpa5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subject_obtained_gpa5ActionPerformed(evt);
            }
        });

        save_button_for_credit.setBackground(new java.awt.Color(0, 0, 0));
        save_button_for_credit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        save_button_for_credit.setForeground(new java.awt.Color(255, 255, 255));
        save_button_for_credit.setText("Save");
        save_button_for_credit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save_button_for_credit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_button_for_creditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout coursesLayout = new javax.swing.GroupLayout(courses);
        courses.setLayout(coursesLayout);
        coursesLayout.setHorizontalGroup(
            coursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, coursesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(465, 465, 465))
            .addGroup(coursesLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(coursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(enroll_button, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(coursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel11)
                        .addComponent(Subject5, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel29)
                        .addComponent(Subject4, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel28)
                        .addComponent(Subject3, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel27)
                        .addComponent(Subject2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel26)
                        .addComponent(Subject1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25)
                        .addComponent(student_id_course, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(148, 148, 148)
                .addGroup(coursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(coursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel12)
                        .addGroup(coursesLayout.createSequentialGroup()
                            .addGroup(coursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13)
                                .addComponent(jLabel30)
                                .addGroup(coursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(subject_obtained_gpa1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                    .addComponent(subject_credit1, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGap(90, 90, 90)
                            .addGroup(coursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel31)
                                .addComponent(jLabel32)
                                .addGroup(coursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(subject_obtained_gpa2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(subject_credit2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel44)
                                .addComponent(jLabel45)
                                .addGroup(coursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(subject_obtained_gpa4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(subject_credit4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(search_bar_courses_with_id)
                        .addComponent(save_button_for_credit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel33)
                    .addComponent(jLabel34)
                    .addGroup(coursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(coursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46)
                            .addComponent(jLabel47)
                            .addGroup(coursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(subject_obtained_gpa5, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(subject_credit5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(coursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(subject_obtained_gpa3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(subject_credit3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(173, Short.MAX_VALUE))
        );
        coursesLayout.setVerticalGroup(
            coursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coursesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(26, 26, 26)
                .addGroup(coursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(coursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_bar_courses_with_id, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(student_id_course, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(coursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(coursesLayout.createSequentialGroup()
                        .addGroup(coursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(coursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(coursesLayout.createSequentialGroup()
                                .addComponent(Subject1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Subject2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Subject3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Subject4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Subject5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(coursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(coursesLayout.createSequentialGroup()
                                    .addComponent(jLabel44)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(subject_credit4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel45)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(subject_obtained_gpa4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(coursesLayout.createSequentialGroup()
                                    .addComponent(subject_credit1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel30)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(subject_obtained_gpa1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(50, 50, 50)
                                    .addComponent(jLabel33)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(subject_credit3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel34)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(subject_obtained_gpa3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(coursesLayout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subject_credit2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subject_obtained_gpa2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(63, 63, 63)
                .addComponent(jLabel46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subject_credit5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subject_obtained_gpa5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addGroup(coursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enroll_button, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save_button_for_credit, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(185, 185, 185))
        );

        option_panels.add(courses, "grades_card");

        results.setBackground(new java.awt.Color(102, 255, 102));
        results.setMaximumSize(new java.awt.Dimension(32767, 900));
        results.setPreferredSize(new java.awt.Dimension(1138, 900));

        javax.swing.GroupLayout resultsLayout = new javax.swing.GroupLayout(results);
        results.setLayout(resultsLayout);
        resultsLayout.setHorizontalGroup(
            resultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1138, Short.MAX_VALUE)
        );
        resultsLayout.setVerticalGroup(
            resultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 998, Short.MAX_VALUE)
        );

        option_panels.add(results, "results_card");

        attendence.setBackground(new java.awt.Color(255, 255, 255));
        attendence.setMaximumSize(new java.awt.Dimension(32767, 900));
        attendence.setPreferredSize(new java.awt.Dimension(1138, 900));

        jLabel52.setBackground(new java.awt.Color(255, 255, 255));
        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(153, 153, 153));
        jLabel52.setText("ID");

        attendence_id.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        attendence_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attendence_idActionPerformed(evt);
            }
        });

        jLabel53.setBackground(new java.awt.Color(255, 255, 255));
        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(153, 153, 153));
        jLabel53.setText("Present");

        attendence_present.setEditable(true);
        attendence_present.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        attendence_present.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Present", "Absent" }));
        attendence_present.setBorder(null);
        attendence_present.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attendence_presentActionPerformed(evt);
            }
        });

        jDateChooser1.setDateFormatString("dd/MM/yyyy");

        jLabel54.setBackground(new java.awt.Color(255, 255, 255));
        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(153, 153, 153));
        jLabel54.setText("Date");

        save_attendence.setBackground(new java.awt.Color(0, 0, 0));
        save_attendence.setForeground(new java.awt.Color(255, 255, 255));
        save_attendence.setText("Save");
        save_attendence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_attendenceActionPerformed(evt);
            }
        });

        update_attendence.setBackground(new java.awt.Color(0, 0, 0));
        update_attendence.setForeground(new java.awt.Color(255, 255, 255));
        update_attendence.setText("Update");
        update_attendence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_attendenceActionPerformed(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel55.setText("Attendence");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "ID", "P/A"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel56.setBackground(new java.awt.Color(255, 255, 255));
        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(153, 153, 153));
        jLabel56.setText("Search ID");

        attendence_search_box_id.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        attendence_search_box_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attendence_search_box_idActionPerformed(evt);
            }
        });
        attendence_search_box_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                attendence_search_box_idKeyReleased(evt);
            }
        });

        jLabel57.setBackground(new java.awt.Color(255, 255, 255));
        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(153, 153, 153));
        jLabel57.setText("No of Days Present");

        days_present.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        days_present.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                days_presentActionPerformed(evt);
            }
        });

        jLabel58.setBackground(new java.awt.Color(255, 255, 255));
        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(153, 153, 153));
        jLabel58.setText("No of Days Absent");

        days_absent.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        days_absent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                days_absentActionPerformed(evt);
            }
        });

        jLabel59.setBackground(new java.awt.Color(255, 255, 255));
        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(153, 153, 153));
        jLabel59.setText("Percentage%");

        attendence_percentage.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        attendence_percentage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attendence_percentageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout attendenceLayout = new javax.swing.GroupLayout(attendence);
        attendence.setLayout(attendenceLayout);
        attendenceLayout.setHorizontalGroup(
            attendenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(attendenceLayout.createSequentialGroup()
                .addGroup(attendenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(attendenceLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(attendenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(attendenceLayout.createSequentialGroup()
                                .addGroup(attendenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(attendenceLayout.createSequentialGroup()
                                        .addComponent(update_attendence, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                        .addComponent(save_attendence, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(attendenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel54)
                                        .addGroup(attendenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(attendence_present, 0, 304, Short.MAX_VALUE)
                                            .addComponent(jLabel53)
                                            .addComponent(attendence_id, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                                            .addComponent(jLabel52)
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(attendenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(attendence_search_box_id, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                                    .addComponent(jLabel56)
                                    .addComponent(days_present, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                                    .addComponent(jLabel57)
                                    .addComponent(days_absent, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                                    .addComponent(jLabel58)
                                    .addComponent(attendence_percentage, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                                    .addComponent(jLabel59)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1033, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(attendenceLayout.createSequentialGroup()
                        .addGap(466, 466, 466)
                        .addComponent(jLabel55)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        attendenceLayout.setVerticalGroup(
            attendenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(attendenceLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel55)
                .addGroup(attendenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(attendenceLayout.createSequentialGroup()
                        .addGroup(attendenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(attendenceLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(attendenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(attendenceLayout.createSequentialGroup()
                                        .addComponent(jLabel52)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(attendence_id, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(attendenceLayout.createSequentialGroup()
                                        .addComponent(jLabel56)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(attendence_search_box_id, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel53)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(attendence_present, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(attendenceLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel57)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(days_present, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(attendenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(attendenceLayout.createSequentialGroup()
                                .addComponent(jLabel54)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(attendenceLayout.createSequentialGroup()
                                .addComponent(jLabel58)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(days_absent, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(attendenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(save_attendence, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                            .addComponent(update_attendence, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(attendenceLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel59)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(attendence_percentage, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(83, 83, 83)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(323, 323, 323))
        );

        option_panels.add(attendence, "attendence_card");

        about.setBackground(new java.awt.Color(255, 255, 255));
        about.setMaximumSize(new java.awt.Dimension(32767, 900));
        about.setPreferredSize(new java.awt.Dimension(1138, 900));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 46)); // NOI18N
        jLabel4.setText("STMS");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Student Management System ");

        jLabel48.setBackground(new java.awt.Color(255, 255, 255));
        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel48.setText("A powerful , yet easy-to-use ");

        jLabel49.setBackground(new java.awt.Color(255, 255, 255));
        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel49.setText("application for managing");

        jLabel50.setBackground(new java.awt.Color(255, 255, 255));
        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel50.setText("data");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Student Management System ");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("Developed by");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Project Scarlet");

        javax.swing.GroupLayout aboutLayout = new javax.swing.GroupLayout(about);
        about.setLayout(aboutLayout);
        aboutLayout.setHorizontalGroup(
            aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutLayout.createSequentialGroup()
                .addContainerGap(326, Short.MAX_VALUE)
                .addGroup(aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aboutLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(640, 640, 640))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aboutLayout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addGap(368, 368, 368))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aboutLayout.createSequentialGroup()
                        .addComponent(jLabel49)
                        .addGap(400, 400, 400))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aboutLayout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addGap(527, 527, 527))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aboutLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(429, 429, 429))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aboutLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(499, 499, 499))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aboutLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(499, 499, 499))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aboutLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(484, 484, 484))))
        );
        aboutLayout.setVerticalGroup(
            aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutLayout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(78, 78, 78)
                .addComponent(jLabel48)
                .addGap(1, 1, 1)
                .addComponent(jLabel49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel50)
                .addGap(225, 225, 225)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(276, Short.MAX_VALUE))
        );

        option_panels.add(about, "about_card");

        jSplitPane1.setRightComponent(option_panels);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1490, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void admin_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_buttonActionPerformed
        // TODO add your handling code here:
        cardlayout.show(option_panels, "admin_card");
    }//GEN-LAST:event_admin_buttonActionPerformed

    private void course_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_course_buttonActionPerformed
        // TODO add your handling code here:
        cardlayout.show(option_panels, "grades_card");
    }//GEN-LAST:event_course_buttonActionPerformed

    private void attendence_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attendence_buttonActionPerformed
        // TODO add your handling code here:
        cardlayout.show(option_panels, "attendence_card");
    }//GEN-LAST:event_attendence_buttonActionPerformed

    private void about_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_about_buttonActionPerformed
        // TODO add your handling code here:
        cardlayout.show(option_panels, "about_card");
    }//GEN-LAST:event_about_buttonActionPerformed

    private void student_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_buttonActionPerformed
        // TODO add your handling code here:
        cardlayout.show(option_panels, "student_card");

    }//GEN-LAST:event_student_buttonActionPerformed

    private void username_studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username_studentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_username_studentActionPerformed

    private void email_studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_email_studentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_email_studentActionPerformed

    private void address_studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_address_studentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_address_studentActionPerformed

    private void phone_number_studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phone_number_studentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phone_number_studentActionPerformed

    private void id_studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_studentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_studentActionPerformed

    private void search_barActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_barActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_barActionPerformed

    private void search_barKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_barKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_search_barKeyTyped

    public ImageIcon resizePic(String picPath) {
        ImageIcon myImg = new ImageIcon(picPath);
        Image img = myImg.getImage().getScaledInstance(jLabelPic.getWidth(), jLabelPic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon myPicture = new ImageIcon(img);
        return myPicture;
    }

    public ImageIcon resizePic1(String picPath) {
        ImageIcon myImg = new ImageIcon(picPath);
        Image img = myImg.getImage().getScaledInstance(jLabelPic1.getWidth(), jLabelPic1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon myPicture = new ImageIcon(img);
        return myPicture;
    }
    private void search_barKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_barKeyReleased

        //for searching data in the table
        DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
        String search = search_bar.getText();

        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(table);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
        // TODO add your handling code here:
        try {

            String str = search_bar.getText();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student_info_sys", "root", "");
            PreparedStatement st = con.prepareStatement("select * from student where username=? or email= ? or address= ?  or phone_number = ? or id = ? or password = ? or department=? or batch =? or session= ? or blood_group = ?");
            st.setString(1, str);
            st.setString(2, str);
            st.setString(3, str);
            st.setString(4, str);
            st.setString(5, str);
            st.setString(6, str);
            st.setString(7, str);
            st.setString(8, str);
            st.setString(9, str);
            st.setString(10, str);

            //Excuting Query  
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String s1 = rs.getString("username");
                String s2 = rs.getString("email");
                String s3 = rs.getString("address");
                String s4 = rs.getString("phone_number");
                String s5 = rs.getString("id");
                String s6 = rs.getString("password");
                String s7 = rs.getString("department");
                String s8 = rs.getString("batch");
                String s9 = rs.getString("session");
                String s10 = rs.getString("blood_group");
                byte[] image = rs.getBytes("picture");

                ImageIcon myImg = new ImageIcon(image);
                //this is used for scaling
                Image img = myImg.getImage().getScaledInstance(jLabelPic.getWidth(), jLabelPic.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon myPicture = new ImageIcon(img);
                jLabelPic.setIcon(myPicture);

                //Sets Records in TextFields.  
                username_student.setText(s1);
                email_student.setText(s2);
                address_student.setText(s3);
                phone_number_student.setText(s4);
                id_student.setText(s5);
                password_student.setText(s6);
                department_student.setText(s7);
                batch_student.setText(s8);
                session_student.setText(s9);
                blood_group_student.setText(s10);

            }
            //Create Exception Handler  
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_search_barKeyReleased

    private void password_studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_studentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password_studentActionPerformed

    private void department_studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_department_studentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_department_studentActionPerformed

    private void batch_studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batch_studentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_batch_studentActionPerformed

    private void session_studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_session_studentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_session_studentActionPerformed

    private void blood_group_studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blood_group_studentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_blood_group_studentActionPerformed

    private void Subject1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Subject1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Subject1ActionPerformed

    private void Subject2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Subject2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Subject2ActionPerformed

    private void Subject3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Subject3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Subject3ActionPerformed

    private void Subject4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Subject4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Subject4ActionPerformed

    private void Subject5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Subject5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Subject5ActionPerformed

    private void subject_obtained_gpa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subject_obtained_gpa1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subject_obtained_gpa1ActionPerformed

    private void search_bar_courses_with_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_bar_courses_with_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_bar_courses_with_idActionPerformed

    private void enroll_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enroll_buttonActionPerformed
        // TODO add your handling code here:

        try {

            String id = student_id_course.getText();

            String subject1 = Subject1.getSelectedItem().toString();
            String subject2 = Subject2.getSelectedItem().toString();
            String subject3 = Subject3.getSelectedItem().toString();
            String subject4 = Subject4.getSelectedItem().toString();
            String subject5 = Subject5.getSelectedItem().toString();

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student_info_sys", "root", "");
            PreparedStatement pst = con.prepareStatement("UPDATE courses set Subject1 = ? ,Subject2 = ? ,Subject3 = ? ,Subject4 = ? ,Subject5= ?  where id = ?");

            pst.setString(1, subject1);
            pst.setString(2, subject2);
            pst.setString(3, subject3);
            pst.setString(4, subject4);
            pst.setString(5, subject5);

            pst.setString(6, id);

            if (pst.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Data saved");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid User");
            }

            //JOptionPane.showMessageDialog(this, "Record added");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SignUpForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SignUpForm.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_enroll_buttonActionPerformed

    private void search_bar_courses_with_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_bar_courses_with_idKeyReleased
        // TODO add your handling code here:

        try {

            String str = search_bar_courses_with_id.getText();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student_info_sys", "root", "");
            PreparedStatement st = con.prepareStatement("select * from courses where id=? or Subject1= ? or Subject2= ?  or Subject3 = ? or Subject4 = ? or Subject5 = ? ");
            st.setString(1, str);
            st.setString(2, str);
            st.setString(3, str);
            st.setString(4, str);
            st.setString(5, str);
            st.setString(6, str);

            //Excuting Query  
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String s1 = rs.getString("id");
                String s2 = rs.getString("Subject1");
                String s3 = rs.getString("Subject2");
                String s4 = rs.getString("Subject3");
                String s5 = rs.getString("Subject4");
                String s6 = rs.getString("Subject5");

                //Sets Records in TextFields.  
                Subject1.getEditor().setItem(s2);
                Subject2.getEditor().setItem(s3);
                Subject3.getEditor().setItem(s4);
                Subject4.getEditor().setItem(s5);
                Subject5.getEditor().setItem(s6);

                student_id_course.setText(s1);

                //this part of code is for the subject part
                Class.forName("com.mysql.jdbc.Driver");
                Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost/student_info_sys", "root", "");
                PreparedStatement st1 = con1.prepareStatement("select * from subject1 where id=? ");
                st1.setString(1, str);

                ResultSet rs1 = st1.executeQuery();
                if (rs1.next()) {
                    String credit = rs1.getString("credit");
                    String obtained_gpa = rs1.getString("obtained_gpa");

                    subject_credit1.setText(credit);
                    subject_obtained_gpa1.setText(obtained_gpa);
                }

                Class.forName("com.mysql.jdbc.Driver");
                Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost/student_info_sys", "root", "");
                PreparedStatement st2 = con2.prepareStatement("select * from subject2 where id=? ");
                st2.setString(1, str);

                ResultSet rs2 = st2.executeQuery();
                if (rs2.next()) {
                    String credit = rs2.getString("credit");
                    String obtained_gpa = rs2.getString("obtained_gpa");

                    subject_credit2.setText(credit);
                    subject_obtained_gpa2.setText(obtained_gpa);
                }

                Class.forName("com.mysql.jdbc.Driver");
                Connection con3 = DriverManager.getConnection("jdbc:mysql://localhost/student_info_sys", "root", "");
                PreparedStatement st3 = con3.prepareStatement("select * from subject3 where id=? ");
                st3.setString(1, str);

                ResultSet rs3 = st3.executeQuery();
                if (rs3.next()) {
                    String credit = rs3.getString("credit");
                    String obtained_gpa = rs3.getString("obtained_gpa");

                    subject_credit3.setText(credit);
                    subject_obtained_gpa3.setText(obtained_gpa);
                }

                Class.forName("com.mysql.jdbc.Driver");
                Connection con4 = DriverManager.getConnection("jdbc:mysql://localhost/student_info_sys", "root", "");
                PreparedStatement st4 = con4.prepareStatement("select * from subject4 where id=? ");
                st4.setString(1, str);

                ResultSet rs4 = st4.executeQuery();
                if (rs4.next()) {
                    String credit = rs4.getString("credit");
                    String obtained_gpa = rs4.getString("obtained_gpa");

                    subject_credit4.setText(credit);
                    subject_obtained_gpa4.setText(obtained_gpa);
                }

                Class.forName("com.mysql.jdbc.Driver");
                Connection con5 = DriverManager.getConnection("jdbc:mysql://localhost/student_info_sys", "root", "");
                PreparedStatement st5 = con5.prepareStatement("select * from subject5 where id=? ");
                st5.setString(1, str);

                ResultSet rs5 = st5.executeQuery();
                if (rs5.next()) {
                    String credit = rs5.getString("credit");
                    String obtained_gpa = rs5.getString("obtained_gpa");

                    subject_credit5.setText(credit);
                    subject_obtained_gpa5.setText(obtained_gpa);
                }

            }
            //Create Exception Handler  
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }//GEN-LAST:event_search_bar_courses_with_idKeyReleased

    private void student_info_save_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_info_save_buttonActionPerformed
        // TODO add your handling code here:

        try {

            String str = search_bar.getText();
            String username = username_student.getText();
            String email = email_student.getText();
            String address = address_student.getText();
            String phone_number = phone_number_student.getText();
            String password = password_student.getText();
            String department = department_student.getText();
            String batch = batch_student.getText();
            String session = session_student.getText();
            String blood_group = blood_group_student.getText();
            String id = id_student.getText();

            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student_info_sys", "root", "");
            PreparedStatement pst = con.prepareStatement("UPDATE student set username = ? ,email = ? ,address = ? ,phone_number= ? ,password= ? ,department= ? ,batch= ? ,session= ? ,blood_group= ?  where id = ?");

            pst.setString(1, username);
            pst.setString(2, email);
            pst.setString(3, address);
            pst.setString(4, phone_number);
            pst.setString(5, password);
            pst.setString(6, department);
            pst.setString(7, batch);
            pst.setString(8, session);
            pst.setString(9, blood_group);
            pst.setString(10, id);

            if (pst.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Data saved");
                //this piece of code is used for refreshing
                DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
                tableModel.setRowCount(0);
                show_user();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid User");
            }

            //JOptionPane.showMessageDialog(this, "Record added");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SignUpForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SignUpForm.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_student_info_save_buttonActionPerformed

    private void username_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username_adminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_username_adminActionPerformed

    private void email_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_email_adminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_email_adminActionPerformed

    private void address_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_address_adminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_address_adminActionPerformed

    private void phone_number_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phone_number_adminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phone_number_adminActionPerformed

    private void id_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_adminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_adminActionPerformed

    private void password_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_adminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password_adminActionPerformed

    private void department_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_department_adminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_department_adminActionPerformed

    private void occupation_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_occupation_adminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_occupation_adminActionPerformed

    private void search_bar_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_bar_adminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_bar_adminActionPerformed

    private void search_bar_adminKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_bar_adminKeyReleased
        // TODO add your handling code here:
        try {

            String str = search_bar_admin.getText();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student_info_sys", "root", "");
            PreparedStatement st = con.prepareStatement("select * from admin where username=? or email= ? or address= ?  or phone_number = ? or id = ? or password = ? or department=? or occupation = ?");
            st.setString(1, str);
            st.setString(2, str);
            st.setString(3, str);
            st.setString(4, str);
            st.setString(5, str);
            st.setString(6, str);
            st.setString(7, str);
            st.setString(8, str);

            //Excuting Query  
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String s1 = rs.getString("username");
                String s2 = rs.getString("email");
                String s3 = rs.getString("address");
                String s4 = rs.getString("phone_number");
                String s5 = rs.getString("id");
                String s6 = rs.getString("password");
                String s7 = rs.getString("department");
                String s8 = rs.getString("occupation");

                byte[] image = rs.getBytes("picture");

                ImageIcon myImg = new ImageIcon(image);
                //this is used for scaling
                Image img = myImg.getImage().getScaledInstance(jLabelPic_admin.getWidth(), jLabelPic_admin.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon myPicture = new ImageIcon(img);
                jLabelPic_admin.setIcon(myPicture);

                //Sets Records in TextFields.  
                username_admin.setText(s1);
                email_admin.setText(s2);
                address_admin.setText(s3);
                phone_number_admin.setText(s4);
                id_admin.setText(s5);
                password_admin.setText(s6);
                department_admin.setText(s7);
                occupation_admin.setText(s8);

            }
            //Create Exception Handler  
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_search_bar_adminKeyReleased

    private void search_bar_adminKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_bar_adminKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_search_bar_adminKeyTyped

    private void student_id_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_id_courseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_id_courseActionPerformed

    private void subject_credit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subject_credit1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subject_credit1ActionPerformed

    private void subject_credit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subject_credit2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subject_credit2ActionPerformed

    private void subject_obtained_gpa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subject_obtained_gpa2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subject_obtained_gpa2ActionPerformed

    private void subject_credit3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subject_credit3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subject_credit3ActionPerformed

    private void subject_obtained_gpa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subject_obtained_gpa3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subject_obtained_gpa3ActionPerformed

    private void subject_credit4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subject_credit4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subject_credit4ActionPerformed

    private void subject_obtained_gpa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subject_obtained_gpa4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subject_obtained_gpa4ActionPerformed

    private void subject_credit5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subject_credit5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subject_credit5ActionPerformed

    private void subject_obtained_gpa5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subject_obtained_gpa5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subject_obtained_gpa5ActionPerformed

    private void save_button_for_creditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_button_for_creditActionPerformed
        // TODO add your handling code here:

        try {

            String str = student_id_course.getText();
            String credit = subject_credit1.getText();
            String obtained_gpa = subject_obtained_gpa1.getText();

            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student_info_sys", "root", "");
            PreparedStatement pst = con.prepareStatement("UPDATE subject1 set credit = ? ,obtained_gpa = ? where id = ?");

            pst.setString(1, credit);
            pst.setString(2, obtained_gpa);
            pst.setString(3, str);
            pst.executeUpdate();

            String str2 = student_id_course.getText();
            String credit2 = subject_credit2.getText();
            String obtained_gpa2 = subject_obtained_gpa2.getText();

            Class.forName("com.mysql.jdbc.Driver");

            Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost/student_info_sys", "root", "");
            PreparedStatement pst2 = con2.prepareStatement("UPDATE subject2 set credit = ? ,obtained_gpa = ? where id = ?");

            pst2.setString(1, credit2);
            pst2.setString(2, obtained_gpa2);
            pst2.setString(3, str2);
            pst2.executeUpdate();

            String str3 = student_id_course.getText();
            String credit3 = subject_credit3.getText();
            String obtained_gpa3 = subject_obtained_gpa3.getText();

            Class.forName("com.mysql.jdbc.Driver");

            Connection con3 = DriverManager.getConnection("jdbc:mysql://localhost/student_info_sys", "root", "");
            PreparedStatement pst3 = con3.prepareStatement("UPDATE subject3 set credit = ? ,obtained_gpa = ? where id = ?");

            pst3.setString(1, credit3);
            pst3.setString(2, obtained_gpa3);
            pst3.setString(3, str3);
            pst3.executeUpdate();

            String str4 = student_id_course.getText();
            String credit4 = subject_credit4.getText();
            String obtained_gpa4 = subject_obtained_gpa4.getText();

            Class.forName("com.mysql.jdbc.Driver");

            Connection con4 = DriverManager.getConnection("jdbc:mysql://localhost/student_info_sys", "root", "");
            PreparedStatement pst4 = con4.prepareStatement("UPDATE subject4 set credit = ? ,obtained_gpa = ? where id = ?");

            pst4.setString(1, credit4);
            pst4.setString(2, obtained_gpa4);
            pst4.setString(3, str4);
            pst4.executeUpdate();

            String str5 = student_id_course.getText();
            String credit5 = subject_credit5.getText();
            String obtained_gpa5 = subject_obtained_gpa5.getText();

            Class.forName("com.mysql.jdbc.Driver");

            Connection con5 = DriverManager.getConnection("jdbc:mysql://localhost/student_info_sys", "root", "");
            PreparedStatement pst5 = con5.prepareStatement("UPDATE subject5 set credit = ? ,obtained_gpa = ? where id = ?");

            pst5.setString(1, credit5);
            pst5.setString(2, obtained_gpa5);
            pst5.setString(3, str5);
            pst5.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data Saved");

            //JOptionPane.showMessageDialog(this, "Record added");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SignUpForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SignUpForm.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_save_button_for_creditActionPerformed

    private void results_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_results_buttonActionPerformed
        // TODO add your handling code here:
        cardlayout.show(option_panels, "results_card");
    }//GEN-LAST:event_results_buttonActionPerformed

    private void attendence_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attendence_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_attendence_idActionPerformed

    private void attendence_presentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attendence_presentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_attendence_presentActionPerformed

    private void save_attendenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_attendenceActionPerformed
        // TODO add your handling code here:

        //getting the date in the simple date format
        SimpleDateFormat dcn = new SimpleDateFormat("dd/MM/yyyy");
        String date = dcn.format(jDateChooser1.getDate());

        String id = attendence_id.getText();
        String present = attendence_present.getSelectedItem().toString();

        //passing the date to the save attendence class for saving 
        save_attendence obj = new save_attendence(id, present, date);

        try {
            obj.save();
        } catch (SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }

        //this piece of code is used for refreshing
        DefaultTableModel tableModel = (DefaultTableModel) jTable2.getModel();
        tableModel.setRowCount(0);

        show_student_attendence();
        //String date = jDateChooser1.getDate().toString();
        //JOptionPane.showMessageDialog(null, date);

    }//GEN-LAST:event_save_attendenceActionPerformed

    private void update_attendenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_attendenceActionPerformed
        // TODO add your handling code here:
        //this piece of code is for updating if the user is present or absent

        //getting the date in the simple date format
        SimpleDateFormat dcn = new SimpleDateFormat("dd/MM/yyyy");
        String date = dcn.format(jDateChooser1.getDate());

        String id = attendence_id.getText();
        String present = attendence_present.getSelectedItem().toString();

        update_attendence obj = new update_attendence(id, present, date);

        try {
            obj.update();
        } catch (SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }

        //this piece of code is used for refreshing
        DefaultTableModel tableModel = (DefaultTableModel) jTable2.getModel();
        tableModel.setRowCount(0);

        show_student_attendence();

    }//GEN-LAST:event_update_attendenceActionPerformed

    private void attendence_search_box_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attendence_search_box_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_attendence_search_box_idActionPerformed

    private void days_presentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_days_presentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_days_presentActionPerformed

    private void days_absentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_days_absentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_days_absentActionPerformed

    private void attendence_search_box_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_attendence_search_box_idKeyReleased
        // TODO add your handling code here:
        String search = attendence_search_box_id.getText();

        //for searching data in the table
        DefaultTableModel table = (DefaultTableModel) jTable2.getModel();

        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(table);
        jTable2.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student_info_sys", "root", "");
            PreparedStatement st = con.prepareStatement("select * from attendence where id=? ");
            st.setString(1, search);

            //Excuting Query  
            ResultSet rs = st.executeQuery();
            //System.out.println(rs.toString());

            //an int for counting elements in result set
            int total_day = 0;
            int abs_day = 0;

            if (!rs.isBeforeFirst()) {
                //System.out.println("No data");
                total_day = 0;
                abs_day = 0;
            } else {
                System.out.println("Data");
                while (rs.next()) {
                    total_day++;
                    String s = rs.getString("present");
                    if (s.equals("Absent")) {
                        abs_day++;
                    }
                }
//                System.out.println(total_day);
//                System.out.println(abs_day);

                days_present.setText(String.valueOf(total_day - abs_day));
                days_absent.setText(String.valueOf(abs_day));

                double ans = (total_day - abs_day);
                double per = ans / total_day;
                //System.out.println(per);
                per = per * 100;
                attendence_percentage.setText(String.valueOf(per));

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_attendence_search_box_idKeyReleased

    private void attendence_percentageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attendence_percentageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_attendence_percentageActionPerformed

    private void add_student_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_student_buttonActionPerformed
        // TODO add your handling code here:
        cardlayout.show(option_panels, "add_student_card");
    }//GEN-LAST:event_add_student_buttonActionPerformed

    private void username_student1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username_student1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_username_student1ActionPerformed

    private void email_student1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_email_student1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_email_student1ActionPerformed

    private void address_student1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_address_student1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_address_student1ActionPerformed

    private void phone_number_student1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phone_number_student1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phone_number_student1ActionPerformed

    private void id_student1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_student1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_student1ActionPerformed

    private void password_student1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_student1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password_student1ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
        // TO show the pass word
        if (jCheckBox3.isSelected()) {
            password_student1.setEchoChar((char) 0);
        } else {
            password_student1.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void re_password_studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_re_password_studentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_re_password_studentActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:
        // TO show the pass word
        if (jCheckBox4.isSelected()) {
            re_password_student.setEchoChar((char) 0);
        } else {
            re_password_student.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void student_add_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_add_buttonActionPerformed
        // TODO add your handling code here:
        //if the sign up is clicked
        if (username_student1.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Please enter the username");
        } else if (email_student1.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Please enter the mail");
        } else if (address_student1.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Please the address");
        } else if (phone_number_student1.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Please the phone number");
        } else if (id_student1.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Please the ID");
        } else if (password_student1.getText().equals(re_password_student.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Password not matched");
        } else if (imagePth == null) {
            JOptionPane.showMessageDialog(null, "Please insert an Image");
        } else {
            try {

                String username = username_student1.getText();
                String email = email_student1.getText();
                String address = address_student1.getText();
                String phone_number = phone_number_student1.getText();
                String id = id_student1.getText();
                String password = password_student1.getText();

                String department = department_student1.getSelectedItem().toString();
                String batch = batch_student1.getSelectedItem().toString();
                String session = session_student1.getSelectedItem().toString();
                String blood_group = blood_group_student1.getSelectedItem().toString();

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student_info_sys", "root", "");
                PreparedStatement pst = con.prepareStatement("insert into student(username,email,address,phone_number,id,password,department,batch,session,blood_group,picture)values(?,?,?,?,?,?,?,?,?,?,?)");

                pst.setString(1, username);
                pst.setString(2, email);
                pst.setString(3, address);
                pst.setString(4, phone_number);
                pst.setString(5, id);
                pst.setString(6, password);
                pst.setString(7, department);
                pst.setString(8, batch);
                pst.setString(9, session);
                pst.setString(10, blood_group);

                InputStream img = new FileInputStream(new File(imagePth));
                pst.setBlob(11, img);

                if (pst.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null, "Account created");

                } else {
                    JOptionPane.showMessageDialog(null, "Something wrong");
                }

                //this piece of code is used for entering the id in courses table as a foreign key
                Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost/student_info_sys", "root", "");
                PreparedStatement pst1 = con1.prepareStatement("insert into courses (id) values(?)");
                pst1.setString(1, id);
                pst1.executeUpdate();

                //this piece of code is used for entering the id in subject1 table as a foreign key
                Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost/student_info_sys", "root", "");
                PreparedStatement pst2 = con2.prepareStatement("insert into subject1 (id) values(?)");
                pst2.setString(1, id);
                pst2.executeUpdate();

                //this piece of code is used for entering the id in subject2 table as a foreign key
                Connection con3 = DriverManager.getConnection("jdbc:mysql://localhost/student_info_sys", "root", "");
                PreparedStatement pst3 = con3.prepareStatement("insert into subject2 (id) values(?)");
                pst3.setString(1, id);
                pst3.executeUpdate();

                //this piece of code is used for entering the id in subject3 table as a foreign key
                Connection con4 = DriverManager.getConnection("jdbc:mysql://localhost/student_info_sys", "root", "");
                PreparedStatement pst4 = con4.prepareStatement("insert into subject3 (id) values(?)");
                pst4.setString(1, id);
                pst4.executeUpdate();

                //this piece of code is used for entering the id in subject4 table as a foreign key
                Connection con5 = DriverManager.getConnection("jdbc:mysql://localhost/student_info_sys", "root", "");
                PreparedStatement pst5 = con5.prepareStatement("insert into subject4 (id) values(?)");
                pst5.setString(1, id);
                pst5.executeUpdate();

                //this piece of code is used for entering the id in subject5 table as a foreign key
                Connection con6 = DriverManager.getConnection("jdbc:mysql://localhost/student_info_sys", "root", "");
                PreparedStatement pst6 = con6.prepareStatement("insert into subject5 (id) values(?)");
                pst6.setString(1, id);
                pst6.executeUpdate();

                //JOptionPane.showMessageDialog(this, "Record added");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SignUpForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(SignUpForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_student_add_buttonActionPerformed

    private void department_student1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_department_student1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_department_student1ActionPerformed

    private void batch_student1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batch_student1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_batch_student1ActionPerformed

    private void session_student1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_session_student1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_session_student1ActionPerformed

    private void blood_group_student1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blood_group_student1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_blood_group_student1ActionPerformed

    private void jButtonBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBrowseActionPerformed
        // TODO add your handling code here:
        //When the browse button for picture is clicked
        // for selecting image
        JFileChooser filec = new JFileChooser();
        filec.setCurrentDirectory(new File(System.getProperty("user.home")));

        //file extension
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("*.Images", "jpg", "png", "gif");
        filec.addChoosableFileFilter(fileFilter);

        int fileState = filec.showSaveDialog(null);

        //if the user select a file
        if (fileState == JFileChooser.APPROVE_OPTION) {
            File selectedFile = filec.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            imagePth = path;//for attaching in data base
            //display the image in the jlabel using resizeImage

            jLabelPic1.setIcon(resizePic1(path));
            //jLabelPic.setIcon(new ImageIcon(path)) ;
        } //if the user cancel
        else if (fileState == JFileChooser.CANCEL_OPTION) {
            //System.out.println("NO IMAGE SELECTED");
            JOptionPane.showMessageDialog(null, "No image selected");
        }
    }//GEN-LAST:event_jButtonBrowseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Subject1;
    private javax.swing.JComboBox<String> Subject2;
    private javax.swing.JComboBox<String> Subject3;
    private javax.swing.JComboBox<String> Subject4;
    private javax.swing.JComboBox<String> Subject5;
    private javax.swing.JPanel about;
    private javax.swing.JButton about_button;
    private javax.swing.JPanel add_student;
    private javax.swing.JButton add_student_button;
    private javax.swing.JTextField address_admin;
    private javax.swing.JTextField address_student;
    private javax.swing.JTextField address_student1;
    private javax.swing.JButton admin_button;
    private javax.swing.JPanel admin_info;
    private javax.swing.JPanel attendence;
    private javax.swing.JButton attendence_button;
    private javax.swing.JTextField attendence_id;
    private javax.swing.JTextField attendence_percentage;
    private javax.swing.JComboBox<String> attendence_present;
    private javax.swing.JTextField attendence_search_box_id;
    private javax.swing.JTextField batch_student;
    private javax.swing.JComboBox<String> batch_student1;
    private javax.swing.JTextField blood_group_student;
    private javax.swing.JComboBox<String> blood_group_student1;
    private javax.swing.JButton course_button;
    private javax.swing.JPanel courses;
    private javax.swing.JTextField days_absent;
    private javax.swing.JTextField days_present;
    private javax.swing.JTextField department_admin;
    private javax.swing.JTextField department_student;
    private javax.swing.JComboBox<String> department_student1;
    private javax.swing.JTextField email_admin;
    private javax.swing.JTextField email_student;
    private javax.swing.JTextField email_student1;
    private javax.swing.JButton enroll_button;
    private javax.swing.JTextField id_admin;
    private javax.swing.JTextField id_student;
    private javax.swing.JTextField id_student1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonBrowse;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelPic;
    private javax.swing.JLabel jLabelPic1;
    private javax.swing.JLabel jLabelPic_admin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField occupation_admin;
    private javax.swing.JPanel option_panels;
    private javax.swing.JTextField password_admin;
    private javax.swing.JTextField password_student;
    private javax.swing.JPasswordField password_student1;
    private javax.swing.JTextField phone_number_admin;
    private javax.swing.JTextField phone_number_student;
    private javax.swing.JTextField phone_number_student1;
    private javax.swing.JPasswordField re_password_student;
    private javax.swing.JPanel results;
    private javax.swing.JButton results_button;
    private javax.swing.JButton save_attendence;
    private javax.swing.JButton save_button_for_credit;
    private javax.swing.JTextField search_bar;
    private javax.swing.JTextField search_bar_admin;
    private javax.swing.JTextField search_bar_courses_with_id;
    private javax.swing.JTextField session_student;
    private javax.swing.JComboBox<String> session_student1;
    private javax.swing.JButton student_add_button;
    private javax.swing.JButton student_button;
    private javax.swing.JTextField student_id_course;
    private javax.swing.JPanel student_info;
    private javax.swing.JButton student_info_save_button;
    private javax.swing.JTextField subject_credit1;
    private javax.swing.JTextField subject_credit2;
    private javax.swing.JTextField subject_credit3;
    private javax.swing.JTextField subject_credit4;
    private javax.swing.JTextField subject_credit5;
    private javax.swing.JTextField subject_obtained_gpa1;
    private javax.swing.JTextField subject_obtained_gpa2;
    private javax.swing.JTextField subject_obtained_gpa3;
    private javax.swing.JTextField subject_obtained_gpa4;
    private javax.swing.JTextField subject_obtained_gpa5;
    private javax.swing.JButton update_attendence;
    private javax.swing.JTextField username_admin;
    private javax.swing.JTextField username_student;
    private javax.swing.JTextField username_student1;
    // End of variables declaration//GEN-END:variables
}
