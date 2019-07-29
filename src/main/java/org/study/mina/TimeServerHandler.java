package org.study.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class TimeServerHandler extends IoHandlerAdapter {
    private int count = 0;

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        String mes = message.toString();
        if (mes.trim().equalsIgnoreCase("quit") || count > 2) {
            System.out.println("退出服务器, count=" + count);
            session.write("退出服务器, count=" + count);
            session.close();
            return;
        }

        session.write(count);
        System.out.println("messageReceived: " + mes + ", count=" + count);
        count++;
    }
}
