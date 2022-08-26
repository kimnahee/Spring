package co.knh.prj.notice.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.knh.prj.notice.service.NoticeService;
import co.knh.prj.notice.service.NoticeVO;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService dao;
	
	@Autowired
	private ServletContext servletContext;
	
	@PostMapping("/noticeSelect.do")
	public String noticeSelect(NoticeVO vo, Model model) {
		model.addAttribute("n", dao.noticeSelect(vo));
		dao.noticeHitUpdate(vo);
		return "notice/noticeSelect";
	}
	
	@GetMapping("/noticeSelectList.do")
	public String noticeSelectList(Model model) {
		model.addAttribute("notices", dao.noticeSelectList());
		return "notice/noticeSelectList";
	}
	
	@PostMapping("/noticeInsert.do")
	public String noticeInsert(NoticeVO vo, @RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		//파일 업로드 처리
		String saveFolder = servletContext.getRealPath("/fileUpload"); //저장할 공간 폴더 명
		File sfile = new File(saveFolder); //물리적 저장할 위치
		String oFileName = file.getOriginalFilename(); //넘어온 파일의 이름
		if(!oFileName.isEmpty()) {
			//파일 명 충돌방지를 위한 별명
			String sFileName = UUID.randomUUID().toString() + oFileName.substring(oFileName.lastIndexOf("."));//물리적 위치에 저장할 파일이름
			file.transferTo(new File(sfile, sFileName)); //파일을 물리적 위치에 저장
			vo.setNoticeAttech(oFileName);
			vo.setNoticeAttechDir(saveFolder + File.separator + sFileName); //fileUpload/273747.txt | File.separator 대신 // 사용가능
		}
		dao.noticeInsert(vo);
		return "redirect:noticeSelectList.do";
	}
	
	@RequestMapping("/noticeUpdate.do")
	public String noticeUpdate(NoticeVO vo) {
		vo.setNoticeWriter("바뀜");
		vo.setNoticeId(45);
		dao.noticeUpdate(vo);
		return "redirect:noticeSelectList.do";
	}
	
	@RequestMapping("/noticeSearch.do") //@RequestParam("key") String key, @RequestParam("val") String val
	public String noticeSearch(NoticeVO vo, 
			String key, String val, Model model) {
		key = "3";
		val = "123";
		model.addAttribute("notices", dao.noticeSearch(key, val));
		return "notice/noticeSearch";
	}
	
	@GetMapping("/noticeInsertForm.do")
	public String noticeInsertForm() {
		return "notice/noticeForm";
	}
	
	@RequestMapping(value = "/ajaxNoticeSelect.do", produces = "application/text; charset=UTF-8")
	@ResponseBody //호출한 페이지로 결과를 반환
	public String ajaxNoticeSelect(HttpServletResponse response) {
		String message = "ajax Test를 해봅니다.";
		return message;
	}
	
	@GetMapping("/ajaxTest.do")
	public String ajaxTest() {
		return "notice/ajaxTest";
	}
	
}
