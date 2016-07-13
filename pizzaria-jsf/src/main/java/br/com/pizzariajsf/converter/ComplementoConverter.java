/**
 * 
 */
package br.com.pizzariajsf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.pizzariajsf.dao.ComplementosDAO;
import br.com.pizzariajsf.util.cdi.CDIServiceLocator;
import br.com.pizzariajsf.util.model.Complemento;



/**
 * @author Silvan de Jesus
 *
 */
@FacesConverter(forClass=Complemento.class)
public class ComplementoConverter implements Converter {
	
private ComplementosDAO complementoDAO;
	
	public ComplementoConverter() {
		this.complementoDAO = CDIServiceLocator.getBean(ComplementosDAO.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Complemento retorno = null;

		if (value != null) {
			retorno = this.complementoDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Complemento) value).getId();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}
}
