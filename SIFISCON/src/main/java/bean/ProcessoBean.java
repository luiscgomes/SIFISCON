package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.FornecedorDAO;
import dao.FornecedorDAOImpl;
import dao.ProcessoDAO;
import dao.ProcessoDAOImpl;
import modelo.Fornecedor;
import modelo.Processo;

@ManagedBean
@SessionScoped
public class ProcessoBean {	
	private Processo processo = new Processo();
	public String msg = "";
	public String cpnjFornecedor;
	private List<Processo> processos;

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}
	
	public String adicionarProcesso() {
		String str = "processos.xhtml";
        
        try{
        	ProcessoDAO processoDAO = new ProcessoDAOImpl();
        	processo.setNumeroProcesso(processo.gerarNumeroProcesso());
        	processoDAO.add(processo);
        	
        	processo = new Processo();
        }catch(Exception e){              
              str = "processo_incluir.xhtml";
        }
        
        return str;
	}
	
	public void getFornecedorByCNPJ(String cnpj) {
		try{              
            FornecedorDAO fornecedorDAO = new FornecedorDAOImpl();
            Fornecedor fornecedor = fornecedorDAO.getByCNPJ(cnpj);            
            
            if (fornecedor == null) {
            	msg = "Fornecedor não encontrado!";            	
            	processo.setFornecedor(new Fornecedor());
            } else {
            	processo.setFornecedor(fornecedor);
            }
      }catch(Exception e){              
            msg = "Erro ao obter o fornecedor - " + e.getMessage();
      }
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCpnjFornecedor() {
		return cpnjFornecedor;
	}

	public void setCpnjFornecedor(String cpnjFornecedor) {
		this.cpnjFornecedor = cpnjFornecedor;
	}

	public List<Processo> getProcessos() {
		List<Processo> processos = new ArrayList<Processo>();
        
        try{
        	ProcessoDAO processoDAO = new ProcessoDAOImpl();
        	processos =  processoDAO.getAll();
        } catch(Exception e) {
        	
		}

		return processos;

	}
}
