package ClientInterfaces;

import Mundo.Event;
import MainInterfaces.DBAccess;
import java.sql.*;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nicolas
 */
public class EventsMoreInfo extends javax.swing.JFrame {
    private boolean bougth;
    /**
     * Creates new form EventsMoreInfo
     * 
     * b=true si me llamo BoughtTickets
     * b=false si me llamo EventSearch
     */
    public EventsMoreInfo(boolean b) {      
        //inicializo las variables locales
        initComponents();
        setVisible(true);
        bougth=b;
        ResultSet sc2;
        String arg,comando;
        Event.consultarId();
        
        //le paso el id para que me devuleva la consulta en un String
        try{
            String sql = Event.consultarPorId();
            ResultSet sc=DBAccess.consultar(sql);
             if(sc.next()){
               
               //traer categoria segun id
               arg=sc.getString(1);
               System.out.println(arg);
               comando = Event.consultarEventCategory(arg);
               System.out.println(arg);
               sc2 = DBAccess.consultar(comando);
               
               if(sc2.next())
                   arg = sc2.getString(1);
               jTFCategoria.setText(arg);

               //traer nombre del evento segun id
               arg=sc.getString(2);
               comando = Event.consultarETName(arg);
               sc2 = DBAccess.consultar(comando);
               
               if(sc2.next())
                   arg = sc2.getString(1);
               jTFNombre.setText(arg);
                             
               //traer el nombre del lugar segun id
               String place_id=sc.getString(3);
               comando = Event.consultarLugar(place_id);
               sc2 = DBAccess.consultar(comando);
               
               if(sc2.next())
                   arg = sc2.getString(1);
               jTFLugar.setText(arg);
              
               
               
               //trer nombre de la ciudad segun id lugar
               comando = Event.consultarCiudad(place_id);
               sc2 = DBAccess.consultar(comando);
               
               if(sc2.next())
                   arg = sc2.getString(1);
               jTFCiudad.setText(arg);
               
               //trer dirección segun id lugar
               comando = Event.consultarDir(place_id);
               sc2 = DBAccess.consultar(comando);
               
               if(sc2.next())
                   arg = sc2.getString(1);
               jTFDir.setText(arg);
               
               
               //trer tipo de lugar segun id lugar
               comando = Event.consultarPType(place_id);
               sc2 = DBAccess.consultar(comando);
               
               if(sc2.next())
                   arg = sc2.getString(1);
               jTF_PType.setText(arg);
               
             
               //trer restricciones de lugar segun id lugar
               comando = Event.consultarRestricciones(place_id);
               sc2 = DBAccess.consultar(comando);
               
               if(sc2.next())
                   arg = sc2.getString(1);
                jTA_Rest.setText(arg);
               
               
               //traer fecha y hora
               arg=sc.getString(4);
               System.out.println(arg);
               String[] hora=arg.split("\\s+");
               jTFFecha.setText(arg.substring(0,10));
               jTFHora.setText(arg.substring(11));
             }
        }catch(SQLException e){
            e.printStackTrace();
        }
       
       
        //mostrar todos los datos de evento
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jTFDir = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTFCiudad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTA_Rest = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jTFHora = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTFFecha = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTFLugar = new javax.swing.JTextField();
        jTFNombre = new javax.swing.JTextField();
        jTFCategoria = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTF_PType = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        JBSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setText("Ciudad");

        jTFDir.setEditable(false);
        jTFDir.setToolTipText("");

        jLabel5.setText("Hora");

        jLabel10.setText("Direccion");

        jTFCiudad.setEditable(false);

        jScrollPane1.setHorizontalScrollBar(null);

        jTA_Rest.setEditable(false);
        jTA_Rest.setColumns(20);
        jTA_Rest.setLineWrap(true);
        jTA_Rest.setRows(5);
        jTA_Rest.setName(""); // NOI18N
        jScrollPane1.setViewportView(jTA_Rest);

        jLabel14.setText("Categoria");

        jTFHora.setEditable(false);
        jTFHora.setToolTipText("");

        jLabel11.setText("Restricciones");

        jLabel2.setText("Nombre del Lugar");

        jLabel8.setText("Lugar");

        jTFFecha.setEditable(false);
        jTFFecha.setToolTipText("");
        jTFFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFFechaActionPerformed(evt);
            }
        });

        jLabel7.setText("Fecha");

        jTFLugar.setEditable(false);

        jTFNombre.setEditable(false);
        jTFNombre.setToolTipText("");

        jTFCategoria.setEditable(false);

        jLabel3.setText("Nombre");

        jTF_PType.setEditable(false);
        jTF_PType.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Informacion del Evento");

        JBSalir.setText("Atras");
        JBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3)
                            .addComponent(jLabel14)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTFCategoria, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTFNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTFFecha, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTFHora, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTFDir, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                            .addComponent(jTF_PType)
                            .addComponent(jTFLugar)
                            .addComponent(jTFCiudad)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(JBSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTFCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTFFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTFHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTFCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTF_PType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jTFDir, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(JBSalir)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFFechaActionPerformed

    private void JBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSalirActionPerformed
        dispose();
        Event.limpiarEvento();
        if(bougth)
            new BoughtTickets();
        else
            new EventSearch();
    }//GEN-LAST:event_JBSalirActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTA_Rest;
    private javax.swing.JTextField jTFCategoria;
    private javax.swing.JTextField jTFCiudad;
    private javax.swing.JTextField jTFDir;
    private javax.swing.JTextField jTFFecha;
    private javax.swing.JTextField jTFHora;
    private javax.swing.JTextField jTFLugar;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTextField jTF_PType;
    // End of variables declaration//GEN-END:variables
}
