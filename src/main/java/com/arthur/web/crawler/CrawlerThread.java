package com.arthur.web.crawler;

/**
 * Created by 数脉科技
 * user : wangtao
 * date : 2017/8/12
 *
 */
public class CrawlerThread extends Thread {
    private final static String thread = "thread";
    public CrawlerThread(String url){
        super(thread + url);
    }

    public void run(){

    }
}
