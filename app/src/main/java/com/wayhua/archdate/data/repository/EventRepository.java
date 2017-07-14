package com.wayhua.archdate.data.repository;


import android.arch.lifecycle.LiveData;

import com.wayhua.archdate.data.local.entity.Event;

import java.util.List;

import io.reactivex.Completable;

/**
 * @author rebeccafranks
 * @since 2017/04/21.
 */
public interface EventRepository {

    Completable addEvent(Event event);

    LiveData<List<Event>> getEvents();

    Completable deleteEvent(Event event);

}
