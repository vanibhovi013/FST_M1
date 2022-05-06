package Activities;

public class Car {
    String color;
    String transmission;
    int make;
    int tyres;
    int doors;

    public Car(){
        tyres = 4;
        doors = 4;
    }

    public void displayCharacteristics() {
        System.out.println("Color: " + color);
        System.out.println("transmission: " + transmission);
        System.out.println("make: " + make);
        System.out.println("tyres: " + tyres);
        System.out.println("doors: " + doors);
    }

    public void accelerate() {
        System.out.println("Car is moving forward.");
    }

    public void brake()  {
        System.out.println("Car has stopped.");
    }

}
