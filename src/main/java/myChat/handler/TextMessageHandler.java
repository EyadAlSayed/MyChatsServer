package myChat.handler;

import myChat.tools.ClientSocket;
import myChat.models.TxtMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import java.net.InetAddress;
import java.util.Objects;


public class TextMessageHandler extends TextWebSocketHandler {


    private final Logger logger = LoggerFactory.getLogger(TextMessageHandler.class);

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {

        logger.info("Connection Established  With Device " + session.getRemoteAddress() + " for Text messages ..");
        ClientSocket.addClientSession(session);

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        logger.info("Connection Closed With Device " + session.getRemoteAddress() + " for Text messages ..");
         ClientSocket.removeClientSession(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message)  {

        TxtMessage msg = TxtMessage.getReceivedMessageFormat(message.getPayload());
        InetAddress receiver = ClientSocket.getInetAddress(Objects.requireNonNull(msg).getTo());

        logger.info("Message received from : " + session.getRemoteAddress());
        logger.info("Message send to : "+ msg.getTo());
        ClientSocket.sendMessageTo(receiver,msg.getSendMessageFormat());

    }




}