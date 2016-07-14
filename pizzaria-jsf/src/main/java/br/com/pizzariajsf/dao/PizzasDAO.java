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
import br.com.pizzariajsf.util.model.Pizza;

/**
 * @author Silvan de Jesus
 *
 */
public class PizzasDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Pizza buscarPeloCodigo(Long codigo) {
		return manager.find(Pizza.class, codigo);
	}

	public void salvar(Pizza pizza) {
		manager.merge(pizza);
	}

	@SuppressWarnings("unchecked")
	public List<Pizza> buscarTodos() {
		return manager.createQuery("from Pizza").getResultList();
	}

	@Transactional
	public void excluir(Pizza pizza) throws NegocioException {
		pizza = buscarPeloCodigo(pizza.getId());
		try {
			manager.remove(pizza);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Pizza não pode ser excluída.");
		}
	}
}
