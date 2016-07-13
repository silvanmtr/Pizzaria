/**
 * 
 */
package br.com.pizzariajsf.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.pizzariajsf.service.CadastroComplementoService;
import br.com.pizzariajsf.util.jsf.FacesUtil;
import br.com.pizzariajsf.util.model.Complemento;

/**
 * @author Silvan de Jesus
 *
 */
@Named
@ViewScoped
public class CadastroComplementoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroComplementoService cadastroComplementoService;

	private Complemento complemento;

	@PostConstruct
	public void init() {
		this.limpar();
	}

	public void limpar() {
		this.complemento = new Complemento();
	}

	public void salvar() {
		try {
			this.cadastroComplementoService.salvar(complemento);
			FacesUtil.addSuccessMessage("Complemento inserido com sucesso");
			this.limpar();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Complemento getComplemento() {
		return complemento;
	}

	public void setComplemento(Complemento complemento) {
		this.complemento = complemento;
	}

}
