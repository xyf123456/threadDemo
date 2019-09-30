package com.bdqn.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * ClassName: {@link NioServer}
 * Description: TODO 服务器端
 * Author: xyf
 * Date 2019/9/30 10:59
 */
public class NioServer {
    /**
     * Description: TODO 启动方法
     * param: []
     * return: void
     * Date: 2019/9/30 11:04
     */
    public void start() throws IOException {

        /**
         *  1、创建Selector
                */
        Selector selector = Selector.open();
        /**
         *  2、通过ServerSocketChannel创建Channel对象
         */
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        /**
         *  3、为Channel对象通道绑定监听端口
         */
        serverSocketChannel.bind(new InetSocketAddress(8000));
        /**
         *  4、设置Channel对象为非阻塞模式
         */
        serverSocketChannel.configureBlocking(false);
        /**
         *  5、将Channel对象注册到Selector上，监听连接对象
         */
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务器端启动成功！");
        /**
         *  6、循环等待新接入的连接
         */
        for (; ; ) {
            // todo 获取可用的chnnel的数量
            int readyChannels = selector.select();
            // todo 为啥要这么做？
            if (readyChannels == 0) continue;
            //获取可用的chnnel的集合
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                //selectionKey的实例
                SelectionKey selectionKey = iterator.next();
//                移除当前的selectionKey
                iterator.remove();
                /**
                 *  7、根据就绪的状态，调用对应的方法处理逻辑
                 */
                /**
                 *  如果是接入事件
                 */
                if (selectionKey.isAcceptable()){
                    acceptHandler(serverSocketChannel,selector);
                }
                /**
                 *  如果是可读事件
                 */
                if (selectionKey.isReadable()){
                    readHandler(selectionKey,selector);
                }
            }
        }

    }

    /**
     * Description: TODO 接入事件
     * param: [serverSocketChannel]
     * return: void
     * Date: 2019/9/30 11:38
     */
    /**
     * Description: TODO
     * param: [serverSocketChannel, selector]
     * return: void
     * Date: 2019/9/30 11:41
     */
    public void acceptHandler(ServerSocketChannel serverSocketChannel,
                              Selector selector) throws IOException {

//       创建SocketChannel
        SocketChannel socketChannel = serverSocketChannel.accept();
//       将SocketChannel设置为非阻塞工作模式
        socketChannel.configureBlocking(false);
//       将SocketChannel对象注册到Selector上，监听，可读事件
        socketChannel.register(selector, SelectionKey.OP_READ);
//       回复客户端的提示信息
        socketChannel.write(StandardCharsets.UTF_8.encode("你和聊天室的其他人都不是朋友关系，请注意隐私安全！"));
    }

    /**
     * Description: TODO 可读事件
     * param: []
     * return: void
     * Date: 2019/9/30 11:20
     */
    public void readHandler(SelectionKey selectionKey, Selector selector) throws IOException {
//        要从SelectionKey中获取到已经就绪的channel
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
//        创建buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//        循环读取客户端请求信息
        String request = "";
        while (socketChannel.read(byteBuffer) > 0) {
//            切换buffer为读模式
            byteBuffer.flip();
//            读取buffer中的内容
            request += StandardCharsets.UTF_8.decode(byteBuffer);
        }
//        将 channel再次注册到selector上，监听他的可读时间
        socketChannel.register(selector, SelectionKey.OP_READ);

        if (request.length() > 0) {
            //        将客户端发送的请求信息，广播给其他客户端
            System.out.println("::"+request);
        }
    }

    public static void main(String[] args) throws IOException {
        NioServer nioServer = new NioServer();
        nioServer.start();
    }
}
