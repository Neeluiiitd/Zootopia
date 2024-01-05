

package org.example;

import java.util.Iterator;
import java.util.Map;

public class AnimalManager {
    public AnimalManager() {
    }

    public static void addAnimal(Animals animal, int num) {
        zoo.dictionary_animals.put(num, animal);
    }

    public static void removeAnimal(int num, Map<Integer, Animals> dictionary) {
        zoo.dictionary_animals.remove(num);
    }

    public static void modifyAnimal(int num, String newName, String newType,String newnoise,String newhis, Map<Integer, Animals> dictionary) {
        Animals animal = (Animals)zoo.dictionary_animals.get(num);
        if (animal != null) {
            animal.setName(newName);
            animal.setNoise(newnoise);
            animal.SetHistory(newhis);

            if (animal instanceof Mammals) {
                ((Mammals)animal).setType(newType);
            }

            if (animal instanceof Amphibians) {
                ((Amphibians)animal).setType(newType);
            }

            if (animal instanceof Reptiles) {
                ((Reptiles)animal).setType(newType);
            }
        }

    }

    public static void listAnimals() {
        System.out.println("List of Animals:");
        Iterator var0 = zoo.dictionary_animals.entrySet().iterator();

        while(var0.hasNext()) {
            Map.Entry<Integer, Animals> entry = (Map.Entry)var0.next();
            int num = (Integer)entry.getKey();
            Animals animal = (Animals)entry.getValue();
            System.out.println("Animal Number: " + num);
            System.out.println("Name: " + animal.getName());
            System.out.println("Type: " + animal.getType());
        }

    }
    public static void printAnimalNoise(int num) {
        Animals animal = zoo.dictionary_animals.get(num);
        if (animal != null) {

            System.out.println("Noise: " + animal.getNoise());

        } else {
            System.out.println("Animal with number " + num + " not found.");
        }
    }
    public static void printAnimalhistory(int num) {
        Animals animal = zoo.dictionary_animals.get(num);
        if (animal != null) {

            System.out.println("History: " + animal.getHistory());
        } else {
            System.out.println("Animal with number " + num + " not found.");
        }
    }
}
