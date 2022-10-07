package Model;

public class ZZPlant extends Plant { //OBS, implemeneterar INTE Waterable


    public ZZPlant(String name, double height) {
        super(name, height);
    }

    @Override //override av metod från superklass Model.Plant
    public String toString() {
        String plantTypeInSwedish = "Garderobsblomman ";
        return plantTypeInSwedish + name;
    }
}
