package androiddeveloper.eder.padilla.mercadopagosample.mercadopago.pxtracking.utils;


import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.pxtracking.model.Event;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.pxtracking.model.ScreenViewEvent;

/**
 * Created by marlanti on 8/7/17.
 */

public class EventFactory {

    private static String NO_TRACKING_SUPPORTED_ERROR_MESSAGE = "Tracking not supported for that event type";

    public static Event getEvent(String toParseJson) {
        Event event = null;
        if(toParseJson.contains(Event.TYPE_SCREEN_VIEW)){
            event = JsonConverter.getInstance().fromJson(toParseJson, ScreenViewEvent.class);
        }
        else {
            throw new IllegalStateException(NO_TRACKING_SUPPORTED_ERROR_MESSAGE);
        }

        return event;
    }
}
