package com.tmIndicadores.view;

import com.tmIndicadores.controller.servicios.ConfiguracionServicio;
import com.tmIndicadores.model.entity.Aplicacion;
import com.tmIndicadores.model.entity.RolAplicacion;
import com.tmIndicadores.model.entity.Role;
import com.tmIndicadores.model.entity.Usuario;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean(name = "configAppRol")
@ViewScoped
public class ConfigAplicacionRolView {

    private List<RolAplicacion> rolAplicacionLista;
    private List<Role> rolLista;
    private List<Aplicacion> aplicacionLista;
    private RolAplicacion nuevoRolAplicacion;
    private RolAplicacion rolAplicacionSelected;
    private Usuario usuarioSelected;

    @ManagedProperty(value="#{ConfigService}")
    private ConfiguracionServicio configuracionServicio;

    @ManagedProperty(value="#{MessagesView}")
    private MessagesView messagesView;

    public ConfigAplicacionRolView() {
    }

    @PostConstruct
    public void init(){
        usuarioSelected = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("usuario");
        rolAplicacionLista = configuracionServicio.getRolAplicacionUsuario(usuarioSelected);
        rolLista = configuracionServicio.getRoleAll();
        aplicacionLista = configuracionServicio.getAplicacionesAll();
    }

    public void crearNuevoRol(){
        nuevoRolAplicacion = new RolAplicacion();
        nuevoRolAplicacion.setUsuario(usuarioSelected);
        nuevoRolAplicacion.setRole(new Role());
        nuevoRolAplicacion.setAplicacion(new Aplicacion());
    }

    public void actualizarRolAplicacion(){
        Role nuevoRol = configuracionServicio.getRoleById(rolAplicacionSelected.getRole().getIdNuevo());
        if(nuevoRol!=null){
            Aplicacion  aplicacion = configuracionServicio.getAplicacionById(rolAplicacionSelected.getAplicacion().getIdNuevo());
            if(aplicacion!=null){
                rolAplicacionSelected.setRole(nuevoRol);
                rolAplicacionSelected.setAplicacion(aplicacion);
                configuracionServicio.updateRoleAplicacion(rolAplicacionSelected);
                messagesView.info(Messages.MENSAJE_EXITOSA,"Actualizada la aplicación");
            }
        }
    }

    public void crearAplicacion(){
        Role nuevoRol = configuracionServicio.getRoleById(nuevoRolAplicacion.getRole().getIdNuevo());
        if(nuevoRol!=null){
            Aplicacion  aplicacion = configuracionServicio.getAplicacionById(nuevoRolAplicacion.getAplicacion().getIdNuevo());
            if(aplicacion!=null){
                nuevoRolAplicacion.setRole(nuevoRol);
                nuevoRolAplicacion.setAplicacion(aplicacion);
                configuracionServicio.crearAplicacion(nuevoRolAplicacion);
                rolAplicacionLista = configuracionServicio.getRolAplicacionUsuario(usuarioSelected);
                messagesView.info(Messages.MENSAJE_EXITOSA,"Nueva Aplicación creada");
            }
        }
    }

    public void cancelar(){

    }



    public List<RolAplicacion> getRolAplicacionLista() {
        return rolAplicacionLista;
    }

    public void setRolAplicacionLista(List<RolAplicacion> rolAplicacionLista) {
        this.rolAplicacionLista = rolAplicacionLista;
    }

    public RolAplicacion getNuevoRolAplicacion() {
        return nuevoRolAplicacion;
    }

    public void setNuevoRolAplicacion(RolAplicacion nuevoRolAplicacion) {
        this.nuevoRolAplicacion = nuevoRolAplicacion;
    }

    public RolAplicacion getRolAplicacionSelected() {
        return rolAplicacionSelected;
    }

    public void setRolAplicacionSelected(RolAplicacion rolAplicacionSelected) {
        this.rolAplicacionSelected = rolAplicacionSelected;
    }

    public List<Aplicacion> getAplicacionLista() {
        return aplicacionLista;
    }

    public void setAplicacionLista(List<Aplicacion> aplicacionLista) {
        this.aplicacionLista = aplicacionLista;
    }

    public List<Role> getRolLista() {
        return rolLista;
    }

    public void setRolLista(List<Role> rolLista) {
        this.rolLista = rolLista;
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

    public Usuario getUsuarioSelected() {
        return usuarioSelected;
    }

    public void setUsuarioSelected(Usuario usuarioSelected) {
        this.usuarioSelected = usuarioSelected;
    }
}
