package com.tmIndicadores.model.dao;

import com.tmIndicadores.model.entity.Role;
import com.tmIndicadores.model.entity.Tarea;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository
@Transactional
public class TareaDao {

    @Autowired
    private SessionFactory sessionFactory;


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addTarea(Tarea tarea) {
        Serializable save = getSessionFactory().getCurrentSession().save(tarea);

    }

    public void deleteTarea(Tarea tarea) {
        getSessionFactory().getCurrentSession().delete(tarea);
    }


    public void updateTarea(Tarea tarea) {
        getSessionFactory().getCurrentSession().update(tarea);
    }

    public List<Tarea> getTareaAll() {
        List list = getSessionFactory().getCurrentSession().createQuery("from  Tarea ").list();
        return list;
    }
}
