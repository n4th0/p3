

public class A {
    private static int numberOfA;

    public A(){
        numberOfA++;
    }

    public static int getNumberOfA(){
        return numberOfA;
    }

    protected void finalize() throws Throwable{
        // run when System.gc();
    }


    public static void main(String args[]){
        A a = new A();
        A b = new A();
        A c = new A();

        System.out.println(c.getNumberOfA());
        System.out.println(a.getNumberOfA());


    }

}

