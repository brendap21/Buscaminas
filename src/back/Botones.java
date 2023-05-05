package back;

import front.PantallaJuego;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class Botones extends JButton {

    private int x;
    private int y;
    private Color color[];
    private int tipoBoton;
    private boolean Visible;
    private boolean bandera = false;

    public boolean getVisible() {
        return Visible;
    }

    public void setVisible(boolean Visible) {
        this.Visible = Visible;
    }

    public Botones(int x, int y) {
        this.x = x;
        this.y = y;
        this.Visible = false;
        this.bandera = false;
        this.tipoBoton = tipoBoton;
        this.color = new Color[]{Color.MAGENTA, Color.BLUE, new Color(0, 89, 19), Color.RED, new Color(0, 9, 135), Color.PINK, Color.YELLOW, Color.GRAY};
        this.setBackground(new java.awt.Color(0, 0, 0));
        this.setMinimumSize(new Dimension(40, 40));
        this.setFont(new java.awt.Font("sans-serif ", Font.BOLD, 14));
        this.setPreferredSize(new Dimension(40, 40));
        this.setMargin(new Insets(0, 0, 0, 0));
        this.setBorder(new LineBorder(new Color(163, 163, 163), 1));

        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent ev) {
                BotonMouseClicked(ev);

            }
        });

        this.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonActionPerformed(evt);
            }
        });
    }

    public void cambiarTipoBoton(int tipoBoton) {
        this.tipoBoton = tipoBoton;
    }

    public void setTipoBoton(int tipoBoton) {
        this.tipoBoton = tipoBoton;
    }

    public int getTipoBoton() {
        return tipoBoton;
    }

    private void BotonMouseClicked(java.awt.event.MouseEvent ev) {

        if (ev.getButton() == MouseEvent.BUTTON3) {
            // toggle bandera
            this.bandera = !this.bandera;
            System.out.println(this.bandera);
            if (PantallaJuego.gano == false) {
                if (this.bandera && this.Visible != true) {
                    this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CaraDerretida_banderaPequeña.png")));
                } else {
                    this.setIcon(null);
                }
            }

        }
    }

    private void BotonActionPerformed(java.awt.event.ActionEvent evt) {
        maquinaDeEstados();

        if (ganar()) {
            PantallaJuego.btnReiniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CaraDerretida_Win.png")));
            PantallaJuego.gano = true;
            PantallaJuego.gano(true);
        }

    }

    public boolean ganar() {
        for (int i = 0; i < DatosJuego.alto; i++) {
            for (int j = 0; j < DatosJuego.ancho; j++) {
                if (PantallaJuego.botones[i][j].getTipoBoton() != 0 && !PantallaJuego.botones[i][j].getVisible()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void maquinaDeEstados() {
        while (!Visible && PantallaJuego.gano == false && bandera == false) {
            this.Visible = true;
            this.setOpaque(false);
            this.setContentAreaFilled(false);
            switch (tipoBoton) {
                //en caso que el boton tenga valor 0 es bomba
                case 0:
                    for (int i = 0; i < DatosJuego.alto; i++) {
                        for (int j = 0; j < DatosJuego.ancho; j++) {
                            if (PantallaJuego.botones[i][j].tipoBoton == 0) {
                                PantallaJuego.botones[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CaraDerretida_bombaPequeño.png")));
                                PantallaJuego.botones[i][j].setBackground(Color.red);
                            }
                        }

                    }
                    
                    PantallaJuego.btnReiniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CaraDerretida_DerretidoPequeño.png")));
                    PantallaJuego.perdio(true);
                    PantallaJuego.gano = true;
                    break;
                case 1:
                    int cont = 0;
                    this.setBackground(new java.awt.Color(240, 240, 240));
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            int fila = x + i;
                            int columna = y + j;
                            if (fila >= 0 && fila < DatosJuego.alto && columna >= 0 && columna < DatosJuego.ancho
                                    && !(i == 0 && j == 0) && PantallaJuego.botones[fila][columna].getTipoBoton() == 0) {
                                cont++;
                            }
                        }
                    }
                    this.setText(" " + cont);
                    this.setForeground(this.color[cont]);
                    this.setOpaque(false);
                    this.setContentAreaFilled(false);

                    break;
                case 2:
                    for (int i = -2; i <= 1; i++) {
                        if (x + i >= 0 && x + i < DatosJuego.alto) {
                            for (int j = -2; j <= 1; j++) {
                                if (y + j >= 0 && y + j < DatosJuego.ancho && PantallaJuego.botones[x + i][y + j].getTipoBoton() != 0) {
                                    if (!PantallaJuego.botones[x + i][y + j].getVisible()) {
                                    }
                                    PantallaJuego.botones[x + i][y + j].maquinaDeEstados();
                                }

                            }
                        }
                    }
                    break;

            }
        }
    }

}
