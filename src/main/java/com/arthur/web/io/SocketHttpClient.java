package com.arthur.web.io;

/**
 * Created by wangtao on 2017/8/22.
 */
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;

public class SocketHttpClient {

    public void start(String host, int port) {

        // 初始化 socket
        Socket socket = new Socket();

        try {
            // 设置 socket 连接
            SocketAddress remote = new InetSocketAddress(host, port);
            socket.setSoTimeout(5000);
            socket.connect(remote);

            // 发起请求
            PrintWriter writer = getWriter(socket);
            System.out.println(HttpUtil.compositeRequest(host));
            writer.write(HttpUtil.compositeRequest(host));
            writer.flush();

            // 读取响应
            String msg;
            InputStreamReader reader = getReader(socket);
            BufferedReader bufferedReader = new BufferedReader(reader);
            while ((msg = new String(bufferedReader.readLine().getBytes(),"GBK")) != null){

                System.out.println(msg);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    private InputStreamReader getReader(Socket socket) throws IOException {
        InputStream in = socket.getInputStream();
        return new InputStreamReader(in);
    }

    private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream out = socket.getOutputStream();
        return new PrintWriter(new OutputStreamWriter(out));
    }

}