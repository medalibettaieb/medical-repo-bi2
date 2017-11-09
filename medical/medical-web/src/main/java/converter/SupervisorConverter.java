package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import ctr.SupervisorBean;
import persistence.Supervisor;

@FacesConverter("tc")
public class SupervisorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
			return null;
		}
		SupervisorBean supervisorBean = context.getApplication().evaluateExpressionGet(context, "#{supervisorBean}",
				SupervisorBean.class);
		Supervisor supervisor = supervisorBean.doFindSupervisorByName(value);

		return supervisor;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		String string = null;
		if (value instanceof Supervisor) {
			string = ((Supervisor) value).getName();
		}

		return string;
	}

}
