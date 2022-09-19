package com.wuying.javaweb.tomcat.test01;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    
    // 存放静态资源
    public static final String WEB_ROOT =
            System.getProperty("user.dir") + File.separator  + "java_question_bank";
    // 关闭Server的请求
    public static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
    
    // 是否关闭Server
    private boolean shutdown = false;
    
    public void await() {
        // 启动ServletSocket
        ServerSocket serverSocket = null;
        int port = 8080;

        try {
            // backlog是队列长度
            // InetAddress.getByName("127.0.0.1")设定绑定的Ip地址
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
            // 无论程序正在执行与否都退出
            System.exit(1);
        }
        
        // 循环等待一个request
        while (!shutdown) {
            Socket socket = null;
            InputStream input = null;
            OutputStream output = null;
            
            // 创建Socket
            try {
                socket = serverSocket.accept();
                input = socket.getInputStream();
                output = socket.getOutputStream();
                
                // 封装input到request，并处理请求
                Request request = new Request(input);
                request.parse();
                
                // 封装output至response
                Response response = new Response(output);
                response.setRequest(request);
                response.sendStaticResource();
                
                // 关闭socket
                socket.close();
                
                // 如果接受的是关闭请求，则设置关闭监听request的标志
                shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
                
                
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }
}
