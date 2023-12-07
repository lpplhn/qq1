package com.example.qq1;



public class Msg {
    private String content;//消息内容
    private int type;//消息类行（发的1和收的0）
    public static final int TYPE_RECEIVED=0;
    public static final int TYPE_SENT=1;

    public Msg(String content, int type) {
        this.content=content;
        this.type=type;
    }

    public int getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
}