package com.labwork4.beans;

import com.labwork4.DAO.ServiceDAO;
import com.labwork4.entities.Service;
import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.util.List;

/**
 * @author Arkadiy Maklakov
 */
@ManagedBean
public class ServiceController implements Converter {

    private static final Logger logger = Logger.getLogger(ServiceController.class);
    private ServiceDAO serviceDAO;
    private List<Service> serviceList;
    private Service service;

    public ServiceController() {
        serviceDAO = new ServiceDAO(Service.class);
        serviceList = serviceDAO.readAll();
        service = new Service();
    }


    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void add() {
        serviceDAO.create(service);
        logger.info("New service was added successfully!");
    }

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        return serviceDAO.read(Integer.parseInt(s));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        return ((Service)o).getId().toString();
    }
}
