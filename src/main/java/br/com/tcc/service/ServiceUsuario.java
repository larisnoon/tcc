package br.com.tcc.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tcc.Exceptions.CriptoExistsException;
import br.com.tcc.Exceptions.EmailExistsException;
import br.com.tcc.dao.UsuarioDao;
import br.com.tcc.model.Usuario;
import br.com.tcc.util.Util;

@Service
public class ServiceUsuario {

	@Autowired
	private UsuarioDao repositorioUsuario;
	
	public void salvarUsuario(Usuario user) throws Exception  {
		try {
			
			if(repositorioUsuario.findByEmail(user.getEmail()) != null) {
				throw new EmailExistsException("Já existe um email cadastrado para " + user.getEmail());
			}
			
			user.setSenha(Util.md5(user.getSenha()));
			
		} catch (NoSuchAlgorithmException e) {
			
			throw new CriptoExistsException("Erro na criptografia da senha");
		}
		
		repositorioUsuario.save(user);
		
	}
}
