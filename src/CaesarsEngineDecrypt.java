import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class CaesarsEngineDecrypt extends CaesarsEngine {
    public CaesarsEngineDecrypt(PrintToScreenEngine printToScreenEngine, Menu menu) {
        super(printToScreenEngine, menu);
    }

    @Override
    protected String processText(String text, int keyLength) {
        StringBuilder decryptedText = new StringBuilder();

        for (char charText : text.toCharArray()) {
            if (Character.isLetter(charText)) {
                char shiftedChar = (char) (charText - keyLength);
                if (Character.isUpperCase(charText)) {
                    shiftedChar = (char) (((shiftedChar - UPPERCASE_A + ALPHABET_SIZE) % ALPHABET_SIZE) + UPPERCASE_A);
                } else {
                    shiftedChar = (char) (((shiftedChar - LOWERCASE_A + ALPHABET_SIZE) % ALPHABET_SIZE) + LOWERCASE_A);
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

    public void decryptFileWithCaesarsCipher() {
        processFileWithCaesarsCipher(false);
    }

    void decryptWithBruteforce(String inputFilePath, String outputFilePath) {
        printToScreenEngine.printTo(RegularCharacters.DECRYPTING_WITHOUT_KEY);

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
                    String decryptedText = processText(decryptedLine, i);
                    writer.write(decryptedText);
                    writer.newLine();
                }

                writer.newLine();
            }

            printToScreenEngine.printTo(RegularCharacters.SUCCESSFULL_DECRYPT);
            menu.start();
        } catch (IOException e) {
            printToScreenEngine.printTo(RegularCharacters.ERROR_DECRYPT + e.getMessage());
            menu.start();
        }
    }
}
