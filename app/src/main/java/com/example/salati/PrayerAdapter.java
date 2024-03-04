package com.example.salati;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class PrayerAdapter extends RecyclerView.Adapter<PrayerAdapter.ViewHolder> {
    private List<PrayerItem> prayerList;
    private Context context;

    public PrayerAdapter(Context context, List<PrayerItem> prayerList) {
        this.context = context;
        this.prayerList = prayerList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.prayer_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final PrayerItem prayerItem = prayerList.get(position);

        holder.titleTextView.setText(prayerItem.getTitle());
        holder.imageView.setImageResource(prayerItem.getImageResId());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                holder.toggleHorizontalRecyclerView();
                return true;
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Number of raka'at: " + prayerItem.getRakatCount(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return prayerList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        ImageView imageView;
        RecyclerView horizontalRecyclerView;
        HorizontalAdapter horizontalAdapter;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            imageView = itemView.findViewById(R.id.imageView);
            horizontalRecyclerView = itemView.findViewById(R.id.horizontalRecyclerView);
            horizontalAdapter = new HorizontalAdapter(Arrays.asList(R.drawable.hand, R.drawable.pray, R.drawable.rukuu, R.drawable.sujuud, R.drawable.praay));
            horizontalRecyclerView.setAdapter(horizontalAdapter);
            horizontalRecyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        }

        private void toggleHorizontalRecyclerView() {
            int visibility = horizontalRecyclerView.getVisibility();
            if (visibility == View.VISIBLE) {
                horizontalRecyclerView.animate().alpha(0f).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        horizontalRecyclerView.setVisibility(View.GONE);
                        horizontalRecyclerView.setAlpha(1f); // Reset alpha
                    }
                }).start();
            } else {
                horizontalRecyclerView.setAlpha(0f);
                horizontalRecyclerView.setVisibility(View.VISIBLE);
                horizontalRecyclerView.animate().alpha(1f).start();
            }
        }

    }

}






