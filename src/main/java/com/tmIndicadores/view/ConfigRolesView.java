package com.tmIndicadores.view;

import com.tmIndicadores.controller.servicios.ConfiguracionServicio;
import com.tmIndicadores.model.entity.Role;
import com.tmIndicadores.model.entity.Usuario;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "configRole")
@SessionScoped
public class ConfigRolesView {

    private List<Role> roleRecords;
    private Role roleSelected;
    private Role roleNuevo;

    @ManagedProperty(value="#{ConfigService}")
    private ConfiguracionServicio configuracionServicio;

    @ManagedProperty(value="#{MessagesView}")
    private MessagesView messagesView;


    public ConfigRolesView() {

    }

    @PostConstruct
    public void init(){
        roleRecords = configuracionServicio.getRoleAll();
    }

    public void actualizarRole(){
        if(roleSelected!=null){
            configuracionServicio.updateRole(roleSelected);
            messagesView.info(Messages.MENSAJE_EXITOSA,Messages.ACTUALIZACION_ROLE);
        }

    }

    public void crearNuevoRole(){
        roleNuevo = new Role();
    }

    public void crearRol(){
        if(roleNuevo!= null){
                configuracionServicio.addURole(roleNuevo);
                messagesView.info(Messages.MENSAJE_EXITOSA,Messages.CREACION_ROLE);
                roleRecords = configuracionServicio.getRoleAll();


        }
    }

    public void cancelar(){
        roleNuevo = new Role();
    }

    public List<Role> getRoleRecords() {
        return roleRecords;
    }

    public void setRoleRecords(List<Role> roleRecords) {
        this.roleRecords = roleRecords;
    }

    public Role getRoleSelected() {
        return roleSelected;
    }

    public void setRoleSelected(Role roleSelected) {
        this.roleSelected = roleSelected;
    }

    public Role getRoleNuevo() {
        return roleNuevo;
    }

    public void setRoleNuevo(Role roleNuevo) {
        this.roleNuevo = roleNuevo;
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
}
