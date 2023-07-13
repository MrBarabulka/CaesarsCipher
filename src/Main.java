public class Main {
    public static void main(String[] args) {
        PrintToScreenEngine printToScreenEngine = new PrintToScreenEngine();
        TextMenu textMenu = new TextMenu(printToScreenEngine);
        textMenu.textMenuStart();    
    }
}
