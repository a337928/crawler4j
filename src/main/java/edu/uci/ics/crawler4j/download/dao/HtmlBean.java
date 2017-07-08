package edu.uci.ics.crawler4j.download.dao;

/**
 * Created by wangtao on 2017/7/8.
 */
public class HtmlBean {
    private String url;
    private String title;
    private String body;
    private String keys;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}
