package ui;

import java.util.Scanner;

public class MemoMenu {

    private Scanner scanner;
    private Console console;
    public MemoMenu() {
        this.scanner = new Scanner(System.in);
        this.console = new Console();
    }

    public void show() {
        int inputNum = 0;
        while (true) {
            displayHome();
            inputNum = selectMenu();
            switch (inputNum) {
                case 1:
                    console.register();
                    break;
                case 2:
                    console.read();
                    break;
                case 3:
                    console.update();
                    break;
                case 4:
                    console.delete();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

    private void displayHome() {
        printLine();
        System.out.println("Note Pad Program");
        printLine();
        System.out.println("1. 메모 등록");
        System.out.println("2. 메모 목록 보기");
        System.out.println("3. 메모 수정");
        System.out.println("4. 메모 삭제");
        System.out.println("5. 메모장 종료");
        printLine();
    }

    private void printLine(){
        System.out.println("-----------------------------------");
    }

    private int selectMenu() {
        System.out.print("Select : ");
        int menuNumber = scanner.nextInt();
        if (menuNumber >= 1 && menuNumber <= 5) {
            scanner.nextLine(); // 버프를 비우기 위함.
            return menuNumber;
        } else {
            System.out.println("입력하신 숫자를 확인해주세요.");
            return -1;
        }
    }
}
