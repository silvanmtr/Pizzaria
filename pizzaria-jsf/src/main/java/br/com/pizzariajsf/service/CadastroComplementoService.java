/**
 * 
 */
package br.com.pizzariajsf.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.pizzariajsf.dao.ComplementosDAO;
import br.com.pizzariajsf.util.jpa.Transactional;
import br.com.pizzariajsf.util.model.Complemento;


/**
 * @author Silvan de Jesus
 *
 */

public class CadastroComplementoService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private ComplementosDAO complementoDAO;
		
	@Transactional
	public void salvar(Complemento complemento) throws NegocioException{
		if(complemento.getNome() == null || complemento.getNome().trim().equals("")){
			throw new NegocioException("O nome é obrigatório");
		}
		this.complementoDAO.salvar(complemento);
	}
}
