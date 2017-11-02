package androiddeveloper.eder.padilla.mercadopagosample.mercadopago.pxtracking.strategies;

import android.content.Context;



import java.util.ArrayList;
import java.util.List;

import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.pxtracking.model.Event;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.pxtracking.model.EventTrackIntent;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.pxtracking.services.MPTrackingService;

public class RealTimeTrackingStrategy extends TrackingStrategy {
    private final MPTrackingService trackingService;

    public RealTimeTrackingStrategy(MPTrackingService trackingService) {
        this.trackingService = trackingService;
    }

    @Override
    public void trackEvent(Event event, Context context) {
        List<Event> events = new ArrayList<>();
        events.add(event);
        EventTrackIntent eventTrackIntent = new EventTrackIntent(getClientId(), getAppInformation(), getDeviceInfo(), events);
        trackingService.trackEvents(eventTrackIntent, context);
    }
}
