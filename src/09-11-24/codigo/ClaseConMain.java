public class ClaseConMain {
 
  // un par de atributos...
  private int x;
  private int y; 

   // un método privado y estático con argumentos
   private static void metodo(int ax, boolean ab) {
		System.out.println("ax: " + ax + ", ab: " + ab);
   }
    
  /*
   * Programa principal
   * Es un método público y estático que no devuelve nada
   * y toma un array de cadenas como argumento.
   */   
  public static void main(String args[]) {
      System.out.println("En main.");
	  metodo(3, false);
	  metodo(4, true);	  
  }
}
