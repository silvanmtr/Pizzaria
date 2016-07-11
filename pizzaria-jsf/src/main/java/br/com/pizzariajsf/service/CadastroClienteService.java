/**
 * 
 */
package br.com.pizzariajsf.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.pizzariajsf.dao.ClientesDAO;
import br.com.pizzariajsf.util.jpa.Transactional;
import br.com.pizzariajsf.util.model.Cliente;


/**
 * @author Silvan de Jesus
 *
 */

public class CadastroClienteService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private ClientesDAO clientesDAO;
		
	@Transactional
	public void salvar(Cliente cliente) throws NegocioException{
		if(cliente.getNome() == null || cliente.getNome().trim().equals("")){
			throw new NegocioException("O nome é obrigatório");
		}
		this.clientesDAO.salvar(cliente);
	}
}
