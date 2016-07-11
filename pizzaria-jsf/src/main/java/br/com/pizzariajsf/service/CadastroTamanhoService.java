/**
 * 
 */
package br.com.pizzariajsf.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.pizzariajsf.dao.TamanhosDAO;
import br.com.pizzariajsf.util.jpa.Transactional;
import br.com.pizzariajsf.util.model.Tamanho;


/**
 * @author Silvan de Jesus
 *
 */

public class CadastroTamanhoService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private TamanhosDAO tamanhosDAO;
		
	@Transactional
	public void salvar(Tamanho tamanho) throws NegocioException{
		if(tamanho.getNome() == null || tamanho.getNome().trim().equals("")){
			throw new NegocioException("O nome é obrigatório");
		}
		this.tamanhosDAO.salvar(tamanho);
	}
}
