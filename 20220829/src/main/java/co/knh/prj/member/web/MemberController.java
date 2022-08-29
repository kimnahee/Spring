package co.knh.prj.member.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.knh.prj.member.service.MemberService;
import co.knh.prj.member.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberService service; // dao를 통해 repository에서 결과를 가져옴

	@RequestMapping("/memberList.do")
	public String memberList(Model model) {
		// service 객체를 호출해서 값을 가져오게 처리
		// model에 담아두면 알아서 view page로 이동
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
		if (n != 0) {
			model.addAttribute("meaage", "정상적으로 추가되었습니다.");
		} else {
			model.addAttribute("meaage", "멤버 추가가 실패하였습니다.");
		}
		return "member/memberInsert";
	}

	@RequestMapping("/memberDelete.do")
	public String memberDelete(MemberVO vo, Model model) {
		int n = service.memberInsert(vo);
		if (n != 0) {
			model.addAttribute("meaage", "정상적으로 삭제되었습니다.");
		} else {
			model.addAttribute("meaage", "멤버 삭제가 실패하였습니다.");
		}
		return "member/memberDelete";
	}

	@RequestMapping("/memberUpdate.do")
	public String memberUpdate(MemberVO vo, Model model) {
		int n = service.memberUpdate(vo);
		if (n != 0) {
			model.addAttribute("meaage", "정상적으로 업데이트 되었습니다.");
		} else {
			model.addAttribute("meaage", "멤버 업데이트가 실패하였습니다.");
		}
		return "member/memberUpdate";
	}
	
	@PostMapping("/memberLogin.do")
	public String memberLogin(MemberVO vo, HttpSession session, Model model) {
		vo = service.memberSelect(vo); // 결과를 vo 에 담아주기를 요청
		String viewPage = "member/memberMessage"; // 로그인 실패했을 때 가는 페이지(디폴트)

		if (vo == null) {
			model.addAttribute("message", "아이디 또는 패스워드가 일치하지 않습니다.");
		} else { // 성공 session.setAttribute("id", vo.getMemberId());
			session.setAttribute("name", vo.getMemberName());
			session.setAttribute("author", vo.getMemberId());
			model.addAttribute("message", vo.getMemberName() + "님 환영합니다."); // 로그인이 성공했을때는 홈으로
			viewPage = "home/home"; // = redirect:home.do } return viewPage;
		}
		return viewPage;
	}
	
	
	// ModelAndView 사용 => 잘 사용하지 않음
	/*
	@PostMapping("/memberLogin.do")
	public ModelAndView memberLogin(MemberVO vo, HttpSession session, ModelAndView mv) {
		vo = service.memberSelect(vo);
		if(vo == null) {
			mv.setViewName("member/memberMessage"); //보여줄 페이지 정의
			mv.addObject("message", "아이디 또는 패스워드가 일치하지 않습니다."); //넘겨줄 데이터
		} else {
			session.setAttribute("id", vo.getMemberId());
			session.setAttribute("name", vo.getMemberName());
			session.setAttribute("author", vo.getMemberAuthor());
			mv.setViewName("home/home");
		}
		return mv;
	}
	*/
	@GetMapping("/memberLoginForm.do")
	public String memberLoginForm() {
		return "memberLoginForm";
	}
}
