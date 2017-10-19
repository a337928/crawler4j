package com.arthur.web.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.RunnableFuture;

/**
 * Created by wangtao on 2017/8/23.
 */
public class ServerAi extends Thread{

   public ServerAi(String name){
       super(name);
   }

    private Map<Integer, Runnable> clients = new HashMap<>();

    public void run(){
        try {
            ServerSocket server = new ServerSocket(5500);

            while (!Thread.currentThread().isInterrupted()){
                Socket socket = server.accept();

                System.out.println("socket host : " + socket.getLocalAddress() + "& port :" + socket.getPort() );

                Thread subThread = new Thread() {

                    private Socket socketClient = socket;

                    @Override
                    public void run() {

                        while (!Thread.currentThread().isInterrupted()){
                            try {
                                Reader  reader = new BufferedReader(
                                    new InputStreamReader(socketClient.getInputStream()));

                                int n = reader.read();
                                if(n == -1){
                                    reader.close();
                                    socketClient.close();
                                    System.out.println("socket is closed");
                                    return;
                                }
                                System.out.println(n);
//

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                };
                subThread.start();
                clients.put(socket.getPort(), subThread);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    private class subSocketServer extends Thread {
//        private Socket socketClient;
//
//        void init(Socket socket){
//            socketClient = socket;
//        }
//
//        @Override
//        public void run() {
//            while (!Thread.currentThread().isInterrupted()){
//                try {
//                    Reader  reader = new BufferedReader(
//                        new InputStreamReader(socketClient.getInputStream()));
//                    System.out.println(reader.read());
//                    reader.close();
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
}
