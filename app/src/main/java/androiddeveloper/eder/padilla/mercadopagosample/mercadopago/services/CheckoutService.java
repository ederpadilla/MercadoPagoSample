package androiddeveloper.eder.padilla.mercadopagosample.mercadopago.services;


import java.math.BigDecimal;

import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.adapters.MPCall;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.model.Instructions;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.model.PayerIntent;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.model.Payment;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.model.PaymentBody;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.model.PaymentMethodSearch;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.preferences.CheckoutPreference;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by mreverter on 2/20/17.
 */

public interface CheckoutService {

    @POST("/" + "beta" + "/checkout/payment_methods/search/options")
    MPCall<PaymentMethodSearch> getPaymentMethodSearch(@Header("Accept-Language") String locale, @Query("public_key") String publicKey, @Query("amount") BigDecimal amount, @Query("excluded_payment_types") String excludedPaymentTypes, @Query("excluded_payment_methods") String excludedPaymentMethods, @Body PayerIntent payerIntent, @Query("site_id") String siteId, @Query("api_version") String apiVersion, @Query("processing_mode") String processingMode);

    @POST("/" + "beta"+ "/checkout/payments")
    MPCall<Payment> createPayment(@Header("X-Idempotency-Key") String transactionId, @Body PaymentBody body);

    @GET("/" + "beta" + "/checkout/payments/{payment_id}/results")
    MPCall<Instructions> getPaymentResult(@Header("Accept-Language") String locale, @Path(value = "payment_id", encoded = true) Long paymentId, @Query("public_key") String mKey, @Query("access_token") String privateKey, @Query("payment_type") String paymentTypeId, @Query("api_version") String apiVersion);

    @GET("/" + "beta" + "/checkout/preferences/{preference_id}")
    MPCall<CheckoutPreference> getPreference(@Path(value = "preference_id", encoded = true) String checkoutPreferenceId, @Query("public_key") String publicKey);
}
