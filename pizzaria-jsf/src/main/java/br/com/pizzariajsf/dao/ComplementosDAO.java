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
import br.com.pizzariajsf.util.model.Complemento;

/**
 * @author Silvan de Jesus
 *
 */
public class ComplementosDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Complemento buscarPeloCodigo(Long codigo) {
		return manager.find(Complemento.class, codigo);
	}

	public void salvar(Complemento complemento) {
		manager.merge(complemento);
	}

	@SuppressWarnings("unchecked")
	public List<Complemento> buscarTodos() {
		return manager.createQuery("from Complemento").getResultList();
	}

	@Transactional
	public void excluir(Complemento complemento) throws NegocioException {
		complemento = buscarPeloCodigo(complemento.getId());
		try {
			manager.remove(complemento);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Complemento não pode ser excluído.");
		}
	}
}
