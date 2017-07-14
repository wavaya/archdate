package com.wayhua.archdate.di;

import com.wayhua.archdate.ui.add.AddEventViewModel;
import com.wayhua.archdate.ui.list.EventListViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author rebeccafranks
 * @since 2017/05/11.
 */
@Singleton
@Component(modules = {CountdownModule.class})
public interface CountdownComponent {

    void inject(EventListViewModel eventListViewModel);

    void inject(AddEventViewModel addEventViewModel);

    interface Injectable {
        void inject(CountdownComponent countdownComponent);
    }
}
