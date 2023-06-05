package ui;

import entity.Memo;
import exception.MemoNotFoundException;
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

    public void read() { // 메모 조회 기능
        ArrayList<Memo> memos = memoList.getMemos();
        for (int i = memos.size() - 1; i > -1; i--) {
            System.out.println(memos.get(i));
        }
    }

    private Memo findOne() {
        int postNum = Integer.parseInt(consoleUtil.getValueOf("수정할 글 번호를 입력해주세요: "));
        return memoList.retrieve(postNum)
                .orElseThrow(() -> new MemoNotFoundException(postNum + "번에 해당하는 메모가 존재하지 않습니다."));
    }

    public void update() {
        Memo memo = findOne();
        String password = consoleUtil.getValueOf("비밀번호를 입력해주세요: ");
        if(memo.getPassword().equals(password)) {
            System.out.println("기존 메모 : \n" + memo.getPost());
            String updatedPost = consoleUtil.getValueOf("메모를 수정해주세요: \n");
            memo.setPost(updatedPost);
            System.out.println("수정 완료되었습니다.");
        } else {
            System.out.println("비밀번호가 일치하지 않습니다.");
        }
    }

    public void delete() {

    }
}
