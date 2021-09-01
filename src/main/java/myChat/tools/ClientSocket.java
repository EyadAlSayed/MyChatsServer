package myChat.tools;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

public class ClientSocket {

    private static final List<WebSocketSession> sessions = new ArrayList<>();

    public static void addClientSession(WebSocketSession session)
    {
        sessions.add(session);
    }

    public static void removeClientSession(WebSocketSession session) {
       sessions.remove(session);
    }

    public static void  sendMessageTo(InetAddress address, String message) {

        WebSocketSession session = sessions.stream()
                .filter(it -> address.equals(it.getRemoteAddress().getAddress()))
                .findFirst().orElse(null);

        if(session != null){
            try {
                session.sendMessage(new TextMessage(message));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public static InetAddress getInetAddress(String s) {
        try {
            return InetAddress.getByName(s);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static  List<String> getClientIpAddress(){
        ArrayList<String> Ips = new ArrayList<>();
        for (WebSocketSession session : sessions){
            String x = String.valueOf(session.getRemoteAddress().getAddress()).substring(1);
            Ips.add(x);
        }
        return Ips;
    }
}
