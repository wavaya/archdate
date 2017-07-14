package com.wayhua.archdate.ui.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.wayhua.archdate.R;


class EventViewHolder extends RecyclerView.ViewHolder {

    TextView eventTextView;
    TextView countdownTextView;
    TextView descriptionTextView;
    ImageButton deleteButton;

    EventViewHolder(View v) {
        super(v);
        eventTextView = (TextView) v.findViewById(R.id.text_view_event_name);
        countdownTextView = (TextView) v.findViewById(R.id.text_view_countdown);
        descriptionTextView = (TextView) v.findViewById(R.id.text_view_event_description);
        deleteButton = (ImageButton) v.findViewById(R.id.button_delete);
    }
}
