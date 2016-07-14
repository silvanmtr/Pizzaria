/**
 * 
 */
package br.com.pizzariajsf.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.pizzariajsf.dao.TamanhosDAO;
import br.com.pizzariajsf.service.CadastroPizzaService;
import br.com.pizzariajsf.service.NegocioException;
import br.com.pizzariajsf.util.jsf.FacesUtil;
import br.com.pizzariajsf.util.model.Pizza;
import br.com.pizzariajsf.util.model.Tamanho;
import br.com.pizzariajsf.util.model.TipoPizza;

/**
 * @author Silvan de Jesus
 *
 */
@Named
@ViewScoped
public class CadastroPizzaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pizza pizza;

	private List<Tamanho> TamanhosPizzas;
	
	@Inject
	private CadastroPizzaService cadastroPizzaService;
	
	
	
	@Inject
	private TamanhosDAO tamanhoDAO;
	
	@PostConstruct
	public void inicializar() {
		this.limpar();
		
		this.TamanhosPizzas = this.tamanhoDAO.buscarTodos();
	}
	
	public void salvar() {
		try {
			this.cadastroPizzaService.salvar(pizza);
			FacesUtil.addSuccessMessage("Pizza salvo com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.addErrorMessage("Erro desconhecido. Contatar o administrador");
		}
		
		this.limpar();
	}
	
	public void limpar() {
		this.pizza = new Pizza();
	}
	
	public TipoPizza[] getTipoPizza() {
		return TipoPizza.values();
	}

	public Pizza getPizza() {
		return pizza;
	}
	
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	
	public List<Tamanho> getTamanhosPizzas() {
		return TamanhosPizzas;
	}

}
