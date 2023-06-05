package ui;

import entity.Memo;
import store.MemoList;
import util.ConsoleUtil;

import java.util.ArrayList;

public class Console {
    private ConsoleUtil consoleUtil;

    private MemoList memoList;

    public Console() {
        this.consoleUtil = new ConsoleUtil();
        this.memoList = new MemoList();
    }

    public void register() {
    }

    public void read() { // 메모 조회 기능
        ArrayList<Memo> memos = memoList.getMemos();
        for (int i = memos.size() - 1; i > -1; i--) {
            System.out.println(memos.get(i));
        }
    }

    private Memo findOne() {
        return null;
    }

    public void update() {

    }

    public void delete() {

    }
}
