package com.wayhua.archdate.ui.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wayhua.archdate.R;
import com.wayhua.archdate.data.local.entity.Event;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventViewHolder> {
    private final Context context;
    private List<Event> items;
    private View.OnClickListener deleteClickListener;
    private View.OnClickListener viewClickListener;

    EventAdapter(List<Event> items, Context context, View.OnClickListener viewClickListener, View.OnClickListener deleteClickListener) {
        this.items = items;
        this.context = context;
        this.deleteClickListener = deleteClickListener;
        this.viewClickListener = viewClickListener;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent,
                                              int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_event, parent, false);
        return new EventViewHolder(v);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        Event item = items.get(position);
        holder.eventTextView.setText(item.getName());
        holder.descriptionTextView.setText(item.getDescription());
        holder.countdownTextView.setText(context.getString(R.string.days_until, item.getDaysUntil()));
        holder.itemView.setTag(item);
        holder.deleteButton.setTag(item);
        holder.deleteButton.setOnClickListener(deleteClickListener);
        holder.itemView.setOnClickListener(viewClickListener);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    void setItems(List<Event> events) {
        this.items = events;
        notifyDataSetChanged();
    }
}