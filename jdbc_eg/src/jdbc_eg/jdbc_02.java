package jdbc_eg;

// importing packages
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public class jdbc_02 extends JFrame implements ActionListener {

    JTextField tfName, tfAge, tfGender, tfCourse, tfYear, tfEmail, tfPhone, tfAddress, tfGPA;
    JButton btnInsert, btnFetch, btnUpdate, btnDelete, btnOrderBy;
    JTable table1;
    DefaultTableModel model;
    JTextField tfSearch1, tfSearch2;
    JComboBox<String> cbSearchType;
    JButton btnSearch;

    Connection con;
    Statement stmt;
    ResultSet rs;

    jdbc_02() {

        setTitle("Team Management System");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel FormPanel = new JPanel(new GridLayout(10, 2, 5, 5));

        FormPanel.add(new JLabel("Name:"));
        tfName = new JTextField();
        FormPanel.add(tfName);

        FormPanel.add(new JLabel("Age:"));
        tfAge = new JTextField();
        FormPanel.add(tfAge);

        FormPanel.add(new JLabel("Gender:"));
        tfGender = new JTextField();
        FormPanel.add(tfGender);

        FormPanel.add(new JLabel("Course:"));
        tfCourse = new JTextField();
        FormPanel.add(tfCourse);

        FormPanel.add(new JLabel("Year:"));
        tfYear = new JTextField();
        FormPanel.add(tfYear);

        FormPanel.add(new JLabel("Email:"));
        tfEmail = new JTextField();
        FormPanel.add(tfEmail);

        FormPanel.add(new JLabel("Phone:"));
        tfPhone = new JTextField();
        FormPanel.add(tfPhone);

        FormPanel.add(new JLabel("Address:"));
        tfAddress = new JTextField();
        FormPanel.add(tfAddress);

        FormPanel.add(new JLabel("GPA:"));
        tfGPA = new JTextField();
        FormPanel.add(tfGPA);

        btnInsert = new JButton("Insert");
        btnFetch = new JButton("Fetch");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnOrderBy = new JButton("OrderBy");

        JPanel BtnPanel = new JPanel();
        BtnPanel.add(btnInsert);
        BtnPanel.add(btnFetch);
        BtnPanel.add(btnUpdate);
        BtnPanel.add(btnDelete);
        BtnPanel.add(btnOrderBy);

        FormPanel.add(BtnPanel);
        add(FormPanel, BorderLayout.NORTH);

        cbSearchType = new JComboBox<>(new String[]{"WHERE GPA >", "LIKE NAME", "BETWEEN GPA"});
        tfSearch1 = new JTextField(10);
        tfSearch2 = new JTextField(10);
        btnSearch = new JButton("Search");

        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("Search Type:"));
        searchPanel.add(cbSearchType);
        searchPanel.add(tfSearch1);
        searchPanel.add(tfSearch2);
        searchPanel.add(btnSearch);

        add(searchPanel, BorderLayout.SOUTH);

        model = new DefaultTableModel();
        table1 = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table1);
        add(scrollPane, BorderLayout.CENTER);

        btnInsert.addActionListener(this);
        btnFetch.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        btnOrderBy.addActionListener(this);
        btnSearch.addActionListener(this);

        String url = "jdbc:mysql://localhost:3306/team_management";
        String user = "root";
        String pass = "spay";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            stmt = con.createStatement();   // FIX: initialize stmt
            JOptionPane.showMessageDialog(this, "Connected To Database");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Database error " + e.getMessage());
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {

            if (ae.getSource() == btnInsert) {

                String sql = "INSERT INTO members " +
                        "(name, age, gender, course, year, email, phone, address, gpa) " +
                        "VALUES (?,?,?,?,?,?,?,?,?)";

                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, tfName.getText());
                pst.setInt(2, Integer.parseInt(tfAge.getText()));
                pst.setString(3, tfGender.getText());
                pst.setString(4, tfCourse.getText());
                pst.setInt(5, Integer.parseInt(tfYear.getText()));
                pst.setString(6, tfEmail.getText());
                pst.setString(7, tfPhone.getText());
                pst.setString(8, tfAddress.getText());
                pst.setDouble(9, Double.parseDouble(tfGPA.getText()));

                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Record inserted successfully.");

            } else if (ae.getSource() == btnFetch) {

                rs = stmt.executeQuery("SELECT * FROM members");
                ResultSetMetaData rsmd = rs.getMetaData();
                int column = rsmd.getColumnCount();

                model.setRowCount(0);
                model.setColumnCount(0);

                for (int i = 1; i <= column; i++) {
                    model.addColumn(rsmd.getColumnName(i));
                }

                while (rs.next()) {
                    Object[] row = new Object[column];
                    for (int i = 1; i <= column; i++) {
                        row[i - 1] = rs.getObject(i);
                    }
                    model.addRow(row);
                }
            }else if(ae.getSource() == btnUpdate){

                String sql = "UPDATE members SET gpa=" + tfGPA.getText() + " WHERE name='" + tfName.getText() + "'";
                stmt.executeUpdate(sql);
                
                JOptionPane.showMessageDialog(this, "Record updated successfully!");
            }else if(ae.getSource()==btnDelete) {

            	String deletequery = "DELETE FROM members WHERE name='" + tfName.getText() + "'";
            	stmt.executeUpdate(deletequery);

            	JOptionPane.showMessageDialog(this, "Record deleted successfully!");
            	
            }
        else if(ae.getSource() == btnOrderBy){

            rs = stmt.executeQuery("SELECT * FROM members ORDER BY gpa ASC");
            ResultSetMetaData rsmd = rs.getMetaData();
            int column = rsmd.getColumnCount();

            model.setRowCount(0);
            model.setColumnCount(0);

            for (int i = 1; i <= column; i++) {
                model.addColumn(rsmd.getColumnName(i));
            }

            while (rs.next()) {
                Object[] row = new Object[column];
                for (int i = 1; i <= column; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                model.addRow(row);
            }
        }
            
        else if(ae.getSource() == btnSearch){

            String type = cbSearchType.getSelectedItem().toString();
            String sql = "";

            if(type.equals("WHERE GPA >")){
                sql = "SELECT * FROM members WHERE gpa > " + tfSearch1.getText();
            }
            else if(type.equals("LIKE NAME")){
                sql = "SELECT * FROM members WHERE name LIKE '%" + tfSearch1.getText() + "%'";
            }
            else if(type.equals("BETWEEN GPA")){
                sql = "SELECT * FROM members WHERE gpa BETWEEN " + tfSearch1.getText() + " AND " + tfSearch2.getText();
            }
            
            rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int column = rsmd.getColumnCount();

            model.setRowCount(0);
            model.setColumnCount(0);

            for (int i = 1; i <= column; i++) {
                model.addColumn(rsmd.getColumnName(i));
            }

            while (rs.next()) {
                Object[] row = new Object[column];
                for (int i = 1; i <= column; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                model.addRow(row);
            }
        }


            	 
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new jdbc_02();
    }
}