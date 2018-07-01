package com.riverluoo;

import org.apache.mina.common.IdleStatus;
import org.apache.mina.common.IoHandlerAdapter;
import org.apache.mina.common.IoSession;

import java.util.Date;

/**
 * @description:
 * @author: wangyang
 * @since: 下午5:44 2018/7/1
 */
public class MyServerHandler extends IoHandlerAdapter {


    @Override
    public void sessionCreated(IoSession session) throws Exception {
        System.out.println(" myhandle : session : 创建");
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        System.out.println("myhandle : session : 打开");
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        System.out.println("myhandle : session  : 关闭  ");
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        System.out.println("myhandle : session  : 空闲");
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        System.out.println("myhandle : 连接异常");
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        String msg= message.toString();
        Date date = new Date();
        System.out.println("myhandle : 接收 ：" + msg);
        session.write(date);
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        System.out.println("myhandle : session : 发送");
    }
}
