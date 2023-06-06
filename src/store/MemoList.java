package store;

import entity.Memo;

import java.util.ArrayList;
import java.util.Optional;

public class MemoList implements MemoStore {
    private ArrayList<Memo> memos;

    public MemoList() {
        this.memos = new ArrayList<>();
    }

    @Override
    public void create(Memo memo) {
        memos.add(memo);
    }

    @Override
    public Optional<Memo> retrieve(int postNum) {
        for (Memo memo : memos) {
            if (memo.getPostNum() == postNum) {
                return Optional.of(memo);
            }
        }
        return Optional.empty();
    }

    @Override
    public void update(Memo memo) {

    }

    @Override
    public void delete(int postNum) {
        for (int i = postNum; i < memos.size(); i++) {
            memos.get(i).setPostNum(i);
        }
        this.memos.remove(postNum);
    }

    @Override
    public ArrayList<Memo> getMemos() {
        return memos;
    }
}
