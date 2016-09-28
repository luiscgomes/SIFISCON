package dao;

import java.util.List;

import modelo.Processo;

public interface ProcessoDAO {
	void add(Processo processo) throws Exception;
	void update(Processo processo) throws Exception;;
	void remove(Processo processo) throws Exception;;
	List<Processo> getAll();
	Processo getById(int id);
}
