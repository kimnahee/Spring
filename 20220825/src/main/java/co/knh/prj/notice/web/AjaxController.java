package co.knh.prj.notice.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.knh.prj.notice.service.NoticeService;
import co.knh.prj.notice.service.NoticeVO;

@RestController //@Controller + @ResponseBody => 호출한 페이지로 결과를 리턴
public class AjaxController {
	@Autowired
	private NoticeService ajaxdao;
	
	@RequestMapping("/ajaxSearch.do")
	public List<NoticeVO> ajaxSearch(@RequestParam String key, @RequestParam String val){
		
		return ajaxdao.noticeSearch(key, val);
	}
}
