package com.smallgroup.websocket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class WebSocketHandler extends TextWebSocketHandler {


    private static Map<String, List<WebSocketSession>> sessionMap = Collections.synchronizedMap(new HashMap<>());

	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ObjectMapper om; //
	
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception { // 메세지가 왔을때 동
        String payload = message.getPayload(); // 5 //8
        
        log.info("payload : {}",payload);
        ChatMsg cm = om.readValue(payload, ChatMsg.class);
        log.info("cm =>{}", cm);

       
        String id = cm.getId(); // meet.id
        if(!sessionMap.containsKey(id)) {
        	sessionMap.put(id, new ArrayList<>()); // 불필요한 메모리는 만들지 않고, 그때 생성한다 relagiz loading != free loading(@compoent, @Service, @repository, Map 선언)

        }
        List<WebSocketSession> sessionList = sessionMap.get(id);
        if(cm.getCmd().equals("open")) {
        	sessionList.add(session);
        }
        for(WebSocketSession sess: sessionList) { // 7
            sess.sendMessage(message);
        }
    }
    
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception { //2.  접속 세션 들어감
    	//webSocketSessionList.add(session);
        log.info("접속 성공 => {}", session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    	Iterator<String> it = sessionMap.keySet().iterator();
    	while(it.hasNext()) {
    		String id = it.next();
    		List<WebSocketSession> sessionList = sessionMap.get(id);
    		if(sessionList.contains(session)) {
    			sessionList.remove(session);
    		}

    		for(WebSocketSession ws:sessionList) {
    			ChatMsg cm = new ChatMsg();
    			cm.setCmd("close");
    			
    			session.sendMessage(null);
    		}
    	}
    }
}