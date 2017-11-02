package androiddeveloper.eder.padilla.mercadopagosample.mercadopago.services;



import java.util.Map;

import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.adapters.MPCall;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.model.Customer;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.model.Discount;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.model.MerchantPayment;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.model.Payment;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.preferences.CheckoutPreference;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface MerchantService {

    @GET("/{uri}")
    MPCall<Customer> getCustomer(@Path(value = "uri", encoded = true) String uri, @Query(value = "merchant_access_token", encoded = true) String merchantAccessToken);

    @POST("/{uri}")
    MPCall<Payment> createPayment(@Path(value = "uri", encoded = true) String uri, @Body MerchantPayment body);

    @POST("/{uri}")
    MPCall<CheckoutPreference> createPreference(@Path(value = "uri", encoded = true) String uri, @Body Map<String, Object> body);

    @GET("/{uri}")
    MPCall<Discount> getDirectDiscount(@Path(value = "uri", encoded = true) String uri, @Query("transaction_amount") String transactionAmount, @Query("email") String payerEmail, @QueryMap(encoded = true) Map<String, String> discountAdditionalInfo);

    @GET("/{uri}")
    MPCall<Discount> getCodeDiscount(@Path(value = "uri", encoded = true) String uri, @Query("transaction_amount") String transactionAmount, @Query("email") String payerEmail, @Query("coupon_code") String couponCode, @QueryMap(encoded = true) Map<String, String> discountAdditionalInfo);
}
