package com.xingyufei.week02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 多线程同步阻塞式IO示例
 *
 * Xingyufei
 *
 * 2020-10-27
 */
public class HttpServer02 {

    public static void main(String[] args) throws IOException {
        final ServerSocket serverSocket = new ServerSocket(8802);
        while(true){
            final Socket socket = serverSocket.accept();
            new Thread(()->service(socket)).start();
        }
    }

    private static void service(Socket socket) {
        try {
            Thread.sleep(20);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            printWriter.println();
            printWriter.write("hello, bio.");
            printWriter.close();
            socket.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
