package com.utopia.java.lang.io;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author utopia on 2020/5/6
 */

public class NIOServer extends Thread{
    @Override
    public void run() {
        try (Selector selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()){
            serverSocketChannel.bind(new InetSocketAddress(InetAddress.getLocalHost(), 8888));

            // 多路复用非阻塞才有意义
            serverSocketChannel.configureBlocking(false);

            //注册事件
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (true){
                selector.select();//阻塞 channel
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iter = selectionKeys.iterator();
                while (iter.hasNext()){
                    SelectionKey key = iter.next();
                    sayHelloWorld((ServerSocketChannel)key.channel());
                    iter.remove();
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sayHelloWorld(ServerSocketChannel server) throws IOException{
        try (SocketChannel client = server.accept()) {
            client.write(ByteBuffer.wrap("hello".getBytes()));
        }
    }

    public static void main(String[] args) {
        NIOServer nioServer = new NIOServer();
        nioServer.start();
    }
}
