import ui.MemoMenu;

public class NotePad {
    public static void main(String[] args) {
        NotePad notePad = new NotePad();
        notePad.startNotePad();
    }

    private void startNotePad() {
        MemoMenu memoMenu = new MemoMenu();
        memoMenu.show();
    }
}
