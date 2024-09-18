package ua.lab;

public class Matter{
    protected int mass = 1;
    private int charge; 
    private static int spin = 0; 

    public Matter(){
    }

    public Matter(int charge){
    }

    int collide(int orbit){
        return 0;
    }

    public static int changeSpin(){
        return 0;
    }

    // this has no sesnse
    private int getMass(){
        return mass;
    }
    



}
