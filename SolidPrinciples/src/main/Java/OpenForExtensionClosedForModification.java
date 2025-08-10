/*
*  What I have observed in open for extension closed for modification is that the code violation did not comes
*  under the inheritance or abstraction it's between 2 classes.But the liskov and interafce for segregation
*  is for inheritance and abstraction.(only for remembering purpose)
*
*
* */
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
public class OpenForExtensionClosedForModification {

}


