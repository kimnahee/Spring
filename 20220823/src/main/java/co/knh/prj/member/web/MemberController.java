package co.knh.prj.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.knh.prj.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService dao; //memberservice를 dao로 자동주입(의존주입)
	
	@RequestMapping("/memberList.do")
	public String memberList(Model model) { //model 객체(model interface) : 처리된 결과를 페이지에 전달
		model.addAttribute("members", dao.memberSelectList()); //멤버 목록 결과를 members에 담음(모델 인터페이스가 수행)
		return "member/memberList";
	}
	
}
