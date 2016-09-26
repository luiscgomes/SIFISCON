package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.FornecedorDAO;
import dao.FornecedorDAOImpl;
import modelo.Fornecedor;

@ManagedBean
public class FornecedorBean {
	private Fornecedor fornecedor = new Fornecedor();
	
	private List<Fornecedor> fornecedores;
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
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
	
	public List<FornecedorBean> getListaFornecedores(){
        List<FornecedorBean> fornecedores = new ArrayList<FornecedorBean>();
        
        try{
        	FornecedorDAO fornecedorDAO = new FornecedorDAOImpl();
        	
        	for(Fornecedor fornecedor : fornecedorDAO.getAll()){

        		FornecedorBean bean = new FornecedorBean();
        		bean.setFornecedor(fornecedor);
        		
        		fornecedores.add(bean);
        	}

        } catch(Exception e) {
        	
		}

		return fornecedores;
	}
}
