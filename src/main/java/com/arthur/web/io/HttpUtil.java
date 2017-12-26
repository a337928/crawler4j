package com.arthur.web.io;

/**
 * Created by wangtao on 2017/8/22.
 */
public class HttpUtil {
    public static String compositeRequest(String host){

        return "GET / HTTP/1.1\r\n" +
               "Host: " + host + "\r\n" +
               "User-Agent: curl/7.43.0\r\n" +
               "Accept: */*\r\n\r\n";
    }
}
