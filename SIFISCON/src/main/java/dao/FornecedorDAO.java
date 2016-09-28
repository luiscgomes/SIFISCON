package dao;

import java.util.List;

import modelo.Fornecedor;

public interface FornecedorDAO {
	void add(Fornecedor fornecedor) throws Exception;
	Fornecedor getByCNPJ(String cnpj);
	List<Fornecedor> getAll();
}
