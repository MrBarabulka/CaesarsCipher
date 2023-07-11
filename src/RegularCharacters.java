public class RegularCharacters {
    public static final String ENGLISH_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static final String PUNCTUATION_MARKS = ".?!,;:-()\"";

    public static final String ERROR_MENU_SELECTION = "Wrong number! Select the menu item again!";
    public static final String NOT_A_NUMBER = "it's not a number! Select the menu item again!";
    public static final String ENCRYPT_ENGINE_START = "Caesars encrypt engine launched...";
    public static final String DECRYPT_ENGINE_START = "Caesars decrypt engine launched...";
    public static final String FILE_DOES_NOT_EXIST = "The file does not exist. Please enter a valid file path.";
    public static final String ENTER_PATH_FILE_OPEN = "Enter the full path to the file to open: ";
    public static final String ENTER_PATH_FILE_SAVE = "Enter the full path to the file to save: ";
    public static final String EXIT_APPLICATION = "Exit from the application.";
    public static final String SELECT_KEY_LENGTH_TO_ENCRYPT = "Enter the number of shift positions (Caesar encryption): ";
    public static final String SELECT_KEY_LENGTH_TO_DECRYPT = "Enter the number of shift positions (Caesar decryption), Enter \"0\" to BRUTEFORCE: ";
    public static final String SUCCESSFULL_ENCRYPT = "The text was successfully encrypted and written to a file.";
    public static final String ERROR_ENCRYPT = "File encryption error: ";
    public static final String SUCCESSFULL_DECRYPT = "The text was successfully decrypted and written to a file.";
    public static final String ERROR_DECRYPT = "File decryption error: ";
    public static final String DECRYPTING_WITH_KEY = "Performing decryption with a specified key length: ";
    public static final String DECRYPTING_WITHOUT_KEY = "Performing decryption without a specified key length. BTUTEFORCE IT ALL!";

    public static final String TEXT_MENU =
            """
                        ┌────────────────────────┐
                       ┌────────────────────────┐│
                       │       .: Menu :.       ││
                       ├────────────────────────┤│
                       │ 1: To Encrypt File     ││
                       ├────────────────────────┤│
                       │ 2: To Decrypt File     ││
                       ├────────────────────────┤│
                       │ 0: To Exit Application │┘
                       └────────────────────────┘
            """;

    private RegularCharacters() {
    }
}
