package co.knh.prj;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(Locale locale, Model model) {
		return "user/home/home";
	}
	
	@RequestMapping("/main.do")
	public String main() {
		return "main/home";
	}
	
	@GetMapping("/userHome.do")
	public String user() {
		return "user/home/home";
	}
	
	@GetMapping("/about.do")
	public String about() {
		return "user/home/about";
	}
	
	@GetMapping("/course.do")
	public String course() {
		return "user/home/course";
	}
}
