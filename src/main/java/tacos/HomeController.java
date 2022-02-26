package tacos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")		// 루트경로의 GET요청 처리
	public String home() {
		return "home";		// 뷰 이름 반환
	}
}
