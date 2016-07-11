/**
 * 
 */
package br.com.pizzariajsf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.pizzariajsf.dao.BebidasDAO;
import br.com.pizzariajsf.util.cdi.CDIServiceLocator;
import br.com.pizzariajsf.util.model.Bebida;



/**
 * @author Silvan de Jesus
 *
 */
@FacesConverter(forClass=Bebida.class)
public class BebidaConverter implements Converter {
	
private BebidasDAO bebidasDAO;
	
	public BebidaConverter() {
		this.bebidasDAO = CDIServiceLocator.getBean(BebidasDAO.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Bebida retorno = null;

		if (value != null) {
			retorno = this.bebidasDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Bebida) value).getId();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}
}
