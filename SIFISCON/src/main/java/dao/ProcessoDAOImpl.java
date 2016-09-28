package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import modelo.Fornecedor;
import modelo.Processo;
import util.HibernateUtil;

public class ProcessoDAOImpl implements ProcessoDAO {

	public void add(Processo processo) throws Exception {
		Transaction transaction = null;
		Session session = null;
        try {
        	session = HibernateUtil.getSessionFactory().openSession();
        	transaction = session.beginTransaction();
            session.save(processo);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (transaction != null) {
            	transaction.rollback();
            }
            e.printStackTrace();
            throw new Exception("Error ao criar o processo");
        } finally {
            session.flush();
            session.close();
        }		
	}

	public void update(Processo processo) {
		// TODO Auto-generated method stub
		
	}

	public void remove(Processo processo) {
		// TODO Auto-generated method stub
		
	}

	public List<Processo> getAll() {
		List<Processo> processos = new ArrayList<Processo>();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
       	 processos = session.createQuery("from Processo").list();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return processos;
	}

}
