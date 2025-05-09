package com.woojin.app.board;

import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVO {
	//DTO : Data Transfer Object
	//VO : Value Object (읽기 전용)
	private Long boardNum;
	private String boardTitle;
	private String boardContents;
	private Date boardDate;
	private Long boardHit;
	private String username;
	private List<BoardVO> boardFileVOs;

}
