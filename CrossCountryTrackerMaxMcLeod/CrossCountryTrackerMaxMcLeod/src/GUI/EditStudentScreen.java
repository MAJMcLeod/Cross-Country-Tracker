/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import LogicMain.DatabaseHandler;
import LogicMain.Student;

/**
 *
 * @author maxaj
 */
public class EditStudentScreen extends javax.swing.JFrame {

    /**
     * Creates new form AddInfoScreen
     */
    private StudentDetailScreen SDS;
    private Student selStudent, updtStudent;
    private DatabaseHandler dataCur = new DatabaseHandler();
    private final int value = 4;
    private HelpScreen SIHS;

    public EditStudentScreen(StudentDetailScreen inSDS, Student inSel) {
        //creates the JFrame and populates it with content
        initComponents();
        //Sets the location of the JFrame to the centre of the screen
        setLocationRelativeTo(null);
        //Sets warning labels invisible 
        lbl_Warning2.setVisible(false);
        lbl_Warning1.setVisible(false);
        lbl_Warning3.setVisible(false);
        lbl_Warning4.setVisible(false);
        SDS = inSDS;
        selStudent = inSel;
        //Populates screen with selected student information
        populateDetails();

    }

    //Populates screen with selected student information
    private void populateDetails() {

        txtfld_Name.setText(selStudent.getfName());
        txtfld_Surname.setText(selStudent.getlName());
        spn_DaysAbsent.setValue(selStudent.getAttend());

        switch (selStudent.getAge()) {
            case 14:
                cmb_AgeGroup.setSelectedIndex(0);
                break;
            case 15:
                cmb_AgeGroup.setSelectedIndex(1);
                break;
            case 16:
                cmb_AgeGroup.setSelectedIndex(2);
                break;
            case 17:
                cmb_AgeGroup.setSelectedIndex(3);
                break;
            case 18:
                cmb_AgeGroup.setSelectedIndex(4);
                break;
            default:
                System.out.println("ERROR - No Age Present");

        }

    }

    //Validity checker, returns true/false value and checks to see whether the name field is empty or is using non-alphabetic characters
    private Boolean ValidateData(String inCurName, String inCurSName) {
        boolean fNameAlphabetic = true, lNameAlphabetic = true, fNameIsEmpty = true, lNameIsEmpty = true;
        lbl_Warning1.setVisible(false);
        lbl_Warning2.setVisible(false);
        lbl_Warning3.setVisible(false);
        lbl_Warning4.setVisible(false);

        if (inCurName.isEmpty()) {
            lbl_Warning3.setVisible(true);

        } else {
            fNameIsEmpty = false;
            lbl_Warning3.setVisible(false);
        }

        for (int i = 0; i < inCurName.length(); i++) {
            if (Character.isAlphabetic(inCurName.charAt(i))) {
                lbl_Warning1.setVisible(false);

            } else {
                fNameAlphabetic = false;
                lbl_Warning1.setVisible(true);
                break;
            }

        }

        if (inCurSName.isEmpty()) {
            lbl_Warning4.setVisible(true);

        } else {
            lNameIsEmpty = false;
            lbl_Warning4.setVisible(false);

        }

        for (int i = 0; i < inCurSName.length(); i++) {
            if (Character.isAlphabetic(inCurSName.charAt(i))) {
                lbl_Warning2.setVisible(false);

            } else {
                lNameAlphabetic = false;
                lbl_Warning2.setVisible(true);
                break;
            }

        }
        if (fNameAlphabetic == true && lNameAlphabetic == true && fNameIsEmpty == false && lNameIsEmpty == false) {
            return true;
        } else {
            return false;
        }

    }

    //Saves data and updates database
    private boolean SaveData() {

        String curName = txtfld_Name.getText();

        String curSName = txtfld_Surname.getText();
        int Age = 0;

        try {
            spn_DaysAbsent.commitEdit();
        } catch (java.text.ParseException e) {
        }
        int CurDaysAbs = (Integer) spn_DaysAbsent.getValue();

        switch (cmb_AgeGroup.getSelectedIndex()) {
            case 0:
                Age = 14;
                break;
            case 1:
                Age = 15;
                break;
            case 2:
                Age = 16;
                break;
            case 3:
                Age = 17;
                break;
            case 4:
                Age = 18;
                break;
            default:
                System.out.println("ERROR - No Age Selected");

        }
        int studentID = selStudent.getId();

        updtStudent = new Student(studentID, curName, curSName, Age, CurDaysAbs);

        return ValidateData(curName, curSName);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbl_Name = new javax.swing.JLabel();
        lbl_Surname = new javax.swing.JLabel();
        txtfld_Name = new javax.swing.JTextField();
        txtfld_Surname = new javax.swing.JTextField();
        lbl_Heading = new javax.swing.JLabel();
        lbl_AgeGroup = new javax.swing.JLabel();
        cmb_AgeGroup = new javax.swing.JComboBox<>();
        btn_Cancel = new javax.swing.JButton();
        btn_Save = new javax.swing.JButton();
        btn_Help = new javax.swing.JButton();
        logo_CornerDecor = new javax.swing.JLabel();
        lbl_DaysAbsent = new javax.swing.JLabel();
        spn_DaysAbsent = new javax.swing.JSpinner();
        lbl_Warning1 = new javax.swing.JLabel();
        lbl_Warning2 = new javax.swing.JLabel();
        lbl_Warning3 = new javax.swing.JLabel();
        lbl_Warning4 = new javax.swing.JLabel();

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Lib/CornerDecalsSmall.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(178, 219, 244));

        lbl_Name.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbl_Name.setText("Name:");

        lbl_Surname.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbl_Surname.setText("Surname:");

        txtfld_Name.setText("Mathew");
        txtfld_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfld_NameActionPerformed(evt);
            }
        });

        txtfld_Surname.setText("Ragland");

        lbl_Heading.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lbl_Heading.setText("Edit");

        lbl_AgeGroup.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbl_AgeGroup.setText("Age Group:");

        cmb_AgeGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "u14", "u15", "u16", "u17", "u18" }));
        cmb_AgeGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_AgeGroupActionPerformed(evt);
            }
        });

        btn_Cancel.setText("Cancel");
        btn_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelActionPerformed(evt);
            }
        });

        btn_Save.setText("Save");
        btn_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SaveActionPerformed(evt);
            }
        });

        btn_Help.setText("?");
        btn_Help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HelpActionPerformed(evt);
            }
        });

        logo_CornerDecor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Lib/CornerDecalsSmall.png"))); // NOI18N

        lbl_DaysAbsent.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbl_DaysAbsent.setText("Days Absent:");

        spn_DaysAbsent.setModel(new javax.swing.SpinnerNumberModel(0, 0, 364, 1));

        lbl_Warning1.setForeground(new java.awt.Color(255, 51, 51));
        lbl_Warning1.setText("Alphabetical characters only");

        lbl_Warning2.setForeground(new java.awt.Color(255, 51, 51));
        lbl_Warning2.setText("Alphabetical characters only");

        lbl_Warning3.setForeground(new java.awt.Color(255, 51, 51));
        lbl_Warning3.setText("Field is empty");

        lbl_Warning4.setForeground(new java.awt.Color(255, 51, 51));
        lbl_Warning4.setText("Field is empty");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_Surname)
                                    .addComponent(lbl_Name)
                                    .addComponent(lbl_AgeGroup))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmb_AgeGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtfld_Surname)
                                    .addComponent(txtfld_Name)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(lbl_Heading))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_DaysAbsent)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spn_DaysAbsent, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(logo_CornerDecor))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_Warning2)
                                    .addComponent(lbl_Warning1)
                                    .addComponent(lbl_Warning3)
                                    .addComponent(lbl_Warning4)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Help)
                        .addGap(21, 21, 21))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logo_CornerDecor)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lbl_Heading)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_Name)
                            .addComponent(txtfld_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_Surname)
                            .addComponent(txtfld_Surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_AgeGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_AgeGroup))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_DaysAbsent)
                            .addComponent(spn_DaysAbsent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbl_Warning1)
                        .addGap(5, 5, 5)
                        .addComponent(lbl_Warning3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_Warning2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_Warning4)))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Help))
                .addContainerGap(56, Short.MAX_VALUE))
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

    //Cancels and goes back to student details screen
    private void btn_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelActionPerformed
        // go back to database access screen

        SDS.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_CancelActionPerformed

    //Calls the 
    private void btn_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SaveActionPerformed

// If data is valid, data will be saved and update database
        SaveData();

        if (SaveData() == true) {
            dataCur.updateStudent(updtStudent);
            SDS.SetStudent(updtStudent);
            SDS.populateDetails();
            System.out.println(updtStudent.toString());
            SDS.setVisible(true);
            this.setVisible(false);

        } else {

        }


    }//GEN-LAST:event_btn_SaveActionPerformed
    
    //Opens Help Screen
    private void btn_HelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HelpActionPerformed
        // go to help screen
        SIHS = new HelpScreen(value);
        SIHS.setVisible(true);

    }//GEN-LAST:event_btn_HelpActionPerformed
    
    private void cmb_AgeGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_AgeGroupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_AgeGroupActionPerformed

    private void txtfld_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfld_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfld_NameActionPerformed

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
//            java.util.logging.Logger.getLogger(EditStudentScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(EditStudentScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(EditStudentScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(EditStudentScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new EditStudentScreen().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cancel;
    private javax.swing.JButton btn_Help;
    private javax.swing.JButton btn_Save;
    private javax.swing.JComboBox<String> cmb_AgeGroup;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_AgeGroup;
    private javax.swing.JLabel lbl_DaysAbsent;
    private javax.swing.JLabel lbl_Heading;
    private javax.swing.JLabel lbl_Name;
    private javax.swing.JLabel lbl_Surname;
    private javax.swing.JLabel lbl_Warning1;
    private javax.swing.JLabel lbl_Warning2;
    private javax.swing.JLabel lbl_Warning3;
    private javax.swing.JLabel lbl_Warning4;
    private javax.swing.JLabel logo_CornerDecor;
    private javax.swing.JSpinner spn_DaysAbsent;
    private javax.swing.JTextField txtfld_Name;
    private javax.swing.JTextField txtfld_Surname;
    // End of variables declaration//GEN-END:variables
}
