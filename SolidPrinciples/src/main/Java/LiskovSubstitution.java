/*
  LiskovSubstitution generally says to obey Inheritance properly lets say If a parent class has some
  properties the child class also have to operate the properties fully lets say Parent class has 2 methods
  the child class should implement with a proper use unwanted methods/irrelevant methods should not be in
   parent class.
*/


/*
    What it means:
        If you have a class A and a class B inherits from A, you should be able to use an
    object of B anywhere an object of A is expected, without breaking the program or producing unexpected behavior.

    How to spot it in code review:
        Look for subclasses that throw unexpected exceptions, return null when the superclass promises a value, or drastically
    alter the behavior expected from the superclass contract.
*/

public class LiskovSubstitution {
    public static void main(String[] args) {

    }
}

//violation code
class Menu{

    public void getNonVegMenu(){
        System.out.println("Non Veg Menu");
    }

    public void getVegMenu(){
        System.out.println("Veg Menu");
    }
}

class NonVegMenu extends Menu{
    @Override
    public void getNonVegMenu(){
        System.out.println("Non Veg Menu");
    }
}

class vegMenu extends Menu{
    @Override
    public void getVegMenu(){
        System.out.println("Veg Menu");
    }
}

class Driver{
    public static void main(String[] args) {
        Menu menu = new NonVegMenu();
        if(menu instanceof NonVegMenu){
            menu.getNonVegMenu();
        }

        if(menu instanceof NonVegMenu){
            menu.getVegMenu();
        }
    }
}



//Non violation code
interface VegMenuInterface {
    void getVegMenu();
}

interface NonVegMenuInterface {
    void getNonVegMenu();
}

class vegRes implements VegMenuInterface{
    @Override
    public void getVegMenu() {
        System.out.println("Veg Menu");
    }
}

class NonVegRes implements NonVegMenuInterface{
    @Override
    public void getNonVegMenu() {
        System.out.println("Non Veg Menu");
    }
}

class DriverForInterface {
    public static void main(String[] args) {
        VegMenuInterface vegMenu = new vegRes();
        NonVegMenuInterface nonVegMenu = new NonVegRes();

        vegMenu.getVegMenu();
        nonVegMenu.getNonVegMenu();
    }
}

