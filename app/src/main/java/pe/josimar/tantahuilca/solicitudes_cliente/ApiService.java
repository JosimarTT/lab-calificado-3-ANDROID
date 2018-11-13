package pe.josimar.tantahuilca.solicitudes_cliente;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {
    String API_BASE_URL = "http://10.0.2.2:8080";

    @GET("/solicitudes")
    Call<List<Solicitud>> getSolicitudes();


    @FormUrlEncoded
    @POST("/solicitudes")
    Call<ResponseMessage> createSolicitud(@Field("correo") String correo,
                                         @Field("tipo") String tipo,
                                         @Field("motivo") String motivo);
    @Multipart
    @POST("/solicitudes")
    Call<ResponseMessage> createSolicitudWithImage(
            @Part("correo") RequestBody correo,
            @Part("tipo") RequestBody tipo,
            @Part("motivo") RequestBody motivo,
            @Part MultipartBody.Part imagen
    );


}
