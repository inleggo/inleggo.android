package inleggo.com.myapplication.io.service.Captura;

import inleggo.com.myapplication.io.model.Request.ListRequest;
import inleggo.com.myapplication.io.model.Response.Captura.UbicacionResponse;
import inleggo.com.myapplication.support.Constantes;
import retrofit.http.Body;
import retrofit.http.POST;
import rx.Observable;

/**
 * Created by apurisaca on 13/12/2016.
 */

public interface UbicacionService {

    @POST(Constantes.URL_UBICACION)
    Observable<UbicacionResponse> getUbicaciones(@Body ListRequest parametros);
}
