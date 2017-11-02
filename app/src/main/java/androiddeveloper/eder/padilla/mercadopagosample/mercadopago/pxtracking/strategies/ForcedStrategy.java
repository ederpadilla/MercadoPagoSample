package androiddeveloper.eder.padilla.mercadopagosample.mercadopago.pxtracking.strategies;

import android.content.Context;



import java.util.List;

import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.pxtracking.model.Event;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.pxtracking.model.EventTrackIntent;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.pxtracking.services.MPTrackingService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForcedStrategy extends TrackingStrategy {

    private final MPTrackingService trackingService;
    private final ConnectivityChecker connectivityChecker;

    public ForcedStrategy(EventsDatabase database, ConnectivityChecker connectivityChecker, MPTrackingService trackingService) {
        setDatabase(database);
        this.trackingService = trackingService;
        this.connectivityChecker = connectivityChecker;
    }

    @Override
    public void trackEvent(Event event, Context context) {
        performTrackAttempt(context);
    }

    private void performTrackAttempt(Context context) {
        if (shouldSendBatch()) {
            sendTracksBatch(context);
        }
    }

    private boolean shouldSendBatch() {
        return isConnectivityOk() && isDataAvailable();
    }

    private boolean isConnectivityOk() {
        return connectivityChecker.hasConnection();
    }


    private void sendTracksBatch(final Context context) {
        final List<Event> batch = getDatabase().retrieveBatch();
        EventTrackIntent intent = new EventTrackIntent(getClientId(), getAppInformation(), getDeviceInfo(), batch);
        trackingService.trackEvents(intent, context, new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    performTrackAttempt(context);
                } else {
                    getDatabase().returnEvents(batch);
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                getDatabase().returnEvents(batch);
            }
        });
    }
}
