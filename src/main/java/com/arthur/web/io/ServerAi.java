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

/**
 * Created by wangtao on 2017/8/23.
 */
public class ServerAi extends Thread{

   public ServerAi(String name){
       super(name);
   }

    public void run(){
        try {
            ServerSocket server = new ServerSocket(5500);

            while (!Thread.currentThread().isInterrupted()){
                Socket socket = server.accept();


//                InputStream inputStream = socket.getInputStream();
//
//
//                //Reader  reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                int data = inputStream.read();
//                while (data != -1){
//                    Character character = (char)data;
//                    System.out.print(character);
//                    data = inputStream.read();
//                }

                OutputStream outputStream =  socket.getOutputStream();
                Writer out = new BufferedWriter(new OutputStreamWriter(outputStream));
                out.write("success");
                out.flush();

                outputStream.close();

//                inputStream.close();



            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
