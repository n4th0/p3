package es.ua.dlsi.prog3.p3.highlevel;

import es.ua.dlsi.prog3.p3.lowlevel.OutputDevice;

/**
 * Class Display.
 * inherits from {@link OutputDevice} and represents a display 
 * where we can put boolean values to show pictures of the 
 *
 * @author Nathan Rodriguez Moyses 48727425Q
 */
public class Display extends OutputDevice{

    /**
     * Atributo de instancia: pixel_rows.
     * representa la cantidad de filas/columnas que tiene el display.
     * se deberá instanciar en el constructor. 
     */
    private int pixel_rows;

    /**
     * Atributo de instancia: display.
     *
     * array bidimensional de bytes.
     * Las cuatro esquinas de una pantalla de tamaño NxN corresponden por 
     * tanto a estas coordenadas: - esquina superior izquierda: (0,0) - esquina 
     * superior derecha: (N-1,0) - esquina inferior izquierda: (0,N-1) - 
     * esquina inferior derecha: (N-1,N-1)
     */
    private byte[][] display;

    /**
     * Metodo de instancia: constructor.
     * hace llamada al constructor de {@link OutputDevice} almacena en el 
     * buffer el doble de la cantidad pasada por argumentos al cuadrado. el display 
     * se inicializa siendo de n filas y n columnas.
     *
     * @param n int  parametro que se inicializará el atributo pixel_rows
     */
	public Display(int n){
        super(n*n*2);
        pixel_rows = n;
        display = new byte[n][n];
	}

	/**
     * Metodo de instancia: getDisplaySize.
     * Metodo que devolverá la dimension en la que opera el display. 
     * @return pixel_rows int.
     */
	public int getDisplaySize() {
        return pixel_rows;
	}


    /**
     * Metodo de instancia: refresh.
     * metodo que refresca y devuelve (haciendo copia defensiva) el array de bytes
     * cambiando el contenido usando el canal al que está asociadio.
     * @throws IllegalStateException en caso de que el dispositivo no tenga canal por el 
     * que comunicarse.
     * @throws IndexOutOfBoundsException en caso de que la coordenada leida del canal
     * se pase de los limites de la matiz del display. 
     * @return d byte[][] using defensive copy with 
     */
	public byte[][] refresh() {
        byte [] coord = new byte[2];

        while (this.getChannel().hasData()) {
            coord[0] = this.receiveFromChannel();
            coord[1] = this.receiveFromChannel();

            display[coord[1]][coord[0]] = 1;
        }

        // defensive copy
        byte[][] d = new byte[pixel_rows][pixel_rows];
        for (int i = 0; i < pixel_rows; i++) 
            for (int j = 0; j < pixel_rows; j++) 
                d[i][j] = display[i][j];

        return d;
	}

    /**
     * Metodo de instancia: clear.
     * pone el display completo a 0 haciendo que todo se vuelva negro en el display.
     */
	public void clear() {
        for (int i = 0; i < pixel_rows; i++) {
            for (int j = 0; j < pixel_rows; j++) {
                display[j][i]= 0;
            }
        }
	}
}
