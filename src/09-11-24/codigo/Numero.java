public class Numero {
  
  private int valor;
  
  public Numero(int valor) { this.valor = valor; }
  public void suma(Numero n) { this.valor += n.valor; }
  public int get() { return valor; }
  
  public boolean equals(Object obj) {
	  if (obj == this) return true; // las dos referencias  
		  // apuntan al mismo objeto
	  if (obj == null) return false;
	  if (!(obj instanceof Numero)) return false;
	  Numero elotro = (Numero) obj;
	  // a partir de aqui comparar los atributos de ambos 
	  // objetos ('this' y 'elotro') para determinar si  
	  // son iguales o no.
	  // !OJO! si los atributos son referencias a objetos, 
	  // hay que usar 'equals' para compararlos.
	  if (this.valor == elotro.valor) return true;
	  return false;
  }
}