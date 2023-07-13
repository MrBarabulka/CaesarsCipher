import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class CaesarsEngineDecrypt {
    private PrintToScreenEngine printToScreenEngine;
    private TextMenu textMenu;

    public CaesarsEngineDecrypt(PrintToScreenEngine printToScreenEngine, TextMenu textMenu) {
        this.printToScreenEngine = printToScreenEngine;
        this.textMenu = textMenu;
    }

    public void decryptFileWithCaesarsCipher() {
        Scanner scanner = new Scanner(System.in);

        printToScreenEngine.printTo(RegularCharacters.ENTER_PATH_FILE_OPEN, false);
        String inputFilePath = scanner.nextLine();

        if (!Files.exists(Path.of(inputFilePath))) {
            printToScreenEngine.printTo(RegularCharacters.FILE_DOES_NOT_EXIST, true);
            decryptFileWithCaesarsCipher();
            return;
        }

        printToScreenEngine.printTo(RegularCharacters.ENTER_PATH_FILE_SAVE, false);
        String outputFilePath = scanner.nextLine();

        printToScreenEngine.printTo(RegularCharacters.SELECT_KEY_LENGTH_TO_DECRYPT, false);
        int keyLength = scanner.nextInt();
        scanner.nextLine();

        if (keyLength == 0) {
            printToScreenEngine.printTo(RegularCharacters.DECRYPTING_WITHOUT_KEY, false);

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
                 BufferedWriter writer = Files.newBufferedWriter(Path.of(outputFilePath), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {

                ArrayList<String> lines = new ArrayList<>();
                String line;

                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }

                for (int i = 1; i < 26; i++) {
                    writer.write("Shift: " + i);
                    writer.newLine();

                    for (String decryptedLine : lines) {
                        String decryptedText = decryptTextWithCaesarsCipher(decryptedLine, i);
                        writer.write(decryptedText);
                        writer.newLine();
                    }

                    writer.newLine(); // Добавляем пустую строку между разными сдвигами
                }

                printToScreenEngine.printTo(RegularCharacters.SUCCESSFULL_DECRYPT, false);
                textMenu.textMenuStart();
            } catch (IOException e) {
                printToScreenEngine.printTo(RegularCharacters.ERROR_DECRYPT + e.getMessage(), true);
                textMenu.textMenuStart();
            }
            return;
        } else {
            printToScreenEngine.printTo(RegularCharacters.DECRYPTING_WITH_KEY + keyLength, false);

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
                 BufferedWriter writer = Files.newBufferedWriter(Path.of(outputFilePath), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {

                String line;
                while ((line = reader.readLine()) != null) {
                    String decryptedLine = decryptTextWithCaesarsCipher(line, keyLength);
                    writer.write(decryptedLine);
                    writer.newLine();
                }

                writer.close(); // Закрываем BufferedWriter после завершения записи

                printToScreenEngine.printTo(RegularCharacters.SUCCESSFULL_DECRYPT, false);
                textMenu.textMenuStart();
            } catch (IOException e) {
                printToScreenEngine.printTo(RegularCharacters.ERROR_DECRYPT + e.getMessage(), true);
                textMenu.textMenuStart();
        }
    }
}

    private String decryptTextWithCaesarsCipher(String text, int keyLength) {
        StringBuilder decryptedText = new StringBuilder();

        for (char charText : text.toCharArray()) {
            if (Character.isLetter(charText)) {
                char shiftedChar = (char) (charText - keyLength);
                if (Character.isUpperCase(charText)) {
                    shiftedChar = (char) (((shiftedChar - 'A' + 26) % 26) + 'A');
                } else {
                    shiftedChar = (char) (((shiftedChar - 'a' + 26) % 26) + 'a');
                }
                decryptedText.append(shiftedChar);
            } else if (charText == '%') {
                decryptedText.append(' ');
            } else {
                decryptedText.append(charText);
            }
        }
        return decryptedText.toString();
    } 
}

