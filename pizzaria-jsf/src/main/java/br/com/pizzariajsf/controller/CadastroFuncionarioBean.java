/**
 * 
 */
package br.com.pizzariajsf.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.pizzariajsf.service.CadastroFuncionarioService;
import br.com.pizzariajsf.util.jsf.FacesUtil;
import br.com.pizzariajsf.util.model.Endereco;
import br.com.pizzariajsf.util.model.Funcionario;


/**
 * @author Silvan de Jesus
 *
 */
@Named
@ViewScoped
public class CadastroFuncionarioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroFuncionarioService cadastroFuncionarioService;
	
	private Funcionario funcionario;
	
	@PostConstruct
	public void init(){
		this.limpar();
	}
	
	public void limpar(){
		this.funcionario = new Funcionario();
		this.funcionario.setEndereco(new Endereco());
	}
	
	public void salvar(){
		try {
			this.cadastroFuncionarioService.salvar(funcionario);
			FacesUtil.addSuccessMessage("Funcionário inserido com sucesso");
			this.limpar();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
}

