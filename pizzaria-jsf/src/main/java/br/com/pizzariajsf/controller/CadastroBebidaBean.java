/**
 * 
 */
package br.com.pizzariajsf.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.pizzariajsf.service.CadastroBebidaService;
import br.com.pizzariajsf.util.jsf.FacesUtil;
import br.com.pizzariajsf.util.model.Bebida;


/**
 * @author Silvan de Jesus
 *
 */
@Named
@ViewScoped
public class CadastroBebidaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroBebidaService cadastroBebidaService;
	
	private Bebida bebida;
	
	@PostConstruct
	public void init(){
		this.limpar();
	}
	
	public void limpar(){
		this.bebida = new Bebida();
	}
	
	public void salvar(){
		try {
			this.cadastroBebidaService.salvar(bebida);
			FacesUtil.addSuccessMessage("Bebida inserida com sucesso");
			this.limpar();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public Bebida getBebida() {
		return bebida;
	}
	
	public void setBebida(Bebida bebida) {
		this.bebida = bebida;
	}
	
}

