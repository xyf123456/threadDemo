package com.bdqn.nio;

import javax.swing.plaf.SliderUI;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * ClassName: NioClient
 * create by:  xyf
 * description: TODO 客户端
 * create time: 2019/9/30 20:33
 */
public class NioClient {

    /**
     * description: TODO 启动
     * create time: 2019/9/30 20:34
     * []
     *
     * @return void
     */
    public void start() throws IOException {
        /**
         * 连接服务器
         */
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8000));

        /**
         * 接受服务器端的相应,通过线程
         * 新开线程，专门负责接受服务器端的响应数据
         */
        Selector selector = Selector.open();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        new Thread(new NioClientHandler(selector)).start();


        /**
         * 向服务器端发送数据
         */
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String result = scanner.nextLine();
            if (result != null && result.length() > 0) {
                socketChannel.write(StandardCharsets.UTF_8.encode(result));
            }
        }


    }

    public static void main(String[] args) throws IOException {
        NioClient nioClient = new NioClient();
        nioClient.start();
    }
}
