package inleggo.com.myapplication.ui.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import inleggo.com.myapplication.R;
import inleggo.com.myapplication.data.Model.LoginProyecto;
import inleggo.com.myapplication.data.Model.LoginUsuario;
import inleggo.com.myapplication.presenter.LoginPresenter;
import inleggo.com.myapplication.ui.adapter.SpinnerAdapter;
import inleggo.com.myapplication.util.UtilNetwork;
import inleggo.com.myapplication.util.Utilidades;
import inleggo.com.myapplication.view.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView {
    private final String TAG = getClass().getName();
    @InjectView(R.id.login_progress)
    ProgressBar mLoginProgress;
    @InjectView(R.id.ll_prog_form)
    LinearLayout mLlProgForm;
    private UtilNetwork mUtilNetwork;
    Resources mResources;
    private LoginPresenter mLoginPresenter;
    private ProgressDialog mProgressDialog;
    @InjectView(R.id.edt_user)
    EditText mEdtUser;
    @InjectView(R.id.edt_pass)
    EditText mEdtPass;
    @InjectView(R.id.btn_ingresar)
    Button mBtnIngresar;
    @InjectView(R.id.ll_login_form)
    LinearLayout mLlLoginForm;
    @InjectView(R.id.login_form)
    ScrollView mLoginForm;
    @InjectView(R.id.activity_login)
    RelativeLayout mActivityLogin;
    @InjectView(R.id.spn_proyecto)
    Spinner mSpnProyecto;
    public List<LoginProyecto> mLoginProyecto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);
        inicializar();
            if (mUtilNetwork.isAvailableNetwork()) {
                if (savedInstanceState == null) {
                    mLoginPresenter.inicializar();
                }else{
                    mLoginProyecto = savedInstanceState.getParcelableArrayList("mListProyecto");
                    setAdapterProyecto(mLoginProyecto);
                    mSpnProyecto.setSelection(savedInstanceState.getInt("spnPosition"));
                    mLoginForm.setVisibility(View.VISIBLE);
                    mLlProgForm.setVisibility(View.GONE);
                }
            } else {
                Utilidades.mensaje_corto_confirmSi(this,this,"Mensaje", getResources().getString(R.string.vConexionInternet),"1");
            }

        mEdtUser.setText("demo");
        mEdtPass.setText("$demostracion$");

    }

    void inicializar() {
        mUtilNetwork = new UtilNetwork(this);
        mLoginPresenter = new LoginPresenter();
        mLoginPresenter.setView(this);
        mResources = getResources();
        mLoginProyecto = new ArrayList<LoginProyecto>();
    }


    @OnClick(R.id.btn_ingresar)
    public void onClick() {
        String user = mEdtUser.getText().toString();
        String pass = mEdtPass.getText().toString();
        LoginProyecto poyect = new LoginProyecto();

        poyect.setEmpresa(((LoginProyecto) mSpnProyecto.getSelectedItem()).getEmpresa());
        poyect.setId(((LoginProyecto) mSpnProyecto.getSelectedItem()).getId());
        Log.i(TAG,"getEmpresa: "+poyect.getEmpresa()+ "id: "+poyect.getId());
        mLoginPresenter.validaLogin(poyect.getId(),user, pass);
    }

    public void setAdapterProyecto(List<LoginProyecto> loginProyectos) {
        SpinnerAdapter<LoginProyecto> proyectoAdapter = new SpinnerAdapter<LoginProyecto>(getApplicationContext(), android.R.layout.simple_spinner_item, loginProyectos) {
            @Override
            public String getDescripcion(int position) {
                return mObjects.get(position).getEmpresa();
            }
        };
        mSpnProyecto.setAdapter(proyectoAdapter);
    }

    @Override
    public void showLoading() {
        mProgressDialog = new ProgressDialog(getContext());
        mProgressDialog.setMessage("Cargando...");
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
        hideKeyboard();

    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mEdtUser.getWindowToken(), 0);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void mensajeError(int nroEdt) {
        switch (nroEdt) {
            case 1:
                TextView errorText = (TextView)mSpnProyecto.getSelectedView();
                errorText.setError("");
                errorText.setTextColor(Color.RED);
                errorText.setText("Debe seleccionar el proyecto");
                errorText.requestFocus();
                break;
            case 2:
                mEdtUser.setError(mResources.getString(R.string.obligatorio));
                mEdtUser.requestFocus();
                break;
            case 3:
                mEdtPass.setError(mResources.getString(R.string.obligatorio));
                mEdtPass.requestFocus();
                break;
            case 4:
                Log.i(TAG, "Campos ingresados");
                Utilidades.mensaje_corto_confirmSi(this,this,"Mensaje", "Los datos ingresados son incorrectos.","0");
                mSpnProyecto.setId(0);
                mEdtUser.setText("");
                mEdtPass.setText("");
                break;
            case 5:
                Log.i(TAG, "Campos ingresados");
                Utilidades.mensaje_corto_confirmSi(this,this,"Mensaje", "Error al intentar consultar el servicio.","0");
                break;
        }

    }

    @Override
    public void loadProyecto(List<LoginProyecto> loginProyectos) {
        mLoginProyecto = loginProyectos;
        setAdapterProyecto(loginProyectos);
        Log.i(TAG,"" + loginProyectos.size());
        mLoginForm.setVisibility(View.VISIBLE);
        mLlProgForm.setVisibility(View.GONE);
    }

    @Override
    public void loadMenuPrincipal(LoginUsuario loginUsuario) {

        Log.i(TAG,"------>>loginUsuario.getDb()"+ loginUsuario.getDb());
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("loginUsuario", loginUsuario);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("spnPosition", mSpnProyecto.getSelectedItemPosition());
        outState.putParcelableArrayList("mListProyecto",new ArrayList<LoginProyecto>(mLoginProyecto));
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}
