package br.com.mvc.projeto.interfaces;

import br.com.mvc.projeto.entities.Usuario;

public interface IUsuarioRepository extends IBaseRepositories<Usuario, Integer> {

	Usuario get(String email) throws Exception;

	Usuario get(String email, String senha) throws Exception;
}
