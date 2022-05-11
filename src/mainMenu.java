import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import org.
/**
 *
 * @author matheus
 */
public final class mainMenu extends javax.swing.JFrame {

    Connection con = null;
    
    public mainMenu() throws SQLException {
        initComponents();
        conectToDB("jdbc:mysql://localhost/game_menu?useTimezone=true&serverTimezone=UTC", "root", "root123");
        //initializeDatabaseTree();
    }
    
    public void conectToDB(String url, String user, String password) throws SQLException
    {
        con = DriverManager.getConnection(url, user, password);
        DatabaseMetaData dbmt = con.getMetaData();
    }
    
    public void initializeDatabaseTree() throws SQLException
    {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select table_name from dba_tables;");
        DefaultMutableTreeNode databases = new DefaultMutableTreeNode("Databases");
        while(rs.next()){
            String database = rs.getString("Database");
            DefaultMutableTreeNode dat = new DefaultMutableTreeNode(database);
            databases.add(dat);
        }
        //databaseTree.add(databases);
        databaseTree = new JTree(databases);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        databaseTree = new javax.swing.JTree();
        jScrollPane3 = new javax.swing.JScrollPane();
        insertQuery = new javax.swing.JTextArea();
        run = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane2.setViewportView(databaseTree);

        insertQuery.setColumns(20);
        insertQuery.setRows(5);
        jScrollPane3.setViewportView(insertQuery);

        run.setText("Run query!");
        run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runActionPerformed(evt);
            }
        });

        mainTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(mainTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(run)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(run)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void runActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runActionPerformed
        System.out.println(this.insertQuery.getText());
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(this.insertQuery.getText());
            ResultSetMetaData rsmd = rs.getMetaData();
            
            int column = rsmd.getColumnCount();
            String[][] title = new String[1][column];
            for(int i = 0; i < column; i++)
            {
                title[0][i] = rsmd.getColumnName(i+1);
            }
            
            String[][] data = {
                {"Kathy", "Smith",
                "Snowboarding"},
                {"John", "Doe",
                "Rowing"},
                {"Sue", "Black",
                "Knitting"},
                {"Jane", "White",
                "Speed reading"},
                {"Joe", "Brown",
                "Pool"}
            };
            System.out.println("melhor do mundo receba");
            this.mainTable = new JTable(data, title);
                    
            //this.mainTable.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (SQLException ex) {
            System.out.println(ex);
            //Logger.getLogger(mainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_runActionPerformed

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
            java.util.logging.Logger.getLogger(mainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new mainMenu().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(mainMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree databaseTree;
    private javax.swing.JTextArea insertQuery;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable mainTable;
    private javax.swing.JButton run;
    // End of variables declaration//GEN-END:variables
}
