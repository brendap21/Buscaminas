package front;

import back.Botones;
import back.DatosJuego;
import java.util.Random;
import javax.swing.JOptionPane;

public class PantallaJuego extends javax.swing.JFrame {

    PantallaPrincipal objPantallaPrin = null;
    DatosJuego objDatosJuego = new DatosJuego();
    public static boolean gano;
    public static Botones[][] botones;

    public int alto = objDatosJuego.getAlto();
    public int ancho = objDatosJuego.getAncho();
    public int bombas = objDatosJuego.getMinas();
    public int noMinas[][] = randomizarMinas(bombas);

    public PantallaJuego() {
        initComponents();
        this.setLocationRelativeTo(null);
        
    }

    public PantallaJuego(PantallaPrincipal objPantallaPrin, DatosJuego objDatosJuego) {
        this.objPantallaPrin = objPantallaPrin;
        this.objDatosJuego = objDatosJuego;
        initComponents();
        startGame();
        this.setLocationRelativeTo(null);
        imprimirDatosJuego();
    }

    public void startGame() {
        
        this.botones = new Botones[alto][ancho];
        int nMinas[][] = randomizarMinas(bombas + 1);

        pnlBotones.setLayout(new java.awt.GridLayout(alto, ancho));
        
        //aqui imprimo mis botones en mi jpanel con valor 2 general para todos para mi maquina de estados
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                this.botones[i][j] = new Botones(i, j);
                // Inicializar todas las celdas con valor 2
                this.botones[i][j].setTipoBoton(2);
                pnlBotones.add(this.botones[i][j]);
            }
        }

        //aqui estoy agregando mis minas a mi tablero
        for (int i = 0; i < bombas; i++) {
            this.botones[nMinas[0][i]][nMinas[1][i]].setTipoBoton(0);
        }

        // Asignar valores 1 o 2 a las celdas vecinas a las minas
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                if (this.botones[i][j].getTipoBoton() == 0) {
                    // La celda actual tiene una mina y buscar las celdas vecinas
                    for (int x = i - 1; x <= i + 1; x++) {
                        for (int y = j - 1; y <= j + 1; y++) {
                            if (x >= 0 && x < alto && y >= 0 && y < ancho) {
                                // La celda vecina esta dentro del tablero
                                if (this.botones[x][y].getTipoBoton() != 0) {
                                    // La celda vecina no es una mina
                                    this.botones[x][y].setTipoBoton(1);
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    public int[][] randomizarMinas(int cantidad) {
        Random rd = new Random();

        int b[][] = new int[2][cantidad]; //b es una matriz doble
        int cont = 0;
        boolean v;

        while (cont < cantidad) {
            int numero1 = (int) (rd.nextDouble() * alto);
            int numero2 = (int) (rd.nextDouble() * ancho);
            v = false;

            for (int i = 0; i < cont; i++) {
                if (numero1 == b[0][i] && numero2 == b[1][i]) {
                    v = true;
                }
            }
            if (!v) {
                b[0][cont] = numero1;
                b[1][cont] = numero2;
                cont++;
            }
        }
        return b;
    }

    public void limpiarCulos(){
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                pnlBotones.remove(this.botones[i][j]);
            }
        }
        
        pnlBotones.updateUI();
    }
    
    private void imprimirDatosJuego() {
        lblNoX.setText(String.valueOf(ancho));
        lblNoY.setText(String.valueOf(alto));
        lblNoBombas.setText(String.valueOf(bombas));
    }
    
    public static void perdio(boolean cagado){
        if(cagado){
            JOptionPane.showMessageDialog(null, "Lo siento, haz perdido :D");
        }
    }
    
    public static void gano(boolean meado){
        if(meado){
            JOptionPane.showMessageDialog(null, "You won, bitch.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlBotones = new javax.swing.JPanel();
        pnlBarrraSuperior = new javax.swing.JPanel();
        lblLogo1 = new javax.swing.JLabel();
        btnReiniciar = new javax.swing.JButton();
        lblLogo2 = new javax.swing.JLabel();
        pnlDatosJuego = new javax.swing.JPanel();
        pnlAltoAncho = new javax.swing.JPanel();
        lblX = new javax.swing.JLabel();
        lblNoX = new javax.swing.JLabel();
        lblY = new javax.swing.JLabel();
        lblNoY = new javax.swing.JLabel();
        PnlBombas = new javax.swing.JPanel();
        lblBombas = new javax.swing.JLabel();
        lblNoBombas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Pantalla Juego");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnlBotones.setBackground(new java.awt.Color(204, 204, 204));
        pnlBotones.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlBotones.setLayout(new java.awt.GridLayout(10, 10));

        pnlBarrraSuperior.setBackground(new java.awt.Color(204, 204, 204));
        pnlBarrraSuperior.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlBarrraSuperior.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 100, 5));

        lblLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CaraDerretida_bandera.png"))); // NOI18N
        pnlBarrraSuperior.add(lblLogo1);

        btnReiniciar.setBackground(new java.awt.Color(204, 204, 204));
        btnReiniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CaraDerretida_felizPequeño.png"))); // NOI18N
        btnReiniciar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });
        pnlBarrraSuperior.add(btnReiniciar);

        lblLogo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CaraDerretida_bandera.png"))); // NOI18N
        pnlBarrraSuperior.add(lblLogo2);

        pnlDatosJuego.setBackground(new java.awt.Color(204, 204, 204));
        pnlDatosJuego.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlDatosJuego.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 70, 5));

        pnlAltoAncho.setBackground(new java.awt.Color(204, 204, 204));

        lblX.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        lblX.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblX.setText("X:");
        lblX.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lblNoX.setFont(new java.awt.Font("Cascadia Code", 1, 21)); // NOI18N
        lblNoX.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNoX.setText("0");
        lblNoX.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblY.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        lblY.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblY.setText("y:");
        lblY.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lblNoY.setFont(new java.awt.Font("Cascadia Code", 1, 21)); // NOI18N
        lblNoY.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNoY.setText("0");
        lblNoY.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlAltoAnchoLayout = new javax.swing.GroupLayout(pnlAltoAncho);
        pnlAltoAncho.setLayout(pnlAltoAnchoLayout);
        pnlAltoAnchoLayout.setHorizontalGroup(
            pnlAltoAnchoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAltoAnchoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAltoAnchoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblX, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblY))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlAltoAnchoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblNoY, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(lblNoX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        pnlAltoAnchoLayout.setVerticalGroup(
            pnlAltoAnchoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAltoAnchoLayout.createSequentialGroup()
                .addGroup(pnlAltoAnchoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNoX, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblX, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnlAltoAnchoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNoY, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblY, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDatosJuego.add(pnlAltoAncho);

        PnlBombas.setBackground(new java.awt.Color(204, 204, 204));
        PnlBombas.setPreferredSize(new java.awt.Dimension(163, 56));
        PnlBombas.setLayout(new java.awt.BorderLayout());

        lblBombas.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        lblBombas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblBombas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CaraDerretida_bombaPequeño.png"))); // NOI18N
        lblBombas.setText(":");
        lblBombas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lblBombasMouseDragged(evt);
            }
        });
        PnlBombas.add(lblBombas, java.awt.BorderLayout.LINE_START);

        lblNoBombas.setFont(new java.awt.Font("Cascadia Code", 1, 21)); // NOI18N
        lblNoBombas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNoBombas.setText("0");
        lblNoBombas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PnlBombas.add(lblNoBombas, java.awt.BorderLayout.CENTER);

        pnlDatosJuego.add(PnlBombas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBarrraSuperior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDatosJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBarrraSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDatosJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        objPantallaPrin.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    private void lblBombasMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBombasMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_lblBombasMouseDragged

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        this.setBackground(new java.awt.Color(0, 0, 0));
        limpiarCulos();
        imprimirDatosJuego();
        startGame();    
        gano = false;
        btnReiniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CaraDerretida_felizPequeño.png")));
    }//GEN-LAST:event_btnReiniciarActionPerformed

    
    
    
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
            java.util.logging.Logger.getLogger(PantallaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnlBombas;
    public static javax.swing.JButton btnReiniciar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBombas;
    private javax.swing.JLabel lblLogo1;
    private javax.swing.JLabel lblLogo2;
    private javax.swing.JLabel lblNoBombas;
    private javax.swing.JLabel lblNoX;
    private javax.swing.JLabel lblNoY;
    private javax.swing.JLabel lblX;
    private javax.swing.JLabel lblY;
    private javax.swing.JPanel pnlAltoAncho;
    private javax.swing.JPanel pnlBarrraSuperior;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlDatosJuego;
    // End of variables declaration//GEN-END:variables
}
