package br.com.mvc.projeto.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.mvc.projeto.dto.ProdutoCadastroDTO;
import br.com.mvc.projeto.dto.ProdutoConsultaDTO;
import br.com.mvc.projeto.entities.Produto;
import br.com.mvc.projeto.repositories.IProdutoRepository;

@Controller
public class ProdutoController {

	@Autowired
	private IProdutoRepository IProdutoRepository;
	
	@RequestMapping(value="/cadastro-produto")
	public ModelAndView cadastro(HttpServletResponse response) throws IOException{
	
		ModelAndView modelAndView = new ModelAndView("cadastro-produto");
		
		modelAndView.addObject("dto", new ProdutoCadastroDTO());
		
		return modelAndView;
		
	}
	
	
	@RequestMapping(value="/cadastro-produto", method = RequestMethod.POST)
	public ModelAndView cadastroProduto(ProdutoCadastroDTO dto) throws IOException{
	
		ModelAndView modelAndView = new ModelAndView("cadastro-produto");
		
		modelAndView.addObject("dto", new ProdutoCadastroDTO());

		try {
			
			Produto produto = new Produto();
			produto.setNome(dto.getNome());
			produto.setQuantidade(Integer.parseInt(dto.getQuantidade()));
			produto.setPreco(Double.parseDouble(dto.getPreco()));
			produto.setDescricao(dto.getDescricao());
			
			IProdutoRepository.create(produto);
			
			modelAndView.addObject("mensagem_sucesso", "Produto cadastrado com sucesso.");
			
		}catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}
		return modelAndView;
		
	}
	
	
	@RequestMapping(value="/consulta-produto")
	public ModelAndView consultar(HttpServletResponse response) throws IOException{
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dto" , new ProdutoConsultaDTO());
		
		return modelAndView;
	}


	@RequestMapping(value="/consulta-produto", method = RequestMethod.GET )
	public ModelAndView consultarProduto(ProdutoConsultaDTO dto) throws IOException{
		
		ModelAndView modelAndView = new ModelAndView("consulta-produto");
		
		try {
			
			modelAndView.addObject("produtos", IProdutoRepository.getAll());
			
		}catch (Exception e) {
			modelAndView.addObject("produtos", e.getMessage());
		}
		
		
		
		return modelAndView;
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
