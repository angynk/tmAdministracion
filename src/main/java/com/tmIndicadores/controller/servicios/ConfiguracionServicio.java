package com.tmIndicadores.controller.servicios;


import com.tmIndicadores.model.dao.RoleDao;
import com.tmIndicadores.model.dao.TareaDao;
import com.tmIndicadores.model.dao.UsuarioDao;
import com.tmIndicadores.model.entity.Role;
import com.tmIndicadores.model.entity.Tarea;
import com.tmIndicadores.model.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service("ConfigService")
public class ConfiguracionServicio {

    @Autowired
    public UsuarioDao usuarioDao;

    @Autowired
    public RoleDao roleDao;

    @Autowired
    public TareaDao tareaDao;

    public void addUsuario(Usuario usuario) {
        usuarioDao.addUsuario(usuario);
    }

    public void deleteUsuario(Usuario usuario) {
        usuarioDao.deleteUsuario(usuario);
    }


    public void updateUsuario(Usuario usuario) {
        usuarioDao.updateUsuario(usuario);
    }


    public List<Usuario> getUsuarioAll() {
        return usuarioDao.getUsuarioAll();
    }

    public Usuario encontrarUsuarioByNombreUsuario(String user){
        return usuarioDao.encontrarUsuarioByNombreUsuario(user);
    }

    public void addURole(Role role) {
        roleDao.addURole(role);
    }

    public void deleteRole(Role role) {
        roleDao.deleteRole(role);
    }


    public void updateRole(Role role) {
        roleDao.updateRole(role);
    }


    public List<Role> getRoleAll() {
       return roleDao.getRoleAll();
    }

    public Role getRoleById(long id) {
        return roleDao.getRoleById(id);
    }

    public List<Tarea> getTareaAll() {
        return tareaDao.getTareaAll();
    }

    public Usuario getUsuarioById(long idNuevo) {
        return usuarioDao.getUsuarioById(idNuevo);
    }

    public void updateTarea(Tarea tareaSelected) {
        tareaDao.updateTarea(tareaSelected);
    }

    public void addTarea(Tarea tareaSelected) {
        tareaDao.addTarea(tareaSelected);
    }

    public List<String> getModulosAll() {
        List<String> modulos = new ArrayList<>();
        modulos.add("Indicadores BRT");
        modulos.add("Tabla Maestra SIRCI");
        return modulos;
    }
}
