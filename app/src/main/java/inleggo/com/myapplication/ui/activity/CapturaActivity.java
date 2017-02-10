package inleggo.com.myapplication.ui.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import fr.ganfra.materialspinner.MaterialSpinner;
import inleggo.com.myapplication.R;
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
import inleggo.com.myapplication.interactor.CapturaInteractor;
import inleggo.com.myapplication.presenter.CapturaPresenter;
import inleggo.com.myapplication.ui.adapter.SpinnerAdapter;
import inleggo.com.myapplication.view.CapturaView;

/**
 * Created by apurisaca on 02/12/2016.
 */

public class CapturaActivity extends AppCompatActivity implements CapturaView {

    @InjectView(R.id.spn_tipo_captura)
    MaterialSpinner spnTipoCaptura;
    @InjectView(R.id.spn_sede)
    MaterialSpinner spnSede;
    @InjectView(R.id.spn_gerencia)
    MaterialSpinner spnGerencia;
    @InjectView(R.id.spn_area)
    MaterialSpinner spnArea;
    @InjectView(R.id.spn_equipo)
    MaterialSpinner spnEquipo;
    @InjectView(R.id.spn_local)
    MaterialSpinner spnLocal;
    @InjectView(R.id.spn_piso)
    MaterialSpinner spnPiso;
    @InjectView(R.id.spn_ubicacion)
    MaterialSpinner spnUbicacion;
    @InjectView(R.id.spn_Usuario)
    MaterialSpinner spnUsuario;
    @InjectView(R.id.spn_proyecto)
    MaterialSpinner spnProyecto;
    @InjectView(R.id.btn_guardar)
    Button btnGuardar;
    CapturaPresenter mCapturaPresenter;
    CapturaInteractor mCapturaInteractor;
    List<Area> mAreas;
    List<Equipo> mEquipos;
    List<Gerencia> mGerencia;
    List<Local> mLocals;
    List<Proyecto> mProyectos;
    List<Sede> mSedes;
    List<Ubicacion> mUbicacions;
    List<UsuarioInv> mUsuarioInvs;
    List<TipoCaptura> mTipoCapturas;
    List<Piso> mPisos;
    private final String TAG = getClass().getName();
    ProgressDialog mProgressDialog;
    LoginUsuario mLoginUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captura);
        ButterKnife.inject(this);
        inicializar();
        //inicializarspn();
    }


    @Override
    protected void onResume() {
        super.onResume();
        inicializarspn();
    }

    @Override
    public Context getContext() {
        return this;
    }


    @OnClick(R.id.btn_guardar)
    public void onClick() {
    }
    void inicializar(){
        mCapturaPresenter = new CapturaPresenter();
        mCapturaInteractor = new CapturaInteractor(getContext());
        mCapturaPresenter.setView(this);
        mLoginUsuario = new LoginUsuario();
        mLoginUsuario = (LoginUsuario) getIntent().getExtras().getParcelable("loginUsuario");
        mCapturaPresenter.inicializar(mLoginUsuario);
    }
    void inicializarspn(){
        spnGerencia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(mGerencia != null){
                    Log.i(TAG,"select Spinner" +mGerencia.get(i).getId() );
                    mCapturaPresenter.callAreas(mGerencia.get(i),mLoginUsuario);
                }
                //
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void setAdapterTipoCaptura(List<TipoCaptura> tipoCapturas) {
        SpinnerAdapter<TipoCaptura> tipoCapturaAdapter = new SpinnerAdapter<TipoCaptura>(getApplicationContext(), android.R.layout.simple_spinner_item, tipoCapturas) {
            @Override
            public String getDescripcion(int position) {
                return mObjects.get(position).getNombre();
            }
        };
        spnTipoCaptura.setAdapter(tipoCapturaAdapter);
    }

    public void setAdapterSede(List<Sede> sedes) {
        SpinnerAdapter<Sede> sedeAdapter = new SpinnerAdapter<Sede>(getApplicationContext(), android.R.layout.simple_spinner_item, sedes) {
            @Override
            public String getDescripcion(int position) {
                return mObjects.get(position).getNombre();
            }
        };
        spnSede.setAdapter(sedeAdapter);
    }

    public void setAdapterGerencia(List<Gerencia> gerencias) {
        SpinnerAdapter<Gerencia> gerenciaAdapter = new SpinnerAdapter<Gerencia>(getApplicationContext(), android.R.layout.simple_spinner_item, gerencias) {
            @Override
            public String getDescripcion(int position) {
                return mObjects.get(position).getNombre();
            }
        };
        spnGerencia.setAdapter(gerenciaAdapter);
    }

    public void setAdapterArea(List<Area> areas) {
        for (int i =0; i<areas.size(); i++){
            Log.i(TAG,"Gerencia: " + areas.get(i).getGerencia() +" -- Id: "+areas.get(i).getId()+" -- Nombre: "+areas.get(i).getNombre());
        }
        SpinnerAdapter<Area> areaAdapter = new SpinnerAdapter<Area>(getApplicationContext(), android.R.layout.simple_spinner_item, areas) {
            @Override
            public String getDescripcion(int position) {
                return mObjects.get(position).getNombre();
            }
        };
        spnArea.setAdapter(areaAdapter);
    }

    public void setAdapterEquipo(List<Equipo> equipos) {
        SpinnerAdapter<Equipo> equipoAdapter = new SpinnerAdapter<Equipo>(getApplicationContext(), android.R.layout.simple_spinner_item, equipos) {
            @Override
            public String getDescripcion(int position) {
                return mObjects.get(position).getNombre();
            }
        };
        spnEquipo.setAdapter(equipoAdapter);
    }

    public void setAdapterLocal(List<Local> locals) {
        SpinnerAdapter<Local> localAdapter = new SpinnerAdapter<Local>(getApplicationContext(), android.R.layout.simple_spinner_item, locals) {
            @Override
            public String getDescripcion(int position) {
                return mObjects.get(position).getNombre();
            }
        };
        spnLocal.setAdapter(localAdapter);
    }

    public void setAdapterPiso(List<Piso> pisos) {
        SpinnerAdapter<Piso> pisoAdapter = new SpinnerAdapter<Piso>(getApplicationContext(), android.R.layout.simple_spinner_item, pisos) {
            @Override
            public String getDescripcion(int position) {
                return mObjects.get(position).getNombre();
            }
        };
        spnPiso.setAdapter(pisoAdapter);
    }

    public void setAdapterUbicacion(List<Ubicacion> ubicacions) {
        SpinnerAdapter<Ubicacion> ubicacionAdapter = new SpinnerAdapter<Ubicacion>(getApplicationContext(), android.R.layout.simple_spinner_item, ubicacions) {
            @Override
            public String getDescripcion(int position) {
                return mObjects.get(position).getNombre();
            }
        };
        spnUbicacion.setAdapter(ubicacionAdapter);
    }

    public void setAdapterUsuario(List<UsuarioInv> usuarios) {
        SpinnerAdapter<UsuarioInv> usuarioAdapter = new SpinnerAdapter<UsuarioInv>(getApplicationContext(), android.R.layout.simple_spinner_item, usuarios) {
            @Override
            public String getDescripcion(int position) {
                return mObjects.get(position).getNombre();
            }
        };
        spnUsuario.setAdapter(usuarioAdapter);
    }

    public void setAdapterProyecto(List<Proyecto> proyectos) {
        SpinnerAdapter<Proyecto> proyectoAdapter = new SpinnerAdapter<Proyecto>(getApplicationContext(), android.R.layout.simple_spinner_item, proyectos) {
            @Override
            public String getDescripcion(int position) {
                return mObjects.get(position).getNombre();
            }
        };
        spnProyecto.setAdapter(proyectoAdapter);
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showLoading() {
        mProgressDialog = new ProgressDialog(getContext());
        mProgressDialog.setMessage("Cargando...");
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
    }

    @Override
    public void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        //imm.hideSoftInputFromWindow(mEdtUser.getWindowToken(), 0);

    }

    @Override
    public void mensajeError(int nroEdt) {

    }

    @Override
    public void loadGerencia(List<Gerencia> gerenciaList) {
        mGerencia = gerenciaList;
        setAdapterGerencia(mGerencia);
        Log.i(TAG,"" + gerenciaList.size());
        //mLoginForm.setVisibility(View.VISIBLE);
        //mLlProgForm.setVisibility(View.GONE);

    }

    @Override
    public void loadAreas(List<Area> areaList) {
        mAreas = areaList;
        setAdapterArea(mAreas);
    }

    @Override
    public void loadEquipos(List<Equipo> equipoList) {
        mEquipos = equipoList;
        setAdapterEquipo(mEquipos);
    }

    @Override
    public void loadLocals(List<Local> localList) {
        mLocals =localList;
        setAdapterLocal(mLocals);
    }

    @Override
    public void loadProyectos(List<Proyecto> proyectoList) {
        mProyectos = proyectoList;
        setAdapterProyecto(mProyectos);
    }

    @Override
    public void loadSedes(List<Sede> sedeList) {
        mSedes = sedeList;
        setAdapterSede(mSedes);
    }

    @Override
    public void loadUbicacions(List<Ubicacion> ubicacionList) {
        mUbicacions = ubicacionList;
        setAdapterUbicacion(mUbicacions);
    }

    @Override
    public void loadUsuariosInv(List<UsuarioInv> usuarioInvList) {
        mUsuarioInvs = usuarioInvList;
        setAdapterUsuario(mUsuarioInvs);

    }

    @Override
    public void loadTipoCaptura(List<TipoCaptura> tipoCapturaList) {
        mTipoCapturas = tipoCapturaList;
        setAdapterTipoCaptura(mTipoCapturas);
    }

    @Override
    public void loadPiso(List<Piso> pisoList) {
        mPisos = pisoList;
        setAdapterPiso(mPisos);
    }
}
