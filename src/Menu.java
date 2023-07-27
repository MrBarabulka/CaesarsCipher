import java.util.Scanner;

public class Menu {
    private static final int ENCRYPT_FILE = 1;
    private static final int DECRYPT_FILE = 2;
    private static final int EXIT_APPLICATION = 0;
    private final PrintToScreenEngine printToScreenEngine;
    private final CaesarsEngineEncrypt caesarsEngineEncrypt;
    private final CaesarsEngineDecrypt caesarsEngineDecrypt;

    public Menu(PrintToScreenEngine printToScreenEngine) {
        this.printToScreenEngine = printToScreenEngine;
        this.caesarsEngineEncrypt = new CaesarsEngineEncrypt(printToScreenEngine, this);
        this.caesarsEngineDecrypt = new CaesarsEngineDecrypt(printToScreenEngine, this);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printToScreenEngine.printTo(RegularCharacters.TEXT_MENU);

            if (scanner.hasNextInt()) {
                int menuItem = scanner.nextInt();
                if (menuItem == ENCRYPT_FILE) {
                    caesarsEngineEncrypt.encryptFileWithCaesarsCipher();
                } else if (menuItem == DECRYPT_FILE) {
                    caesarsEngineDecrypt.decryptFileWithCaesarsCipher();
                } else if (menuItem == EXIT_APPLICATION) {
                    textMenuExit();
                    break;
                } else {
                    printToScreenEngine.printTo(RegularCharacters.ERROR_MENU_SELECTION);
                }
            } else {
                printToScreenEngine.printTo(RegularCharacters.NOT_A_NUMBER);
                scanner.next();
            }
        }
        scanner.close();
    }

    private void caesarEngineEncrypt() {
        printToScreenEngine.printTo(RegularCharacters.ENCRYPT_ENGINE_START);
        caesarsEngineEncrypt.encryptFileWithCaesarsCipher();
    }

    private void caesarEngineDecrypt() {
        printToScreenEngine.printTo(RegularCharacters.DECRYPT_ENGINE_START);
        caesarsEngineDecrypt.decryptFileWithCaesarsCipher();
    }

    public void textMenuExit() {
        printToScreenEngine.printTo(RegularCharacters.EXIT_APPLICATION);
    }
}
