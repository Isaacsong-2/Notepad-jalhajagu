import exception.MemoNotFoundException;
import ui.MemoMenu;

public class NotePad {
    public static void main(String[] args) {
        NotePad notePad = new NotePad();
        notePad.startNotePad();
    }

    private void startNotePad() {
        MemoMenu memoMenu = new MemoMenu();
        try {
            memoMenu.show();
        } catch(MemoNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("메인 메뉴로 돌아갑니다.\n");
            memoMenu.show();
        }
    }
}
