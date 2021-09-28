package br.com.mvc.projeto.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import br.com.mvc.projeto.entities.Produto;

public class ProdutoRepository implements IProdutoRepository {
	private JdbcTemplate jdbcTemplate;

	public ProdutoRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(Produto obj) throws Exception {
		String query = "insert into produto(nome,quantidade,preco,descricao) values(?,?,?,?)";
		
		Object[] params={
			obj.getNome(),
			obj.getQuantidade(),
			obj.getPreco(),
			obj.getDescricao()
		};
		jdbcTemplate.update(query, params);

	}

	@Override
	public void update(Produto obj) throws Exception {
		String query = "update produto set nome=?,quantidade=?,preco=?,descricao=?where idProduto=?";
		
		Object[] params= {
				obj.getNome(),
				obj.getQuantidade(),
				obj.getPreco(),
				obj.getDescricao(),
				obj.getIdProduto()
		};
		jdbcTemplate.update(query, params);

	}

	@Override
	public void delete(Produto obj) throws Exception {
		String query = "delete from produto where idProduto = ?";
		Object[] params = {
			obj.getIdProduto()
		};
		
		jdbcTemplate.update(query, params);

	}

	@Override
	public List<Produto> getAll() throws Exception {
		String query = "select * from produto order by nome desc";
		List<Produto> lista = jdbcTemplate.query(query, new RowMapper<Produto>() {
			@Override
			public Produto mapRow(ResultSet rs, int rowNum) throws SQLException {
				Produto produto = new Produto();

				produto.setIdProduto(rs.getInt("idProduto"));
				produto.setNome(rs.getString("nome"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setPreco(rs.getDouble("preco"));
				produto.setDescricao(rs.getString("descricao"));

				return produto;
			}
		});
		return lista;
	}

	@Override
	public Produto getByID(Integer id) throws Exception {
		String query = "select * from produto order by nome desc";
		
		Object[] params = { id };
		
		List<Produto> lista = jdbcTemplate.query(query, new RowMapper<Produto>() {
			@Override
			public Produto mapRow(ResultSet rs, int rowNum) throws SQLException {
				Produto produto = new Produto();

				produto.setIdProduto(rs.getInt("idProduto"));
				produto.setNome(rs.getString("nome"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setPreco(rs.getDouble("preco"));
				produto.setDescricao(rs.getString("descricao"));

				return produto;
			}
		});
		
		if (lista != null && lista.size() == 1) {
			return lista.get(0);
		} else {
			return null;
		}
	}

	private Produto getProduto(ResultSet rs) throws SQLException{
		
		Produto produto = new Produto();

		produto.setIdProduto(rs.getInt("idProduto"));
		produto.setNome(rs.getString("nome"));
		produto.setQuantidade(rs.getInt("quantidade"));
		produto.setPreco(rs.getDouble("preco"));
		produto.setDescricao(rs.getString("descricao"));

		return produto;
	}

}
