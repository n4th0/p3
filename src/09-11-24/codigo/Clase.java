import java.util.*;

public class Clase {
	// Sintaxis básica 
	private int campo1; 
	private float campo2; 
	
	public Clase(int v) {
		campo1 = v; 
	}
	
	public int getCampo1() { 
		return campo1;
	} 
	
	// Atributos constantes y estáticos
	public final int KN=10;
	private static int contador=1;
	public static final int KNN=10;
	public static void incrementaContador () {
  		contador++;
	}	
	
	// 14
	public boolean equals(Object obj) {
	  if (obj == null) return false;
	  
	  if (this == obj) return true;
	  
	  if ( !(obj instanceof Clase) ) 
	    return false;
	    
	  Clase r = (Clase) obj;
	  
	    if ( (this.campo1 == r.campo1)
	    && (this.campo2 == r.campo2) )
	    	return true;
	    else
	    	return false;

        // return ((this.campo1 == r.campo1) && (this.campo2 == r.campo2));

	}
	
	public String toString() {
	  return "campo1="+campo1+"; campo2="+campo2;
	}
	

	public static void  F(int a, String x, int v[]) {
	   a = 10;
	   x = x + "Hola"; // x.concatenate("hola")
	   v[2] = 7000;
	}

	private static Map<Integer,String> titulos;
	
	static {
		titulos = new HashMap<>();
		titulos.put(1,"Constantes, estáticos [1]");
		titulos.put(2,"Tipos de datos escalares [2]");
		titulos.put(3,"La referencia  this [3]");
		titulos.put(4,"Implementación de 'equals' [4]");
		titulos.put(5,"Boxing - Unboxing [5]");
		titulos.put(6,"Excepciones [6]");
		titulos.put(7,"Cadenas - String [7]");
		titulos.put(8,"Concatenacion [8]");
		titulos.put(9,"Arrays [9]");
		titulos.put(10,"Métodos, paso por valor [10]");
		titulos.put(11,"Control de flujo [11]");
		titulos.put(12,"Vectores dinámicos [12]");

	}
	
	private static void next(int n) throws Exception {
		System.out.println("-- Pulsa INTRO para ver '"+titulos.get(n+1)+"'");
		System.out.println("-- o CTRL-C para acabar.");
		System.in.read();
	}
	
	// [1]
	private static void do1() {
    		System.out.println(titulos.get(1));
	    	Clase objeto = new Clase(4);
	    	System.out.println("\tpublic final int KN="+objeto.KN);
			System.out.println("\tprivate static int contador="+Clase.contador);
			System.out.println("\tpublic static final int KNN="+Clase.KNN);
			System.out.println("\tClase.incrementaContador()");
			Clase.incrementaContador();
			System.out.println("\tprivate static int contador="+Clase.contador);
	}

	// [2]
	private static void do2() {
			System.out.println("Tipos de datos escalares [2]");
		
			int k = -14;
			float a = 100.3f; 
			double b = 100.3;
			double b2 = 1.003e2;
			char c = 'a';
			boolean d = true; // o false
		
			System.out.println("\tfloat a = "+ a);
			System.out.println("\tdouble b = "+ b);
			System.out.println("\tdouble b2 = "+ b2);
			System.out.println("\tchar c = "+ c);
			System.out.println("\tboolean d = "+ d);
	}
	
	// [3]
	private static void do3() {
			System.out.println("La referencia  this [3]");

			Numero a = new Numero(10);
			Numero b = new Numero(3);
			System.out.println("\ta.valor="+a.get());
			System.out.println("\tb.valor="+b.get());
			System.out.println("\ta.suma(b)");
			a.suma(b);
			System.out.println("\ta.valor="+a.get());			
	}

	// [4]
	private static void do4() {
	    System.out.println(titulos.get(4));

		Numero x = new Numero(-3);
		Numero y = new Numero(4);
		Numero z = new Numero(4);
		Numero z2 = new Numero(4);

		System.out.println("Numero x = new Numero(-3);");
		System.out.println("Numero y = new Numero(4);");
		System.out.println("Numero z = new Numero(4);");
		System.out.println("\tProp. reflexiva: x.equals(x) == "+x.equals(x));
		System.out.println("\tProp. simétrica: x.equals(y) == y.equals(x) :");
		System.out.println("\t\tx.equals(y)=="+x.equals(y));
		System.out.println("\t\ty.equals(x)=="+y.equals(x));
		System.out.println("\tProp. transitiva: y.equals(z) && z.equals(z2) --> y.equals(z2):");
		System.out.println("\t\ty.equals(z)=="+y.equals(z));
		System.out.println("\t\tz.equals(z2)=="+z.equals(z2));
		System.out.println("\t\ty.equals(z2)=="+y.equals(z2));

	}

	// [5]
	private static void do5() {
		System.out.println(titulos.get(5));

		Integer b = 3;
		
		System.out.println("\tInteger b = 3;");
		System.out.println("\tb.intValue() : "+b.intValue());
		
		b = new Integer(100);
		int x = b;
		
		System.out.println("\tb = new Integer(100);");
		System.out.println("\tint x = b;");
		System.out.println("\tx : "+x);

	}
	
	// [6]
	private static void do6() {
		System.out.println(titulos.get(6));

		Integer a=null, b=new Integer(3);
		System.out.println("\tInteger a=null;");
		System.out.println("\tInteger b=new Integer(3);");
		System.out.println("\tif (a.equals(b)) {...");
		try {
			if (a.equals(b)) {
				// este if lanza la excepción NullPointerException 
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
			
		// ArrayIndexOutOfBoundsException
		int [] v = new int[10];
		v[20] = 3;
	}
	
	private void F(String s) {
		System.out.println(s);
	}
	
	// [7]
	private static void do7() {

		System.out.println(titulos.get(7));
		
		String s = new String("Hola");		
		
		System.out.println("\tString s = new String(\"Hola\");");
		System.out.println("\ts == \"Hola\" : " + (s == "Hola")); 
		System.out.println("\ts.equals(\"Hola\") : " + s.equals("Hola")); 
		System.out.println();
		
		Float f = new Float(20); 
		s = f.toString();
			
		System.out.println("\tFloat f = new Float(20);");
		System.out.println("\ts = f.toString();");
		System.out.println("\t\tEl valor de f es " + f); // al concatenar 'f', Java lo expande a 'f.toString()'
		System.out.println("\t\ts = " + s); 
	}
	
	// [8]
	private static void do8() {
		System.out.println(titulos.get(8));
		
		int i=100;
		
		System.out.println("\tint i=100;");
		System.out.println("\tEl valor de i es = " + i);

		String s1 = new String("El valor de i es = "); 
		String s2 = new Integer(i).toString();
		String s3 = s1.concat(s2); // que crea un objeto nuevo
		
		System.out.println("s3 = " + s3);

		StringBuilder sb = new StringBuilder(); 
		sb.append("El valor de i es = "); 
		sb.append(i);
		
		System.out.println("sb.toString() : \"" + sb.toString() + "\""); // objeto String
	}
	

	// [9]	
	private static void do9() {
		System.out.println(titulos.get(9));

		Integer [] v; // v es un puntero a null
		v = new Integer[100];
		// v.length es la longitud reservada para el array
		for (int i=0; i<v.length; i++) {
			v[i] = new Integer(0);
			// ó v[i] = 0 (equivalente por el boxing)
		}
		
		System.out.println("\tInteger [] v;..."); 
		System.out.println("\t\tv : " + v);
		System.out.println("\t\tv[0] : " + v[0]);
			
		int [] origen = new int []{1,2,3,4,5};
		int [] destino = new int[origen.length]; 
		
		System.out.println("\tint [] origen = new int []{1,2,3,4,5};");
		System.out.println("\tint [] destino = new int[origen.length];");
		
		System.arraycopy(origen, 0, destino, 0, origen.length);	  
		
		System.out.println("\tSystem.arraycopy(origen, 0, destino, 0, origen.length);");
		for (int i=0; i<destino.length; i++) {
			System.out.println("\t\tdestino["+i+"] : "+ destino[i]);
		}
		
	}

	// [10]	
	private static void do10() {
		System.out.println(titulos.get(10));
			
		int z = 0;
		String str = "Adios";
		int [] array = new int []{1,2,3,4,5};

		System.out.println("Antes de llamar a F:");
		System.out.println("int z : " + z);
		System.out.println("String str : " + str);
		System.out.println("array[2] : " + array[2]);
		
		F(z,str,array);
		
		System.out.println("Despues de llamar a F(z,str,array) : ");
		System.out.println("z : " + z);
		System.out.println("str : " + str);
		System.out.println("array[2] : " + array[2]);
	}
	
	// [11]	
	private static void do11() {
		System.out.println(titulos.get(11));

		String v[] = new String[] {"Azul", "Verde", "Rojo"}; 

		System.out.println("Primer for (int i=0; i<v.length...");
		for (int i=0; i < v.length; i++) {
		  System.out.println("v["+i+"] : "+v[i]);
		}

		System.out.println();

		System.out.println("Segundo for (String color : v)");
	  	for (String color: v) {
		  System.out.println("color : "+color); 
		}
	}
	

	// [12]	
	private static void do12() {
		System.out.println(titulos.get(12));

		ArrayList<Integer> v = new ArrayList<Integer>();
		v.add(87); // esto internamente hace v.add(new Integer(87)) 
		v.add(22);  
		System.out.println("\tArrayList<Integer> v = new ArrayList<Integer>()");
		System.out.println("\tv.add(87);");
		System.out.println("\tv.add(22);");  

		ArrayList<String> sv = new ArrayList<String>();
		sv.add("PROG3");
		sv.add("JAVA");  
		System.out.println("\tArrayList<String> sv = new ArrayList<String>();");
		System.out.println("\tsv.add(\"PROG3\");");
		System.out.println("\tsv.add(\"JAVA\");");  

		Integer a = v.get(0);  
		String s = sv.get(1);

		System.out.println("\tInteger a = v.get(0);");
		System.out.println("\tString s = sv.get(1);");
		System.out.println("\t\ta : "+a);
		System.out.println("\t\ts : "+s);
		System.out.println("\t\tv.size() : " + v.size()); // size() devuelve el tamaño		
	}
	
	public static final void main(String[] args) throws Exception {
	
	  int n = Integer.valueOf(args[0]);
	  switch(n) {
	    
	    case 1: 
			do1();
			next(1);
	    case 2:
	    	do2();
			next(2);
		case 3:
			do3();
			next(3);
		case 4:
			do4();
			next(4);
		case 5:
			do5();
			next(5);
	    case 6:
			do6();
	    case  7:
	    	do7();
	    	next(7);
	    case  8:
	    	do8();
	    	next(8);
	    case  9:
	    	do9();
	    	next(9);
	    case 10:
	    	do10();
	    	next(10);
	    case 11:
	    	do11();
	    	next(11);
	     case 12:
	    	do12();
	  }
	}
	
} // ¡sin punto y coma!
