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

import br.com.pizzariajsf.dao.ComplementosDAO;
import br.com.pizzariajsf.service.NegocioException;
import br.com.pizzariajsf.util.jsf.FacesUtil;
import br.com.pizzariajsf.util.model.Complemento;


/**
 * @author Silvan de Jesus
 *
 */
@Named
@ViewScoped
public class PesquisaComplementosBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	ComplementosDAO complementosDAO;
	
	private List<Complemento> complentos = new ArrayList<>();
	
	private Complemento complementoSelecionado;
	
	public List<Complemento> getComplentos() {
		return complentos;
	}
	
	public void excluir() {
		try {
			complementosDAO.excluir(complementoSelecionado);
			this.complentos.remove(complementoSelecionado);
			FacesUtil.addSuccessMessage("Bebida " + complementoSelecionado.getNome() + " excluído com sucesso.");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	@PostConstruct
	public void inicializar() {
		complentos = complementosDAO.buscarTodos();
	}
	
	public Complemento getComplementoSelecionado() {
		return complementoSelecionado;
	}
	
	public void setComplementoSelecionado(Complemento complementoSelecionado) {
		this.complementoSelecionado = complementoSelecionado;
	}
}
