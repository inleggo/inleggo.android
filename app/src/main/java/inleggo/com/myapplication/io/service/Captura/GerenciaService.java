package inleggo.com.myapplication.io.service.Captura;

import inleggo.com.myapplication.io.model.Response.Captura.GerenciaResponse;
import inleggo.com.myapplication.io.model.Request.ListRequest;
import inleggo.com.myapplication.support.Constantes;
import rx.Observable;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by Amarilisis on 11/12/2016.
 */

public interface GerenciaService {
    @POST(Constantes.URL_GERENCIA)
    Observable<GerenciaResponse> getGerencias(@Body ListRequest parametros);
}
