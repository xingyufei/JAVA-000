package com.xingyufei.week02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * 单线程同步阻塞式IO示例
 *
 * Xingyufei
 *
 * 2020-10-27
 */
public class HttpServer01 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8801);
        while(true){
            Socket socket = serverSocket.accept();
            service(socket);
        }
    }

    private static void service(Socket socket) {
        try {
            TimeUnit.MILLISECONDS.sleep(20);
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