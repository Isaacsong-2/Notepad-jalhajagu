package service;

import entity.Memo;
import store.MemoList;
import store.MemoStore;

import java.util.ArrayList;
import java.util.Optional;

public class MemoServiceLogic implements MemoService {

    MemoStore memoStore;

    public MemoServiceLogic() {
        this.memoStore = new MemoList();
    }

    @Override
    public void register(Memo memo) {
        this.memoStore.create(memo);
    }

    @Override
    public Optional<Memo> find(int postNum) {
        return this.memoStore.retrieve(postNum);
    }

    @Override
    public void modify(Memo memo) {
        this.memoStore.update(memo);
    }

    @Override
    public void remove(int postNum) {
        this.memoStore.delete(postNum);
    }

    @Override
    public ArrayList<Memo> getMemos(){
        return this.memoStore.getMemos();
    }
}
