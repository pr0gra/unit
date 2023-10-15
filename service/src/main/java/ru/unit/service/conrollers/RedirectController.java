package ru.unit.service.conrollers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.unit.service.securiry.PersonDetails;

@Controller
@RequestMapping("/redirect")
public class RedirectController {

	@GetMapping("/user")
	public String redirect(@AuthenticationPrincipal PersonDetails PersonDetals) {
		return "redirect:/user/" + PersonDetals.getPerson().getId();
	}
	
}
