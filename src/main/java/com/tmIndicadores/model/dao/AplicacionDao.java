package com.tmIndicadores.model.dao;


import com.tmIndicadores.model.entity.Aplicacion;
import com.tmIndicadores.model.entity.Tarea;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository
@Transactional
public class AplicacionDao {

    @Autowired
    private SessionFactory sessionFactory;


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Aplicacion obtenerAplicacionById(int idAplicacion) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Aplicacion.class);
        criteria.add(Restrictions.eq("codigo", idAplicacion));
        return (Aplicacion) criteria.uniqueResult();
    }

    public List<Aplicacion> obtenerAplicaciones() {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Aplicacion.class);
        return criteria.list();
    }

    public void addAplicacion(Aplicacion aplicacion) {
        Serializable save = getSessionFactory().getCurrentSession().save(aplicacion);

    }

    public void deleteAplicacion(Aplicacion aplicacion) {
        getSessionFactory().getCurrentSession().delete(aplicacion);
    }


    public void updateAplicacion(Aplicacion aplicacion) {
        getSessionFactory().getCurrentSession().update(aplicacion);
    }

    public Aplicacion obtenerAplicacionIdGenerico(long idNuevo) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Aplicacion.class);
        criteria.add(Restrictions.eq("id", idNuevo));
        return (Aplicacion) criteria.uniqueResult();
    }
}
