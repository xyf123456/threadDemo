package com.bdqn.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * ClassName: NioClientHandler
 * create by:  xyf
 * description: TODO
 * create time: 2019/9/30 20:44
 */
public class NioClientHandler implements Runnable {
    private Selector selector;

    public NioClientHandler(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void run() {

        try {
            for (; ; ) {
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
                     *  如果是可读事件
                     */
                    if (selectionKey.isReadable()) {
                        readHandler(selectionKey, selector);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
//        循环读取服务器端响应信息
        String response = "";
        while (socketChannel.read(byteBuffer) > 0) {
//            切换buffer为读模式
            byteBuffer.flip();
//            读取buffer中的内容
            response += StandardCharsets.UTF_8.decode(byteBuffer);
        }
//        将 channel再次注册到selector上，监听他的可读时间
        socketChannel.register(selector, SelectionKey.OP_READ);

        //        将服务器端的响应信息，广播给其他客户端
        if (response.length() > 0) {

            System.out.println("::" + response);
        }
    }
}
