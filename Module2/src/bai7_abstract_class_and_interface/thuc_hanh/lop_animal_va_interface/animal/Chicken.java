package bai7_abstract_class_and_interface.thuc_hanh.lop_animal_va_interface.animal;

import bai7_abstract_class_and_interface.thuc_hanh.lop_animal_va_interface.edible.Edible;

public class Chicken extends Animal implements Edible {
    public String makeSound(){
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}
