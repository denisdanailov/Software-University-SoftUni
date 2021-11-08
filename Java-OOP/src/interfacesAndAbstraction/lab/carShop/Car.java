package interfacesAndAbstraction.lab.carShop;

import java.io.Serializable;

public interface Car extends Serializable {

    public static final Integer TIRES = 4;

    public abstract String getModel();
    public abstract String getColor();
    public abstract Integer getHorsePower();
    public abstract String getCountryProduced();

}
