package androiddeveloper.eder.padilla.mercadopagosample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.MercadoPagoServices;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.callbacks.Callback;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.model.ApiException;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.model.CardToken;
import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.model.Token;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MercadoPagoServices mercadoPagoServices = new MercadoPagoServices.Builder()
                .setContext(getApplicationContext())
                .setPublicKey("TEST-8deff8af-5f7a-4e9b-a769-8178b84a34fa")
                .build();
        CardToken cardToken = new CardToken("5256781533121492",9,19,"500","vlads","Otro","123");
        mercadoPagoServices.createToken(cardToken, new Callback<Token>() {
            @Override
            public void success(Token token) {
                Log.e("Yeiii","token "+token.toString());
            }

            @Override
            public void failure(ApiException apiException) {
                Log.e("UPs","no se logro"+apiException.getMessage()+apiException.getError());
            }
        });
    }
}