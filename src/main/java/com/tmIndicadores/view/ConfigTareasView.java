package com.tmIndicadores.view;

import com.tmIndicadores.controller.servicios.ConfiguracionServicio;
import com.tmIndicadores.model.entity.Role;
import com.tmIndicadores.model.entity.Tarea;
import com.tmIndicadores.model.entity.Usuario;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean(name = "configTareas")
@ViewScoped
public class ConfigTareasView {

    private List<Usuario> usuariosRecords;
    private List<Tarea> tareaRecords;
    private List<String> moduloRecords;
    private Tarea tareaSelected;
    private Tarea nuevaTarea;

    @ManagedProperty(value="#{ConfigService}")
    private ConfiguracionServicio configuracionServicio;

    @ManagedProperty(value="#{MessagesView}")
    private MessagesView messagesView;

    public ConfigTareasView() {
    }

    @PostConstruct
    public void init(){
        tareaRecords = configuracionServicio.getTareaAll();
        usuariosRecords = configuracionServicio.getUsuarioAll();
        moduloRecords = configuracionServicio.getModulosAll();
    }

    public void crearNuevaTarea(){
        nuevaTarea = new Tarea();

    }

    public void  actualizarTarea(){
        Usuario nuevoUsuario = configuracionServicio.getUsuarioById(tareaSelected.getUsuario().getIdNuevo());
        if(nuevoUsuario!=null){
            tareaSelected.setUsuario(nuevoUsuario);
            configuracionServicio.updateTarea(tareaSelected);
            messagesView.info(Messages.MENSAJE_EXITOSA,Messages.ACTUALIZACION_TAREA);
        }
    }

    public void crearTarea(){
        if(nuevaTarea!= null){
            Usuario nuevoUsuario = configuracionServicio.getUsuarioById(nuevaTarea.getIdNuevo());
            if(nuevoUsuario!=null){
                nuevaTarea.setUsuario(nuevoUsuario);
                configuracionServicio.addTarea(nuevaTarea);
                messagesView.info(Messages.MENSAJE_EXITOSA,Messages.CREACION_TAREA);
                tareaRecords = configuracionServicio.getTareaAll();
            }


        }
    }

    public void cancelar(){
        nuevaTarea = new Tarea();
    }

    public List<Usuario> getUsuariosRecords() {
        return usuariosRecords;
    }

    public void setUsuariosRecords(List<Usuario> usuariosRecords) {
        this.usuariosRecords = usuariosRecords;
    }

    public List<Tarea> getTareaRecords() {
        return tareaRecords;
    }

    public void setTareaRecords(List<Tarea> tareaRecords) {
        this.tareaRecords = tareaRecords;
    }

    public ConfiguracionServicio getConfiguracionServicio() {
        return configuracionServicio;
    }

    public void setConfiguracionServicio(ConfiguracionServicio configuracionServicio) {
        this.configuracionServicio = configuracionServicio;
    }

    public MessagesView getMessagesView() {
        return messagesView;
    }

    public void setMessagesView(MessagesView messagesView) {
        this.messagesView = messagesView;
    }

    public Tarea getTareaSelected() {
        return tareaSelected;
    }

    public void setTareaSelected(Tarea tareaSelected) {
        this.tareaSelected = tareaSelected;
    }

    public Tarea getNuevaTarea() {
        return nuevaTarea;
    }

    public void setNuevaTarea(Tarea nuevaTarea) {
        this.nuevaTarea = nuevaTarea;
    }

    public List<String> getModuloRecords() {
        return moduloRecords;
    }

    public void setModuloRecords(List<String> moduloRecords) {
        this.moduloRecords = moduloRecords;
    }
}
