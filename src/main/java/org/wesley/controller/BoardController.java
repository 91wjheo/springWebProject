package org.wesley.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.wesley.domain.BoardVO;
import org.wesley.domain.PagingCriteria;
import org.wesley.service.BoardService;

@Controller
@RequestMapping(value = "/board/*")
public class BoardController {

	@Inject
	BoardService service;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	/*1.  모든리스트 */
	// 메소드 return 타입이 void인 경우에는 현재 경로에 해당하는 jsp파일을 실행한다.
	// -> 즉 /board/listAll을 실행함.
	@RequestMapping(method = RequestMethod.GET, value = "listAll")
	public void listAll(Model model) {
		logger.info("listAll get");
		
		List<BoardVO> list = service.listAll();
		model.addAttribute("list", list);	
	}
	
	/* 1.5 페이징처리된 리스트*/
	@RequestMapping(method = RequestMethod.GET, value = "list")
	public void pagingList(PagingCriteria cri, Model model) {
		// page, perPageNum을 수집해와.
		logger.info(cri.toString());
		
		model.addAttribute("pagingList", service.pagingList(cri));
		
	}
	
	
	
	
	/* 2. 상세조회 */
	// bno를 파라미터로 받아온다.
	@RequestMapping(method=RequestMethod.GET, value = "read")
	public void get(@RequestParam("bno") int bno, Model model) {
		
		logger.info("read page. bno : " + bno);
		model.addAttribute("boardVO", service.read(bno));
		
	}
	
	/* 3. 수정페이지- 화면조회*/
	@RequestMapping(value = "modify", method=RequestMethod.GET)
	public void modify(BoardVO boardVO, Model model) {
		int bno = boardVO.getBno();
		
		logger.info("수정페이지 \n bno : " + bno);
		model.addAttribute("boardVO", service.read(bno));	
	}
	
	/* 4.수정페이지- 수정처리*/
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public String modifySave(BoardVO boardVO, RedirectAttributes rttr) {
		
		// 폼에서 가져오는 데이터를 파라미터로 수집해서 update처리 하고
		// list페이지로 이동시켜준다. 이때 alert을 띄워줌.
		logger.info("수정저장처리");
		logger.info(boardVO.toString());
		
		service.update(boardVO);
		rttr.addFlashAttribute("modifyResult", "success");
		
		return "redirect:/board/listAll";
	}
	
	
	/* 5.삭제처리 */
	@RequestMapping(value = "delete", method=RequestMethod.POST)
	public String delete(@RequestParam("bno") int bno, RedirectAttributes rttr) {
		
		service.delete(bno);
		rttr.addFlashAttribute("deleteResult", "success");
		
		return "redirect:/board/listAll"; 
	}
	
	/* 6. 등록처리 - 페이지조회 */
	@RequestMapping(value="register", method = RequestMethod.GET)
	public void register() {
		logger.info("register get page");
	}
	
	
	/* 7. 등록처리 */
	@RequestMapping(value="register", method = RequestMethod.POST)
	public String registerSave(BoardVO boardVO, RedirectAttributes rttr) {
		logger.info("register save page");
		
		service.create(boardVO);
		rttr.addFlashAttribute("registerResult", "success");
		
		return "redirect:/board/listAll";
	}
	
	
	
	
	
	
	
	
	
}
