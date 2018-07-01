package com.riverluoo;

import org.apache.mina.common.IoFilterAdapter;
import org.apache.mina.common.IoSession;
import org.apache.mina.common.WriteRequest;

/**
 * @description:
 * @author: wangyang
 * @since: 下午9:48 2018/7/1
 */
public class MyClinetFilter extends IoFilterAdapter {


    @Override
    public void messageReceived(NextFilter nextFilter, IoSession session, Object message) throws Exception {
        System.out.println("MyClinetFilter : 收到");
        nextFilter.messageReceived(session,message);
    }

    @Override
    public void messageSent(NextFilter nextFilter, IoSession session, WriteRequest writeRequest) throws Exception {
        System.out.println("MyClinetFilter : 发送");
        nextFilter.messageSent(session,writeRequest);
    }
}
