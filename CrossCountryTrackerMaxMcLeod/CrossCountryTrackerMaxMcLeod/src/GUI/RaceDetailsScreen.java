/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import LogicMain.DatabaseHandler;
import LogicMain.Race;
import LogicMain.Results;
import LogicMain.Student;
import java.util.Calendar;
import javax.swing.DefaultListModel;

/**
 *
 * @author maxaj
 */
public class RaceDetailsScreen extends javax.swing.JFrame {

    /** Creates new form RaceDetailsScreen */
    private RaceEditScreen RES;
    private TimeEditScreen TES;
    private TimeAddScreen TAS;
    private RaceScreen TS;
     private Race selRace;
      private final int value = 11;
      private HelpScreen SIHS;
     
    
     private DatabaseHandler db = new DatabaseHandler();
    
    public RaceDetailsScreen(RaceScreen inTS, Race inRace) {
        initComponents();
        setLocationRelativeTo(null);
        selRace = inRace;
        TS = inTS;
        GetRaceDetails();
        PopulateList();
    }
    
    public void GetRaceDetails(){
        System.out.println(selRace);
        date_Date.getModel().setDate(selRace.getRaceDate().get(Calendar.YEAR), selRace.getRaceDate().get(Calendar.MONTH) , selRace.getRaceDate().get(Calendar.DAY_OF_MONTH) );
        date_Date.getModel().setSelected(true);
        txtfld_Distance.setText(String.valueOf(selRace.getDist()));
        
        
    }
    public void PopulateList(){
         String[] SelectedResults = db.getStudentsAndTimesFromRaceID(selRace.getRaceID());
         DefaultListModel l = new DefaultListModel();
        for (int x = 0; x < SelectedResults.length; x++) {
            l.addElement(SelectedResults[x]);

        }
        lst_StudentList.setModel(l);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_Cancel = new javax.swing.JButton();
        btn_Help = new javax.swing.JButton();
        logo_CornerDecor = new javax.swing.JLabel();
        lbl_EditTime = new javax.swing.JLabel();
        lbl_Date = new javax.swing.JLabel();
        lbl_Distance = new javax.swing.JLabel();
        date_Date = new org.jdatepicker.JDatePicker();
        txtfld_Distance = new javax.swing.JTextField();
        scrl_StudentList = new javax.swing.JScrollPane();
        lst_StudentList = new javax.swing.JList<>();
        btn_AddTime = new javax.swing.JButton();
        btn_EditRace = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(178, 219, 244));

        btn_Cancel.setText("Cancel");
        btn_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelActionPerformed(evt);
            }
        });

        btn_Help.setText("?");
        btn_Help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HelpActionPerformed(evt);
            }
        });

        logo_CornerDecor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Lib/CornerDecalsSmall.png"))); // NOI18N

        lbl_EditTime.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_EditTime.setText("Race Details");

        lbl_Date.setText("Date:");

        lbl_Distance.setText("Distance:");

        date_Date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                date_DateActionPerformed(evt);
            }
        });

        lst_StudentList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lst_StudentList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lst_StudentListMouseClicked(evt);
            }
        });
        scrl_StudentList.setViewportView(lst_StudentList);

        btn_AddTime.setText("Add Time");
        btn_AddTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddTimeActionPerformed(evt);
            }
        });

        btn_EditRace.setText("Edit Race");
        btn_EditRace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EditRaceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_EditRace)
                .addGap(18, 18, 18)
                .addComponent(btn_AddTime)
                .addGap(70, 70, 70))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(scrl_StudentList, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbl_EditTime)
                        .addGap(56, 56, 56)
                        .addComponent(logo_CornerDecor))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_Date)
                                    .addComponent(lbl_Distance))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtfld_Distance, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(118, 118, 118))
                                    .addComponent(date_Date, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(btn_Help)))
                        .addGap(34, 34, 34))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logo_CornerDecor)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_EditTime, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date_Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Date))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lbl_Distance))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtfld_Distance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(scrl_StudentList, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_AddTime)
                    .addComponent(btn_EditRace))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Help)
                    .addComponent(btn_Cancel))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelActionPerformed
        // go back to database access screen
        
        TS.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_CancelActionPerformed

    private void btn_HelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HelpActionPerformed
        // go to help screen
        SIHS = new HelpScreen(value);
        SIHS.setVisible(true);
    }//GEN-LAST:event_btn_HelpActionPerformed

    private void btn_AddTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddTimeActionPerformed
        // TODO add your handling code here:
        TAS = new TimeAddScreen(this, selRace.getRaceID());
        TAS.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_AddTimeActionPerformed

    private void date_DateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_date_DateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_date_DateActionPerformed

    private void lst_StudentListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lst_StudentListMouseClicked
        // TODO add your handling code here:
                if (evt.getClickCount() == 2) {

            String value = String.valueOf(lst_StudentList.getSelectedValue());
                    System.out.println(value);

           String[] x = value.split(", ");
            int id = db.getStudentFromName(x[0], x[1]);
           

           

            TES = new TimeEditScreen(this, selRace.getRaceID(), id);
            TES.setVisible(true);
            this.setVisible(false);

        }
    }//GEN-LAST:event_lst_StudentListMouseClicked

    private void btn_EditRaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditRaceActionPerformed
        // TODO add your handling code here:
        RES = new RaceEditScreen(this, selRace);
        RES.setVisible(true);
        this.setVisible(false);
        
        
    }//GEN-LAST:event_btn_EditRaceActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(RaceDetailsScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(RaceDetailsScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(RaceDetailsScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(RaceDetailsScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new RaceDetailsScreen().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_AddTime;
    private javax.swing.JButton btn_Cancel;
    private javax.swing.JButton btn_EditRace;
    private javax.swing.JButton btn_Help;
    private org.jdatepicker.JDatePicker date_Date;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_Date;
    private javax.swing.JLabel lbl_Distance;
    private javax.swing.JLabel lbl_EditTime;
    private javax.swing.JLabel logo_CornerDecor;
    private javax.swing.JList<String> lst_StudentList;
    private javax.swing.JScrollPane scrl_StudentList;
    private javax.swing.JTextField txtfld_Distance;
    // End of variables declaration//GEN-END:variables

}