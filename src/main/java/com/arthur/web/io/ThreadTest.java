package com.arthur.web.io;

/**
 * Created by wangtao on 2017/8/23.
 */
public class ThreadTest {
    public static void main(String[] args) {
        ServerAi serverAi = new ServerAi("ai");
        serverAi.start();
    }
}
