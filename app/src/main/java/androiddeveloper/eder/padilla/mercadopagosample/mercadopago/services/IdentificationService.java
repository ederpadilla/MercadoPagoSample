package androiddeveloper.eder.padilla.mercadopagosample.mercadopago.services;



import java.util.List;

import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.adapters.MPCall;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.model.IdentificationType;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IdentificationService {

    @GET("/v1/identification_types")
    MPCall<List<IdentificationType>> getIdentificationTypes(@Query("public_key") String publicKey, @Query("access_token") String privateKey);

}
