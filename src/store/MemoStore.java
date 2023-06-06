package store;

import entity.Memo;

import java.util.ArrayList;
import java.util.Optional;

public interface MemoStore {
    void create(Memo memo);

    Optional<Memo> retrieve(int postNum);


    void delete(int postNum);

    ArrayList<Memo> getMemos();

}

