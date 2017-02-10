package inleggo.com.myapplication.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import inleggo.com.myapplication.R;
import inleggo.com.myapplication.data.Model.LoginUsuario;
import inleggo.com.myapplication.view.MenuView;

/**
 * Created by Amarilisis on 4/12/2016.
 */

public class MenuActivity extends AppCompatActivity implements MenuView {
    private final String TAG = getClass().getName();
    LoginUsuario mLoginUsuario;
    @InjectView(R.id.btn_registrarcaptura)
    Button btn_registrarcaptura;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.inject(this);
        inicializar();
        mLoginUsuario = (LoginUsuario) getIntent().getExtras().getParcelable("loginUsuario");
    }

    public void inicializar() {
        mLoginUsuario = new LoginUsuario();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @OnClick(R.id.btn_registrarcaptura)
    public void onClick() {
        Intent intent = new Intent(this, CapturaActivity.class);
        Log.i(TAG,"------>>loginUsuario.getDb()"+ mLoginUsuario.getDb());
        intent.putExtra("loginUsuario", mLoginUsuario);
        startActivity(intent);
    }
}
