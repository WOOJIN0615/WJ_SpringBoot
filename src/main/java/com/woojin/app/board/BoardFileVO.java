package com.woojin.app.board;

import com.woojin.app.files.FileVO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardFileVO  extends FileVO{
	
	private Long boardNum;
}
