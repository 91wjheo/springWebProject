package org.wesley.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.wesley.dao.BoardDAO;
import org.wesley.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	BoardDAO dao;
	
	@Override
	public List<BoardVO> listAll() {
		// TODO Auto-generated method stub
		return dao.listAll();
	}

	@Override
	public void create(BoardVO vo) {
		// TODO Auto-generated method stub
		dao.create(vo);
	}

	@Override
	public BoardVO read(int bno) {
		// TODO Auto-generated method stub
		return dao.read(bno);
	}

	@Override
	public void update(BoardVO vo) {
		// TODO Auto-generated method stub
		dao.update(vo);
	}

	@Override
	public void delete(int bno) {
		// TODO Auto-generated method stub
		dao.delete(bno);

	}

}
