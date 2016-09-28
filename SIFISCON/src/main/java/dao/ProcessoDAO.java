package dao;

import java.util.List;

import modelo.Processo;

public interface ProcessoDAO {
	void add(Processo processo) throws Exception;
	void update(Processo processo);
	void remove(Processo processo);
	List<Processo> getAll();
}
