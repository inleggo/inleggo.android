package inleggo.com.myapplication.presenter;

import android.util.Log;

import java.util.List;

import inleggo.com.myapplication.data.Model.Area;
import inleggo.com.myapplication.data.Model.Equipo;
import inleggo.com.myapplication.data.Model.Gerencia;
import inleggo.com.myapplication.data.Model.Local;
import inleggo.com.myapplication.data.Model.LoginUsuario;
import inleggo.com.myapplication.data.Model.Piso;
import inleggo.com.myapplication.data.Model.Proyecto;
import inleggo.com.myapplication.data.Model.Sede;
import inleggo.com.myapplication.data.Model.TipoCaptura;
import inleggo.com.myapplication.data.Model.Ubicacion;
import inleggo.com.myapplication.data.Model.UsuarioInv;
import inleggo.com.myapplication.interactor.CapturaCallback;
import inleggo.com.myapplication.interactor.CapturaInteractor;
import inleggo.com.myapplication.view.CapturaView;

/**
 * Created by Amarilisis on 11/12/2016.
 */

public class CapturaPresenter implements Presenter<CapturaView>, CapturaCallback {
    private final String TAG = getClass().getName();
    CapturaInteractor mCapturaInteractor;
    CapturaView mCapturaView;

    public void inicializar(LoginUsuario loginUsuario){
        Gerencia gerencia = new Gerencia();gerencia.setId("0");
        Area area = new Area(); area.setId("0");
        Sede sede = new Sede(); sede.setId("0");
        Local local = new Local(); local.setId("0");
        Piso piso = new Piso(); piso.setId("0");
        mCapturaInteractor.loadTipoCaptura(this);
        mCapturaInteractor.serviceSede(loginUsuario,this);
        mCapturaInteractor.serviceGerencia(loginUsuario, this);
        mCapturaInteractor.serviceArea(gerencia,loginUsuario,this);
        mCapturaInteractor.serviceEquipo(area,loginUsuario,this);
        mCapturaInteractor.serviceLocal(sede,loginUsuario,this);
        mCapturaInteractor.loadPiso(this);
        mCapturaInteractor.serviceUbicacion(local,piso,loginUsuario,this);
        mCapturaInteractor.serviceUsuarioInv(loginUsuario,this);
        mCapturaInteractor.serviceProyecto(loginUsuario,this);
    }

    public void callAreas(Gerencia gerencia, LoginUsuario loginUsuario){
        mCapturaInteractor.serviceArea(gerencia,loginUsuario,this);
    }


    @Override
    public void setView(CapturaView view) {
        mCapturaView = view;
        mCapturaInteractor = new CapturaInteractor(view.getContext());
    }

    @Override
    public void detachView() {

    }

    @Override
    public void serviceAreas(List<Area> areaList) {
        mCapturaView.hideLoading();
        mCapturaView.loadAreas(areaList);
    }

    @Override
    public void serviceEquipos(List<Equipo> equipoList) {
        mCapturaView.hideLoading();
        mCapturaView.loadEquipos(equipoList);
    }

    @Override
    public void serviceGerencia(List<Gerencia> gerenciaList) {
        mCapturaView.hideLoading();
        mCapturaView.loadGerencia(gerenciaList);

    }

    @Override
    public void serviceLocals(List<Local> localList) {
        mCapturaView.hideLoading();
        mCapturaView.loadLocals(localList);
    }

    @Override
    public void serviceProyectos(List<Proyecto> proyectoList) {
        mCapturaView.hideLoading();
        mCapturaView.loadProyectos(proyectoList);
    }

    @Override
    public void serviceSedes(List<Sede> sedeList) {
        mCapturaView.hideLoading();
        mCapturaView.loadSedes(sedeList);
    }

    @Override
    public void serviceUbicacions(List<Ubicacion> ubicacionList) {
        mCapturaView.hideLoading();
        mCapturaView.loadUbicacions(ubicacionList);
    }

    @Override
    public void serviceUsuariosInv(List<UsuarioInv> usuarioInvList) {
        mCapturaView.hideLoading();
        mCapturaView.loadUsuariosInv(usuarioInvList);
    }

    @Override
    public void hardTipoCaptura(List<TipoCaptura> tipoCapturaList) {
        mCapturaView.hideLoading();
        mCapturaView.loadTipoCaptura(tipoCapturaList);
    }

    @Override
    public void hardPiso(List<Piso> pisoList) {
        mCapturaView.hideLoading();
        mCapturaView.loadPiso(pisoList);

    }
}
