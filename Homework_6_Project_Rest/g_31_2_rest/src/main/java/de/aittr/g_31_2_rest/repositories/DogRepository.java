package de.aittr.g_31_2_rest.repositories;

import de.aittr.g_31_2_rest.domain.Dog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class DogRepository implements CrudRepository<Dog> {
    private Map<Integer, Dog> dogs = new HashMap<>();
    private int currentId;


    public DogRepository() {
        save(new Dog("Black", 5.20));
        save(new Dog("White", 3.50));
        save(new Dog("Braun", 12.50));
    }

    @Override
    public Dog save(Dog dog) {
        dog.setId(++currentId);
        dogs.put(currentId, dog);
        return dog;
    }

    @Override
    public List<Dog> getAll() {
        return new ArrayList<>(dogs.values());
    }

    @Override
    public Dog getById(int id) {
        return dogs.get(id);
    }

    @Override
    public void update(Dog obj) {

    }

    @Override
    public void deleteById(int id) {

    }
}