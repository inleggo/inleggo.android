package inleggo.com.myapplication.data.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by apurisaca on 29/11/2016.
 */

public class LoginUsuario implements Parcelable{
    String code;
    String resplogin;
    String cliente;
    String cliente_c;
    String año;
    String empresa;
    String ruc;
    String web;
    String empresa_;
    String db;
    String user_db_temp;
    String pass_db_temp;
    String server_img;
    String server_activo;
    String fecha_inicio_c;
    String fecha_fin_c;
    String tipo_empresa;
    String modelo;
    String limite_cap;
    String cod_def;
    String cod_maxlength_inv;
    String cod_barra_type;
    String cod_loc_def;
    String captura_auto;
    String captura_date;
    String inv_electrico;
    String year_last;
    String cod_inv_lasted;
    String cod_inv_last;
    String cod_inv_last_1;
    String cod_inv_last_2;
    String cod_inv_last_3;
    String token_in;
    String inv_tipo;
    String user_id_in;
    String user_nombre_in;
    String user_paterno_in;
    String user_materno_in;
    String user_name_all_in;
    String user_dni_in;
    String user_email_in;
    String user_tipoid_in;
    String user_tipo_in;
    String ws_ver_mob_app;

    public LoginUsuario() {
    }

    protected LoginUsuario(Parcel in) {
        code = in.readString();
        resplogin = in.readString();
        cliente = in.readString();
        cliente_c = in.readString();
        año = in.readString();
        empresa = in.readString();
        ruc = in.readString();
        web = in.readString();
        empresa_ = in.readString();
        db = in.readString();
        user_db_temp = in.readString();
        pass_db_temp = in.readString();
        server_img = in.readString();
        server_activo = in.readString();
        fecha_inicio_c = in.readString();
        fecha_fin_c = in.readString();
        tipo_empresa = in.readString();
        modelo = in.readString();
        limite_cap = in.readString();
        cod_def = in.readString();
        cod_maxlength_inv = in.readString();
        cod_barra_type = in.readString();
        cod_loc_def = in.readString();
        captura_auto = in.readString();
        captura_date = in.readString();
        inv_electrico = in.readString();
        year_last = in.readString();
        cod_inv_lasted = in.readString();
        cod_inv_last = in.readString();
        cod_inv_last_1 = in.readString();
        cod_inv_last_2 = in.readString();
        cod_inv_last_3 = in.readString();
        token_in = in.readString();
        inv_tipo = in.readString();
        user_id_in = in.readString();
        user_nombre_in = in.readString();
        user_paterno_in = in.readString();
        user_materno_in = in.readString();
        user_name_all_in = in.readString();
        user_dni_in = in.readString();
        user_email_in = in.readString();
        user_tipoid_in = in.readString();
        user_tipo_in = in.readString();
        ws_ver_mob_app = in.readString();
    }

    public static final Creator<LoginUsuario> CREATOR = new Creator<LoginUsuario>() {
        @Override
        public LoginUsuario createFromParcel(Parcel in) {
            return new LoginUsuario(in);
        }

        @Override
        public LoginUsuario[] newArray(int size) {
            return new LoginUsuario[size];
        }
    };

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getResplogin() {
        return resplogin;
    }

    public void setResplogin(String resplogin) {
        this.resplogin = resplogin;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCliente_c() {
        return cliente_c;
    }

    public void setCliente_c(String cliente_c) {
        this.cliente_c = cliente_c;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getEmpresa_() {
        return empresa_;
    }

    public void setEmpresa_(String empresa_) {
        this.empresa_ = empresa_;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getUser_db_temp() {
        return user_db_temp;
    }

    public void setUser_db_temp(String user_db_temp) {
        this.user_db_temp = user_db_temp;
    }

    public String getPass_db_temp() {
        return pass_db_temp;
    }

    public void setPass_db_temp(String pass_db_temp) {
        this.pass_db_temp = pass_db_temp;
    }

    public String getServer_img() {
        return server_img;
    }

    public void setServer_img(String server_img) {
        this.server_img = server_img;
    }

    public String getServer_activo() {
        return server_activo;
    }

    public void setServer_activo(String server_activo) {
        this.server_activo = server_activo;
    }

    public String getFecha_inicio_c() {
        return fecha_inicio_c;
    }

    public void setFecha_inicio_c(String fecha_inicio_c) {
        this.fecha_inicio_c = fecha_inicio_c;
    }

    public String getFecha_fin_c() {
        return fecha_fin_c;
    }

    public void setFecha_fin_c(String fecha_fin_c) {
        this.fecha_fin_c = fecha_fin_c;
    }

    public String getTipo_empresa() {
        return tipo_empresa;
    }

    public void setTipo_empresa(String tipo_empresa) {
        this.tipo_empresa = tipo_empresa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getLimite_cap() {
        return limite_cap;
    }

    public void setLimite_cap(String limite_cap) {
        this.limite_cap = limite_cap;
    }

    public String getCod_def() {
        return cod_def;
    }

    public void setCod_def(String cod_def) {
        this.cod_def = cod_def;
    }

    public String getCod_maxlength_inv() {
        return cod_maxlength_inv;
    }

    public void setCod_maxlength_inv(String cod_maxlength_inv) {
        this.cod_maxlength_inv = cod_maxlength_inv;
    }

    public String getCod_barra_type() {
        return cod_barra_type;
    }

    public void setCod_barra_type(String cod_barra_type) {
        this.cod_barra_type = cod_barra_type;
    }

    public String getCod_loc_def() {
        return cod_loc_def;
    }

    public void setCod_loc_def(String cod_loc_def) {
        this.cod_loc_def = cod_loc_def;
    }

    public String getCaptura_auto() {
        return captura_auto;
    }

    public void setCaptura_auto(String captura_auto) {
        this.captura_auto = captura_auto;
    }

    public String getCaptura_date() {
        return captura_date;
    }

    public void setCaptura_date(String captura_date) {
        this.captura_date = captura_date;
    }

    public String getInv_electrico() {
        return inv_electrico;
    }

    public void setInv_electrico(String inv_electrico) {
        this.inv_electrico = inv_electrico;
    }

    public String getYear_last() {
        return year_last;
    }

    public void setYear_last(String year_last) {
        this.year_last = year_last;
    }

    public String getCod_inv_lasted() {
        return cod_inv_lasted;
    }

    public void setCod_inv_lasted(String cod_inv_lasted) {
        this.cod_inv_lasted = cod_inv_lasted;
    }

    public String getCod_inv_last() {
        return cod_inv_last;
    }

    public void setCod_inv_last(String cod_inv_last) {
        this.cod_inv_last = cod_inv_last;
    }

    public String getCod_inv_last_1() {
        return cod_inv_last_1;
    }

    public void setCod_inv_last_1(String cod_inv_last_1) {
        this.cod_inv_last_1 = cod_inv_last_1;
    }

    public String getCod_inv_last_2() {
        return cod_inv_last_2;
    }

    public void setCod_inv_last_2(String cod_inv_last_2) {
        this.cod_inv_last_2 = cod_inv_last_2;
    }

    public String getCod_inv_last_3() {
        return cod_inv_last_3;
    }

    public void setCod_inv_last_3(String cod_inv_last_3) {
        this.cod_inv_last_3 = cod_inv_last_3;
    }

    public String getToken_in() {
        return token_in;
    }

    public void setToken_in(String token_in) {
        this.token_in = token_in;
    }

    public String getInv_tipo() {
        return inv_tipo;
    }

    public void setInv_tipo(String inv_tipo) {
        this.inv_tipo = inv_tipo;
    }

    public String getUser_id_in() {
        return user_id_in;
    }

    public void setUser_id_in(String user_id_in) {
        this.user_id_in = user_id_in;
    }

    public String getUser_nombre_in() {
        return user_nombre_in;
    }

    public void setUser_nombre_in(String user_nombre_in) {
        this.user_nombre_in = user_nombre_in;
    }

    public String getUser_paterno_in() {
        return user_paterno_in;
    }

    public void setUser_paterno_in(String user_paterno_in) {
        this.user_paterno_in = user_paterno_in;
    }

    public String getUser_materno_in() {
        return user_materno_in;
    }

    public void setUser_materno_in(String user_materno_in) {
        this.user_materno_in = user_materno_in;
    }

    public String getUser_name_all_in() {
        return user_name_all_in;
    }

    public void setUser_name_all_in(String user_name_all_in) {
        this.user_name_all_in = user_name_all_in;
    }

    public String getUser_dni_in() {
        return user_dni_in;
    }

    public void setUser_dni_in(String user_dni_in) {
        this.user_dni_in = user_dni_in;
    }

    public String getUser_email_in() {
        return user_email_in;
    }

    public void setUser_email_in(String user_email_in) {
        this.user_email_in = user_email_in;
    }

    public String getUser_tipoid_in() {
        return user_tipoid_in;
    }

    public void setUser_tipoid_in(String user_tipoid_in) {
        this.user_tipoid_in = user_tipoid_in;
    }

    public String getUser_tipo_in() {
        return user_tipo_in;
    }

    public void setUser_tipo_in(String user_tipo_in) {
        this.user_tipo_in = user_tipo_in;
    }

    public String getWs_ver_mob_app() {
        return ws_ver_mob_app;
    }

    public void setWs_ver_mob_app(String ws_ver_mob_app) {
        this.ws_ver_mob_app = ws_ver_mob_app;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(code);
        parcel.writeString(resplogin);
        parcel.writeString(cliente);
        parcel.writeString(cliente_c);
        parcel.writeString(año);
        parcel.writeString(empresa);
        parcel.writeString(ruc);
        parcel.writeString(web);
        parcel.writeString(empresa_);
        parcel.writeString(db);
        parcel.writeString(user_db_temp);
        parcel.writeString(pass_db_temp);
        parcel.writeString(server_img);
        parcel.writeString(server_activo);
        parcel.writeString(fecha_inicio_c);
        parcel.writeString(fecha_fin_c);
        parcel.writeString(tipo_empresa);
        parcel.writeString(modelo);
        parcel.writeString(limite_cap);
        parcel.writeString(cod_def);
        parcel.writeString(cod_maxlength_inv);
        parcel.writeString(cod_barra_type);
        parcel.writeString(cod_loc_def);
        parcel.writeString(captura_auto);
        parcel.writeString(captura_date);
        parcel.writeString(inv_electrico);
        parcel.writeString(year_last);
        parcel.writeString(cod_inv_lasted);
        parcel.writeString(cod_inv_last);
        parcel.writeString(cod_inv_last_1);
        parcel.writeString(cod_inv_last_2);
        parcel.writeString(cod_inv_last_3);
        parcel.writeString(token_in);
        parcel.writeString(inv_tipo);
        parcel.writeString(user_id_in);
        parcel.writeString(user_nombre_in);
        parcel.writeString(user_paterno_in);
        parcel.writeString(user_materno_in);
        parcel.writeString(user_name_all_in);
        parcel.writeString(user_dni_in);
        parcel.writeString(user_email_in);
        parcel.writeString(user_tipoid_in);
        parcel.writeString(user_tipo_in);
        parcel.writeString(ws_ver_mob_app);
    }
}