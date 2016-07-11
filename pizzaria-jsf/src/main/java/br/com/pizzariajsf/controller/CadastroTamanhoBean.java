/**
 * 
 */
package br.com.pizzariajsf.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.pizzariajsf.service.CadastroTamanhoService;
import br.com.pizzariajsf.util.jsf.FacesUtil;
import br.com.pizzariajsf.util.model.Tamanho;


/**
 * @author Silvan de Jesus
 *
 */
@Named
@ViewScoped
public class CadastroTamanhoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroTamanhoService cadastroTamanhoService;
	
	private Tamanho tamanho;
	
	@PostConstruct
	public void init(){
		this.limpar();
	}
	
	public void limpar(){
		this.tamanho = new Tamanho();
	}
	
	public void salvar(){
		try {
			this.cadastroTamanhoService.salvar(tamanho);
			FacesUtil.addSuccessMessage("Tamanho a pizza inserido com sucesso");
			this.limpar();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public Tamanho getTamanho() {
		return tamanho;
	}
	
	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho;
	}
	
}

