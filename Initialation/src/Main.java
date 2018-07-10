public class Main {
    public static void main(String[] args){
        CityBicycle cityBicycle = new CityBicycle();
        System.out.println(CityBicycle.lastCreationalByciceDate);
        RunningBicycle runningBicycle = new RunningBicycle();
        System.out.println(runningBicycle.getColor() + " " + runningBicycle.getVelocity());
    }
}
