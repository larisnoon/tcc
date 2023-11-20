package br.com.tcc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tcc.model.Cachorro;

@Controller
public class CachorroController {

	@GetMapping("/inserirCachorros")
	public ModelAndView InsertCachorros(Cachorro cachorro){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Cachorro/formularioCachorro");
		mv.addObject("cachorro", new Cachorro());
		return mv;
	}
}
