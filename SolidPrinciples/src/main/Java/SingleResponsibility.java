//  SingleResponsibility means that a class should have only one reason to change and one work have to do entirely

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