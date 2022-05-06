package Activities;

public class Activity1 {
    public static void main(String args[])
    {
    Activities.Car c = new Car();
    c.make = 2014;
    c.color = "Black";
    c.transmission = "Manual";
    c.displayCharacteristics();
    c.accelerate();
    c.brake();
    }
}
