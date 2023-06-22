public class TextMenu {
    private static final int ENCRYPT_FILE = 0;
    private static final int DECRYPT_FILE = 1;
    private static final int EXIT_APPLICATION = 2;
    private static final String INCORRECT_PATHFILE = "Path file is incorrect, please enter it again!";
    private static final String FILE_DOES_NOT_EXIST = "File does not exist, please check.";
    private static final String ERROR_MENU_SELECTION = "Wrong number! Select the menu item again!";

    private static final String TEXT_MENU =
            """
                         ┌────────────────────────┐
                        ┌────────────────────────┐│
                        │ Menu:                  ││
                        ├────────────────────────┤│
                        │ 0: To Encrypt File     ││
                        ├────────────────────────┤│
                        │ 1: To Decrypt File     ││
                        ├────────────────────────┤│
                        │ 2: To Exit Application │┘
                        └────────────────────────┘
            """;


}
