package br.com.mvc.projeto.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import br.com.mvc.projeto.entities.Usuario;
import br.com.mvc.projeto.interfaces.IUsuarioRepository;

public class UsuarioRepository implements IUsuarioRepository {

	private JdbcTemplate jdbcTemplate;

	public UsuarioRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(Usuario obj) throws Exception {
		String query = "insert into usuario(nome,email,senha) values(?,?,md5(?))";

		Object[] params = { obj.getNome(), obj.getEmail(), obj.getSenha(), };
		jdbcTemplate.update(query, params);

	}

	@Override
	public void update(Usuario obj) throws Exception {
		String query = "update usuario set nome=?,email=?,senha=md5(?) where idUsuario=?";

		Object[] params = { obj.getNome(), obj.getEmail(), obj.getSenha(), obj.getIdUsuario(), };
		jdbcTemplate.update(query, params);

	}

	@Override
	public void delete(Usuario obj) throws Exception {
		String query = "delete from usuario where idUsuario = ?";
		Object[] params = { obj.getIdUsuario() };

		jdbcTemplate.update(query, params);

	}

	@Override
	public List<Usuario> getAll() throws Exception {
		String query = "select * from usuario order by nome desc";
		List<Usuario> lista = jdbcTemplate.query(query, new RowMapper<Usuario>() {
			@Override
			public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
				return getUsuario(rs);
			}
		});
		return lista;
	}

	@Override
	public Usuario getByID(Integer id) throws Exception {
		String query = "select * from usuario where idusuario = ?";

		Object[] params = { id };

		List<Usuario> lista = jdbcTemplate.query(query, params, new RowMapper<Usuario>() {
			@Override
			public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
				return getUsuario(rs);
			}
		});
		if (lista != null && lista.size() == 1) {
			return lista.get(0);
		} else {
			return null;
		}
	}


	@Override
	public Usuario get(String email) throws Exception {
		String query = "select * from usuario where email = ?";

		Object[] params = { email };

		List<Usuario> lista = jdbcTemplate.query(query, params, new RowMapper<Usuario>() {
			@Override
			public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
				return getUsuario(rs);
			}
		});
		if (lista != null && lista.size() == 1) {
			return lista.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Usuario get(String email, String senha) throws Exception {
		
		String query = "select * from usuario where email = ?  and senha = md5(?)";

		Object[] params = { email, senha };

		List<Usuario> lista = jdbcTemplate.query(query, params, new RowMapper<Usuario>() {
			@Override
			public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
				return getUsuario(rs);
			}
		});
		if (lista != null && lista.size() == 1) {
			return lista.get(0);
		} else {
			return null;
		}
	}

	private Usuario getUsuario(ResultSet rs) throws SQLException {
		
		Usuario usuario = new Usuario();
		
		usuario.setIdUsuario(rs.getInt("idUsuario"));
		usuario.setNome(rs.getString("nome"));
		usuario.setEmail(rs.getString("email"));
		usuario.setSenha(rs.getString("senha"));
		
		return usuario;
	}
}
