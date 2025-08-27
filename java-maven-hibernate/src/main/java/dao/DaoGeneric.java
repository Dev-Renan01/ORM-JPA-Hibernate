package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java_maven_hibernate.java_maven_hibernate.HibernateUtil;

public class DaoGeneric<E> {

	// Gerenciar entidades e permitir interagir com o banco de dados 
	private EntityManager entityManager = HibernateUtil.getEntityManager();
	
	
	public void salvar(E entidade) {
		
		EntityTransaction transacao = entityManager.getTransaction(); // Inicia uma transação / processo
		transacao.begin();
		
		entityManager.persist(entidade); // Persistir / salvar	
		transacao.commit(); // Salvar no banco de dados
	} 
	
	
	public E updateMerge(E entidade) { // Salva ou atualiza
		
		EntityTransaction transacao = entityManager.getTransaction();
		transacao.begin();
		
		E entidadeSalva = entityManager.merge(entidade);
		transacao.commit();
		
		return entidadeSalva;
		
	}
	
	
	public E pesquisar(E entidade) {
				
		Object id = HibernateUtil.getPrimaryKey(entidade); // Indantificar o id
		
		E e =  (E) entityManager.find(entidade.getClass(), id);// Buscar
		
		return e;
	}
	
	
	public void deletarPorId(E entidade) {
		 
		Object id = HibernateUtil.getPrimaryKey(entidade); // Indantificar o id
		
		EntityTransaction transacao = entityManager.getTransaction();
		transacao.begin();
		
		entityManager.createNativeQuery("delete from usuario_pessoa  where id =" + id).executeUpdate(); // Mandar um SQL direto para o banco de dados
		
		transacao.commit();
	}
	
	
	public List<E> listar(Class<E> entidade){
		
		EntityTransaction transacao = entityManager.getTransaction();
		transacao.begin();
		
		List<E> listar = entityManager.createQuery("from " + entidade.getName()).getResultList();
		
		transacao.commit();
		
		return listar;
	}
	
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
}
