package androiddeveloper.eder.padilla.mercadopagosample.mercadopago.services;


import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.adapters.MPCall;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.model.CardToken;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.model.SavedCardToken;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.model.SavedESCCardToken;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.model.SecurityCodeIntent;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.model.Token;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GatewayService {

    @POST("/v1/card_tokens")
    MPCall<Token> getToken(@Query("public_key") String publicKey, @Query("access_token") String privateKey, @Body CardToken cardToken);

    @POST("/v1/card_tokens")
    MPCall<Token> getToken(@Query("public_key") String publicKey, @Query("access_token") String privateKey, @Body SavedCardToken savedCardToken);

    @POST("/v1/card_tokens")
    MPCall<Token> getToken(@Query("public_key") String publicKey, @Query("access_token") String privateKey, @Body SavedESCCardToken savedESCCardToken);

    @POST("/v1/card_tokens/{token_id}/clone")
    MPCall<Token> getToken(@Path(value = "token_id") String tokenId, @Query("public_key") String publicKey, @Query("access_token") String privateKey);

    @PUT("/v1/card_tokens/{token_id}")
    MPCall<Token> getToken(@Path(value = "token_id") String tokenId, @Query("public_key") String publicKey, @Query("access_token") String privateKey, @Body SecurityCodeIntent securityCodeIntent);
}