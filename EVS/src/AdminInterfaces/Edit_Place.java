package AdminInterfaces;
import MainInterfaces.DBAccess;
import Mundo.Admin.City;
import Mundo.Admin.Place;
import Mundo.Admin.PlaceType;
import java.util.*;
import java.sql.*;
import javax.swing.JComboBox;

public class Edit_Place extends javax.swing.JFrame {
    private String PLACE_ID;
    private DBAccess dba;
    private Boolean edit;
    
    public Edit_Place(DBAccess dba, Boolean edit) {
        this.PLACE_ID = PLACE_ID;
        this.dba = dba;
        this.edit = edit;
        initComponents();
        if (this.edit == false) { labelTitle.setText("Crear Lugar"); } else { labelTitle.setText("Modificar Lugar"); }
        
        City City = new City();
        ResultSet rsCity = dba.consultar(City.getCiudades());
        String[] arrayCity = rsToArray(rsCity);
        selplacecity = new JComboBox(arrayCity);
        
        PlaceType PlaceType = new PlaceType();
        ResultSet rsPlaceType = dba.consultar(PlaceType.getPlacesTypes());
        String[] arrayPlaceType = rsToArray(rsPlaceType);
        selplacetype = new JComboBox(arrayPlaceType);
    }
    
    public Edit_Place(DBAccess dba, String PLACE_ID, Boolean edit) {
        this.PLACE_ID = PLACE_ID;
        this.dba = dba;
        this.edit = edit;
        initComponents();
        if (this.edit == false) { labelTitle.setText("Crear Lugar"); } else { labelTitle.setText("Modificar Lugar"); }

        City City = new City();
        ResultSet rsCity = dba.consultar(City.getCiudades());
        String[] arrayCity = rsToArray(rsCity);
        selplacecity = new JComboBox(arrayCity);
        
        PlaceType PlaceType = new PlaceType();
        ResultSet rsPlaceType = dba.consultar(PlaceType.getPlacesTypes());
        String[] arrayPlaceType = rsToArray(rsPlaceType);
        selplacetype = new JComboBox(arrayPlaceType);
        
        Place Place = new Place();
        
        String PLACE_NAME = Place.getName(PLACE_ID);
        ResultSet RSpName = dba.consultar(PLACE_NAME);
        PLACE_NAME = getDataFromRS(RSpName);
        textplacename.setText(PLACE_NAME);
        
        String PLACE_PHONE = Place.getPhone(PLACE_ID);
        ResultSet RSpPhone = dba.consultar(PLACE_PHONE);
        PLACE_PHONE = getDataFromRS(RSpPhone);
        textplacephone.setText(PLACE_PHONE);
        
        String ACCESS_RESTRICTIONS = Place.getRestrictions(PLACE_ID);
        ResultSet RSpRestrictions = dba.consultar(ACCESS_RESTRICTIONS);
        ACCESS_RESTRICTIONS = getDataFromRS(RSpRestrictions);
        textplacerestrictions.setText(ACCESS_RESTRICTIONS);
        
        String PLACE_ADDRESS = Place.getPhone(PLACE_ID);
        ResultSet RSpAddress = dba.consultar(PLACE_ADDRESS);
        PLACE_ADDRESS = getDataFromRS(RSpAddress);
        textplaceaddress.setText(PLACE_ADDRESS);
        
        String CAPACITY = Place.getCapacity(PLACE_ID);
        ResultSet RSpCapacity = dba.consultar(CAPACITY);
        CAPACITY = getDataFromRS(RSpCapacity);
        textplacecapacity.setText(CAPACITY);
        
        String CITY_NAME = Place.getCity(PLACE_ID);
        ResultSet RSpCity = dba.consultar(CITY_NAME);
        CITY_NAME = getDataFromRS(RSpCity);
        selplacecity.setSelectedItem(CITY_NAME);
        
        String PLACE_TYPE = Place.getPType(PLACE_ID);
        ResultSet RSpType = dba.consultar(PLACE_TYPE);
        PLACE_TYPE = getDataFromRS(RSpType);
        selplacetype.setSelectedItem(PLACE_TYPE);
    }
    
    public String[] rsToArray(ResultSet data){
        ArrayList<String> items = new ArrayList<>(100);    
        try {
        while(data.next()){ items.add(data.getString(1)); }
        } catch(SQLException e){}
        return items.toArray(new String[items.size()]);
    }
    
    public String getDataFromRS(ResultSet data) {
        try{
            if(data.next()){ return data.getString(1); }
        } catch(SQLException e) {}
        return "";
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

        selplacecity.setEditable(true);
        selplacecity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Capacidad");

        jLabel7.setText("Tipo de lugar");

        selplacetype.setEditable(true);
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
                                    .addComponent(selplacecity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(selplacetype, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                    .addComponent(textplacecapacity)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(labelTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
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
        String PLACE_NAME = textplacename.getSelectedText();
        String PLACE_PHONE = textplacephone.getSelectedText();
        String ACCESS_RESTRICTIONS = textplacerestrictions.getSelectedText();
        String PLACE_ADDRESS = textplaceaddress.getSelectedText();
        String CAPACITY = textplacecapacity.getSelectedText();
        String PTYPE_ID = (String)selplacetype.getSelectedItem();
        String CITY_ID = (String)selplacecity.getSelectedItem();
        
        PlaceType pType = new PlaceType();
        PTYPE_ID = pType.getID(PTYPE_ID);
        ResultSet RSpType = dba.consultar(PTYPE_ID);
        PTYPE_ID = getDataFromRS(RSpType);
        
        City pCity = new City();
        CITY_ID = pCity.getID(CITY_ID);
        ResultSet RSpCity = dba.consultar(CITY_ID);
        CITY_ID = getDataFromRS(RSpCity);
        
        Boolean make;
        if (edit == true) {
            Place PlaceUpdate = new Place(PLACE_ID, PLACE_NAME, PLACE_PHONE, ACCESS_RESTRICTIONS, PLACE_ADDRESS, CAPACITY, PTYPE_ID, CITY_ID);
            make = dba.ejecutar(PlaceUpdate.update());
        } else {
            Place PlaceCreate = new Place(PLACE_NAME, PLACE_PHONE, ACCESS_RESTRICTIONS, PLACE_ADDRESS, CAPACITY, PTYPE_ID, CITY_ID);
            make = dba.ejecutar(PlaceCreate.create());
        }
        if (make == true) { System.out.println("Operation make it!"); } else { System.out.println("Operation with errors"); }
    }//GEN-LAST:event_buttonUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(Edit_Place.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Edit_Place.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Edit_Place.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Edit_Place.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Edit_Place().setVisible(true);
            }
        });
    }

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
