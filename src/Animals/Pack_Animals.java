package Animals;

public class Pack_Animals extends Animal {
    private String name;
    private String commands;

    public Pack_Animals(String species, String color, String years, String name, String command) {
        super(species, color, years);
        this.name = name;
        this.commands = command;
    }

    public String getName() {
        return this.name;
    }

    public String getCommands() {
        return this.commands;
    }

    public void addCommand(String newCommand) {
        if (this.commands.length() > 0) {
            this.commands += ", " + newCommand;
        } else {
            this.commands = newCommand;
        }
    }

    @Override
    public String toString() {
        return "Вьючное животное - " +
                "ID = " + super.getId() + ", " +
                "имя = " + name + ", " +
                "вид = " + super.getSpecies() + ", " +
                "возраст = " + super.getYears() + ", " +
                "цвет = " + super.getColor() + ", " +
                "команды = '" + commands;
    }

}