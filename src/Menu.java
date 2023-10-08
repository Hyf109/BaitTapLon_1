import java.util.Scanner;

public class Menu {
    public static void showMenu() {
        System.out.println("[0] Exit");
        System.out.println("[1] Add");
        System.out.println("[2] Remove");
        System.out.println("[3] Update");
        System.out.println("[4] Display");
        System.out.println("[5] Lookup");
        System.out.println("[6] Search");
        System.out.println("[7] Game");
        System.out.println("[8] Import from file");
        System.out.println("[9] Export to file");
        System.out.println("Your action: ");
    }

    public static void actionMenu(Dictionary obj) throws Exception {
        boolean status = true;
        while (status) {
            showMenu();
            Scanner sc = new Scanner(System.in);
            switch (sc.nextInt()) {
                case 0: {
                    status = false;
                    System.out.println("Leaving the app...");
                    break;
                }
                case 1: {
                    obj.insertFromCommandline();
                    break;
                }
                case 2: {
                    obj.removeFromCommandLine();
                    break;
                }
                case 3: {
                    obj.updateFromFile();
                    break;
                }
                case 4: {
                    obj.showAllWords();
                    break;
                }
                case 5: {
                    obj.lookupFromDictionary();
                    break;
                }
                case 6: {
                    obj.searchFromDictionary();
                    break;
                }
                case 8: {
                    try {
                        obj.insertFromFile();
                        System.out.println("Insert thanh cong");
                    } catch (Exception e) {
                        System.out.println("Insert khong thanh cong");
                        throw new RuntimeException(e);
                    }
                }
                case 9: {
                    try {
                        obj.saveRecords();
                        System.out.println("Export thanh cong");
                    } catch (Exception e) {
                        System.out.println("Export khong thanh cong");
                        throw new RuntimeException(e);
                    }
                }


            }
        }
        try {
            obj.saveRecords();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
