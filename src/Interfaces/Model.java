package Interfaces;

import Animals.Animal;

import java.util.List;

public interface Model {
    List<Animal> getAnimals();

    Animal getAnimalById(int id);

    void newAnimal(Animal animal);

    void removeAnimal(int id);

    void updateAnimal(int id, Animal animal);

}