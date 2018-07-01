package com.riverluoo;


import org.apache.mina.common.IdleStatus;
import org.apache.mina.common.IoAcceptor;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * @description:
 * @author: wangyang
 * @since: 下午5:14 2018/7/1
 */
public class MinaServer {

    static int PORT = 7081;

    static IoAcceptor acceptor = null;

    public static void main(String[] args) {
        try {
            acceptor = new NioSocketAcceptor();
            // 编码过滤器
            acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(
                    new TextLineCodecFactory(Charset.forName("UTF-8"),
                            LineDelimiter.MAC.getValue(),
                            LineDelimiter.MAC.getValue())
            ));

            acceptor.getSessionConfig().setReadBufferSize(1024);
            acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
            acceptor.setHandler(new MyHandler());

            acceptor.bind(new InetSocketAddress(PORT));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("server : " + PORT);

    }

}
