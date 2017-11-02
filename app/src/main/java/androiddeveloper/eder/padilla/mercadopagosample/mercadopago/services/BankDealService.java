package androiddeveloper.eder.padilla.mercadopagosample.mercadopago.services;



import java.util.List;

import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.adapters.MPCall;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.model.BankDeal;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BankDealService {

    @GET("/v1/payment_methods/deals")
    MPCall<List<BankDeal>> getBankDeals(@Query("public_key") String publicKey, @Query("access_token") String privateKey, @Query("locale") String locale);
}