package androiddeveloper.eder.padilla.mercadopagosample.mercadopago.adapters;


import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.callbacks.Callback;

/**
 * Created by mreverter on 6/6/16.
 */
public interface MPCall<T> {
    void cancel();
    void enqueue(Callback<T> callback);
    MPCall<T> clone();
}

