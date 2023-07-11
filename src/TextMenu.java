import java.util.InputMismatchException;
import java.util.Scanner;

public class TextMenu {

    private PrintToScreenEngine printToScreenEngine;
    private CaesarsEngineEncrypt caesarsEngineEncrypt;
    private CaesarsEngineDecrypt caesarsEngineDecrypt;

    public TextMenu(PrintToScreenEngine printToScreenEngine) {
        this.printToScreenEngine = printToScreenEngine;
        this.caesarsEngineEncrypt = new CaesarsEngineEncrypt(printToScreenEngine, this);
        this.caesarsEngineDecrypt = new CaesarsEngineDecrypt(printToScreenEngine, this);
    }

    private static final int ENCRYPT_FILE = 1;
    private static final int DECRYPT_FILE = 2;
    private static final int EXIT_APPLICATION = 0;
    private static boolean verification = true;
    Scanner scanner = new Scanner(System.in);

    public void textMenuStart() {
        while (verification) {

            printToScreenEngine.printTo(RegularCharacters.TEXT_MENU, false);

            try {
                int menuItem = scanner.nextInt();
                if (menuItem == ENCRYPT_FILE) {
                    caesarEngineEncrypt();
                    verification = false;
                } else if (menuItem == DECRYPT_FILE) {
                    caesarEngineDecrypt();
                    verification = false;
                } else if (menuItem == EXIT_APPLICATION) {
                    textMenuExit();
                    verification = false;
                } else {
                    printToScreenEngine.printTo(RegularCharacters.ERROR_MENU_SELECTION,true);
                    scanner.next();
                }
            } catch (InputMismatchException e) {
                printToScreenEngine.printTo(RegularCharacters.NOT_A_NUMBER,true);
                scanner.next();
            }
        }
    }

    private void caesarEngineEncrypt() {
        printToScreenEngine.printTo(RegularCharacters.ENCRYPT_ENGINE_START,false);
        caesarsEngineEncrypt.encryptFileWithCaesarsCipher();
    }

    private void caesarEngineDecrypt() {
        printToScreenEngine.printTo(RegularCharacters.DECRYPT_ENGINE_START,false);
        caesarsEngineDecrypt.decryptFileWithCaesarsCipher();

    }

    public void textMenuExit() {
        printToScreenEngine.printTo(RegularCharacters.EXIT_APPLICATION,false);
    }
}
