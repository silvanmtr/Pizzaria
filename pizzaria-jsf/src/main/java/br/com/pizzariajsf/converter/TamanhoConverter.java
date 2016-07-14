/**
 * 
 */
package br.com.pizzariajsf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.pizzariajsf.dao.TamanhosDAO;
import br.com.pizzariajsf.util.cdi.CDIServiceLocator;
import br.com.pizzariajsf.util.model.Tamanho;



/**
 * @author Silvan de Jesus
 *
 */
@FacesConverter(forClass=Tamanho.class)
public class TamanhoConverter implements Converter {
	
private TamanhosDAO tamanhoDAO;
	
	public TamanhoConverter() {
		this.tamanhoDAO = CDIServiceLocator.getBean(TamanhosDAO.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Tamanho retorno = null;

		if (value != null) {
			retorno = this.tamanhoDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Tamanho) value).getId();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}
}
