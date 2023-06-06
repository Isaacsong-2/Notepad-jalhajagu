package service;

import entity.Memo;

import java.util.ArrayList;
import java.util.Optional;

public interface MemoService {
    void register(Memo memo);

    Optional<Memo> find(int postNum);


    void remove(int postNum);

    ArrayList<Memo> getMemos();
}
