package entity;

import util.DateUtil;

public class Memo {
    private int postNum;
    private String name;
    private String password;
    private String post;
    private String time;

    public Memo(int postNum, String name, String password, String post) {
        this.postNum = postNum;
        this.name = name;
        this.password = password;
        this.post = post;
        this.time = DateUtil.today();
    }

    public int getPostNum() {
        return postNum;
    }

    public void setPostNum(int postNum) {
        this.postNum = postNum;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPost(String post) {
        this.post = post;
        this.time = DateUtil.today();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("글 번호 : " + postNum + "  ");
        builder.append("작성자 이름 : " + name + "\n");
        builder.append(post + "\n");
        builder.append("작성시간 : " + time + "\n");
        builder.append("-----------------------------------");
        builder.toString();
        return builder.toString();
    }
}
