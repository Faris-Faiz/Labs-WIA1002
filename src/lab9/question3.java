package lab9;

public class question3 {
    public static void main(String[] args) {
        int base = 10, powerRaised = 3;
        int result = (int) exponent(base, powerRaised);

        System.out.println(base + "^" + powerRaised + "=" + result);
    }

    public static long exponent(int x, int y) {
        if (y != 0) {
            // recursive call to power()
            return (x * exponent(x, y - 1));
        }
        else { // base case when y = 0 to prevent stackoverflowerror
            return 1;
        }
    }
}
