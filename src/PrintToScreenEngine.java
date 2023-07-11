public class PrintToScreenEngine {
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    public void printTo(String report, boolean isRedColor) {
        if (isRedColor) {
            System.out.println(ANSI_RED + report + ANSI_RESET);
        } else {
            System.out.println(report);
        }
    }
}
