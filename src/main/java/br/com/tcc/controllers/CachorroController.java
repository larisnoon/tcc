package br.com.tcc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tcc.dao.CachorroDao;
import br.com.tcc.model.Cachorro;

@Controller
public class CachorroController {
	
	@Autowired
	private CachorroDao cachorrorepositorio;

	@GetMapping("/inserirCachorros")
	public ModelAndView InsertCachorros(Cachorro cachorro){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Cachorro/formularioCachorro");
		mv.addObject("cachorro", new Cachorro());
		return mv;
	}
	
	@PostMapping("InsertCachorros")
	public ModelAndView inserirCachorro(Cachorro cachorro) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/cachorros-adicionados");
		cachorrorepositorio.save(cachorro);
		return mv;
	}
	
	@GetMapping ("cachorros-adicionados")
	public ModelAndView listagemCachorros(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Cachorro/listCachorros");
        mv.addObject("cachorrosList", cachorrorepositorio.findAll());
		return mv;
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Cachorro/alterar");
		Cachorro cachorro = cachorrorepositorio.getReferenceById(id);
		mv.addObject("cachorro", cachorro);
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Cachorro cachorro) {
		ModelAndView mv = new ModelAndView();
		cachorrorepositorio.save(cachorro);
		mv.setViewName("redirect:/cachorros-adicionados");
		return mv;
	}
	
	@GetMapping("excluir/{id}")
	public String excluir(@PathVariable("id") Integer id) {
		cachorrorepositorio.deleteById(id);
		return "redirect:/cachorros-adicionados";
	}
	
}
