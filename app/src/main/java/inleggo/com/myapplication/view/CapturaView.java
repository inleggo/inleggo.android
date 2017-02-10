package inleggo.com.myapplication.view;

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
 * Created by apurisaca on 02/12/2016.
 */

public interface CapturaView extends MvpView {
    void showLoading();
    void hideLoading();
    void hideKeyboard();
    void mensajeError(int nroEdt);

    void loadAreas(List<Area> areaList);
    void loadEquipos(List<Equipo> equipoList);
    void loadGerencia(List<Gerencia> gerenciaList);
    void loadLocals(List<Local> localList);
    void loadProyectos(List<Proyecto> proyectoList);
    void loadSedes(List<Sede> sedeList);
    void loadUbicacions(List<Ubicacion> ubicacionList);
    void loadUsuariosInv(List<UsuarioInv> usuarioInvList);
    void loadTipoCaptura(List<TipoCaptura> tipoCapturaList);
    void loadPiso(List<Piso> pisoList);

}
