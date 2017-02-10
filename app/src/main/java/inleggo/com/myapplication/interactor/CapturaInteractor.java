package inleggo.com.myapplication.interactor;

import android.content.Context;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;
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
import inleggo.com.myapplication.io.adapter.Captura.AreaAdapter;
import inleggo.com.myapplication.io.adapter.Captura.EquipoAdapter;
import inleggo.com.myapplication.io.adapter.Captura.GerenciaAdapter;
import inleggo.com.myapplication.io.adapter.Captura.LocalAdapter;
import inleggo.com.myapplication.io.adapter.Captura.ProyectoAdapter;
import inleggo.com.myapplication.io.adapter.Captura.SedeAdapter;
import inleggo.com.myapplication.io.adapter.Captura.UbicacionAdapter;
import inleggo.com.myapplication.io.adapter.Captura.UsuarioInvAdapter;
import inleggo.com.myapplication.io.model.Response.Captura.AreaResponse;
import inleggo.com.myapplication.io.model.Response.Captura.EquipoResponse;
import inleggo.com.myapplication.io.model.Response.Captura.GerenciaResponse;
import inleggo.com.myapplication.io.model.Request.ListRequest;
import inleggo.com.myapplication.io.model.Response.Captura.LocalResponse;
import inleggo.com.myapplication.io.model.Response.Captura.SedeResponse;
import inleggo.com.myapplication.io.model.Response.Captura.UbicacionResponse;
import inleggo.com.myapplication.io.model.Response.Captura.UsuarioInvResponse;
import inleggo.com.myapplication.io.model.Response.Captura.ProyectoResponse;
import inleggo.com.myapplication.support.Constantes;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

import static android.content.ContentValues.TAG;

/**
 * Created by Amarilisis on 11/12/2016.
 */

public class CapturaInteractor {
    AreaResponse mAreaResponse;
    EquipoResponse mEquipoResponse;
    GerenciaResponse mGerenciaResponse;
    LocalResponse mLocalResponse;
    ProyectoResponse mProyectoResponse;
    SedeResponse mSedeResponse;
    UbicacionResponse mUbicacionResponse;
    UsuarioInvResponse mUsuarioInvResponse;
    List<Area> mAreas;
    List<Equipo> mEquipos;
    List<Gerencia> mGerencias;
    List<Local> mLocals;
    List<Proyecto> mProyectos;
    List<Sede> mSedes;
    List<Ubicacion> mUbicacions;
    List<UsuarioInv> mUsuarioInvs;
    List<TipoCaptura> mTipoCapturas;
    List<Piso> mPisos;
    Context mContext;

    public CapturaInteractor(Context context) {
        mContext = context;
        mAreaResponse = new AreaResponse();
        mEquipoResponse = new EquipoResponse();
        mGerenciaResponse = new GerenciaResponse();
        mLocalResponse = new LocalResponse();
        mProyectoResponse = new ProyectoResponse();
        mSedeResponse = new SedeResponse();
        mUbicacionResponse = new UbicacionResponse();
        mUsuarioInvResponse = new UsuarioInvResponse();

    }

    public void serviceArea(Gerencia gerencia, LoginUsuario loginUsuario, final CapturaCallback callback){
        ListRequest request = new ListRequest();
        request.setUser(Constantes.USUARIO);
        request.setPassword(Constantes.PASSWORD);
        request.setDb(loginUsuario.getDb());
        request.setOperation(Constantes.OPERATION_LIST);
        request.setGerencia(gerencia.getId());
        AreaAdapter.getApiService()
                .getAreas(request)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (new Subscriber<AreaResponse>(){
                    @Override
                    public void onCompleted() {
                        Log.i(TAG, "onCompleted serviceAreas");
                    }
                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError");
                        e.printStackTrace();
                        AreaResponse areaResponse = new AreaResponse();
                        mAreas = areaResponse.ToArea("AREA");
                        callback.serviceAreas(mAreas);
                    }
                    @Override
                    public void onNext(AreaResponse areaResponse) {
                        Log.i(TAG, "AreaResponse--> "+areaResponse.getArea().size());
                        mAreas = areaResponse.ToArea("AREA");
                        callback.serviceAreas(mAreas);
                    }
                });
    }

    public void serviceEquipo(Area area, LoginUsuario loginUsuario, final CapturaCallback callback){
        ListRequest request = new ListRequest();
        request.setUser(Constantes.USUARIO);
        request.setPassword(Constantes.PASSWORD);
        request.setDb(loginUsuario.getDb());
        request.setOperation(Constantes.OPERATION_LIST);
        request.setArea(area.getId());
        EquipoAdapter.getApiService()
                .getEquipos(request)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (new Subscriber<EquipoResponse>(){
                    @Override
                    public void onCompleted() {
                        Log.i(TAG, "onCompleted serviceEquipos");
                    }
                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError");
                        e.printStackTrace();
                    }
                    @Override
                    public void onNext(EquipoResponse areaResponse) {
                        mEquipos = areaResponse.ToEquipo("EQUIPO");
                        callback.serviceEquipos(mEquipos);
                    }
                });
    }

    public void serviceGerencia(LoginUsuario loginUsuario, final CapturaCallback callback){
        ListRequest request = new ListRequest();
        request.setUser(Constantes.USUARIO);
        request.setPassword(Constantes.PASSWORD);
        request.setDb(loginUsuario.getDb());
        request.setOperation(Constantes.OPERATION_LIST);
        GerenciaAdapter.getApiService()
                .getGerencias(request)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (new Subscriber<GerenciaResponse>(){
                    @Override
                    public void onCompleted() {
                        Log.i(TAG, "onCompleted serviceGerencias");
                    }
                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError");
                        e.printStackTrace();
                    }
                    @Override
                    public void onNext(GerenciaResponse gerenciaResponse) {
                        mGerencias = gerenciaResponse.ToGerencia("GERENCIA");
                        callback.serviceGerencia(mGerencias);
                    }
                });
    }

    public void serviceLocal(Sede sede, LoginUsuario loginUsuario, final CapturaCallback callback){
        ListRequest request = new ListRequest();
        request.setUser(Constantes.USUARIO);
        request.setPassword(Constantes.PASSWORD);
        request.setDb(loginUsuario.getDb());
        request.setOperation(Constantes.OPERATION_LIST);
        request.setSede(sede.getId());
        LocalAdapter.getApiService()
                .getLocales(request)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (new Subscriber<LocalResponse>(){
                    @Override
                    public void onCompleted() {
                        Log.i(TAG, "onCompleted serviceLocal");
                    }
                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError");
                        e.printStackTrace();
                    }
                    @Override
                    public void onNext(LocalResponse localResponse) {
                        mLocals = localResponse.ToLocal("LOCAL");
                        callback.serviceLocals(mLocals);
                    }
                });
    }

    public void serviceProyecto(LoginUsuario loginUsuario, final CapturaCallback callback){
        ListRequest request = new ListRequest();
        request.setUser(Constantes.USUARIO);
        request.setPassword(Constantes.PASSWORD);
        request.setDb(loginUsuario.getDb());
        request.setOperation(Constantes.OPERATION_LIST);
        ProyectoAdapter.getApiService()
                .getProyectos(request)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (new Subscriber<ProyectoResponse>(){
                    @Override
                    public void onCompleted() {
                        Log.i(TAG, "onCompleted serviceProyecto");
                    }
                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError");
                        e.printStackTrace();
                    }
                    @Override
                    public void onNext(ProyectoResponse proyectoResponse) {
                        mProyectos = proyectoResponse.ToProyecto("PROYECTO");
                        callback.serviceProyectos(mProyectos);
                    }
                });
    }

    public void serviceSede(LoginUsuario loginUsuario, final CapturaCallback callback){
        ListRequest request = new ListRequest();
        request.setUser(Constantes.USUARIO);
        request.setPassword(Constantes.PASSWORD);
        request.setDb(loginUsuario.getDb());
        request.setOperation(Constantes.OPERATION_LIST);
        SedeAdapter.getApiService()
                .getSedes(request)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (new Subscriber<SedeResponse>(){
                    @Override
                    public void onCompleted() {
                        Log.i(TAG, "onCompleted serviceSedes");
                    }
                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError");
                        e.printStackTrace();
                    }
                    @Override
                    public void onNext(SedeResponse sedeResponse) {
                        /*Log.i(TAG, "sedeResponse--> "+sedeResponse.getSede().size());
                        int tam = sedeResponse.getSede().size();
                        for (int i = 0; i<tam;i++ ){
                            Log.i(TAG, "sedeResponse--> "+i+": "+sedeResponse.getSede().get(i).getId()+" nombre: " +sedeResponse.getSede().get(i).getNombre());
                        }*/
                        mSedes = sedeResponse.ToSede("SEDE");
                        callback.serviceSedes(mSedes);
                    }
                });
    }

    public void serviceUbicacion(Local local, Piso piso, LoginUsuario loginUsuario, final CapturaCallback callback){
        ListRequest request = new ListRequest();
        request.setUser(Constantes.USUARIO);
        request.setPassword(Constantes.PASSWORD);
        request.setDb(loginUsuario.getDb());
        request.setOperation(Constantes.OPERATION_LIST);
        request.setLocal(local.getId());
        request.setPiso(piso.getId());
        UbicacionAdapter.getApiService()
                .getUbicaciones(request)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (new Subscriber<UbicacionResponse>(){
                    @Override
                    public void onCompleted() {
                        Log.i(TAG, "onCompleted serviceUbicacion");
                    }
                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError");
                        e.printStackTrace();
                    }
                    @Override
                    public void onNext(UbicacionResponse ubicacionResponse) {
                        mUbicacions = ubicacionResponse.ToUbicacion("UBICACIÓN");
                        callback.serviceUbicacions(mUbicacions);
                    }
                });
    }

    public void serviceUsuarioInv(LoginUsuario loginUsuario, final CapturaCallback callback){
        ListRequest request = new ListRequest();
        request.setUser(Constantes.USUARIO);
        request.setPassword(Constantes.PASSWORD);
        request.setDb(loginUsuario.getDb());
        request.setOperation(Constantes.OPERATION_LIST);
        UsuarioInvAdapter.getApiService()
                .getUsuariosInv(request)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (new Subscriber<UsuarioInvResponse>(){
                    @Override
                    public void onCompleted() {
                        Log.i(TAG, "onCompleted serviceUsuariosInv");
                    }
                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError");
                        e.printStackTrace();
                    }
                    @Override
                    public void onNext(UsuarioInvResponse usuarioInvResponse) {
                        mUsuarioInvs = usuarioInvResponse.ToUsuario("USUARIO");
                        callback.serviceUsuariosInv(mUsuarioInvs);
                    }
                });
    }

    public List<TipoCaptura> hardTipoCaptura(){
        List<TipoCaptura> listTipoCaptura = new ArrayList<>();
        listTipoCaptura.add(new TipoCaptura("-1", "TIPO DE CAPTURA"));
        listTipoCaptura.add(new TipoCaptura("1", "Bien"));
        listTipoCaptura.add(new TipoCaptura("2", "Maquinaria"));
        listTipoCaptura.add(new TipoCaptura("3", "Vehículo"));
        return listTipoCaptura;
    }

    public List<Piso> hardPiso(){
        List<Piso> listPiso = new ArrayList<>();
        listPiso.add(new Piso("-1", "PISO"));
        for (int i=1; i<=50; i++){
            listPiso.add(new Piso(String.valueOf(i),String.valueOf(i)));
        }
        return listPiso;
    }

    public void loadTipoCaptura(final CapturaCallback callback){
        mTipoCapturas= hardTipoCaptura();
        callback.hardTipoCaptura(mTipoCapturas);

    }

    public void loadPiso(final CapturaCallback callback){
        mPisos = hardPiso();
        callback.hardPiso(mPisos);
    }
}
