package co.knh.prj.notice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import co.knh.prj.notice.service.NoticeService;
import co.knh.prj.notice.vo.NoticeVO;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService dao;
	
	@RequestMapping("/noticeList.do")
	public String noticeList(Model model) {
		//앞쪽:jsp에 전달할 변수명, 뒷쪽:jsp에 전달할 정보(데이터)
		model.addAttribute("notice", dao.noticeList());
		return "notice/noticeList";
	}
	
	/*
	 * //modelandview
	 * 
	 * @RequestMapping("/noticeSelect.do") public ModelAndView noticeSelect(NoticeVO
	 * vo, ModelAndView mv) { mv.addObject("notice", dao.noticeSelect(vo));
	 * mv.setViewName("notice/noticeSelect"); //view 선택 return mv; }
	 */
	
	@RequestMapping("/noticeForm.do")
	public String noticeForm() {
		return "notice/noticeForm";
	}
	
	@PostMapping("/noticeInsert.do")
	public String noticeInsert(NoticeVO vo, MultipartFile mFile){ //첨부파일 x(multipart:파일 업로드에 사용)
		//첨부파일 등록 처리
		
		dao.noticeInsert(vo);
		return "redirect:noticeList.do"; //글 목록으로 돌아가기
		//redirect : dispatcher Servlet이 controller로부터 받은 반환값을 view resolver가 아니라 handler Mapper로 보냄
		//요청이 들어왔다고 인식 : 처리된 후에 noticeList.do 를 수행함
	}
	
}
