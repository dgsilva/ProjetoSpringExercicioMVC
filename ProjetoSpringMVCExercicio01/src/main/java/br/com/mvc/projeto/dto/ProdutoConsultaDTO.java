package br.com.mvc.projeto.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProdutoConsultaDTO {
	
	private String idProduto;
	private String nome;
	private String quantidade;
	private String preco;
	private String descricao;

}
