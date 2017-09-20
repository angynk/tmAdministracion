package com.tmIndicadores.controller.servicios;

import com.tmIndicadores.model.dao.RoleDao;
import com.tmIndicadores.model.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name="roleService", eager = true)
@ApplicationScoped
public class RoleServicio {

    private List<Role> roleList;

    @Autowired
    public RoleDao roleDao;

    @PostConstruct
    public void init() {
//        roleList = roleDao.getRoleAll();
    }

    public List<Role> getRoleList() {
        return roleDao.getRoleAll();
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
