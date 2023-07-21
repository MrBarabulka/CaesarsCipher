public class Main {
    public static void main(String[] args) {
        PrintToScreenEngine printToScreenEngine = new PrintToScreenEngine();
        Menu menu = new Menu(printToScreenEngine);
        menu.start();
    }
}
