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
import br.com.pizzariajsf.util.model.Bebida;

/**
 * @author Silvan de Jesus
 *
 */
public class BebidasDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Bebida buscarPeloCodigo(Long codigo) {
		return manager.find(Bebida.class, codigo);
	}

	public void salvar(Bebida bebida) {
		manager.merge(bebida);
	}

	@SuppressWarnings("unchecked")
	public List<Bebida> buscarTodos() {
		return manager.createQuery("from Bebida").getResultList();
	}

	@Transactional
	public void excluir(Bebida bebida) throws NegocioException {
		bebida = buscarPeloCodigo(bebida.getId());
		try {
			manager.remove(bebida);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Carro não pode ser excluído.");
		}
	}
}
