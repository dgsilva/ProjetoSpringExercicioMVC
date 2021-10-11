package br.com.mvc.projeto.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.mvc.projeto.dto.LoginDTO;
import br.com.mvc.projeto.dto.RegisterDTO;
import br.com.mvc.projeto.entities.Usuario;
import br.com.mvc.projeto.interfaces.IUsuarioRepository;


@Controller
public class UsuarioControllers {
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@RequestMapping(value = "/")//URL
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login"); //Página.jsp
		modelAndView.addObject("dto", new LoginDTO());
		return modelAndView;
	}
	
	@RequestMapping(value = "/autenticar-usuario")//URL
	public ModelAndView autenticar(LoginDTO dto, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("login"); //Página.jsp

		try {
			
			Usuario usuario = usuarioRepository.get(dto.getEmail(), dto.getSenha());
			
			if(usuario == null) {
				throw new Exception("Acesso negado usuário invalido");
			}
			
			request.getSession().setAttribute("usuario_autenticado", usuario);
			
			modelAndView.setViewName("redirect:home");
			
		}catch (Exception e) {

		}
		
		return modelAndView;
	}

	
	@RequestMapping(value = "/register")//URL
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView("register"); //Página.jsp
		modelAndView.addObject("dto", new RegisterDTO());
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/cadastrar-usuario", method = RequestMethod.POST)//URL
	public ModelAndView cadastrarUsuario(RegisterDTO dto) {
		ModelAndView modelAndView = new ModelAndView("register"); //Página.jsp
		
		try {
			
			if(!dto.getSenha().equals(dto.getSenhaConfirmacao())) {
				throw new Exception("Senhas não conferem.");
			}
			
			if(usuarioRepository.get(dto.getEmail()) != null) {
			throw new Exception("O email informado já está cadastrado, tente outro.");
			}
			
			
			Usuario usuario = new Usuario();
			
			usuario.setNome(dto.getNome());
			usuario.setEmail(dto.getEmail());
			usuario.setSenha(dto.getSenha());
			
			usuarioRepository.create(usuario);
			
			modelAndView.addObject("mensagem_sucesso", "Sua conta de usuário foi criada com sucesso!");
			dto = new RegisterDTO();
			
		}catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}
		modelAndView.addObject("dto", dto);
		return modelAndView;
	}

	@RequestMapping(value = "/password-recover")//URL
	public ModelAndView passwordUpdate() {
		ModelAndView modelAndView = new ModelAndView("password-recover"); //Página.jsp
		modelAndView.addObject("dto", new LoginDTO());
		return modelAndView;
	}

}
