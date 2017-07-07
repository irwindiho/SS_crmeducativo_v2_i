package com.consultoraestrategia.ss_crmeducativo.MainCursosAlumno.view.adapters;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.consultoraestrategia.ss_crmeducativo.MainCursosAlumno.view.activities.MainCursosAlumnoActivity;
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

public class ListaTareaCursoAlumnoAdapter extends RecyclerView.Adapter<ListaTareaCursoAlumnoAdapter.ViewHolder> {


    private ArrayList<Tarea> tareaArrayList;
    private MainCursosAlumnoActivity activity;

    private ImageLoader imageLoader;

    // Provee una referencia a cada item dentro de una vista y acceder a ellos facilmente
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Cada uno de los elementos de mi vista
        @BindView(R.id.txtItemTarea)
        TextView txtItemTarea;
        @BindView(R.id.contItemView)
        LinearLayout contItemView;
        @BindView(R.id.cardviewTareas)
        CardView cardviewTareas;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);


        }
    }

    // Constructor
    public ListaTareaCursoAlumnoAdapter(ArrayList<Tarea> tareaArrayList, MainCursosAlumnoActivity activity) {
        this.tareaArrayList = tareaArrayList;
        this.activity = activity;
        this.imageLoader = new GlideImageLoader(activity.getApplicationContext());
    }

    // Create new views (invoked by the layout managxer)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflo la vista (vista padre)
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_titulos_tareas, parent, false);
        // creo el grupo de vistas


        return new ViewHolder(v);
    }


    // Reemplaza en contenido de la vista
    @Override
    public void onBindViewHolder(final ViewHolder vh, final int position) {


        final String tituloTarea = tareaArrayList.get(position).getTitulo();

        vh.txtItemTarea.setText(tituloTarea);

    }


    @Override
    public int getItemCount() {
        return tareaArrayList.size();
    }

    private void goToActivity(Class<?> cls, View view, int dwb, String[] csoData) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().setExitTransition(new Explode());
            Intent intent = new Intent(activity.getApplicationContext(), cls);
            intent.putExtra("csoData", csoData);
            intent.putExtra("fondo", dwb);
            ActivityOptions options = view != null ?
                    ActivityOptions.makeSceneTransitionAnimation(
                            activity, view, "view") :
                    ActivityOptions.makeSceneTransitionAnimation(
                            activity);
            activity.startActivityForResult(intent, 19, options.toBundle());

        } else {
            Intent intent = new Intent(activity, cls);
            intent.putExtra("csoData", csoData);
            intent.putExtra("fondo", dwb);
            activity.startActivity(intent);
        }
    }
}
