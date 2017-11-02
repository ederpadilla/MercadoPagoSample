package androiddeveloper.eder.padilla.mercadopagosample.mercadopago.controllers;


import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.preferences.ServicePreference;

public class CustomServicesHandler {
    private static CustomServicesHandler mInstance;
    private ServicePreference servicePreference;

    private CustomServicesHandler(){}

    public static CustomServicesHandler getInstance() {
        if(mInstance == null) {
            mInstance = new CustomServicesHandler();
        }
        return mInstance;
    }

    public void clear() {
        servicePreference = null;
    }

    public void setServices(ServicePreference servicePreference) {
        this.servicePreference = servicePreference;
    }

    public ServicePreference getServicePreference() {
        return servicePreference;
    }
}
