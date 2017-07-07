package com.consultoraestrategia.ss_crmeducativo.evaluacion.view.adapters;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.consultoraestrategia.ss_crmeducativo.R;
import com.consultoraestrategia.ss_crmeducativo.entities.Calendario;
import com.consultoraestrategia.ss_crmeducativo.entities.Tarea;
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

public class ListaCalendarioAdapter extends RecyclerView.Adapter<ListaCalendarioAdapter.ViewHolder> {
    List<Calendario> calendarioList;

    public static ArrayList<Tarea> tareaArrayList;
    FragmentManager fragmentManager;


    private ImageLoader imageLoader;
    private Context context;
    int idAlumno;

    public ListaCalendarioAdapter(List<Calendario> calendarioList, Context context, FragmentManager fragmentManager, int idAlumno) {
        this.context = context;
        this.idAlumno = idAlumno;
        this.fragmentManager = fragmentManager;
        this.calendarioList = calendarioList;
        this.imageLoader = new GlideImageLoader(context);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txtFechaCal)
        TextView txtFechaCal;
        @BindView(R.id.txtHora)
        TextView txtHora;
        @BindView(R.id.txtEventos)
        TextView txtEventos;
        @BindView(R.id.contentLayout)
        LinearLayout contentLayout;
        @BindView(R.id.fabEditCalendario)
        ImageButton fabEditCalendario;
        @BindView(R.id.fabAddAnotaion)
        ImageButton fabAddAnotaion;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);


        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_calendario, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder vh, final int position) {

        vh.txtFechaCal.setText(calendarioList.get(position).getFecha());
        vh.txtHora.setText(calendarioList.get(position).getEventoList().get(position).getHoraInicio() + "");
        vh.txtEventos.setText(calendarioList.get(position).getEventoList().get(position).getNombre() + "");

        vh.fabEditCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                DialogFragment dialogFragment = new DialogFragmentNuevaAnotacion();
//                Bundle bundle = new Bundle();
//
//                bundle.putInt("idAlumno", idAlumno);
//                dialogFragment.setArguments(bundle);
//                dialogFragment.show(fragmentManager, "DialogFragmentNuevaAnotacion");
                Toast.makeText(v.getContext(), "Editar Calenadrio ", Toast.LENGTH_LONG).show();
            }
        });
        vh.fabAddAnotaion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                DialogFragment dialogFragment = new DialogFragmentNuevaAnotacion();
//                Bundle bundle = new Bundle();
//
//                bundle.putInt("idAlumno", idAlumno);
//                dialogFragment.setArguments(bundle);
//                dialogFragment.show(fragmentManager, "DialogFragmentNuevaAnotacion");
                Toast.makeText(v.getContext(), "Nueva Anotacion ", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return calendarioList.size();
    }


}
