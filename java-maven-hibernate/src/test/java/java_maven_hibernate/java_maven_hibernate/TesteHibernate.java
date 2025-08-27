package java_maven_hibernate.java_maven_hibernate;

import java.util.List;
import org.junit.Test;
import dao.DaoGeneric;
import model.UsuarioPessoa;

public class TesteHibernate {

	// @Test
	public void testeHibernateUtil() {

		HibernateUtil.getEntityManager();
	}

	// @Test
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

	// @Test
	public void testeBuscar() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

		UsuarioPessoa pessoa = new UsuarioPessoa();
		pessoa.setId(52L);

		pessoa = daoGeneric.pesquisar(pessoa);

		System.out.println(pessoa);
	}

	// @Test
	public void testeUpdate() { // buscar usuário e mostrar as atualizações / antes e depois

		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

		UsuarioPessoa pessoa = new UsuarioPessoa();

		pessoa.setId(2L);
		pessoa = daoGeneric.pesquisar(pessoa);
		System.out.println("Usuário atual -> " + pessoa);

		pessoa.setNome("suany");
		pessoa.setIdade(25);
		pessoa.setSenha("2222");

		pessoa = daoGeneric.updateMerge(pessoa);

		System.out.println("Atualizações -> " + pessoa);

	}

	// @Test
	public void testeDelete() {

		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

		UsuarioPessoa pessoa = new UsuarioPessoa();

		pessoa.setId(52L);
		pessoa = daoGeneric.pesquisar(pessoa);
		System.out.println(pessoa);

		daoGeneric.deletarPorId(pessoa);
		System.out.println("Deletado com sucesso!");
	}

	@Test
	public void testeListar() {

		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

		List<UsuarioPessoa> list = daoGeneric.listar(UsuarioPessoa.class);

		for (UsuarioPessoa pessoa : list) {
			System.out.println(pessoa);
			System.out.println("---------------------------------------------------");
		}

	}

}