package com.smallgroup.websocket;

public class ChatMsg {
	private String cmd;
	private String msg;
	private String chatName;
	
	
	public String getChatName() {
		return chatName;
	}
	public void setChatName(String chatName) {
		this.chatName = chatName;
	}
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "ChatMsg [cmd=" + cmd + ", msg=" + msg + ", chatName=" + chatName + "]";
	}
}
