package Activities;

public class MountainBike extends Bicycle{

    public int seatHeight;

    public MountainBike(int gears, int currentSpeed, int startHeight) {
        super(gears, currentSpeed);
    }
    // the MountainBike subclass adds one more method
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }

    public String bicycleDesc() {
        return (super.bicycleDesc()+ "\nSeat height is " + seatHeight);
    }

}
