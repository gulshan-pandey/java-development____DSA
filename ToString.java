public class ToString {
    
    class Car {
        int noOfDoors;
        int wheels;
        String name;
        int maxSpeed;

        public Car(int noOfDoors, int wheels, String name, int maxSpeed) {
            this.noOfDoors = noOfDoors;
            this.wheels = wheels;
            this.name = name;
            this.maxSpeed = maxSpeed;
        }

        @Override
        public String toString() {  //this toString class is also defined in java and if we dont define it here then that method will be returned hashes!
            return "Car [name=" + name + ", maxSpeed=" + maxSpeed + "]";
        }

       
    }

    public static void main(String[] args) {
        ToString outerObject = new ToString(); // Create an instance of the outer class
        Car cr = outerObject.new Car(4, 4, "maruti", 120);
        System.out.println(cr.toString()); //will print the name of class followed by hashcode because everytime we try to print object,it will call toString method even if you dont mention.,if basically call the methods toString from its own class and print those hexadecimal hashcode stuff.

        //so what if we define our own toString mthod it will just imply our toString method
        System.out.println(cr);

        

    }
}
