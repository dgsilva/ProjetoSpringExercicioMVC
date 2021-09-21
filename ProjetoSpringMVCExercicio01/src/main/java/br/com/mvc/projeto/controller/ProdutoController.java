package br.com.mvc.projeto.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProdutoController {

	@RequestMapping(value="cadastro-tarefa")
	public ModelAndView cadastro(HttpServletResponse response) throws IOException{
		return new ModelAndView("cadastro-tarefa");
	}
	
	@RequestMapping(value="consulta-tarefa")
	public ModelAndView consultar(HttpServletResponse response) throws IOException{
		return new ModelAndView("consulta-tarefa");
	}
	
	@RequestMapping(value="edicao-tarefa")
	public ModelAndView edicao(HttpServletResponse response) throws IOException{
		return new ModelAndView("edicao-tarefa");
	}
	
	@RequestMapping(value="relatorio-tarefa")
	public ModelAndView relatorio(HttpServletResponse response) throws IOException{
		return new ModelAndView("relatorio-tarefa");
	}
}
