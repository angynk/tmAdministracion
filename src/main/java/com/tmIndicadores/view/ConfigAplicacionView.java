package com.tmIndicadores.view;

import com.tmIndicadores.controller.servicios.AplicacionServicio;
import com.tmIndicadores.model.entity.Aplicacion;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean(name = "configApp")
@ViewScoped
public class ConfigAplicacionView {

    private List<Aplicacion> aplicacionRecords;
    private Aplicacion nuevaAplicacion;
    private Aplicacion aplicacionSeleccionada;


    @ManagedProperty(value="#{AplicacionServicio}")
    private AplicacionServicio aplicacionServicio;

    @ManagedProperty(value="#{MessagesView}")
    private MessagesView messagesView;

    public ConfigAplicacionView() {
    }

    @PostConstruct
    public void init(){
        aplicacionRecords = aplicacionServicio.obtenerAplicaciones();
    }

    public List<Aplicacion> getAplicacionRecords() {
        return aplicacionRecords;
    }

    public void setAplicacionRecords(List<Aplicacion> aplicacionRecords) {
        this.aplicacionRecords = aplicacionRecords;
    }

    public Aplicacion getNuevaAplicacion() {
        return nuevaAplicacion;
    }

    public void setNuevaAplicacion(Aplicacion nuevaAplicacion) {
        this.nuevaAplicacion = nuevaAplicacion;
    }

    public Aplicacion getAplicacionSeleccionada() {
        return aplicacionSeleccionada;
    }

    public void setAplicacionSeleccionada(Aplicacion aplicacionSeleccionada) {
        this.aplicacionSeleccionada = aplicacionSeleccionada;
    }

    public AplicacionServicio getAplicacionServicio() {
        return aplicacionServicio;
    }

    public void setAplicacionServicio(AplicacionServicio aplicacionServicio) {
        this.aplicacionServicio = aplicacionServicio;
    }

    public MessagesView getMessagesView() {
        return messagesView;
    }

    public void setMessagesView(MessagesView messagesView) {
        this.messagesView = messagesView;
    }

    public void actualizarAplicacion(){
        if(camposCompletos(aplicacionSeleccionada)){
            aplicacionServicio.actualizarAplicacion(aplicacionSeleccionada);
            messagesView.info(Messages.MENSAJE_EXITOSA,"Aplicación actualizada");
        }
    }

    public void crearAplicacion(){
        if(camposCompletos(nuevaAplicacion)){
            aplicacionServicio.nuevaAplicacion(nuevaAplicacion);
            aplicacionRecords = aplicacionServicio.obtenerAplicaciones();
            messagesView.info(Messages.MENSAJE_EXITOSA,"Aplicación creada");
        }
    }

    private boolean camposCompletos(Aplicacion app) {
        if(app.getCodigo()!=0 && app.getNombre()!=null){
            return true;
        }
        return false;
    }

    public void cancelar(){
        nuevaAplicacion = new Aplicacion();
    }

    public void crearNuevaApp(){
        nuevaAplicacion = new Aplicacion();
    }
}
