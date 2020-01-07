package org.wesley.service;

import java.util.List;

import org.wesley.domain.BoardVO;
import org.wesley.domain.PagingCriteria;

public interface BoardService {

	// list
	public List<BoardVO> listAll();
	
	//pagingList
	public List<BoardVO> pagingList(PagingCriteria cri);
	
	// crud
	public  void create(BoardVO vo);
	
	public BoardVO read(int bno);
	
	public void update(BoardVO vo);
	
	public void delete(int bno);
	
	
}
