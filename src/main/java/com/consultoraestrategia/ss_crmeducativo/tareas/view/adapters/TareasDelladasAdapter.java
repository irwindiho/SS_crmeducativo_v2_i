package com.consultoraestrategia.ss_crmeducativo.tareas.view.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.consultoraestrategia.ss_crmeducativo.R;
import com.consultoraestrategia.ss_crmeducativo.entities.Tarea;
import com.consultoraestrategia.ss_crmeducativo.lib.GlideImageLoader;
import com.consultoraestrategia.ss_crmeducativo.lib.ImageLoader;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by irvinmarin on 27/02/2017.
 */

public class TareasDelladasAdapter extends RecyclerView.Adapter<TareasDelladasAdapter.ViewHolder> {


    private final Context context;
    private ArrayList<Tarea> tareaArrayList;
    private ImageLoader imageLoader;
    private int backgroudColor;

    // Provee una referencia a cada item dentro de una vista y acceder a ellos facilmente
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Cada uno de los elementos de mi vista

        @BindView(R.id.txtNombreAnunciante)
        TextView txtNombreAnunciante;
        @BindView(R.id.txtFechaPublicacion)
        TextView txtFechaPublicacion;
        @BindView(R.id.txtTituloTarea)
        TextView txtTituloTarea;
        @BindView(R.id.txtContenidoTarea)
        TextView txtContenidoTarea;



        @BindView(R.id.imgTarea)
        ImageView imgTarea;
        @BindView(R.id.contItemView)
        LinearLayout contItemView;
        @BindView(R.id.cardviewTareasDetalles)
        CardView cardviewTareasDetalles;


        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);

        }
    }

    // Constructor
    public TareasDelladasAdapter(ArrayList<Tarea> tareaArrayList, Context context, int backgroudColor) {
        this.tareaArrayList = tareaArrayList;
        this.context = context;
        this.imageLoader = new GlideImageLoader(context);
        this.backgroudColor = backgroudColor;
    }

    // Create new views (invoked by the layout managxer)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflo la vista (vista padre)
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tareas_detalles, parent, false);
        // creo el grupo de vistas

        return new ViewHolder(v);
    }


    // Reemplaza en contenido de la vista
    @Override
    public void onBindViewHolder(final ViewHolder vh, final int position) {

        String titulo = tareaArrayList.get(position).getTitulo();
        String contenido = tareaArrayList.get(position).getContenido();

        vh.imgTarea.setBackgroundColor(backgroudColor);
        vh.txtTituloTarea.setText(titulo);
        vh.txtContenidoTarea.setText(contenido);
        vh.txtNombreAnunciante.setText("Guillermo Mamani");
        vh.txtFechaPublicacion.setText("15 mar");

    }


    @Override
    public int getItemCount() {
        return tareaArrayList.size();
    }

}
