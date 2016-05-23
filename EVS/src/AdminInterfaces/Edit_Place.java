package AdminInterfaces;
import MainInterfaces.DBAccess;
import Mundo.City;
import Mundo.Place;
import Mundo.PlaceType;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Edit_Place extends javax.swing.JFrame {
    private Boolean edit;
    
    public Edit_Place(Boolean edit) {
        this.edit = edit;
        initComponents();
        if (!edit) { 
            labelTitle.setText("Crear Lugar"); 
            nuevo();
        } else { 
            labelTitle.setText("Modificar Lugar");
            editar();
        }
        setVisible(true);
       
    }
    
    public void nuevo(){
        try {
            selplacetype.setModel(new DefaultComboBoxModel(DBAccess.rsToArray(DBAccess.consultar(PlaceType.getAllPlaceTypes()))));
            selplacecity.setModel(new DefaultComboBoxModel(DBAccess.rsToArray(DBAccess.consultar(City.getCiudades()))));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERROR: Al cargar los tipos de lugares y/o las ciudades");
        }
    }
    
    public void editar(){
        ArrayList parametros = new ArrayList();
        parametros.add(Place.getPLACE_ID());
        for(int i = 0; i < 7; i++) parametros.add(Types.VARCHAR);
        try {
            ArrayList<String> datosUsuario = DBAccess.procedureIN_OUT("PLACE_INFORMATION(?,?,?,?,?,?,?,?)", parametros);
            textplacename.setText(datosUsuario.get(0));
            textplacephone.setText(datosUsuario.get(1));
            textplaceaddress.setText(datosUsuario.get(2));
            selplacecity.setModel(new DefaultComboBoxModel(DBAccess.llenarCB(datosUsuario.get(3), DBAccess.rsToArray(DBAccess.consultar(City.getCiudades())))));
            textplacecapacity.setText(datosUsuario.get(4));
            selplacetype.setModel(new DefaultComboBoxModel(DBAccess.llenarCB(datosUsuario.get(5), DBAccess.rsToArray(DBAccess.consultar(PlaceType.getAllPlaceTypes())))));
            textplacerestrictions.setText(datosUsuario.get(6));
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"ERROR: Al cargar la informacion de lugar");
        }
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        labelTitle = new javax.swing.JLabel();
        textplacename = new javax.swing.JTextField();
        textplaceaddress = new javax.swing.JTextField();
        textplacephone = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        selplacecity = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        textplacecapacity = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        selplacetype = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        textplacerestrictions = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        buttonCancel = new javax.swing.JButton();
        buttonUpdate = new javax.swing.JButton();

        jButton2.setText("Nueva");

        jButton3.setText("Nuevo Tipo");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelTitle.setText("Modificar Lugar");

        jLabel2.setText("Telefono");

        jLabel3.setText("Dirección");

        jLabel4.setText("Nombre");

        jLabel5.setText("Ciudad");

        selplacecity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Capacidad");

        jLabel7.setText("Tipo de lugar");

        selplacetype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        textplacerestrictions.setColumns(20);
        textplacerestrictions.setRows(5);
        jScrollPane1.setViewportView(textplacerestrictions);

        jLabel8.setText("Restricciones");

        buttonCancel.setText("Cancelar");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        buttonUpdate.setText("Aceptar");
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(selplacetype, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                    .addComponent(textplacecapacity)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel2)))
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textplacephone, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                    .addComponent(textplacename)
                                    .addComponent(textplaceaddress, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                    .addComponent(selplacecity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelTitle)
                .addGap(137, 137, 137))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textplacename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textplacephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textplaceaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(selplacecity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textplacecapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(selplacetype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        dispose();
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
        ArrayList parametros = new ArrayList();
        if(edit){
            parametros.add(Place.getPLACE_ID());
            parametros.add(textplacename.getText());
            parametros.add(textplacephone.getText());
            parametros.add(textplaceaddress.getText());
            parametros.add(selplacecity.getSelectedItem());
            parametros.add(textplacecapacity.getText());
            parametros.add(selplacetype.getSelectedItem());
            parametros.add(textplacerestrictions.getText());
            try {
                DBAccess.procedureIN("CHANGE_PLACE_INFO(?,?,?,?,?,?,?,?)",parametros);
                JOptionPane.showMessageDialog(null,"Se hiso las modificaciones Exitosamente");
                dispose();
                new Search_Places();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"No se pudo modificar el lugar, la direccion solicitada ya esta en uso o algun dato es erroneo");
                try {
                    DBAccess.getConexion().rollback();
                } catch (SQLException ex1) {
                    System.out.println("Error: Cargar la Base de Datos desde las ediciones de los lugares");
                }
            }         
        }else{
            parametros.add(textplacename.getText());
            parametros.add(textplacephone.getText());
            parametros.add(textplaceaddress.getText());
            parametros.add((String)selplacecity.getSelectedItem());
            parametros.add(textplacecapacity.getText());
            parametros.add((String)selplacetype.getSelectedItem());
            parametros.add(textplacerestrictions.getText());
            try {
                DBAccess.procedureIN("CREATE_PLACE(?,?,?,?,?,?,?)",parametros);
                JOptionPane.showMessageDialog(null,"Se creo el Lugar Exitosamente");
                dispose();
                new Search_Places();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"No se pudo crear el lugar, la direccion solicitada ya esta en uso o algun dato es erroneo");
                try {
                    DBAccess.getConexion().rollback();
                } catch (SQLException ex1) {
                    System.out.println("Error: Cargar la Base de Datos desde la creacion de los lugares");
                }
            } 
        }
    }//GEN-LAST:event_buttonUpdateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JComboBox<String> selplacecity;
    private javax.swing.JComboBox<String> selplacetype;
    private javax.swing.JTextField textplaceaddress;
    private javax.swing.JTextField textplacecapacity;
    private javax.swing.JTextField textplacename;
    private javax.swing.JTextField textplacephone;
    private javax.swing.JTextArea textplacerestrictions;
    // End of variables declaration//GEN-END:variables
}
