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

import br.com.pizzariajsf.service.CadastroClienteService;
import br.com.pizzariajsf.util.jsf.FacesUtil;
import br.com.pizzariajsf.util.model.Cliente;
import br.com.pizzariajsf.util.model.Endereco;


/**
 * @author Silvan de Jesus
 *
 */
@Named
@ViewScoped
public class CadastroClienteBean implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroClienteService cadastroBebidaService;
	
	private Cliente cliente;
	private Endereco endereco;
	
	
	@PostConstruct
	public void init(){
		this.limpar();
	}
	
	@SuppressWarnings("unchecked")
	public void limpar(){
		this.cliente = new Cliente();
		this.cliente.setEnderecos((List<Endereco>) new Endereco());
	}
	
	public void salvar(){
		try {
			this.cadastroBebidaService.salvar(cliente);
			FacesUtil.addSuccessMessage("Cliente inserida com sucesso");
			this.limpar();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}	
}

