package androiddeveloper.eder.padilla.mercadopagosample.mercadopago.pxtracking.strategies;

public interface ConnectivityChecker {
    boolean hasConnection();

    boolean hasWifiConnection();
}
