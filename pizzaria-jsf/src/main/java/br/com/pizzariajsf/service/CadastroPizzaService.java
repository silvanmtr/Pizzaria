/**
 * 
 */
package br.com.pizzariajsf.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.pizzariajsf.dao.PizzasDAO;
import br.com.pizzariajsf.util.jpa.Transactional;
import br.com.pizzariajsf.util.model.Pizza;


/**
 * @author Silvan de Jesus
 *
 */

public class CadastroPizzaService implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private PizzasDAO pizzaDAO;
		
	@Transactional
	public void salvar(Pizza pizza) throws NegocioException{
		if(pizza.getNome() == null || pizza.getNome().trim().equals("")){
			throw new NegocioException("O nome é obrigatório");
		}
		this.pizzaDAO.salvar(pizza);
	}
}
