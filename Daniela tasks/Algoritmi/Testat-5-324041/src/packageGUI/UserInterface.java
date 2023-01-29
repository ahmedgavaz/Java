/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/Application.java to edit this template
 */
package packageGUI;

import newpackage.CarManager;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import newpackage.Settings;
import newpackage.SettingsSerialization;

/**
 *
 * @author Petya Tetevenska
 */
public class UserInterface extends javax.swing.JFrame {

    CarManager myCarManager = CarManager.getTheCarManager();
    JPanelCars carsGUI = new JPanelCars();
    JPanelParkingSpaces spacesGUI = new JPanelParkingSpaces();
    Settings settings ;

    /**
     * Creates new form GUIManager
     */
    public UserInterface() {
        initComponents();
        this.setLocationRelativeTo(null);
        jPanelMain.setLayout(new BorderLayout());
        carsGUI.init();
        spacesGUI.init();
        //deserialize the settings and save them in settings variable
        Settings settings = SettingsSerialization.deserialize();
        //if the deserialization does not work, create a new object with default values
        if(settings == null){
            this.settings = new Settings("Parking Management", " 1.0 (C) 2021 ", " Petya Tetevenska");
        }      
        else{
            this.settings = settings;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        jMenuItemSettings = new javax.swing.JMenuItem();
        basicDataMenu = new javax.swing.JMenu();
        manageCarsMenuItem = new javax.swing.JMenuItem();
        manageSpacesMenuItem = new javax.swing.JMenuItem();
        manageMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        helpMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("PARKING-Management (Version 1.0 (C) 2021 by Petya");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanelMain.setPreferredSize(new java.awt.Dimension(400, 280));

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        jMenuItemSettings.setText("Settings");
        jMenuItemSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSettingsActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItemSettings);

        menuBar.add(fileMenu);

        basicDataMenu.setMnemonic('e');
        basicDataMenu.setText("Basic Data");

        manageCarsMenuItem.setMnemonic('t');
        manageCarsMenuItem.setText("Manage cars");
        manageCarsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageCarsMenuItemActionPerformed(evt);
            }
        });
        basicDataMenu.add(manageCarsMenuItem);

        manageSpacesMenuItem.setMnemonic('y');
        manageSpacesMenuItem.setText("Manage parking spaces");
        manageSpacesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageSpacesMenuItemActionPerformed(evt);
            }
        });
        basicDataMenu.add(manageSpacesMenuItem);

        manageMenuItem.setMnemonic('p');
        manageMenuItem.setText("Manage...");
        manageMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageMenuItemActionPerformed(evt);
            }
        });
        basicDataMenu.add(manageMenuItem);

        menuBar.add(basicDataMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        helpMenuItem.setMnemonic('c');
        helpMenuItem.setText("Help");
        helpMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(helpMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        exitIfConfirmed();
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void helpMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMenuItemActionPerformed
       JOptionPane.showMessageDialog(this, "This part of the app is currrently NOT implemented!", "Please note", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_helpMenuItemActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        exitIfConfirmed();
    }//GEN-LAST:event_formWindowClosing

    private void manageSpacesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageSpacesMenuItemActionPerformed
        cleanMainPanel(); //wipe out any content in main panel
       jPanelMain.add(spacesGUI);
       jPanelMain.updateUI();
    }//GEN-LAST:event_manageSpacesMenuItemActionPerformed

    private void manageMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageMenuItemActionPerformed
        JOptionPane.showMessageDialog(this, "This part of the app is currrently NOT implemented!", "Please note", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_manageMenuItemActionPerformed

    private void manageCarsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageCarsMenuItemActionPerformed
       cleanMainPanel(); //wipe out any content in main panel
       jPanelMain.add(carsGUI);
       jPanelMain.updateUI();
    }//GEN-LAST:event_manageCarsMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
      
        JOptionPane.showMessageDialog(this, this.settings.toString(), "About", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void jMenuItemSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSettingsActionPerformed

            SettingsDialog sd = new SettingsDialog(this, true, settings);               
       
            sd.setVisible(true);
            this.setTitle(settings.toString());
     
    }//GEN-LAST:event_jMenuItemSettingsActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

     private void cleanMainPanel() {
        jPanelMain.remove(carsGUI);
        jPanelMain.remove(spacesGUI);
    }
    
    private void exitIfConfirmed() {
        // exit the app if user confirms this 
        int answer = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit the app?", "Please confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (answer == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

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
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenu basicDataMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem helpMenuItem;
    private javax.swing.JMenuItem jMenuItemSettings;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JMenuItem manageCarsMenuItem;
    private javax.swing.JMenuItem manageMenuItem;
    private javax.swing.JMenuItem manageSpacesMenuItem;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

   

}
