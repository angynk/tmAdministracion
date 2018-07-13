package com.tmIndicadores.controller.servicios;

import com.tmIndicadores.model.dao.AplicacionDao;
import com.tmIndicadores.model.entity.Aplicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AplicacionServicio")
public class AplicacionServicio {

    @Autowired
    private AplicacionDao aplicacionDao;

    public AplicacionServicio() {
    }


    public List<Aplicacion> obtenerAplicaciones() {
        return aplicacionDao.obtenerAplicaciones();
    }

    public void actualizarAplicacion(Aplicacion aplicacionSeleccionada) {
        aplicacionDao.updateAplicacion(aplicacionSeleccionada);
    }

    public void nuevaAplicacion(Aplicacion nuevaAplicacion) {
        aplicacionDao.addAplicacion(nuevaAplicacion);
    }
}
