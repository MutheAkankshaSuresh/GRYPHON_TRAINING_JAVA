package Sports;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Sports1 extends JFrame implements ActionListener {

    private static final String URL = "jdbc:mysql://localhost:3306/final_fullstack_project";
    private static final String USER = "root";
    private static final String PASSWORD = "spay";

    JButton bRow, bRank, bLag, bLead, bAgg, bInsert;
    JTable table;
    DefaultTableModel model;

    JTextField tId, tName, tTeam, tDate, tGoal, tPerf;
    Connection con;

    public Sports1() {
        setTitle("Sports SQL Functions");
        setSize(900, 500);
        setLayout(new BorderLayout());

        /* ---------- TOP PANEL ---------- */
        Panel p = new Panel();
        bRow = new JButton("ROW_NUMBER");
        bRank = new JButton("RANK");
        bLag = new JButton("LAG");
        bLead = new JButton("LEAD");
        bAgg = new JButton("AGGREGATE");
        bInsert = new JButton("INSERT");

        p.add(bRow);
        p.add(bRank);
        p.add(bLag);
        p.add(bLead);
        p.add(bAgg);
        p.add(bInsert);

        add(p, BorderLayout.NORTH);

        /* ---------- INPUT PANEL ---------- */
        Panel ip = new Panel(new GridLayout(2, 6));

        tId = new JTextField();
        tName = new JTextField();
        tTeam = new JTextField();
        tDate = new JTextField("2024-01-01");
        tGoal = new JTextField();
        tPerf = new JTextField();

        ip.add(new JLabel("ID"));
        ip.add(new JLabel("Name"));
        ip.add(new JLabel("Team"));
        ip.add(new JLabel("Date (YYYY-MM-DD)"));
        ip.add(new JLabel("Goal"));
        ip.add(new JLabel("Performance"));

        ip.add(tId);
        ip.add(tName);
        ip.add(tTeam);
        ip.add(tDate);
        ip.add(tGoal);
        ip.add(tPerf);

        add(ip, BorderLayout.SOUTH);

        /* ---------- TABLE ---------- */
        model = new DefaultTableModel();
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        /* ---------- EVENTS ---------- */
        bRow.addActionListener(this);
        bRank.addActionListener(this);
        bLag.addActionListener(this);
        bLead.addActionListener(this);
        bAgg.addActionListener(this);
        bInsert.addActionListener(this);

        connectDB();
        loadData("SELECT * FROM sports");

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void connectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "DB Connection Error: " + e.getMessage());
        }
    }

    private void loadData(String query) {
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            ResultSetMetaData md = rs.getMetaData();
            int cols = md.getColumnCount();

            model.setRowCount(0);
            model.setColumnCount(0);

            for (int i = 1; i <= cols; i++) {
                model.addColumn(md.getColumnName(i));
            }

            while (rs.next()) {
                Object[] row = new Object[cols];
                for (int i = 1; i <= cols; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                model.addRow(row);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Load Error: " + e.getMessage());
        }
    }

    private void insertData() {
        try {
            if (tId.getText().isEmpty() || tName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Fill all fields");
                return;
            }

            String sql = "INSERT INTO sports VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(tId.getText()));
            ps.setString(2, tName.getText());
            ps.setString(3, tTeam.getText());
            ps.setDate(4, Date.valueOf(tDate.getText()));
            ps.setInt(5, Integer.parseInt(tGoal.getText()));
            ps.setInt(6, Integer.parseInt(tPerf.getText()));

            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(this, "Inserted Successfully");
            loadData("SELECT * FROM sports");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Insert Error: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == bInsert)
            insertData();

        else if (ae.getSource() == bRow)
            loadData("SELECT player_name, team, goal, ROW_NUMBER() OVER(PARTITION BY team ORDER BY goal DESC) rn FROM sports");

        else if (ae.getSource() == bRank)
            loadData("SELECT player_name, team, goal, RANK() OVER(PARTITION BY team ORDER BY goal DESC) rnk FROM sports");

        else if (ae.getSource() == bLag)
            loadData("SELECT player_name, match_date, goal, LAG(goal) OVER(ORDER BY match_date) prev_goal FROM sports");

        else if (ae.getSource() == bLead)
            loadData("SELECT player_name, match_date, goal, LEAD(goal) OVER(ORDER BY match_date) next_goal FROM sports");

        else if (ae.getSource() == bAgg)
            loadData("SELECT team, SUM(goal) total_goal, AVG(performance) avg_performance FROM sports GROUP BY team");
    }

    public static void main(String[] args) {
        new Sports1();
    }
}