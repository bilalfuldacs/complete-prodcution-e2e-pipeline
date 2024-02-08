public class Example {
    private int value = 10; // Instance variable

    public void printValue() {
        int value = 20; // Local variable shadowing the instance variable
        System.out.println(value); // This will print 20, not 10
    }
}
