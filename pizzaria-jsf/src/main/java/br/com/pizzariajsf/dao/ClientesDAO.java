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
import br.com.pizzariajsf.util.model.Cliente;

/**
 * @author Silvan de Jesus
 *
 */
public class ClientesDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Cliente buscarPeloCodigo(Long codigo) {
		return manager.find(Cliente.class, codigo);
	}

	public void salvar(Cliente cliente) {
		manager.merge(cliente);
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> buscarTodos() {
		return manager.createQuery("from Cliente").getResultList();
	}

	@Transactional
	public void excluir(Cliente cliente) throws NegocioException {
		cliente = buscarPeloCodigo(cliente.getId());
		try {
			manager.remove(cliente);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Cliente não pode ser excluído.");
		}
	}
}
