package androiddeveloper.eder.padilla.mercadopagosample.mercadopago.services;


import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.adapters.MPCall;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.model.Customer;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CustomerService {

    @GET("/customers")
    MPCall<Customer> getCustomer(@Query("preference_id") String preferenceId);
}