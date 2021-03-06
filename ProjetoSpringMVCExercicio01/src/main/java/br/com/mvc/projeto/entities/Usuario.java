package br.com.mvc.projeto.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
	private Integer idUsuario;
	private String nome;
	private String email;
	private String senha;

}
