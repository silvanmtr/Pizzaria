/**
 * 
 */
package br.com.pizzariajsf.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.pizzariajsf.dao.FuncionarioDAO;
import br.com.pizzariajsf.util.jpa.Transactional;
import br.com.pizzariajsf.util.model.Funcionario;


/**
 * @author Silvan de Jesus
 *
 */

public class CadastroFuncionarioService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private FuncionarioDAO funcionarioDAO;
		
	@Transactional
	public void salvar(Funcionario funcionario) throws NegocioException{
		if(funcionario.getNome() == null || funcionario.getNome().trim().equals("")){
			throw new NegocioException("O nome é obrigatório");
		}
		this.funcionarioDAO.salvar(funcionario);
	}
}
