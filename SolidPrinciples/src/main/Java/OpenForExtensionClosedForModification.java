/*
  What I have observed in open for extension closed for modification is that the code violation did not comes
  under the inheritance or abstraction it's between 2 classes.But the liskov and interafce for segregation
  is for inheritance and abstraction.(only for remembering purpose)
*/

/*
   What it means:
        You should be able to add new functionality without altering existing, working code.
   Think of it like adding a new app to your phone without having to rewrite the phone's operating system.

   How to spot it in code review:
        Look for large if-else or switch statements that might need to grow every time a new variant
   of a feature is introduced.
*/


//Violated code
class Customer{
    Discount discount;
    public double calculate(String customerType, double amount) {
        if (customerType.equals("Regular")) {
            return amount * 0.9; // 10% discount
        }
        else if (customerType.equals("Premium")) {
            return amount * 0.8; // 20% discount
        }
        else if (customerType.equals("Gold")) {
            return amount * 0.7; // 30% discount
        }
        else {
            return amount; // No discount
        }
    }
}

class Discount{
    public double applyDiscount(double amount) {
        return amount * 0.1;
    }
}

class NormalDiscount extends Discount{
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.9;
    }
}

class PremiumDiscount extends Discount {
    @Override
    public double applyDiscount(double amount) {
        return amount * 1.9;
    }
}




//Non-Violatied code
//Here we no need to check for instance and no need to change this method if a new discount method will be implemented.
public class OpenForExtensionClosedForModification {
    public double applyDiscount(Discount discount, double amount){
        return discount.applyDiscount(amount);
    }
}


