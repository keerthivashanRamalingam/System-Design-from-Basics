/* SingleResponsibility means that a class should have only one reason to change and\
 one work have to do entirely
*/

/*
    What it means:
        A class or module should have one, and only one, job. If there's more than one reason for a class
    to change, it's doing too much.

    How to spot it in code review:
        When looking at a class, ask yourself:
        * "If the requirements for feature A change, will this class also need to change because it
           handles feature B?"
        * "Does this class have multiple concerns, like database interaction, business logic, and
           reporting?"
*/

//Violatied code
class violatedSingleResponsibility {
    //In this example, the DBOPerations class is responsible for both saving and reading data if a slave database is used.
    class DBOPerations {
        public static void saveData(String data) {
            // Logic to save data to the database
            System.out.println("Data has been saved: " + data);
        }

        public static void readData() {
            // Logic to read data from the database
            System.out.println("Data has been read from the database");
        }
    }



    class Driver {
        public static void main(String[] args) {
            DBOPerations.saveData("Sample Data");
            DBOPerations.readData();
        }
    }
}

//Non-Violatied code
class SingleResponsibility {
    static class MasterDB {
        public static void doOnlyWrite(String data) {
            // Logic to save data to the database
            System.out.println("Data has been : " + data);
        }
    }

    static class SlaveDB{
        public static void doOnlyRead() {
            // Logic to read data from the database
            System.out.println("Data has been read from the database");
        }
    }

    class Driver{
        public static void main(String[] args) {
            SingleResponsibility singleResponsibility = new SingleResponsibility();
            MasterDB.doOnlyWrite("data");
            SlaveDB.doOnlyRead();
        }
    }
}