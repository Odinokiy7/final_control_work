import Animals.Animal;
import Interfaces.Model;

import java.util.ArrayList;
import java.util.List;

public class ModelSimple implements Model {
    private List<Animal> animals;

    public ModelSimple() {
        animals = new ArrayList<>();
    }

    @Override
    public List<Animal> getAnimals() {
        return animals;
    }

    @Override
    public Animal getAnimalById(int id) {
        Animal animal;
        for (Animal el : animals) {
            if (el.getId() == id) {
                return el;
            }
        }
        return null;
    }

    @Override
    public void newAnimal(Animal animal) {
        animals.add(animal);
    }

    @Override
    public void removeAnimal(int id) {
        for (Animal el : animals) {
            if (el.getId() == id) {
                animals.remove(el);
            }
        }
    }

    @Override
    public void updateAnimal(int id, Animal animal) {
        for (Animal el : animals) {
            if (el.getId() == id) {
                animals.remove(el);
                animals.add(animal);
            }
        }
    }
}