public class CaesarsEngineEncrypt extends CaesarsEngine {
    public CaesarsEngineEncrypt(PrintToScreenEngine printToScreenEngine, Menu menu) {
        super(printToScreenEngine, menu);
    }

    @Override
    protected String processText(String text, int shift) {
        StringBuilder encryptedText = new StringBuilder();

        for (char charText : text.toCharArray()) {
            if (Character.isLetter(charText)) {
                char shiftedChar = (char) (charText + shift);
                if (Character.isUpperCase(charText)) {
                    shiftedChar = (char) (((shiftedChar - UPPERCASE_A) % ALPHABET_SIZE) + UPPERCASE_A);
                } else {
                    shiftedChar = (char) (((shiftedChar - LOWERCASE_A) % ALPHABET_SIZE) + LOWERCASE_A);
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

    public void encryptFileWithCaesarsCipher() {
        processFileWithCaesarsCipher(true);
    }
}
