package co.knh.prj.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.knh.prj.member.service.MemberService;
import co.knh.prj.member.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberService service; //dao를 통해 repository에서 결과를 가져옴
	
	@RequestMapping("/memberList.do")
	public String memberList(Model model) {
		//service 객체를 호출해서 값을 가져오게 처리
		//model에 담아두면 알아서 view page로 이동
		model.addAttribute("members", service.memberSelectList());
		return "member/memberList";
	}
	
	@RequestMapping("/memberSelect.do")
	public String memberSelect(MemberVO vo, Model model) {
		model.addAttribute("member", service.memberSelect(vo));
		return "member/memberSelect";
	}
	
	@RequestMapping("/memberInsert.do")
	public String memberInsert(MemberVO vo, Model model) {
		int n = service.memberInsert(vo);
		if(n!=0) {
			model.addAttribute("meaage", "정상적으로 추가되었습니다.");
		} else {
			model.addAttribute("meaage", "멤버 추가가 실패하였습니다.");
		}
		return "member/memberInsert";
	}
	
	@RequestMapping("/memberDelete.do")
	public String memberDelete(MemberVO vo, Model model) {
		int n = service.memberInsert(vo);
		if(n!=0) {
			model.addAttribute("meaage", "정상적으로 삭제되었습니다.");
		} else {
			model.addAttribute("meaage", "멤버 삭제가 실패하였습니다.");
		}
		return "member/memberDelete";
	}
	
	@RequestMapping("/memberUpdate.do")
	public String memberUpdate(MemberVO vo, Model model) {
		int n = service.memberUpdate(vo);
		if(n!=0) {
			model.addAttribute("meaage", "정상적으로 업데이트 되었습니다.");
		} else {
			model.addAttribute("meaage", "멤버 업데이트가 실패하였습니다.");
		}
		return "member/memberUpdate";
	}
}
