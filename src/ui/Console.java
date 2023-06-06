package ui;

import entity.Memo;
import exception.MemoNotFoundException;
import service.MemoService;
import service.MemoServiceLogic;
import store.MemoList;
import util.ConsoleUtil;

import java.util.ArrayList;

public class Console {
    private ConsoleUtil consoleUtil;

    private MemoService memoService;

    public Console() {
        this.consoleUtil = new ConsoleUtil();
        this.memoService = new MemoServiceLogic();
    }

    public void register() {
        ArrayList<Memo> memos = memoService.getMemos();
        int postNum = memos.size();
        String name = consoleUtil.getValueOf("name");
        String password = consoleUtil.getValueOf("password");
        String post = consoleUtil.getValueOf("post");
        Memo memo = new Memo(postNum + 1, name, password, post);
        memoService.register(memo);
    }

    public void read() { // 메모 조회 기능
        ArrayList<Memo> memos = memoService.getMemos();
        if (memos.size() != 0) {
            for (int i = memos.size() - 1; i > -1; i--) {
                System.out.println(memos.get(i));
            }
        } else if (memos.size() == 0) {
            System.out.println("메모 목록에 메모가 없습니다. 메모를 등록해주세요.");
        }
    }

    private Memo findOne(){
        int postNum = Integer.parseInt(consoleUtil.getValueOf("수정할 글 번호를 입력해주세요"));
        return memoService.find(postNum)
                .orElseThrow(() -> new MemoNotFoundException(postNum + "번에 해당하는 메모가 존재하지 않습니다."));
    }

    public void update() {
        Memo memo = null;
        try {
            memo = findOne();
        } catch(MemoNotFoundException e){
            System.out.println(e.getMessage());
            return;
        }
        String password = consoleUtil.getValueOf("비밀번호를 입력해주세요");
        if (memo.getPassword().equals(password)) {
            System.out.println("기존 메모 : " + memo.getPost());
            String updatedPost = consoleUtil.getValueOf("수정된 메모");
            memo.setPost(updatedPost);
            System.out.println("수정 완료되었습니다.");
        } else {
            System.out.println("비밀번호가 일치하지 않습니다.");
        }
    }

    public void delete() {
        Memo memo = findOne();
        //findOne을 불러서 delete 할 게시글을 탐색
        if (memo == null) {
            System.out.println("해당 게시글이 존재하지 않습니다.");
            return;
        }//만약 memo가 null이라면 sout 출력

        System.out.println("게시글 삭제");
        String password = consoleUtil.getValueOf("비밀번호 입력");
        //sout이 출력되고 비밀번호 입력하기
        //consoleUtil에 있는 getValueOf는 불러와서 password 입력할 수 있게 해줌?

        if (!password.equals(memo.getPassword())) {
            System.out.println("비밀번호가 틀립니다.");
            return;
        }

        memoService.remove(memo.getPostNum() - 1);
        System.out.println("게시글이 성공적으로 삭제되었습니다.");
        // getPostNum(게시물 넘버) 삭제 완료??!
    }
}
