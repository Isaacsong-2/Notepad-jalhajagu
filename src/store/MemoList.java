package store;

import entity.Memo;

import java.util.ArrayList;

public class MemoList {
    private ArrayList<Memo> memos;

    public MemoList() {
        this.memos = new ArrayList<>();
    }

    //    @Override
    public void create(Memo memo) {
        memos.add(memo);
    }

    //    @Override
    public Memo retrieve(int postNum) {
        return null;
    }

    //    @Override
    public void update(Memo updateMemo) {
    }

    //    @Override
    public void delete(int postNum) {

    }

    //    @Override
    public ArrayList<Memo> getMemos() {
        return memos;
    }
}
