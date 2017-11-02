package androiddeveloper.eder.padilla.mercadopagosample.mercadopago.pxtracking.strategies;



import java.util.List;

import androiddeveloper.eder.padilla.mercadopagosample.mercadopago.pxtracking.model.Event;

public interface EventsDatabase {

    void persist(Event event);

    void returnEvents(List<Event> batch);

    Integer getBatchSize();

    List<Event> retrieveBatch();

    void clearExpiredTracks();

    Long getNextTrackTimestamp();

    void clearDatabase();
}
