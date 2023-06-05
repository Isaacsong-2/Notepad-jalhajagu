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
        ArrayList<Memo> memos = memoList.getMemos();
        int postNum = memos.size();
        String name = consoleUtil.getValueOf("name");
        String password = consoleUtil.getValueOf("password");
        String post = consoleUtil.getValueOf("post");
        Memo memo = new Memo(postNum + 1, name, password, post);
        memoList.create(memo);
    }

    public void read() {
        ArrayList<Memo> memos = memoList.getMemos();
        for (Memo m : memos) {
            System.out.println(m);
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
