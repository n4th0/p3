package es.ua.dlsi.prog3.p2.model;

import java.util.ArrayList;

public class Car {
    private ArrayList<Wheel> wheels;
    public Car(){
        wheels = new ArrayList<Wheel>();
    }

    public Car(Car c){
        wheels = new ArrayList<Wheel>(c.wheels);
    }

    public void addWheel(Wheel w){
        if(wheels.size() >=4)
            System.out.println("lanzar too many wheels exception");

        if(wheels.size() == 0){
            wheels.add(w);
            return;
        }

        for (int i = 0; i < wheels.size(); i++) {
            if(!w.getTyreType().equals(wheels.get(i).getTyreType()) 
                    /*&& wheels.get(i).getTyreType() != null*/ ){
                System.out.println("lanzar wrong tyreType exception");
            }
        }

        wheels.add(w);

    }

    public ArrayList<Wheel> getWheels(){
        return new ArrayList<>(wheels);
    }

    public void changeTyres(TyreType t, double pressure) {
        if(t == null)
            throw new IllegalArgumentException("changeTyres: TyreType is null");

        if (wheels == null || wheels.size() == 0) {
            throw new RuntimeException();
        }

        for (int i = 0; i < wheels.size(); i++) {
            wheels.get(i).inflate(pressure);
        }
    }

}
