package es.ua.dlsi.prog3.p2.model;

import java.util.Objects;

public final class TyreType {

	private String description;
    private double min_preassure;
    private double max_preassure;

    public TyreType(String desc, double min, double max) throws IllegalArgumentException{
        if(desc == null || desc.isEmpty() || min <= 0 || min >= max) //TODO comprobar los iguales
            throw new IllegalArgumentException("TyreType constructor: description or min or max are wrong");

        description = new String(desc);
        min_preassure = min;
        max_preassure = max;
    }

    public TyreType(TyreType t){

        description = new String(t.description);
        min_preassure = t.min_preassure;
        max_preassure = t.max_preassure;

    }
    public double getMinPressure(){
        return min_preassure;
    }
    public double getMaxPressure(){
        return max_preassure;
    }
    public String toString(){
        return "TyreType "+description+" ["+min_preassure+","+max_preassure+"]";
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TyreType other = (TyreType) obj;
		return Objects.equals(description, other.description)
				&& Double.doubleToLongBits(max_preassure) == Double.doubleToLongBits(other.max_preassure)
				&& Double.doubleToLongBits(min_preassure) == Double.doubleToLongBits(other.min_preassure);
	}

}
