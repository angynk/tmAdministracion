package com.tmIndicadores.view;

import com.tmIndicadores.controller.servicios.RoleServicio;
import com.tmIndicadores.model.entity.Role;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("roleConverter")
public class RoleConverter implements Converter {

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                RoleServicio service = (RoleServicio) fc.getExternalContext().getApplicationMap().get("roleService");
                return service.getRoleList().get(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Role) object).getNombre());
        }
        else {
            return null;
        }
    }
}