package androiddeveloper.eder.padilla.mercadopagosample.mercadopago.pxtracking.services;

import android.content.Context;


import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.pxtracking.model.EventTrackIntent;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.pxtracking.model.PaymentIntent;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.pxtracking.model.TrackingIntent;
import retrofit2.Callback;

/**
 * Created by vaserber on 7/3/17.
 */

public interface MPTrackingService {

    void trackToken(TrackingIntent trackingIntent, Context context);
    void trackPaymentId(PaymentIntent paymentIntent, Context context);
    void trackEvents(EventTrackIntent eventTrackIntent, Context context);
    void trackEvents(EventTrackIntent eventTrackIntent, Context context, Callback<Void> callback);
}
