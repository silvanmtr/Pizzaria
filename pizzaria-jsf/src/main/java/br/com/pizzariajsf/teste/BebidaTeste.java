/**
 * 
 */
package br.com.pizzariajsf.teste;

import javax.inject.Inject;

import br.com.pizzariajsf.dao.BebidasDAO;
import br.com.pizzariajsf.service.NegocioException;
import br.com.pizzariajsf.util.jpa.Transactional;
import br.com.pizzariajsf.util.model.Bebida;

/**
 * @author Silvan de Jesus
 *
 */
public class BebidaTeste {

	/**
	 * @param args
	 * 
	 */
	@Inject
	private static BebidasDAO bebidasDAO;

	
	public static void main(String[] args) throws NegocioException {
		
		Bebida bebida = new Bebida();
		
		bebida.setId(Long.parseLong("1"));
		bebida.setNome("Coca Cola");
		bebida.setEstoque(Integer.parseInt("5"));
		bebida.setEstoqueCarrinho(Integer.parseInt("5"));
		bebida.setPreco(Float.parseFloat("4"));
		
		salvar(bebida);
		
	}
	
	@Transactional
	public static void salvar(Bebida bebida) throws NegocioException{
		if(bebida.getNome() == null || bebida.getNome().trim().equals("")){
			throw new NegocioException("O nome é obrigatório");
		}
		
		bebidasDAO.salvar(bebida);
	}

}
