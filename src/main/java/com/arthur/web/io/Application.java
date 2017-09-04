package com.arthur.web.io;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangtao on 2017/8/22.
 */
public class Application {

    private static List<Socket> sockets = new ArrayList<>(10);


    public static void main(String[] args) {

        try {
            for(int i = 0; i < 10; i ++){
                Socket socket = new Socket("127.0.0.1",5500);
                sockets.add(socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
