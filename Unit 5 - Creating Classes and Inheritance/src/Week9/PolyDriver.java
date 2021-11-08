package Week9;

public class PolyDriver {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.makeSound();
        Cat cat = new Cat();
        cat.makeSound();
        Dog dog = new Dog();
        dog.makeSound();
        dog.chaseTail();

        Animal april = new Cat();
        april.makeSound(); //this says meow, it calls it from child class cat bc april was instatiated as a cat
        april = new Dog(); //changed animal to dog
        april.makeSound(); //dynamic binding, first the computer checks the parent class to see if the method's there
        // if it is, it checks the type of the object(dog or cat or just animal) and if it's a specfic type that 
        //has another method of that name, it does the child method

        ((Dog)april).chaseTail(); //this doesn't work (unless you cast it) because of the reason above, animal
        //does not have a chaseTail method
    }
}
