import Animals.*;
import Interfaces.Controller;
import Interfaces.Model;
import Interfaces.View;

import java.util.Scanner;

public class ControllerSimple implements Controller {
    private Model model;
    private View view;
    Scanner sc;

    String menu = "1. Добавить новое животное\n2. " +
            "Список команд животного\n3. " +
            "Обучить животное новым командам\n" +
            "Введите номер действия: ";

    public ControllerSimple(Model model, View view) {
        this.model = model;
        this.view = view;
        sc = new Scanner(System.in);
    }


    @Override
    public void runProgramm() {
        while (true) {
            view.showData(menu);
            choice();
        }
    }

    private void choice() {
        try {
            String ch = sc.nextLine();
            switch (ch) {
                case "1" -> addAnimal();
                case "2" -> listOfSkills();
                case "3" -> newSkill();
                default -> view.showData("Неверное значение. Попробуйте еще раз.\n");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void newSkill() {
        int id = getAnimalForOperate();
        if (id == 0) {
            return;
        }
        String skill;
        Animal animal = model.getAnimalById(id);
        try {
            view.showData("\n----------------------\nВведите новый навык\n----------------------\n");
            skill = sc.nextLine();
            if (animal instanceof Pack_Animals) {
                ((Pack_Animals) animal).addCommand(skill);
            } else {
                ((Pet_Animals) animal).addCommand(skill);
            }
            model.updateAnimal(id, animal);
        } catch (Exception ex) {
            view.showData(ex.getMessage());
        }
    }

    public void listOfSkills() {
        int id = getAnimalForOperate();
        if (id == 0) {
            return;
        }
        Animal animal = model.getAnimalById(id);
        view.showData("\n----------------------\nСписок команд животного\n----------------------\n----------------------\n" + animal.toString() + "\n----------------------\n");
        if (animal instanceof Pack_Animals) {
            view.showData(((Pack_Animals) animal).getCommands());
        } else {
            view.showData(((Pet_Animals) animal).getSkill());
        }
    }

    @Override
    public void addAnimal() {
        Animal animal = null;
        Species species = new Species();
        view.showData("1. Домашнее животное\n2. Вьючное животное\nВыберите тип животного: ");
        String ch = sc.nextLine();
        if (ch.equals("1")) {
            view.showData("1. Собака\n2. Кошка\n3. Хомяк\nВыберите вид животного: ");
            ch = sc.nextLine();
            species = getSpecies();
            switch (ch) {
                case "1" ->
                        animal = new Dog(species.species, species.color, species.years, species.name, species.commands);
                case "2" ->
                        animal = new Cat(species.species, species.color, species.years, species.name, species.commands);
                case "3" ->
                        animal = new Humster(species.species, species.color, species.years, species.name, species.commands);
            }
        } else if (ch.equals("2")) {
            view.showData("1. Лошадь\n2. Верблюд\n3. Осел\nВыберите вид животного: ");
            ch = sc.nextLine();
            species = getSpecies();
            switch (ch) {
                case "1" ->
                        animal = new Horse(species.species, species.color, species.years, species.name, species.commands);
                case "2" ->
                        animal = new Camel(species.species, species.color, species.years, species.name, species.commands);
                case "3" ->
                        animal = new Donkey(species.species, species.color, species.years, species.name, species.commands);
            }
        } else {
            view.showData("Неверный ввод!\n");
            return;
        }
        model.newAnimal(animal);
    }

    private Species getSpecies() {
        Species species = new Species();
        view.showData("Введите имя животного: ");
        species.name = sc.nextLine();
        view.showData("Введите возраст животного: ");
        species.years = sc.nextLine();
        view.showData("Введите цвет животного: ");
        species.color = sc.nextLine();
        view.showData("Введите вид животного: ");
        species.species = sc.nextLine();
        view.showData("Введите команды животного: ");
        species.commands = sc.nextLine();

        return species;
    }

    private void showList() {
        for (Animal animal : model.getAnimals()) {
            if (animal instanceof Pack_Animals) {
                view.showData(((Pack_Animals) (animal)).toString());
            } else {
                view.showData(((Pet_Animals) (animal)).toString());
            }
        }
    }

    private int getAnimalForOperate() {
        if (model.getAnimals().size() == 0) {
            view.showData("\n----------------------\nСписок пуст\n----------------------\n");
            return 0;
        }
        view.showData("\n----------------------\nСписок всех животных\n----------------------\n");
        showList();
        view.showData("\n----------------------\nВыберите животное по ID \n----------------------\n");
        int animalId = 0;
        try {
            String str = sc.nextLine();
            animalId = Integer.valueOf(str);
        } catch (Exception ex) {
            view.showData("Введено неверное значение");
        }
        return animalId;
    }
}