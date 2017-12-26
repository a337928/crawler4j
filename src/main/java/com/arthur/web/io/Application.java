package com.arthur.web.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangtao on 2017/8/22.
 */
public class Application {

    private static List<Thread> sockets = new ArrayList<>(10);


    public static void main(String[] args) {

        try {
            for(int i = 0; i < 2; i ++){
                Thread subThread = new Thread(){
                    private Socket socket = new Socket("127.0.0.1",5500);
                    public void run(){
                        OutputStream outputStream = null;
                        Integer i = 0;
                        try {
                            outputStream = socket.getOutputStream();
                            Writer out = new BufferedWriter(new OutputStreamWriter(outputStream));
                            while (true){
                                if(i > 10){
                                    out.close();
                                    socket.close();
                                    return;
                                }
                                out.write(i ++ );
                                out.flush();
                                try {
                                    sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                };


                subThread.start();
//                out.close();
                sockets.add(subThread);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
