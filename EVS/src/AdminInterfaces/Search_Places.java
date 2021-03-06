package AdminInterfaces;

import MainInterfaces.DBAccess;
import Mundo.Place;
import Mundo.PlaceType;
import Mundo.Event;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Search_Places extends javax.swing.JFrame {
    
    private String CITY;
    private String PTYPE; 
    private String PLACE_NAME;
    private String ADDRESS;
    
    public Search_Places() {
        initComponents();
        setVisible(true);
        llenarCiudades();
    }
    
    public void llenarCiudades(){
        try {
            ResultSet rsCity = DBAccess.consultar(Event.consultarTodasCiudades());
            String[] arrayCity = DBAccess.rsToArray(rsCity);
            selCity.setModel(new DefaultComboBoxModel(arrayCity));
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR: No se pudo Cargar las Ciudades");
        }
    }

    public void setLugarId() throws SQLException{
        ArrayList parametros = new ArrayList();
        parametros.add(CITY);
        parametros.add(PTYPE);
        parametros.add(PLACE_NAME);
        parametros.add((String)direccionCB.getSelectedItem());
        parametros.add(Types.NUMERIC);
        ArrayList<String> datosLugar = DBAccess.procedureIN_OUT("PLACE_SEARCH(?,?,?,?,?)", parametros);
        Place.setPLACE_ID(datosLugar.get(0));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        buttonEdit = new javax.swing.JButton();
        selCity = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        selPlaceType = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        selPlace = new javax.swing.JComboBox<>();
        buttonExit = new javax.swing.JButton();
        buttonNew = new javax.swing.JButton();
        buttonRemove = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        direccionCB = new javax.swing.JComboBox<>();

        jButton1.setText("Nuevo lugar");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Consultar Lugares");

        buttonEdit.setText("Editar");
        buttonEdit.setEnabled(false);
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });

        selCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selCityActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Ciudad ");

        selPlaceType.setEnabled(false);
        selPlaceType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selPlaceTypeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Tipo de lugar");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Lugar");

        selPlace.setEnabled(false);
        selPlace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selPlaceActionPerformed(evt);
            }
        });

        buttonExit.setText("Salir");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

        buttonNew.setText("Nuevo");
        buttonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewActionPerformed(evt);
            }
        });

        buttonRemove.setText("Eliminar");
        buttonRemove.setEnabled(false);
        buttonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoveActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Dirección");

        direccionCB.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(selPlaceType, 0, 185, Short.MAX_VALUE)
                            .addComponent(selCity, 0, 185, Short.MAX_VALUE)
                            .addComponent(selPlace, 0, 185, Short.MAX_VALUE)
                            .addComponent(direccionCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(buttonNew, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selCity, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selPlaceType, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(direccionCB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonNew, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
        try {          
            setLugarId();
            dispose();
            new Edit_Place(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error: No se encuentran lugares");
        }
    }//GEN-LAST:event_buttonEditActionPerformed

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        dispose();
        new Administrator_Panel();
    }//GEN-LAST:event_buttonExitActionPerformed

    private void buttonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewActionPerformed
        dispose();
        new Edit_Place(false);
    }//GEN-LAST:event_buttonNewActionPerformed

    private void buttonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveActionPerformed
      try {          
            setLugarId();
            ArrayList parametros = new ArrayList();
            parametros.add(Place.getPLACE_ID());
            DBAccess.procedureIN("DELETE_PLACE(?)",parametros);
            JOptionPane.showMessageDialog(null,"Se elimino el lugar exitosamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error: No se pudo eliminar el lugar, porfavor intentarlo mas tarde");
          try {
              DBAccess.getConexion().rollback();
          } catch (SQLException ex1) {
               System.out.println("Error: Cargar la Base de Datos al intentar borrar un lugar");
          }
        }
    }//GEN-LAST:event_buttonRemoveActionPerformed

    private void selCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selCityActionPerformed
        buttonEdit.setEnabled(false);
        buttonRemove.setEnabled(false);
        CITY = (String)selCity.getSelectedItem();        
        try {
            ResultSet rs = DBAccess.consultar(PlaceType.getPlacesTypesOfCity(CITY));
            String[] arrayPlaceType = DBAccess.rsToArray(rs);
            selPlaceType.setModel(new DefaultComboBoxModel(arrayPlaceType));
            selPlaceType.setEnabled(true);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR: No se pudo Cargar los tipos de lugares");
        }
    }//GEN-LAST:event_selCityActionPerformed

    private void selPlaceTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selPlaceTypeActionPerformed
        buttonEdit.setEnabled(false);
        buttonRemove.setEnabled(false);
        PTYPE = (String)selPlaceType.getSelectedItem();
        
        try {
            ResultSet rsPlace = DBAccess.consultar(Place.getPlaces(PTYPE, CITY));
            String[] arrayPlace = DBAccess.rsToArray(rsPlace);
            selPlace.setModel(new DefaultComboBoxModel(arrayPlace));
            selPlace.setEnabled(true);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR: No se pudo Cargar los nombres de los lugares");
        }
    }//GEN-LAST:event_selPlaceTypeActionPerformed

    private void selPlaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selPlaceActionPerformed
        PLACE_NAME = (String)selPlace.getSelectedItem();
        
        try {
            ResultSet rsAddress = DBAccess.consultar(Place.getAddress(PLACE_NAME,PTYPE, CITY));
            String[] arrayAddress = DBAccess.rsToArray(rsAddress);
            direccionCB.setModel(new DefaultComboBoxModel(arrayAddress));
            direccionCB.setEnabled(true);
            if(arrayAddress.length > 0){
                buttonEdit.setEnabled(true);
                buttonRemove.setEnabled(true);
            }
        } catch(Exception e){
             JOptionPane.showMessageDialog(null,"ERROR: No se pudo Cargar los las direcciones de los lugares");
        }
    }//GEN-LAST:event_selPlaceActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonNew;
    private javax.swing.JButton buttonRemove;
    private javax.swing.JComboBox<String> direccionCB;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JComboBox<String> selCity;
    private javax.swing.JComboBox<String> selPlace;
    private javax.swing.JComboBox<String> selPlaceType;
    // End of variables declaration//GEN-END:variables
}
