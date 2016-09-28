package bean;

import javax.faces.bean.ManagedBean;

import dao.FornecedorDAO;
import dao.FornecedorDAOImpl;
import dao.ProcessoDAO;
import dao.ProcessoDAOImpl;
import modelo.Fornecedor;
import modelo.Processo;

@ManagedBean
public class ProcessoBean {
	private Processo processo = new Processo(new Fornecedor());
	public String msg = "";

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
            	processo.getFornecedor().setCNPJ("");
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
	
	
		
}
