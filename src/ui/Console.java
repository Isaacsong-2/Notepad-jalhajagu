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
        int postNum = Integer.parseInt(consoleUtil.getValueOf("수정할 글 번호를 입력해주세요"));
        return memoList.retrieve(postNum)
                .orElseThrow(() -> new MemoNotFoundException(postNum + "번에 해당하는 메모가 존재하지 않습니다."));
    }
//    private Memo findOne() {
//        Memo memo = null;
//        // 초기값을 주지 않으면 쓰레기값이 들어감, 필수
//        int postNum = Integer.parseInt(consoleUtil.getValueOf("수정하실 글의 번호를 입력해주세요"));
//        // Integer.parseInt 문자열을 정수형으로 변환하는 역할, 게시글 번호를 나타내는 값
//        // consoleUtil.getValueOf의 값(수정할 글 번호)를 불러옴
//
//        memo = memoList.retrieve(postNum);
//        //memo는 memoList에 있는 retrieve(int postNum)이다
//
//        if (memo == null) {
//            System.out.println("해당 게시글이 존재하지 않습니다.");
//        } else {
//            System.out.println(memo.toString());
//            //else는 게시글이 존재할 때 memo.toString() = memo 객체의 내용을 가지고 있는 문자열을 반환
//            //-> 게시글 번호 나옴?
//
//        }
//        return memo;
//    }
    public void update() {
        Memo memo = findOne();
        String password = consoleUtil.getValueOf("비밀번호를 입력해주세요");
        if(memo.getPassword().equals(password)) {
            System.out.println("기존 메모 : " + memo.getPost());
            String updatedPost = consoleUtil.getValueOf("수정된 메모");
            memo.setPost(updatedPost);
            System.out.println("수정 완료되었습니다.");
        } else {
            System.out.println("비밀번호가 일치하지 않습니다.");
        }
    }1

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

        memoList.delete(memo.getPostNum());
        System.out.println("게시글이 성공적으로 삭제되었습니다.");
        // getPostNum(게시물 넘버) 삭제 완료??!
    }
}
