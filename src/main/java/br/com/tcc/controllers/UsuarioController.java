package br.com.tcc.controllers;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tcc.dao.UsuarioDao;
import br.com.tcc.model.Cachorro;
import br.com.tcc.model.Usuario;
import br.com.tcc.service.ServiceExc;
import br.com.tcc.service.ServiceUsuario;
import br.com.tcc.util.Util;
import jakarta.servlet.http.HttpSession;

@Controller("/")
public class UsuarioController {
	
//	@Autowired
//	private UsuarioDao usuarioRepositorio;
	
	@Autowired
	private ServiceUsuario serviceUsuario;
	
	@GetMapping("/")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Login/login");
		return mv;
	}
	
	@GetMapping("/index")
	public ModelAndView index() {
	ModelAndView mv = new ModelAndView();
	mv.setViewName("home/index");
	mv.addObject("cachorro", new Cachorro());
	return mv;
	}

	@GetMapping("/cadastro")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario", new Usuario());
		mv.setViewName("Login/cadastro");
		return mv;
	}
	
	@PostMapping("salvarUsuario")
		public ModelAndView cadastrar(Usuario usuario) throws Exception {
		ModelAndView mv = new ModelAndView();
		serviceUsuario.salvarUsuario(usuario);
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@PostMapping("/login")
	public ModelAndView login(Usuario usuario, BindingResult br, HttpSession session) throws NoSuchAlgorithmException, ServiceExc {
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario", new Usuario());
		if(br.hasErrors()) {
			mv.setViewName("Login/login");
		
		} 
		
		Usuario userLogin = serviceUsuario.loginUser(usuario.getUser(), Util.md5(usuario.getSenha()));
		if(userLogin == null) {
			mv.addObject("msg", "Usuário não encontrato. Tente novamente");
		} else {
		session.setAttribute("usuarioLogado", userLogin);
			return index();
		}
		return mv;
	}
}
