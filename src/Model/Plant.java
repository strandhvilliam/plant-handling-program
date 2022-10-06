package Model;

public abstract class Plant {

    protected String name;
    protected double height;

    public Plant(String name, double height) {
        this.name = name;
        this.height = height;
    }

    //Inkapsling
    public String getName() {
        return name;
    }
    public double getHeight() {
        return height;
    }

    @Override
    public abstract String toString();

}
