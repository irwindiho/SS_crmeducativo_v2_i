package com.consultoraestrategia.ss_crmeducativo.evaluacion.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.consultoraestrategia.ss_crmeducativo.R;
import com.consultoraestrategia.ss_crmeducativo.entities.Cursos;
import com.consultoraestrategia.ss_crmeducativo.lib.GlideImageLoader;
import com.consultoraestrategia.ss_crmeducativo.lib.ImageLoader;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

//import com.shehabic.droppy.DroppyClickCallbackInterface;
//import com.shehabic.droppy.DroppyMenuPopup;
//import com.shehabic.droppy.animations.DroppyFadeInAnimation;


/**
 * Created by irvinmarin on 27/02/2017.
 */

public class ListaCargaAcademicaAlumnoAdapter extends RecyclerView.Adapter<ListaCargaAcademicaAlumnoAdapter.ViewHolder> {
    List<Cursos> cursosList;


    private ImageLoader imageLoader;
    private static Context context;

    public ListaCargaAcademicaAlumnoAdapter(List<Cursos> cursosList, Context context) {
        this.cursosList = cursosList;
        this.imageLoader = new GlideImageLoader(context);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtMenuCursoo)
        TextView txtMenuCursoo;
        @BindView(R.id.txtNombrePeriodoPrograma)
        TextView txtNombrePeriodoPrograma;
        @BindView(R.id.txtInicial)
        TextView txtInicial;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);


        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.nav_item_menu_curso, parent, false);
        return new ViewHolder(v);
    }

    int nro = 0;

    @Override
    public void onBindViewHolder(final ViewHolder vh, final int position) {
        nro = position + 1;
        vh.txtMenuCursoo.setText(cursosList.get(position).getNombre());
        vh.txtNombrePeriodoPrograma.setText(cursosList.get(position).getAlias());
        vh.txtInicial.setText(nro + "");
    }

    @Override
    public int getItemCount() {
        return cursosList.size();
    }


}
