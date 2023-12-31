import java.io.*;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class CaesarsEngineEncrypt {
    private PrintToScreenEngine printToScreenEngine;
    private TextMenu textMenu;

    public CaesarsEngineEncrypt(PrintToScreenEngine printToScreenEngine, TextMenu textMenu) {
        this.printToScreenEngine = printToScreenEngine;
        this.textMenu = textMenu;
    }

    public void encryptFileWithCaesarsCipher() {
        Scanner scanner = new Scanner(System.in);

        printToScreenEngine.printTo(RegularCharacters.ENTER_PATH_FILE_OPEN, false);
        String inputFilePath = scanner.nextLine();

        if (!Files.exists(Path.of(inputFilePath))) {
            printToScreenEngine.printTo(RegularCharacters.FILE_DOES_NOT_EXIST, true);
            encryptFileWithCaesarsCipher();
            return;
        }

        printToScreenEngine.printTo(RegularCharacters.ENTER_PATH_FILE_SAVE, false);
        String outputFilePath = scanner.nextLine();

        printToScreenEngine.printTo(RegularCharacters.SELECT_KEY_LENGTH_TO_ENCRYPT, false);
        int shift = scanner.nextInt();
        scanner.nextLine(); // Зчитування символу новою строки після вводу довжини ключа

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(outputFilePath), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {

            String line;
            while ((line = reader.readLine()) != null) {
                String encryptedLine = encryptTextWithCaesarsCipher(line, shift);
                writer.write(encryptedLine);
                writer.newLine();
            }
            writer.close(); // Примусово закриваємо BufferedWriter, бо він не дає відкрити готовий файл з зашифрованим текстом
            printToScreenEngine.printTo(RegularCharacters.SUCCESSFULL_ENCRYPT,false);
            textMenu.textMenuStart();
        } catch (IOException e) {
            printToScreenEngine.printTo(RegularCharacters.ERROR_ENCRYPT + e.getMessage(), true);
            textMenu.textMenuStart();
        } finally {
            scanner.close();
        }
    }

    private String encryptTextWithCaesarsCipher(String text, int shift) {
        StringBuilder encryptedText = new StringBuilder();

        for (char charText : text.toCharArray()) {
            if (Character.isLetter(charText)) {
                char shiftedChar = (char) (charText + shift);
                if (Character.isUpperCase(charText)) {
                    shiftedChar = (char) (((shiftedChar - 'A') % 26) + 'A');
                } else {
                    shiftedChar = (char) (((shiftedChar - 'a') % 26) + 'a');
                }
                encryptedText.append(shiftedChar);
            } else if (charText == ' ') {
                encryptedText.append('%');
            } else {
                encryptedText.append(charText);
            }
        }
        return encryptedText.toString();
    }
}
