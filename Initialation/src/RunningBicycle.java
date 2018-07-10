public class RunningBicycle extends Bicycle {

    private String color;
    // velocity in km/hr
    private int velocity;
    {
        Bicycle.bycicleQuantity++;
        this.color= "red";
        velocity = 10;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }
}
