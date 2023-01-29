/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package packageGUI;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import newpackage.ParkingSpaces;
import newpackage.ParkingSpacesManager;

/**
 *
 * @author Petya Tetevenska
 */
public class JPanelParkingSpaces extends javax.swing.JPanel {

    ParkingSpacesManager mySpacesManager = ParkingSpacesManager.getTheSpacesManager();
    /**
     * Creates new form JPanelParkingSpaces
     */
    public JPanelParkingSpaces() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableParkingSpaces = new javax.swing.JTable();
        jTextFieldPosition = new javax.swing.JTextField();
        jTextFieldStatus = new javax.swing.JTextField();
        jLabelPosition = new javax.swing.JLabel();
        jLabelStatus = new javax.swing.JLabel();
        jButtonAddSpace = new javax.swing.JButton();
        jButtonDeleteSpace = new javax.swing.JButton();
        jButtonUpdateSpace = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(500, 400));

        jLabelTitle.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabelTitle.setText("Parking Spaces Management");

        jTableParkingSpaces.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Parking space position", "Parking space status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableParkingSpaces.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableParkingSpacesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableParkingSpaces);

        jLabelPosition.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabelPosition.setText("Parking space position:");

        jLabelStatus.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabelStatus.setText("Parking space status:");

        jButtonAddSpace.setText("Add");
        jButtonAddSpace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddSpaceActionPerformed(evt);
            }
        });

        jButtonDeleteSpace.setText("Delete");
        jButtonDeleteSpace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteSpaceActionPerformed(evt);
            }
        });

        jButtonUpdateSpace.setText("Update");
        jButtonUpdateSpace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateSpaceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelPosition)
                                    .addComponent(jLabelStatus))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonAddSpace)
                                        .addGap(12, 12, 12)
                                        .addComponent(jButtonUpdateSpace)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonDeleteSpace))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelTitle)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPosition)
                    .addComponent(jTextFieldPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelStatus))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddSpace)
                    .addComponent(jButtonDeleteSpace)
                    .addComponent(jButtonUpdateSpace))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddSpaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddSpaceActionPerformed
         DefaultTableModel model = (DefaultTableModel) jTableParkingSpaces.getModel();
        ArrayList<ParkingSpaces> localSpaces = newpackage.ParkingSpacesManager.getSpaces();
        int position = 0;
        String status = "";

        int answer = JOptionPane.showConfirmDialog(this, "Do you want to save this parking space?", "Please confirm!", JOptionPane.CANCEL_OPTION, JOptionPane.OK_OPTION);
        if (answer == JOptionPane.CANCEL_OPTION) {
            JOptionPane.getRootFrame().dispose();
        } else {

            try {
                position = Integer.parseInt(jTextFieldPosition.getText());
                status = jTextFieldStatus.getText();

                ParkingSpaces space = new ParkingSpaces(position, status);
                localSpaces.add(space);

                mySpacesManager.addSpace(position, status);
                mySpacesManager.serialize();
                Object rowData[] = new Object[2];

                for (int i = 0; i < localSpaces.size(); i++) {
                    //filter what to add to the ui table
                    if (localSpaces.get(i).getPosition()== space.getPosition()&& localSpaces.get(i).getStatus().equals(space.getStatus())) {
                        rowData[0] = localSpaces.get(i).getPosition();
                        rowData[1] = localSpaces.get(i).getStatus();
                        model.addRow(rowData);
                    }
                }

            } catch (Exception e) {
                String message = "Car id \"" + jTextFieldPosition.getText() + "\" is not valid! Please enter a number instead!";
                JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonAddSpaceActionPerformed

    private void jButtonUpdateSpaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateSpaceActionPerformed
        int i = jTableParkingSpaces.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTableParkingSpaces.getModel();
        try {
            
            String result = model.getValueAt(i, 0).toString();
            int position = Integer.parseInt(result);
            int newPosition = Integer.parseInt(jTextFieldPosition.getText());
            String status = jTextFieldStatus.getText().trim();
            
            mySpacesManager.update(position, newPosition, status);
            mySpacesManager.serialize();
                       
            model.setValueAt(newPosition, i, 0);
            model.setValueAt(status, i, 1);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Update Error!" + "\n Please enter a valid position number!", "Please note", JOptionPane.INFORMATION_MESSAGE);
        }
                
    }//GEN-LAST:event_jButtonUpdateSpaceActionPerformed

    private void jButtonDeleteSpaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteSpaceActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTableParkingSpaces.getModel();
        int i = jTableParkingSpaces.getSelectedRow();
        if ((i < 0)) {  // no row is selected
            JOptionPane.showMessageDialog(this, "Sorry, no parking space is selected!");
            return; 
        }
        // a row is selected: get the data of that row in first column
        String parkingPosition = model.getValueAt(i, 0).toString();
        if (parkingPosition.equals("null")) {  // no parking space position in the row
            JOptionPane.showMessageDialog(this, "Sorry, there is no parking space position in this row!");
            return; 
        }
        
        int answer = JOptionPane.showConfirmDialog(this, "Do you really want to delete this parking space?", "Please confirm!", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.NO_OPTION) {
            JOptionPane.getRootFrame().dispose();
        } else {
            int thePosition = Integer.parseInt(model.getValueAt(i, 0).toString());
            mySpacesManager.delete(thePosition);
            mySpacesManager.serialize();
            model.removeRow(i);
            JOptionPane.showMessageDialog(this, "Parking space deleted");
        }
    }//GEN-LAST:event_jButtonDeleteSpaceActionPerformed

    private void jTableParkingSpacesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableParkingSpacesMouseClicked
        int i = jTableParkingSpaces.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTableParkingSpaces.getModel();
        jTextFieldPosition.setText(model.getValueAt(i, 0).toString());
        jTextFieldStatus.setText(model.getValueAt(i, 1).toString());
    }//GEN-LAST:event_jTableParkingSpacesMouseClicked

    public void init() {
        DefaultTableModel model = (DefaultTableModel) jTableParkingSpaces.getModel();
        
        mySpacesManager.deserialize();
        
        if(mySpacesManager.getSpaces().isEmpty()){
            mySpacesManager.createTestParkingSpaces();
            mySpacesManager.serialize();
            mySpacesManager.deserialize();
        }
        
        for (ParkingSpaces aSpace : mySpacesManager.getSpaces()) {
            model.addRow(new Object[]{aSpace.getPosition(), aSpace.getStatus()});
        }
        // 2. define a TableModelListener to handle car table updates
        model.addTableModelListener(new TableModelListener() {
            // we only handle update events!
            @Override
            public void tableChanged(TableModelEvent ev) {
                if (ev.getType() == javax.swing.event.TableModelEvent.UPDATE) {
                    // handleSpaceUpdate(ev);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddSpace;
    private javax.swing.JButton jButtonDeleteSpace;
    private javax.swing.JButton jButtonUpdateSpace;
    private javax.swing.JLabel jLabelPosition;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableParkingSpaces;
    private javax.swing.JTextField jTextFieldPosition;
    private javax.swing.JTextField jTextFieldStatus;
    // End of variables declaration//GEN-END:variables
}
