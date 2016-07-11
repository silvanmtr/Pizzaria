/**
 * 
 */
package br.com.pizzariajsf.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.com.pizzariajsf.service.NegocioException;
import br.com.pizzariajsf.util.jpa.Transactional;
import br.com.pizzariajsf.util.model.Funcionario;

/**
 * @author Silvan de Jesus
 *
 */
public class FuncionarioDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Funcionario buscarPeloCodigo(Long codigo) {
		return manager.find(Funcionario.class, codigo);
	}

	public void salvar(Funcionario funcionario) {
		manager.merge(funcionario);
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> buscarTodos() {
		return manager.createQuery("from Funcionario").getResultList();
	}

	@Transactional
	public void excluir(Funcionario funcionario) throws NegocioException {
		funcionario = buscarPeloCodigo(funcionario.getId());
		try {
			manager.remove(funcionario);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Funcionário não pode ser excluído.");
		}
	}
}
