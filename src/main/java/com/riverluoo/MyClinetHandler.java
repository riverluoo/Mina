package com.riverluoo;

import org.apache.mina.common.IdleStatus;
import org.apache.mina.common.IoHandlerAdapter;
import org.apache.mina.common.IoSession;

/**
 * @description:
 * @author: wangyang
 * @since: 下午6:43 2018/7/1
 */
public class MyClinetHandler extends IoHandlerAdapter {


    @Override
    public void sessionCreated(IoSession session) throws Exception {
        System.out.println("session : 关闭");
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        System.out.println("session : 打开");
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        System.out.println("session : 关闭");
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        System.out.println("session : 空闲");
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        System.out.println("连接异常");
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        String mag=message.toString();
        System.out.println(mag);



    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        System.out.println("发送");
    }
}
