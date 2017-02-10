package inleggo.com.myapplication.interactor;

import java.util.List;

import inleggo.com.myapplication.data.Model.Area;
import inleggo.com.myapplication.data.Model.Equipo;
import inleggo.com.myapplication.data.Model.Gerencia;
import inleggo.com.myapplication.data.Model.Local;
import inleggo.com.myapplication.data.Model.Piso;
import inleggo.com.myapplication.data.Model.Proyecto;
import inleggo.com.myapplication.data.Model.Sede;
import inleggo.com.myapplication.data.Model.TipoCaptura;
import inleggo.com.myapplication.data.Model.Ubicacion;
import inleggo.com.myapplication.data.Model.UsuarioInv;

/**
 * Created by Amarilisis on 11/12/2016.
 */

public interface CapturaCallback {

    void serviceAreas(List<Area> areaList);
    void serviceEquipos(List<Equipo> equipoList);
    void serviceGerencia(List<Gerencia> gerenciaList);
    void serviceLocals(List<Local> localList);
    void serviceProyectos(List<Proyecto> proyectoList);
    void serviceSedes(List<Sede> sedeList);
    void serviceUbicacions(List<Ubicacion> ubicacionList);
    void serviceUsuariosInv(List<UsuarioInv> usuarioInvList);
    void hardTipoCaptura(List<TipoCaptura> tipoCapturaList);
    void hardPiso(List<Piso> pisoList);
}
