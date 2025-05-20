package com.woojin.app.websocket;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MessageVO {
	
	private Long chatNum;
	private Long roomNum;
	private String sender;
	private String receiver;
	private String body;
	private String date;
	private String status;
	private boolean readStatus;
}
