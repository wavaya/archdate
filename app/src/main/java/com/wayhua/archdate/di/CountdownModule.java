package com.wayhua.archdate.di;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.wayhua.archdate.App;
import com.wayhua.archdate.data.local.db.EventDatabase;
import com.wayhua.archdate.data.repository.EventRepository;
import com.wayhua.archdate.data.repository.EventRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author rebeccafranks
 * @since 2017/05/11.
 */
@Module
public class CountdownModule {
  //我习惯将Application定义为App,所以这个名字我做了修改
    private App countdownApplication;

    public CountdownModule(App countdownApplication) {
        this.countdownApplication = countdownApplication;
    }

    @Provides
    Context applicationContext() {
        return countdownApplication;
    }

    @Provides
    @Singleton
    EventRepository providesEventRepository(EventDatabase eventDatabase) {
        return new EventRepositoryImpl(eventDatabase);
    }

    @Provides
    @Singleton
    EventDatabase providesEventDatabase(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(), EventDatabase.class, "event_db").build();
    }
}
