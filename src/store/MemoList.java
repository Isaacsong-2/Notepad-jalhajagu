package store;

import entity.Memo;

import java.util.ArrayList;
import java.util.Optional;

public class MemoList {
    private ArrayList<Memo> memos;

    public MemoList() {
        this.memos = new ArrayList<>();
    }

//    @Override
    public void create(Memo memo) {
        memos.add(memo);
    }

    public Optional<Memo> retrieve(int postNum) {
        for(Memo memo : memos) {
            if(memo.getPostNum() == postNum) {
                return Optional.of(memo);
            }
        }
        return Optional.empty();
    }

//    @Override
    public void delete(int postNum) {

    }

//    @Override
    public ArrayList<Memo> getMemos() {
        return null;
    }
}
