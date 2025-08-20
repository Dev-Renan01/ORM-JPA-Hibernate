package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java_maven_hibernate.java_maven_hibernate.HibernateUtil;

public class DaoGeneric<E> {

	private EntityManager entityManager = HibernateUtil.getEntityManager();
	
	
	public void salvar(E entidade) {
		
		EntityTransaction transacao = entityManager.getTransaction(); // niciar uma transação / processo
		transacao.begin();
		
		entityManager.persist(entidade); // Persistir / salvar
		
		transacao.commit(); // Salvar no banco de dados
	}
	
}
