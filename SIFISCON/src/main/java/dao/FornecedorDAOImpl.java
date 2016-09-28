package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import modelo.Fornecedor;
import util.HibernateUtil;

public class FornecedorDAOImpl implements FornecedorDAO {

	public void add(Fornecedor fornecedor) throws Exception {
		Transaction transaction = null;
		Session session = null;
        try {
        	session = HibernateUtil.getSessionFactory().openSession();
        	transaction = session.beginTransaction();
            session.save(fornecedor);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (transaction != null) {
            	transaction.rollback();
            }
            e.printStackTrace();
            throw new Exception("Error ao criar o fornecedor");
        } finally {
            session.flush();
            session.close();
        }		
	}
	
	public Fornecedor getByCNPJ(String cnpj) {
		Fornecedor fornecedor = null;
		Session session = null;
        try {
        	session = HibernateUtil.getSessionFactory().openSession();
        	Query query= session.
        	        createQuery("from Fornecedor where cnpj=:cnpj");
        	query.setParameter("cnpj", cnpj);
        	fornecedor = (Fornecedor) query.uniqueResult();            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return fornecedor;	
	}

	public List<Fornecedor> getAll() {
		 List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
         
         Session session = HibernateUtil.getSessionFactory().openSession();
         try {
        	 fornecedores = session.createQuery("from Fornecedor").list();
             
         } catch (Exception e) {
             e.printStackTrace();
         } finally {
             session.flush();
             session.close();
         }
         return fornecedores;
	}

}
