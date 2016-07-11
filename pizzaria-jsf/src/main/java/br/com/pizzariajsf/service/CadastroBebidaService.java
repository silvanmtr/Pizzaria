/**
 * 
 */
package br.com.pizzariajsf.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.pizzariajsf.dao.BebidasDAO;
import br.com.pizzariajsf.util.jpa.Transactional;
import br.com.pizzariajsf.util.model.Bebida;


/**
 * @author Silvan de Jesus
 *
 */

public class CadastroBebidaService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private BebidasDAO bebidasDAO;
		
	@Transactional
	public void salvar(Bebida bebida) throws NegocioException{
		if(bebida.getNome() == null || bebida.getNome().trim().equals("")){
			throw new NegocioException("O nome é obrigatório");
		}
		this.bebidasDAO.salvar(bebida);
	}
}
