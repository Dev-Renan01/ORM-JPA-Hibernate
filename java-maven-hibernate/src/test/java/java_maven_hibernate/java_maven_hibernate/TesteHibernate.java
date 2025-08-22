package java_maven_hibernate.java_maven_hibernate;

import org.junit.Test;

import dao.DaoGeneric;
import model.UsuarioPessoa;

public class TesteHibernate {

	//@Test
	public void testeHibernateUtil() {
		HibernateUtil.getEntityManager();
	}

	//@Test
	public void testarSalvar() {
		
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

		UsuarioPessoa pessoa = new UsuarioPessoa();

		pessoa.setNome("Bruno Oliveira");
		pessoa.setSobrenome("Campos");
		pessoa.setEmail("br@gmail.com");
		pessoa.setIdade(32);
		pessoa.setLogin("bruno");
		pessoa.setSenha("1122");

		daoGeneric.salvar(pessoa);
		
		System.out.println(pessoa + "Salvo(a) com sucesso!");
	}
	
	@Test
	public void testeBuscar() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		pessoa.setId(52L);
		 
		pessoa = daoGeneric.pesquisar(pessoa);
		
		System.out.println(pessoa);
	}

}
