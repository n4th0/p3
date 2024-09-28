package es.ua.dlsi.prog3.p2.model;

public class Wheel {
    private double pressure;
    TyreType tyreType;

    public Wheel(){
        pressure = 0;
        tyreType = null;
    }

    public Wheel(TyreType t){
        pressure = 0;
        tyreType = t;

    }

    public Wheel(Wheel w){
        pressure = w.pressure;
        tyreType = w.tyreType;
    }

    public void setTyreType(TyreType t){
        tyreType = t;
    }

    public TyreType getTyreType(){
        return tyreType;
    }

    public void inflate(double p)throws IllegalArgumentException{
        if (p< 0) 
            throw new IllegalArgumentException("inflate: negative pressure detected");

        // TODO  lanzar las excepciones
        if (this.tyreType == null) 
            System.out.println("lanzar una noTyretypeExeception");

        if (p > tyreType.getMaxPressure() || p < tyreType.getMaxPressure()) 
            System.out.println("lanzar una Pessure wheel exception");

    }
}
