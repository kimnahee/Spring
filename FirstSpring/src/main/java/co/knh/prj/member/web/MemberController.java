package co.knh.prj.member.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //member 관리 controller
public class MemberController {
	
	@GetMapping("memberList.do")
	public String memberList() {
		return "member/memberList";
	}
	
	@RequestMapping("memberSearch.do")
	public String memberSearch(){
		return "member/memberSearch";
	}
	
	@RequestMapping("memberInsert.do")
	public String memberInsert() {
		return "member/memberInsert";
	}
}
