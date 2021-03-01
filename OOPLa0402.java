// Herbert Schildt, 2014, modified
// Demonstrate a lambda expression that takes a parameter
// Another functional interface
interface FunctInterface {
    boolean test(int n);
}

class LambdaDemo2 {
    public static void main(String args[]) {
        // A lambda expression to define the test method
        // (tests if a number is even)
        FunctInterface t = (n) -> (n % 2) == 0;

        if (t.test(10)) {
            System.out.println("10 is even");
        }

        if (!t.test(9)) {
            System.out.println("9 is not even");
        }

        t = (n) -> n > 0;

        if (!t.test(-2)) {
            System.out.println("-2 is not positive");
        }

        if (t.test(2)) {
            System.out.println("2 is positive");
        }
    }
}

