package br.com.mvc.projeto.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
	
	private Integer idProduto;
	private String nome;
	private Integer quantidade;
	private Double preco;
	private String descricao;
	
	
}