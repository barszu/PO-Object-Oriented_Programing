package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Simulation {
    private final List<MoveDirection> directionsList; //moves for animals

    public List<Animal> getAnimalsList() {
        return Collections.unmodifiableList(animalsList);
    }

    private final List<Animal> animalsList; //animals in the simulation

    public Simulation(List<MoveDirection> directionsList , List<Vector2d> positionsList ){
        this.directionsList = directionsList; //as link list
        this.animalsList = new ArrayList<>(); //as normal list because we will pick el from the middle

        for (Vector2d position: positionsList){
            Animal animal = new Animal(position);
            animalsList.add(animal);
        }
    }

    public void run(){
        int animalIdx = 0 ;
        if (this.animalsList.size() == 0){ return;} //nothing to do, no animals present
        for (MoveDirection direction: this.directionsList){ //if no moves 'for' won't start
            // animal on animalIdx gets moved
            Animal animalReference = this.animalsList.get(animalIdx);
            animalReference.move(direction);

            //unspecified order in exercise?

            System.out.println("Zwierze %d: %s".formatted(animalIdx , animalReference.toString() ));
//            System.out.println("Zwierze %d: %s".formatted(animalIdx , animalReference.getPosition().toString() ));

            animalIdx ++ ;
            if (animalIdx >= this.animalsList.size()){
                animalIdx = 0 ; //reset idx for repetition
            }

        }
    }
}
