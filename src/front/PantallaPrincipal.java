package front;

import back.DatosJuego;
import javax.swing.JOptionPane;

public class PantallaPrincipal extends javax.swing.JFrame {

    PantallaJuego objPantallaJuego = null;
    DatosJuego objDatosJuego = null;

    public PantallaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        objDatosJuego = new DatosJuego();
    }

    private void modoJuego() {
        if (rbDificultad.isSelected()) {
            getValoresDificultad();

        }
        if (RbPersonalizado.isSelected()) {
            getValoresPersonalizado();
        }
    }

    private void getValoresPersonalizado() {
        objDatosJuego.setAlto((int) SpinnerAlto.getValue());
        objDatosJuego.setAncho((int) SpinnerAncho.getValue());
        objDatosJuego.setMinas((int) SpinnerMinas.getValue());
    }

    private void getValoresDificultad() {

        if (CmbDificultad.getSelectedItem() == "Fácil") {
            objDatosJuego.setAlto(10);
            objDatosJuego.setAncho(10);
            objDatosJuego.setMinas(15);
        }
        if (CmbDificultad.getSelectedItem() == "Medio") {
            objDatosJuego.setAlto(15);
            objDatosJuego.setAncho(15);
            objDatosJuego.setMinas(50);
        }
        if (CmbDificultad.getSelectedItem() == "Difícil") {
            objDatosJuego.setAlto(20);
            objDatosJuego.setAncho(40);
            objDatosJuego.setMinas(500);
        }
    }

    private void habilitarPersonalizado() {
        lblAlto.setEnabled(true);
        lblAncho.setEnabled(true);
        lblBombas.setEnabled(true);
        lblBombaLogo.setEnabled(true);
        SpinnerAlto.setEnabled(true);
        SpinnerAncho.setEnabled(true);
        SpinnerMinas.setEnabled(true);
    }

    private void habilitarPredeterminado() {
        CmbDificultad.setEnabled(true);
    }

    private void deshabilitarPredeterminado() {
        CmbDificultad.setEnabled(false);
    }

    private void deshabilitarPersonalizado() {
        lblAlto.setEnabled(false);
        lblAncho.setEnabled(false);
        lblBombas.setEnabled(false);
        lblBombaLogo.setEnabled(false);
        SpinnerAlto.setEnabled(false);
        SpinnerAncho.setEnabled(false);
        SpinnerMinas.setEnabled(false);
    }

    private boolean validarDatos() {

        boolean datosValidos = true;

        if (rbDificultad.isSelected() && CmbDificultad.getSelectedItem() == "Seleccione un valor...") {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una dificultad", "Error", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        }

        /*if (RbPersonalizado.isSelected()) {
            
            int alto = objDatosJuego.getAlto();
            int ancho = objDatosJuego.getAncho();
            int bombas = objDatosJuego.getMinas();
            int maxMinas = objDatosJuego.multiplicacionXY() - 1;
        
            if (alto < 2 || alto > 20) {
                JOptionPane.showMessageDialog(this, "El valor del alto debe ser mayor o igual a 2 y menor o igual a 20", "Error", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
            }

            if (ancho < 2 || ancho > 40) {
                JOptionPane.showMessageDialog(this, "El valor del ancho debe ser mayor o igual a 2 y menor o igual a 40", "Error", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
            }

            if (bombas < 1) {
                JOptionPane.showMessageDialog(this, "El valor de las minas debe ser mayor o igual a 1", "Error", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
            }

            if (bombas > maxMinas) {
                JOptionPane.showMessageDialog(this, "El valor de las minas debe ser menor o igual a " + maxMinas, "Error", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
            }
        }*/
        return datosValidos;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgModoJuego = new javax.swing.ButtonGroup();
        pnlFondoUno = new javax.swing.JPanel();
        pnlFondo = new javax.swing.JPanel();
        pnlDificultad = new javax.swing.JPanel();
        CmbDificultad = new javax.swing.JComboBox<>();
        rbDificultad = new javax.swing.JRadioButton();
        PnlPersonalizado = new javax.swing.JPanel();
        lblAlto = new javax.swing.JLabel();
        lblAncho = new javax.swing.JLabel();
        RbPersonalizado = new javax.swing.JRadioButton();
        lblBombas = new javax.swing.JLabel();
        lblBombaLogo = new javax.swing.JLabel();
        SpinnerAlto = new javax.swing.JSpinner();
        SpinnerAncho = new javax.swing.JSpinner();
        SpinnerMinas = new javax.swing.JSpinner();
        lblBandera2 = new javax.swing.JLabel();
        pnlTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblBandera1 = new javax.swing.JLabel();
        lblBandera3 = new javax.swing.JLabel();
        btnJugar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Buscaminas");
        setResizable(false);

        pnlFondoUno.setBackground(new java.awt.Color(102, 102, 102));
        pnlFondoUno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlFondoUno.setForeground(new java.awt.Color(102, 102, 102));

        pnlFondo.setBackground(new java.awt.Color(204, 204, 204));
        pnlFondo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        pnlDificultad.setBackground(new java.awt.Color(204, 204, 204));

        CmbDificultad.setFont(new java.awt.Font("Cascadia Code", 0, 15)); // NOI18N
        CmbDificultad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un valor...", "Fácil", "Medio", "Difícil" }));
        CmbDificultad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        bgModoJuego.add(rbDificultad);
        rbDificultad.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        rbDificultad.setSelected(true);
        rbDificultad.setText("¡Selecciona un nivel de dificultad!");
        rbDificultad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDificultadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDificultadLayout = new javax.swing.GroupLayout(pnlDificultad);
        pnlDificultad.setLayout(pnlDificultadLayout);
        pnlDificultadLayout.setHorizontalGroup(
            pnlDificultadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDificultadLayout.createSequentialGroup()
                .addContainerGap(135, Short.MAX_VALUE)
                .addComponent(CmbDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
            .addGroup(pnlDificultadLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(rbDificultad)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDificultadLayout.setVerticalGroup(
            pnlDificultadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDificultadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbDificultad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CmbDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        PnlPersonalizado.setBackground(new java.awt.Color(204, 204, 204));
        PnlPersonalizado.setEnabled(false);

        lblAlto.setFont(new java.awt.Font("Cascadia Code", 0, 15)); // NOI18N
        lblAlto.setText("Alto");
        lblAlto.setEnabled(false);

        lblAncho.setFont(new java.awt.Font("Cascadia Code", 0, 15)); // NOI18N
        lblAncho.setText("Ancho");
        lblAncho.setEnabled(false);

        bgModoJuego.add(RbPersonalizado);
        RbPersonalizado.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        RbPersonalizado.setText("Personalizado");
        RbPersonalizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbPersonalizadoActionPerformed(evt);
            }
        });

        lblBombas.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        lblBombas.setText("¿Cuántas minas?");
        lblBombas.setEnabled(false);

        lblBombaLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBombaLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CaraDerretida_bombaPequeño.png"))); // NOI18N
        lblBombaLogo.setEnabled(false);

        SpinnerAlto.setFont(new java.awt.Font("Cascadia Code", 0, 15)); // NOI18N
        SpinnerAlto.setModel(new javax.swing.SpinnerNumberModel(10, 10, 20, 1));
        SpinnerAlto.setEnabled(false);

        SpinnerAncho.setFont(new java.awt.Font("Cascadia Code", 0, 15)); // NOI18N
        SpinnerAncho.setModel(new javax.swing.SpinnerNumberModel(10, 10, 40, 1));
        SpinnerAncho.setEnabled(false);

        SpinnerMinas.setFont(new java.awt.Font("Cascadia Code", 0, 15)); // NOI18N
        SpinnerMinas.setModel(new javax.swing.SpinnerNumberModel(1, 1, 800, 5));
        SpinnerMinas.setEnabled(false);

        javax.swing.GroupLayout PnlPersonalizadoLayout = new javax.swing.GroupLayout(PnlPersonalizado);
        PnlPersonalizado.setLayout(PnlPersonalizadoLayout);
        PnlPersonalizadoLayout.setHorizontalGroup(
            PnlPersonalizadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlPersonalizadoLayout.createSequentialGroup()
                .addComponent(lblBombas)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(PnlPersonalizadoLayout.createSequentialGroup()
                .addGroup(PnlPersonalizadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlPersonalizadoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PnlPersonalizadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblAlto)
                            .addComponent(lblAncho))
                        .addGap(18, 18, 18)
                        .addGroup(PnlPersonalizadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SpinnerAlto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SpinnerAncho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlPersonalizadoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(RbPersonalizado)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlPersonalizadoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblBombaLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SpinnerMinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        PnlPersonalizadoLayout.setVerticalGroup(
            PnlPersonalizadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlPersonalizadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RbPersonalizado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnlPersonalizadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAlto)
                    .addComponent(SpinnerAlto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PnlPersonalizadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAncho)
                    .addComponent(SpinnerAncho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBombas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnlPersonalizadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBombaLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SpinnerMinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        lblBandera2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CaraDerretida_bandera.png"))); // NOI18N

        pnlTitulo.setBackground(new java.awt.Color(204, 204, 204));

        lblTitulo.setBackground(new java.awt.Color(0, 0, 0));
        lblTitulo.setFont(new java.awt.Font("Cascadia Code", 1, 54)); // NOI18N
        lblTitulo.setText("BUSCAMINAS");
        lblTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));

        lblLogo.setBackground(new java.awt.Color(204, 204, 204));
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CaraDerretida_bomba.png"))); // NOI18N

        lblBandera1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBandera1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CaraDerretida_bandera.png"))); // NOI18N

        javax.swing.GroupLayout pnlTituloLayout = new javax.swing.GroupLayout(pnlTitulo);
        pnlTitulo.setLayout(pnlTituloLayout);
        pnlTituloLayout.setHorizontalGroup(
            pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTituloLayout.createSequentialGroup()
                .addGroup(pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTituloLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(pnlTituloLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblBandera1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(lblLogo))
        );
        pnlTituloLayout.setVerticalGroup(
            pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLogo)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTituloLayout.createSequentialGroup()
                .addComponent(lblBandera1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo))
        );

        lblBandera3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CaraDerretida_bandera.png"))); // NOI18N

        btnJugar.setFont(new java.awt.Font("Cascadia Code", 1, 30)); // NOI18N
        btnJugar.setText("¡JUGAR!");
        btnJugar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnJugar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                        .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                        .addComponent(PnlPersonalizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(214, 214, 214))))
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addComponent(lblBandera3)
                        .addGap(92, 92, 92)
                        .addComponent(btnJugar)))
                .addGap(0, 40, Short.MAX_VALUE))
            .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                    .addContainerGap(489, Short.MAX_VALUE)
                    .addComponent(lblBandera2)
                    .addGap(44, 44, 44)))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(pnlDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PnlPersonalizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnJugar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(lblBandera3)
                        .addGap(15, 15, 15))))
            .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                    .addContainerGap(477, Short.MAX_VALUE)
                    .addComponent(lblBandera2)
                    .addGap(13, 13, 13)))
        );

        javax.swing.GroupLayout pnlFondoUnoLayout = new javax.swing.GroupLayout(pnlFondoUno);
        pnlFondoUno.setLayout(pnlFondoUnoLayout);
        pnlFondoUnoLayout.setHorizontalGroup(
            pnlFondoUnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoUnoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(pnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        pnlFondoUnoLayout.setVerticalGroup(
            pnlFondoUnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoUnoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(pnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondoUno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondoUno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RbPersonalizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbPersonalizadoActionPerformed
        habilitarPersonalizado();
        deshabilitarPredeterminado();
    }//GEN-LAST:event_RbPersonalizadoActionPerformed

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed

        if (validarDatos()) {
            modoJuego();
            objPantallaJuego = new PantallaJuego(this, objDatosJuego);
            objPantallaJuego.setVisible(true);
            this.setVisible(false);
        }

    }//GEN-LAST:event_btnJugarActionPerformed

    private void rbDificultadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDificultadActionPerformed
        deshabilitarPersonalizado();
        habilitarPredeterminado();
    }//GEN-LAST:event_rbDificultadActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CmbDificultad;
    private javax.swing.JPanel PnlPersonalizado;
    private javax.swing.JRadioButton RbPersonalizado;
    private javax.swing.JSpinner SpinnerAlto;
    private javax.swing.JSpinner SpinnerAncho;
    private javax.swing.JSpinner SpinnerMinas;
    private javax.swing.ButtonGroup bgModoJuego;
    private javax.swing.JButton btnJugar;
    private javax.swing.JLabel lblAlto;
    private javax.swing.JLabel lblAncho;
    private javax.swing.JLabel lblBandera1;
    private javax.swing.JLabel lblBandera2;
    private javax.swing.JLabel lblBandera3;
    private javax.swing.JLabel lblBombaLogo;
    private javax.swing.JLabel lblBombas;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlDificultad;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlFondoUno;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JRadioButton rbDificultad;
    // End of variables declaration//GEN-END:variables
}
