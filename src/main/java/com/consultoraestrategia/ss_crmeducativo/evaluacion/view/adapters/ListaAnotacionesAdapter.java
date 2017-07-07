package com.consultoraestrategia.ss_crmeducativo.evaluacion.view.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.consultoraestrategia.ss_crmeducativo.R;
import com.consultoraestrategia.ss_crmeducativo.entities.Anotaciones;
import com.consultoraestrategia.ss_crmeducativo.entities.Tarea;
import com.consultoraestrategia.ss_crmeducativo.evaluacion.view.fragments.DialogFragmentNuevaAnotacion;
import com.consultoraestrategia.ss_crmeducativo.lib.GlideImageLoader;
import com.consultoraestrategia.ss_crmeducativo.lib.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

//import com.shehabic.droppy.DroppyClickCallbackInterface;
//import com.shehabic.droppy.DroppyMenuPopup;
//import com.shehabic.droppy.animations.DroppyFadeInAnimation;


/**
 * Created by irvinmarin on 27/02/2017.
 */

public class ListaAnotacionesAdapter extends RecyclerView.Adapter<ListaAnotacionesAdapter.ViewHolder> {
    List<Anotaciones> anotacionesList;

    public static ArrayList<Tarea> tareaArrayList;
    FragmentManager fragmentManager;

    private ImageLoader imageLoader;
    private Context context;
    int idAlumno;

    public ListaAnotacionesAdapter(List<Anotaciones> anotacionesList, Context context, FragmentManager fragmentManager, int idAlumno) {
        this.context = context;
        this.idAlumno = idAlumno;
        this.fragmentManager = fragmentManager;
        this.anotacionesList = anotacionesList;
        this.imageLoader = new GlideImageLoader(context);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtTitulo)
        TextView txtTitulo;
        @BindView(R.id.txtContent)
        TextView txtContent;
        @BindView(R.id.txtNombreCurso)
        TextView txtNombreCurso;
        @BindView(R.id.txtNombreDocente)
        TextView txtNombreDocente;
        @BindView(R.id.txtHora)
        TextView txtHora;
        @BindView(R.id.contentLayout)
        LinearLayout contentLayout;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);


        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_anotaciones, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder vh, final int position) {

        vh.txtTitulo.setText(anotacionesList.get(position).getTitulo());
        vh.txtContent.setText(anotacionesList.get(position).getContent());
        vh.txtNombreCurso.setText(anotacionesList.get(position).getCurso());
        vh.txtNombreDocente.setText(anotacionesList.get(position).getNombreDocente());
        vh.txtHora.setText(anotacionesList.get(position).getHora());
        vh.contentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new DialogFragmentNuevaAnotacion();
                Bundle bundle = new Bundle();
                bundle.putString("NombreCurso", anotacionesList.get(position).getCurso());
                bundle.putString("Titulo", anotacionesList.get(position).getTitulo());
                bundle.putString("NombreDocente", anotacionesList.get(position).getNombreDocente());
                bundle.putString("Content", anotacionesList.get(position).getContent());
                bundle.putInt("idAlumno", idAlumno);
                dialogFragment.setArguments(bundle);
                dialogFragment.show(fragmentManager, "DialogFragmentNuevaAnotacion");
                Toast.makeText(v.getContext(), "Editar Anotacion", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return anotacionesList.size();
    }


}
