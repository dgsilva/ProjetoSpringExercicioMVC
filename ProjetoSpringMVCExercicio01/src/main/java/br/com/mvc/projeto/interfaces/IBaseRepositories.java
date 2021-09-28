package br.com.mvc.projeto.interfaces;

import java.util.List;

public interface IBaseRepositories<T, ID> {

	void create(T obj) throws Exception;

	void update(T obj) throws Exception;

	void delete(T obj) throws Exception;

	List<T> getAll() throws Exception;

	T getByID(ID id) throws Exception;

}
