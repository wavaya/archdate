package com.wayhua.archdate.data.local.db;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.wayhua.archdate.data.local.dao.EventDao;
import com.wayhua.archdate.data.local.entity.Event;


@Database(entities = {Event.class}, version = 1,exportSchema = false)
@TypeConverters(DateTypeConverter.class)
public abstract class EventDatabase extends RoomDatabase {

    public abstract EventDao eventDao();

}
