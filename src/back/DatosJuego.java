
package back;

public class DatosJuego {
    
    public static int alto;
    public static int ancho;
    public static int minas;

    public static int getAlto() {
        return alto;
    }

    public static void setAlto(int alto) {
        DatosJuego.alto = alto;
    }

    public static int getAncho() {
        return ancho;
    }

    public static void setAncho(int ancho) {
        DatosJuego.ancho = ancho;
    }

    public static int getMinas() {
        return minas;
    }

    public static void setMinas(int minas) {
        DatosJuego.minas = minas;
    }


    
    public int multiplicacionXY(){
        int resultado = alto * ancho;
        return resultado;
    }
    
    
}
