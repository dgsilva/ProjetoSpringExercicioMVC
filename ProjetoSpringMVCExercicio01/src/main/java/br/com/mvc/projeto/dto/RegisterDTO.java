package br.com.mvc.projeto.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterDTO {
	
	private String nome;
	private String email;
	private String senha;
	private String senhaConfirmacao;

}
