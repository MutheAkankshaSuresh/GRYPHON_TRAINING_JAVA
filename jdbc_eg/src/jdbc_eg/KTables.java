package jdbc_eg;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class KTables extends JFrame implements ActionListener {

    JTextField emp_id, emp_name, manager_id, dep_id;
    JTextArea result;
    JButton insert, selfJoin, crossJoin, compositeJoin, multiTableJoin;

    static final String URL = "jdbc:mysql://localhost:3306/companydb";
    static final String USER = "root";
    static final String PASS = "spay";

    KTables() {
        setTitle("Employee Management System");
        setSize(750, 500);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Employee ID"));
        emp_id = new JTextField(10);
        add(emp_id);

        add(new JLabel("Employee Name"));
        emp_name = new JTextField(10);
        add(emp_name);

        add(new JLabel("Manager ID"));
        manager_id = new JTextField(10);
        add(manager_id);

        add(new JLabel("Department ID"));
        dep_id = new JTextField(10);
        add(dep_id);

        insert = new JButton("Insert");
        selfJoin = new JButton("Self Join");
        crossJoin = new JButton("Cross Join");
        compositeJoin = new JButton("Composite Join");
        multiTableJoin = new JButton("Multi Table Join");

        add(insert);
        add(selfJoin);
        add(crossJoin);
        add(compositeJoin);
        add(multiTableJoin);

        result = new JTextArea(15, 65);
        result.setEditable(false);
        add(new JScrollPane(result));

        insert.addActionListener(this);
        selfJoin.addActionListener(this);
        crossJoin.addActionListener(this);
        compositeJoin.addActionListener(this);
        multiTableJoin.addActionListener(this);

        setVisible(true);
    }

    private Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public void actionPerformed(ActionEvent e) {
        try (Connection con = getConnection();
             Statement st = con.createStatement()) {

            if (e.getSource() == insert) {
                String q = "INSERT INTO employee VALUES (" +
                        emp_id.getText() + ",'" +
                        emp_name.getText() + "'," +
                        dep_id.getText() + "," +
                        manager_id.getText() + ")";
                st.executeUpdate(q);
                result.setText("Record inserted successfully.");

            } else if (e.getSource() == selfJoin) {

                String q = """
                    SELECT e1.employeeid, e1.empname, e2.empname AS manager
                    FROM employee e1
                    JOIN employee e2 ON e1.managerid = e2.employeeid
                """;

                display(st.executeQuery(q));

            } else if (e.getSource() == crossJoin) {

                String q = "SELECT empname, deptname FROM employee CROSS JOIN department";
                display(st.executeQuery(q));

            } else if (e.getSource() == compositeJoin) {            //more than one conditions in join clause

                String q = """
                    SELECT e.empname, d.deptname, p.projectname
                    FROM employee e
                    JOIN department d ON e.deptid = d.deptid
                    JOIN project p ON d.deptid = p.deptid
                """;

                display(st.executeQuery(q));
 
            } else if (e.getSource() == multiTableJoin) {           

                String q = """
                    SELECT e.empname, d.deptname, p.projectname
                    FROM employee e
                    JOIN department d ON e.deptid = d.deptid
                    JOIN project p ON d.deptid = p.deptid
                    WHERE e.empname LIKE 'a%'
                """;

                display(st.executeQuery(q));
            }

        } catch (Exception ex) {
            result.setText("ERROR:\n" + ex.getMessage());
        }
    }

    private void display(ResultSet rs) throws Exception {
        StringBuilder sb = new StringBuilder();
        ResultSetMetaData md = rs.getMetaData();
        int cols = md.getColumnCount();

        while (rs.next()) {
            for (int i = 1; i <= cols; i++) {
                sb.append(md.getColumnName(i)).append(": ")
                  .append(rs.getString(i)).append(" | ");
            }
            sb.append("\n");
        }
        result.setText(sb.toString());
    }

    public static void main(String[] args) {
        new KTables();
    }
}