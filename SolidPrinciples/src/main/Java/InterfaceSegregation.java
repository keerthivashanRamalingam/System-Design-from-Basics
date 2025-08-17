/*
    The Interface Segregation mainly stands for Interface as the name suggests. We have to segregate or
    sepearte the interface.If we have single interface with lot of abstarct methods it will be messy
    because the inheritors sometimes don't want all abstract methods in interface.
*/


/*
    What it means:
     Instead of one large interface, create smaller, more specific interfaces tailored
     to what individual clients need.

    How to spot it in code review:
        Look for an interface with many methods, where its implementers often
    have empty method bodies, throw UnsupportedOperationException, or comment out sections because they
    don't use all the methods.
*/

//Violated code
interface commonInterfaceForAll {
    void work();
    void eat();
    void sleep();
}
class human implements commonInterfaceForAll {
    public void work() {
        System.out.println("Working");
    }

    public void eat() {
        System.out.println("Eating");
    }

    public void sleep() {
        System.out.println("Sleeping");
    }
}

//Here the robot class is implementing the same interface but it doesn't need eat and sleep methods.
class robot implements commonInterfaceForAll{
    public void work() {
        System.out.println("Working");
    }

    public void eat() {
        // Robots don't eat, so this method is not applicable
        throw new UnsupportedOperationException("Robots do not eat");
    }

    public void sleep() {
        // Robots don't sleep, so this method is not applicable
        throw new UnsupportedOperationException("Robots do not sleep");
    }
}

//non violated code
interface LivingBeing {
    void work();
    void eat();
}

interface NonLivingBeing {
    void work();
}

class Human implements LivingBeing {
    public void work() {
        System.out.println("Working");
    }

    public void eat() {
        System.out.println("Eating");
    }
}

class Robot implements NonLivingBeing {
    public void work() {
        System.out.println("Working");
    }
}


public class InterfaceSegregation {
    public static void main(String[] args) {
        // Using the violated code
        commonInterfaceForAll human = new human();
        human.work();

        NonLivingBeing robot = new Robot();
        robot.work();
    }
}
