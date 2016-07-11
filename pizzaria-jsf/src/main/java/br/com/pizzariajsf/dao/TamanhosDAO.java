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
import br.com.pizzariajsf.util.model.Tamanho;

/**
 * @author Silvan de Jesus
 *
 */
public class TamanhosDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Tamanho buscarPeloCodigo(Long codigo) {
		return manager.find(Tamanho.class, codigo);
	}

	public void salvar(Tamanho tamanho) {
		manager.merge(tamanho);
	}

	@SuppressWarnings("unchecked")
	public List<Tamanho> buscarTodos() {
		return manager.createQuery("from Tamanho").getResultList();
	}

	@Transactional
	public void excluir(Tamanho tamanho) throws NegocioException {
		tamanho = buscarPeloCodigo(tamanho.getId());
		try {
			manager.remove(tamanho);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Tamanho não pode ser excluído.");
		}
	}
}
