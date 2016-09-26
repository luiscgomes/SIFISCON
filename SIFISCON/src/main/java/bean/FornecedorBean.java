package bean;

import javax.faces.bean.ManagedBean;

import dao.FornecedorDAO;
import dao.FornecedorDAOImpl;
import modelo.Fornecedor;

@ManagedBean
public class FornecedorBean {
	private Fornecedor fornecedor = new Fornecedor();
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	
	public String adicionarFornecedor() {
		String str = "fornecedores.xhtml";
        
        try{              
              FornecedorDAO fornecedorDAO = new FornecedorDAOImpl();
              fornecedorDAO.add(fornecedor);
        }catch(Exception e){              
              str = "fornecedor_incluir.xhtml";
        }
        
        return str;
     }
}
