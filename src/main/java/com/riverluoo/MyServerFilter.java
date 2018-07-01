package com.riverluoo;

import org.apache.mina.common.IoFilterAdapter;
import org.apache.mina.common.IoSession;
import org.apache.mina.common.WriteRequest;

/**
 * @description:
 * @author: wangyang
 * @since: 下午9:43 2018/7/1
 */
public class MyServerFilter extends IoFilterAdapter {


    @Override
    public void messageReceived(NextFilter nextFilter, IoSession session, Object message) throws Exception {
        System.out.println("MyServerFilter : 收到");
        nextFilter.messageReceived(session,message);
    }

    @Override
    public void messageSent(NextFilter nextFilter, IoSession session, WriteRequest writeRequest) throws Exception {
        System.out.println("MyServerFilter : 发送");
        nextFilter.messageSent(session,writeRequest);
    }
}
