package org.study.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class TcpClientHanlder extends IoHandlerAdapter {
    @Override
    public void sessionCreated(IoSession session) throws Exception {
        System.out.println("sessionCreated");
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        session.write("hello");
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        System.out.println("clientReceived: " + message.toString());
        session.write("clientReceived: " + message.toString());
    }
}
