package com.example.startwarsapps.Films;

import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.startwarsapps.DetailActivity;
import com.example.startwarsapps.R;

import java.text.DateFormatSymbols;
import java.util.ArrayList;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.MyViewHolder> {
    private ArrayList<Results> results;

    public FilmAdapter(ArrayList<Results> results) {
        this.results = results;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_film, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Results data = results.get(position);

        String releaseDate = data.getReleaseDate();
        String releaseDateWithoutStrip = releaseDate.replaceAll("-", "");
        String hari = releaseDateWithoutStrip.substring(0, 4);
        String bulan = releaseDateWithoutStrip.substring(5, 6);
        String tahun = releaseDateWithoutStrip.substring(6, 8);
        String namaBulan = new DateFormatSymbols().getMonths()[Integer.parseInt(bulan) - 1];

        holder.txtTitle.setText(data.getTitle());
        holder.txtHari.setText(hari);
        holder.txtBulan.setText(namaBulan);
        holder.txtTahun.setText(tahun);
        holder.txtOpening.setText(Html.fromHtml(data.getOpeningCrawl()));

        holder.btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),DetailActivity.class);
                intent.putExtra("film",data);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView txtHari, txtBulan, txtTahun, txtOpening, txtTitle,btnRead;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            btnRead = itemView.findViewById(R.id.btnRead);
            txtHari = itemView.findViewById(R.id.txtHari);
            txtBulan = itemView.findViewById(R.id.txtBulan);
            txtTahun = itemView.findViewById(R.id.txtTahun);
            txtOpening = itemView.findViewById(R.id.txtOpening);
            txtTitle = itemView.findViewById(R.id.txtTitle);
        }
    }
}
