package com.xingyufei.week02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 同步阻塞IO模式，多线程线程池模式
 *
 * Xingyufei
 *
 * 2020-10-27
 */
public class HttpServer03 {

    private static ExecutorService executorService = Executors.newFixedThreadPool(40);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8803);
        while(true){
            Socket socket = serverSocket.accept();
            executorService.execute(() -> service(socket));
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}