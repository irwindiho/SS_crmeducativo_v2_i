package com.consultoraestrategia.ss_crmeducativo.sesiones.view.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.consultoraestrategia.ss_crmeducativo.R;
import com.consultoraestrategia.ss_crmeducativo.entities.Sesiones;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AdapterSesiones extends RecyclerView.Adapter<AdapterSesiones.ViewHolder> {
    ArrayList<Sesiones> sesionesArrayList;


    // Provee una referencia a cada item dentro de una vista y acceder a ellos facilmente
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Cada uno de los elementos de mi vista

//        @BindView(R.id.tv_nroSesion)
//        public TextView tv_nroSesion;

        @BindView(R.id.tv_tituloSesion)
        public TextView tv_tituloSesion;

        @BindView(R.id.tv_contenidoSesion)
        public TextView tv_contenidoSesion;

        @BindView(R.id.tv_tareasSesion)
        public TextView tv_tareasSesion;

        @BindView(R.id.tv_cantHorasSesion)
        public TextView tv_cantHorasSesion;

        @BindView(R.id.tv_estadoSesion)
        public TextView tv_estadoSesion;

        @BindView(R.id.cardv_sesiones)
        public CardView cardv_sesiones;

        @BindView(R.id.parentPanelSesiones)
        public RelativeLayout parentPanelSesiones;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    // Constructor
    public AdapterSesiones(ArrayList<Sesiones> sesionesArrayList) {
        this.sesionesArrayList = sesionesArrayList;
    }

    // Create new views (invoked by the layout managxer)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflo la vista (vista padre)
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_sesiones, parent, false);
        // creo el grupo de vistas
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    // Reemplaza en contenido de la vista
    @Override
    public void onBindViewHolder(final ViewHolder vh, final int position) {

//        vh.tv_nroSesion.setText(sesionesArrayList.get(position).getNroSesion() + "");
        vh.tv_tituloSesion.setText("T: " + sesionesArrayList.get(position).getTituloSesion());
        vh.tv_contenidoSesion.setText("CT: " + sesionesArrayList.get(position).getContenidoSesion());
        vh.tv_tareasSesion.setText("Tareas: " + sesionesArrayList.get(position).getTareasSesion());
        vh.tv_cantHorasSesion.setText(sesionesArrayList.get(position).getCantHoras() + "");
        vh.tv_cantHorasSesion.setText(sesionesArrayList.get(position).getCantHoras() + "");


        int estado = sesionesArrayList.get(position).getEstadoSesion();

        switch (estado) {
            case 1:
                vh.tv_estadoSesion.setText("Pendiente");
                break;
            case 2:
                vh.tv_estadoSesion.setText("En Proceso");
                break;
            case 3:
                vh.tv_estadoSesion.setText("Hecho");
                break;
            case 4:
                vh.tv_estadoSesion.setText("Reprogramado");
                break;
            case 5:
                vh.tv_estadoSesion.setText("Anulado");
                break;
        }


    }


    // Retorna el tamano de nuestra data
    @Override
    public int getItemCount() {
        return sesionesArrayList.size();
    }

}