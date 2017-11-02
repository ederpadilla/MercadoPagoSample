package androiddeveloper.eder.padilla.mercadopagosample.mercadopago.pxtracking.strategies;

import android.content.Context;

import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.pxtracking.model.AppInformation;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.pxtracking.model.DeviceInfo;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.pxtracking.model.Event;


public abstract class TrackingStrategy {

    private String clientId;
    private AppInformation appInformation;
    private DeviceInfo deviceInfo;
    private EventsDatabase database;

    public abstract void trackEvent(Event event, Context context);

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setAppInformation(AppInformation appInformation) {
        this.appInformation = appInformation;
    }

    public void setDeviceInfo(DeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getClientId() {
        return clientId;
    }

    public AppInformation getAppInformation() {
        return appInformation;
    }

    public DeviceInfo getDeviceInfo() {
        return deviceInfo;
    }

    public EventsDatabase getDatabase() {
        return database;
    }

    public void setDatabase(EventsDatabase database) {
        this.database = database;
    }

    public boolean isDataAvailable() {
        return database != null && database.getBatchSize() != 0;
    }

}
