public class Demo07 {
    public static void main(String[] args) {
        IPrinter m = new BasicPrinter();
        m.print("Hello");
        // m.scan("/tmp/out"); // blows up
        IScanner scanner = new MultiFunctionPrinter();
        scanner.scan("/tmp/out");
    }
}
