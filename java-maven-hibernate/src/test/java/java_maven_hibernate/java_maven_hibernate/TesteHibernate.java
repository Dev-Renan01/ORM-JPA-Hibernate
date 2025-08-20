package java_maven_hibernate.java_maven_hibernate;

import org.junit.Test;

import dao.DaoGeneric;
import model.UsuarioPessoa;

public class TesteHibernate {

	//@Test
	public void testeHibernateUtil() {
		HibernateUtil.getEntityManager();
	}

	@Test
	public void testarSalvar() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

		UsuarioPessoa pessoa = new UsuarioPessoa();

		pessoa.setNome("Suany Severina");
		pessoa.setSobrenome("da Silva");
		pessoa.setEmail("susu@gmail.com");
		pessoa.setIdade(19);
		pessoa.setLogin("susu");
		pessoa.setSenha("7777");

		daoGeneric.salvar(pessoa);
	}

}
