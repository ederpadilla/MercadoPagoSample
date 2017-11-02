package androiddeveloper.eder.padilla.mercadopagosample.mercadopago.pxtracking.services;



import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.pxtracking.model.EventTrackIntent;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.pxtracking.model.PaymentIntent;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.pxtracking.model.TrackingIntent;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by vaserber on 6/5/17.
 */

public interface TrackingService {

    @POST("/" + "beta" + "/checkout/tracking")
    Call<Void> trackToken(@Body TrackingIntent body);

    @POST("/" + "beta" + "/checkout/tracking/off")
    Call<Void> trackPaymentId(@Body PaymentIntent body);

    @POST("/" + "beta" + "/checkout/tracking/events")
    Call<Void> trackEvents(@Body EventTrackIntent body);
}
