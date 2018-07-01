package com.riverluoo;

import org.apache.mina.common.ConnectFuture;
import org.apache.mina.common.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * @description:
 * @author: wangyang
 * @since: 下午6:36 2018/7/1
 */
public class MinaClinet {



    private static String host="127.0.0.1";

    private static int port=7081;

    public static void main(String[] args) {
        IoSession session=null;

        NioSocketConnector connector = new NioSocketConnector();

        connector.setConnectTimeout(3000);

        connector.getFilterChain().addLast("coderc",new ProtocolCodecFilter(
                new TextLineCodecFactory(Charset.forName("UTF-8"),
                        LineDelimiter.MAC.getValue(),
                        LineDelimiter.MAC.getValue())
        ));
        connector.setHandler(new MyClinetHandler());
        ConnectFuture future = connector.connect(new InetSocketAddress(host, port));
        future.awaitUninterruptibly();

        session=future.getSession();
        session.write("hello");
        session.getCloseFuture().awaitUninterruptibly();

        connector.dispose();

    }
}
