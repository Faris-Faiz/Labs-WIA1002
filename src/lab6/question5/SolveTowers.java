package lab6.question5;

public class SolveTowers {
    public static void main(String[] args) {
        System.out.println("Starting: ");
        towerOfHanoi towers = new towerOfHanoi(4);
        System.out.println("Solving: ");
        towers.solve();
        System.out.println("Done!");
    }
}
