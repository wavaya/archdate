package com.wayhua.archdate.data.repository;

import android.arch.lifecycle.LiveData;

import com.wayhua.archdate.data.local.db.EventDatabase;
import com.wayhua.archdate.data.local.entity.Event;

import org.threeten.bp.LocalDateTime;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;

/**
 * @author rebeccafranks
 * @since 2017/04/21.
 */
public class EventRepositoryImpl implements EventRepository {

    @Inject
    EventDatabase eventDatabase;

    public EventRepositoryImpl(EventDatabase eventDatabase) {
        this.eventDatabase = eventDatabase;
    }

    @Override
    public Completable addEvent(Event event) {
        return Completable.fromAction(() -> eventDatabase.eventDao().addEvent(event));
    }

    @Override
    public LiveData<List<Event>> getEvents() {
        //Here is where we would do more complex logic, like getting events from a cache
        //then inserting into the database etc. In this example we just go straight to the dao.
        return eventDatabase.eventDao().getEvents(LocalDateTime.now());
    }

    @Override
    public Completable deleteEvent(Event event) {
        return Completable.fromAction(() -> eventDatabase.eventDao().deleteEvent(event));
    }


}
