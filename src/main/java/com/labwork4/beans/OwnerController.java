package com.labwork4.beans;

import com.labwork4.DAO.OwnerDAO;
import com.labwork4.entities.Owner;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.util.List;

/**
 * @author Arkadiy Maklakov
 */
@ManagedBean
public class OwnerController implements Converter {

    private OwnerDAO ownerDAO;

    private List<Owner> ownerList;

    public OwnerController() {
        ownerDAO = new OwnerDAO(Owner.class);
        ownerList = ownerDAO.readAll();
    }


    public List<Owner> getOwnerList() {
        return ownerList;
    }

    public void setOwnerList(List<Owner> ownerList) {
        this.ownerList = ownerList;
    }

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        return ownerDAO.read(Integer.parseInt(s));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        return ((Owner)o).getId().toString();
    }
}
