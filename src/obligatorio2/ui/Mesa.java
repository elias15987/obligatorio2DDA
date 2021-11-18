/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package obligatorio2.ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import obligatorio2.controladores.LoginController;
import obligatorio2.controladores.MesaController;
import obligatorio2.dominio.Sistema;
import obligatorio2.dominio.juego.MesaClase;
import obligatorio2.dominio.usuarios.Sesion;
import obligatorio2.dominio.usuarios.Usuario;
import obligatorio2.dominio.usuarios.UsuarioJuego;
import obligatorio2.utilidades.Observable;
import obligatorio2.utilidades.Observador;
import obligatorio2.utilidades.RotatedIcon;


public class Mesa extends javax.swing.JDialog{

    
    private MesaController mesaController;
  
    public Mesa(java.awt.Dialog parent, boolean modal, MesaController mesaControlador) {
        super(parent, modal);
        initComponents();
        //Sistema.getInstancia().agregar(this);
        this.mesaController = mesaControlador;
        this.getContentPane().setBackground( Color.black );
        marcarSillas();
        ocultarBotones();
    }

    
    public void ocultarBotones(){
        this.btnApostar.setVisible(false);
        this.btnPasar.setVisible(false);
        this.intApuesta.setVisible(false);
    }
    
    public void mostrarBotones(){
        this.btnApostar.setVisible(true);
        this.btnPasar.setVisible(true);
        this.intApuesta.setVisible(true);
    }
    
    public void limpiarIntApuesta(){
        this.intApuesta.setText("");
    }
    
    public boolean validarApuesta(String apuesta){
        try {
            int valor = Integer.parseInt(apuesta);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        carta1 = new javax.swing.JLabel();
        carta2 = new javax.swing.JLabel();
        carta3 = new javax.swing.JLabel();
        carta4 = new javax.swing.JLabel();
        carta5 = new javax.swing.JLabel();
        tituloMesa1 = new javax.swing.JLabel();
        tituloMesa2 = new javax.swing.JLabel();
        labelFaltantes = new javax.swing.JLabel();
        silla1 = new javax.swing.JLabel();
        textoSilla1 = new javax.swing.JLabel();
        silla2 = new javax.swing.JLabel();
        textoSilla2 = new javax.swing.JLabel();
        silla3 = new javax.swing.JLabel();
        textoSilla3 = new javax.swing.JLabel();
        silla4 = new javax.swing.JLabel();
        textoSilla4 = new javax.swing.JLabel();
        silla5 = new javax.swing.JLabel();
        textoSilla5 = new javax.swing.JLabel();
        silla6 = new javax.swing.JLabel();
        textoSilla6 = new javax.swing.JLabel();
        mesaFondo = new javax.swing.JLabel();
        pozo = new javax.swing.JLabel();
        valorPozo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaJugadoresMano = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        intApuesta = new javax.swing.JTextPane();
        btnApostar = new javax.swing.JButton();
        btnPasar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        saldoPersonal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(carta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 480, -1, -1));
        getContentPane().add(carta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 480, -1, -1));
        getContentPane().add(carta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 480, -1, -1));
        getContentPane().add(carta4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 480, -1, -1));
        getContentPane().add(carta5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 480, -1, -1));

        tituloMesa1.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        tituloMesa1.setForeground(new java.awt.Color(204, 204, 204));
        tituloMesa1.setText("Esperando inicio");
        getContentPane().add(tituloMesa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 190, 50));

        tituloMesa2.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        tituloMesa2.setForeground(new java.awt.Color(204, 204, 204));
        tituloMesa2.setText("del juego");
        getContentPane().add(tituloMesa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, -1, -1));

        labelFaltantes.setForeground(new java.awt.Color(204, 204, 204));
        labelFaltantes.setText("Faltan 0 jugadores para iniciar.");
        getContentPane().add(labelFaltantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, -1, -1));
        getContentPane().add(silla1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 10, 30));

        textoSilla1.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(textoSilla1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, 200, 30));
        getContentPane().add(silla2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 30, 30));

        textoSilla2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(textoSilla2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 430, 160, 30));
        getContentPane().add(silla3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 230, 20, 30));

        textoSilla3.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(textoSilla3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 300, 170, 30));
        getContentPane().add(silla4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 50, 40));

        textoSilla4.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(textoSilla4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 140, 20));
        getContentPane().add(silla5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 40, 40));

        textoSilla5.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(textoSilla5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 130, 20));
        getContentPane().add(silla6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 40, 20));

        textoSilla6.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(textoSilla6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 170, 30));

        mesaFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mesa_sin_jugador.jpg"))); // NOI18N
        getContentPane().add(mesaFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 67, -1, -1));

        pozo.setForeground(new java.awt.Color(255, 255, 255));
        pozo.setText("Pozo:");
        getContentPane().add(pozo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        valorPozo.setForeground(new java.awt.Color(255, 255, 255));
        valorPozo.setText("0");
        getContentPane().add(valorPozo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        tablaJugadoresMano.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaJugadoresMano.setFocusTraversalKeysEnabled(false);
        tablaJugadoresMano.setFocusable(false);
        jScrollPane1.setViewportView(tablaJugadoresMano);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, 180, 200));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Jugadores Activos en la mano");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, -1, -1));

        jScrollPane2.setViewportView(intApuesta);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 320, 80, -1));

        btnApostar.setText("Apostar");
        btnApostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApostarActionPerformed(evt);
            }
        });
        getContentPane().add(btnApostar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 320, 80, -1));

        btnPasar.setText("Pasar");
        btnPasar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPasar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 360, 80, -1));

        jLabel2.setText("Mi saldo:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 380, -1, -1));

        btnSalir.setText("Salir");
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 400, 80, -1));

        saldoPersonal.setText("0");
        getContentPane().add(saldoPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 380, 60, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        mesaController.salirDeMesa();
    }//GEN-LAST:event_formWindowClosed

    private void btnApostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApostarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnApostarActionPerformed

    private void btnPasarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasarActionPerformed
        mesaController.pasarTurno();
    }//GEN-LAST:event_btnPasarActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Mesa dialog = new Mesa(new javax.swing.JDialog(), true, new MesaController(new PanelJugador(), new UsuarioJuego()));
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApostar;
    private javax.swing.JButton btnPasar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel carta1;
    private javax.swing.JLabel carta2;
    private javax.swing.JLabel carta3;
    private javax.swing.JLabel carta4;
    private javax.swing.JLabel carta5;
    private javax.swing.JTextPane intApuesta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelFaltantes;
    private javax.swing.JLabel mesaFondo;
    private javax.swing.JLabel pozo;
    private javax.swing.JLabel saldoPersonal;
    private javax.swing.JLabel silla1;
    private javax.swing.JLabel silla2;
    private javax.swing.JLabel silla3;
    private javax.swing.JLabel silla4;
    private javax.swing.JLabel silla5;
    private javax.swing.JLabel silla6;
    private javax.swing.JTable tablaJugadoresMano;
    private javax.swing.JLabel textoSilla1;
    private javax.swing.JLabel textoSilla2;
    private javax.swing.JLabel textoSilla3;
    private javax.swing.JLabel textoSilla4;
    private javax.swing.JLabel textoSilla5;
    private javax.swing.JLabel textoSilla6;
    private javax.swing.JLabel tituloMesa1;
    private javax.swing.JLabel tituloMesa2;
    private javax.swing.JLabel valorPozo;
    // End of variables declaration//GEN-END:variables
  
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    
    
    
    public void mostrarTitulo(String titulo){
        this.setTitle(titulo);
    }

    
    public void actualizarFaltantes(){
  
        ArrayList<Usuario> usuariosMesa = this.mesaController.getMesa().getUsuarios();

        int faltantes = mesaController.getMesa().getTopeUsuarios() - usuariosMesa.size();
        
        if(faltantes > 0){
            this.labelFaltantes.setText("Faltan " + faltantes + " jugadores para iniciar.");
        }
        else{
            this.labelFaltantes.setVisible(false);
            this.tituloMesa1.setVisible(false);
            this.tituloMesa2.setVisible(false);
        }
    }
    
    public void actualizarPozo(int pozo){
        this.valorPozo.setText(pozo + "");
    }
    
    private DefaultTableModel modelo;
    
    public void actualizarTablaMano(ArrayList<Usuario> usuarios){
        this.modelo = new DefaultTableModel();
        ArrayList<Object> list = new ArrayList<Object>();
        list.add("Nombre");
        
        
        for(Object col : list){
            this.modelo.addColumn(col);
        }
        this.tablaJugadoresMano.setModel(modelo);
        
        
        ArrayList<Object[]> datos = new ArrayList<Object[]>();
        
        for(Usuario u : usuarios){
            datos.add(new Object[]{u.getNombreCompleto()});
        }
        
        for(Object[] DatoPersonal : datos){
            modelo.addRow(DatoPersonal);
        }
        tablaJugadoresMano.setModel(modelo);
        
        tablaJugadoresMano.setFocusable(false);
        tablaJugadoresMano.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent me) {
        }
      });
    }
    
    public void mostrarCartas(ArrayList<String> cartas){
        this.carta1.setVisible(true);
        this.carta1.setIcon(new RotatedIcon(new ImageIcon(getClass().getResource("../../img/cartas/" + cartas.get(0))), 0));
        this.carta2.setVisible(true);
        this.carta2.setIcon(new RotatedIcon(new ImageIcon(getClass().getResource("../../img/cartas/" + cartas.get(1))), 0));        
        this.carta3.setVisible(true);
        this.carta3.setIcon(new RotatedIcon(new ImageIcon(getClass().getResource("../../img/cartas/" + cartas.get(2))), 0));        
        this.carta4.setVisible(true);
        this.carta4.setIcon(new RotatedIcon(new ImageIcon(getClass().getResource("../../img/cartas/" + cartas.get(3))), 0));        
        this.carta5.setVisible(true);
        this.carta5.setIcon(new RotatedIcon(new ImageIcon(getClass().getResource("../../img/cartas/" + cartas.get(4))), 0));
    }
    
    public void marcarSillas()
    {
        this.setSize(1000, 700);
        setLocationRelativeTo(null);
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("../../img/silla.png"));
        this.silla1.setIcon(new RotatedIcon(imageIcon, 205));
        this.silla1.setVisible(false);
        this.silla2.setIcon(new RotatedIcon(imageIcon, 150));     
        this.silla2.setVisible(false);
        this.silla3.setIcon(new RotatedIcon(imageIcon, 90));
        this.silla3.setVisible(false);
        this.silla4.setIcon(new RotatedIcon(imageIcon, 270));
        this.silla4.setVisible(false);
        this.silla5.setIcon(new RotatedIcon(imageIcon, 330));
        this.silla5.setVisible(false);
        this.silla6.setIcon(new RotatedIcon(imageIcon, 45));
        this.silla6.setVisible(false);
        
        this.textoSilla1.setText("");        
        this.textoSilla2.setText("");
        this.textoSilla3.setText("");
        this.textoSilla4.setText("");
        this.textoSilla5.setText("");
        this.textoSilla6.setText("");

        
        ArrayList<Usuario> usuariosMesa = this.mesaController.getMesa().getUsuarios();
        
        
        this.silla1.setVisible(true);
        textoSilla1.setText(mesaController.getSesion().getUsuario().getNombreCompleto());
        
        for(int i = 0; i < usuariosMesa.size(); i++){
            Usuario u = usuariosMesa.get(i);
           switch (i){
                    
                case 1:
                    this.silla6.setVisible(true);
                    this.textoSilla6.setText(u.getNombreCompleto());
                    break;
                
                case 2:
                    this.silla4.setVisible(true);
                    this.textoSilla4.setText(u.getNombreCompleto());
                    break;
                        
                case 3:
                    this.silla3.setVisible(true);
                    this.textoSilla3.setText(u.getNombreCompleto());
                    break;
                    
                case 4:
                    this.silla5.setVisible(true);
                    this.textoSilla5.setText(u.getNombreCompleto());
                    break;
                    
                case 5:
                    this.silla2.setVisible(true);
                    this.textoSilla2.setText(u.getNombreCompleto());
                    break;
                        
                default:
                    this.silla1.setVisible(true);
                    this.textoSilla1.setText(u.getNombreCompleto());
            }
        }

    }
}