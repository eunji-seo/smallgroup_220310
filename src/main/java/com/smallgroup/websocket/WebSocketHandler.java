package com.smallgroup.websocket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketHandler extends TextWebSocketHandler {

    private static List<WebSocketSession> webSocketSessionList = Collections.synchronizedList(new ArrayList<>());

	private Logger log = LoggerFactory.getLogger(getClass());
	
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("payload : {}",payload);
        for(WebSocketSession sess: webSocketSessionList) {
            sess.sendMessage(message);
        }
    }
    
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    	webSocketSessionList.add(session);
        log.info("접속 성공 => {}", session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    	webSocketSessionList.remove(session);
        log.info("접속 해제=>{}", session);
    }
}
