/**
 * 
 */
package br.com.pizzariajsf.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.pizzariajsf.dao.BebidasDAO;
import br.com.pizzariajsf.service.NegocioException;
import br.com.pizzariajsf.util.jsf.FacesUtil;
import br.com.pizzariajsf.util.model.Bebida;


/**
 * @author Silvan de Jesus
 *
 */
@Named
@ViewScoped
public class PesquisaBebidaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	BebidasDAO bebidaDAO;
	
	private List<Bebida> bebidas = new ArrayList<>();
	
	private Bebida bebidaSelecionada;
	
	public List<Bebida> getBebidas() {
		return bebidas;
	}
	
	public void excluir() {
		try {
			bebidaDAO.excluir(bebidaSelecionada);
			this.bebidas.remove(bebidaSelecionada);
			FacesUtil.addSuccessMessage("Bebida " + bebidaSelecionada.getNome() + " excluído com sucesso.");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	@PostConstruct
	public void inicializar() {
		bebidas = bebidaDAO.buscarTodos();
	}
	public Bebida getBebidaSelecionada() {
		return bebidaSelecionada;
	}
	
	public void setBebidaSelecionada(Bebida bebidaSelecionada) {
		this.bebidaSelecionada = bebidaSelecionada;
	}
}
