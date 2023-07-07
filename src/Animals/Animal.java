package Animals;

public abstract class Animal {
    private static int counter;
    private String species;
    private String color;
    private String years;
    private int id;

    public Animal(String species, String color, String years) {
        this.species = species;
        this.color = color;
        this.years = years;
        this.id = ++counter;
    }

    public String getSpecies() {
        return this.species;
    }

    public String getColor() {
        return this.color;
    }

    public String getYears() {
        return this.years;
    }

    public int getId() {
        return this.id;
    }

}