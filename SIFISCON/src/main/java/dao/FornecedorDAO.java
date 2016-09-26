package dao;

import java.util.List;

import modelo.Fornecedor;

public interface FornecedorDAO {
	void add(Fornecedor fornecedor) throws Exception;
	List<Fornecedor> getAll();
}
