/**
 * 
 */
package br.com.pizzariajsf.util.model;

/**
 * @author Silvan de Jesus
 *
 */
public enum TipoPizza {
	SALGADA("Salgada"),
	DOCE("Doce");
	
	private String descricao;
	
	
	TipoPizza(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
