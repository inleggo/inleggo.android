package inleggo.com.myapplication.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import inleggo.com.myapplication.R;

/**
 * Created by apurisaca on 28/11/2016.
 */

public class Utilidades {
    public static void mensaje_corto(String title, String mensaje, Context activity) {
        AlertDialog.Builder ventana = new AlertDialog.Builder(activity);
        ventana.setTitle(title);
        //ventana.setIcon(R.drawable.icono_mensajes);
        ventana.setMessage(mensaje);
        ventana.setPositiveButton("OK", null);
        ventana.show();
        ventana.show();
    }

    public static void mensaje_corto_confirmSi(final Activity partida, final Context context, String titulo, String mensaje,String valor) {
        AlertDialog.Builder ventana = new AlertDialog.Builder(context);
        ventana.setTitle(titulo);
        ventana.setMessage(mensaje);
        //ventana.setIcon(R.drawable.icono_mensajes);
        ventana.setCancelable(false);
        if(valor=="1"){
            ventana.setPositiveButton("Aceptar",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog,
                                            int which) {
                            dialog.cancel();
                            partida.finish();
                        }
                    });
        }else{
            ventana.setPositiveButton("Aceptar",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog,
                                            int which) {
                            dialog.cancel();
                        }
                    });
        }
        ventana.show();
    }


}
