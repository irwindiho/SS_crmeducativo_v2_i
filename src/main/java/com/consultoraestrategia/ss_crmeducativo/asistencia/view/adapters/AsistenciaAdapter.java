package com.consultoraestrategia.ss_crmeducativo.asistencia.view.adapters;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.consultoraestrategia.ss_crmeducativo.R;
import com.consultoraestrategia.ss_crmeducativo.asistencia.view.fragments.DialogFragmentJustificado;
import com.consultoraestrategia.ss_crmeducativo.entities.Contrato;
import com.consultoraestrategia.ss_crmeducativo.entities.Contrato_Table;
import com.consultoraestrategia.ss_crmeducativo.entities.DetalleContratoAcad;
import com.consultoraestrategia.ss_crmeducativo.entities.Persona;
import com.consultoraestrategia.ss_crmeducativo.entities.Persona_Table;
import com.consultoraestrategia.ss_crmeducativo.lib.ImageLoader;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kelvi on 03/03/2017.
 */

public class AsistenciaAdapter extends RecyclerView.Adapter<AsistenciaAdapter.AsistenciaHolder> {

    private List<DetalleContratoAcad> detalleContratoAcadList;
    private ListenerFabButton listenerFabButton;
    private ImageLoader imageLoader;
    private FragmentManager fragmentManager;
    int cursoId;

    public interface ListenerFabButton {
        void onFabPrincipalClick(Persona persona, FloatingActionButton floatingActionButton);

        void onFabChilCick(Persona persona, FloatingActionButton btnCurrentState, FloatingActionButton btnAsistio, FloatingActionButton btnFalto, FloatingActionButton btnJustificado);
    }

    public AsistenciaAdapter(int cursoId, List<DetalleContratoAcad> detalleContratoAcadList, ListenerFabButton listenerFabButton, ImageLoader imageLoader, FragmentManager fragmentManager) {
        this.detalleContratoAcadList = detalleContratoAcadList;
        this.cursoId = cursoId;
        this.listenerFabButton = listenerFabButton;
        this.imageLoader = imageLoader;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public AsistenciaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_asistencia, parent, false);
        return new AsistenciaHolder(itemView);
    }

    int vis = View.VISIBLE;
    int gone = View.GONE;
    boolean isVisiblebtnCurrentState = true;

    @Override
    public void onBindViewHolder(final AsistenciaHolder holder, int position) {


        Contrato contrato = SQLite.select()
                .from(Contrato.class)
                .where(Contrato_Table.idContrato.is(detalleContratoAcadList.get(position).getIdContrato()))
                .queryList().get(0);
//
// Contrato.find(Contrato.class, "id_Contrato=? ", detalleContratoAcadList.get(position).getIdContrato() + "").get(0);
        final Persona persona = SQLite.select()
                .from(Persona.class)
                .where(Persona_Table.personaId.is(contrato.getPersonaId()))
                .queryList().get(0);
//
//
// Persona.find(Persona.class, "persona_Id=?", contrato.getPersonaId() + "").get(0);


        holder.textViewDatos.setText(persona.getApellidoPaterno() + " " + persona.getApellidoMaterno() + ", " + persona.getNombres());
        holder.btnCurrentState.setTag(0);
        imageLoader.loadWithCircular(holder.imageViewProfile, "https://www.invest-direct-online.com/images/img-school-fee-planning-profile.jpg");

        holder.btnCurrentState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                holder.btnAsistio.setVisibility(vis);
                holder.btnFalto.setVisibility(vis);
                holder.btnJustificado.setVisibility(vis);
//                listenerFabButton.onFabChilCick(persona, holder.btnCurrentState, holder.btnAsistio, holder.btnFalto, holder.btnJustificado);
            }
        });
        holder.btnJustificado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialogFragment = new DialogFragmentJustificado();
                dialogFragment.show(fragmentManager, "dialogframent");
                if (isVisiblebtnCurrentState) {
                    holder.btnCurrentState.setVisibility(gone);
                    holder.btnAsistio.setVisibility(gone);
                    holder.btnFalto.setVisibility(gone);
                    holder.btnJustificado.setVisibility(vis);
                    isVisiblebtnCurrentState = false;
                } else {
                    holder.btnCurrentState.setVisibility(vis);
                    holder.btnAsistio.setVisibility(vis);
                    holder.btnFalto.setVisibility(vis);
                    holder.btnJustificado.setVisibility(vis);
                    isVisiblebtnCurrentState = true;
                }
//                listenerFabButton.onFabPrincipalClick(persona, holder.btnJustificado);


            }
        });
        holder.btnFalto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                listenerFabButton.onFabPrincipalClick(persona, holder.btnFalto);
                if (isVisiblebtnCurrentState) {
                    holder.btnCurrentState.setVisibility(gone);
                    holder.btnAsistio.setVisibility(gone);
                    holder.btnFalto.setVisibility(vis);
                    holder.btnJustificado.setVisibility(gone);
                    isVisiblebtnCurrentState = false;
                } else {
                    holder.btnCurrentState.setVisibility(vis);
                    holder.btnAsistio.setVisibility(vis);
                    holder.btnFalto.setVisibility(vis);
                    holder.btnJustificado.setVisibility(vis);
                    isVisiblebtnCurrentState = true;
                }
            }
        });
        holder.btnAsistio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                listenerFabButton.onFabPrincipalClick(persona, holder.btnAsistio);
                if (isVisiblebtnCurrentState) {
                    holder.btnCurrentState.setVisibility(gone);
                    holder.btnAsistio.setVisibility(vis);
                    holder.btnFalto.setVisibility(gone);
                    holder.btnJustificado.setVisibility(gone);
                    isVisiblebtnCurrentState = false;
                } else {
                    holder.btnCurrentState.setVisibility(vis);
                    holder.btnAsistio.setVisibility(vis);
                    holder.btnFalto.setVisibility(vis);
                    holder.btnJustificado.setVisibility(vis);
                    isVisiblebtnCurrentState = true;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return detalleContratoAcadList.size();
    }

    public class AsistenciaHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_nombresApellidos)
        TextView textViewDatos;
        @BindView(R.id.imgProfile)
        public ImageView imageViewProfile;
        @BindView(R.id.btnCurrentState)
        public FloatingActionButton btnCurrentState;
        @BindView(R.id.btnAsistio)
        public FloatingActionButton btnAsistio;
        @BindView(R.id.btnFalto)
        public FloatingActionButton btnFalto;
        @BindView(R.id.btnJustificado)
        public FloatingActionButton btnJustificado;

        public AsistenciaHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            btnAsistio.setVisibility(gone);
            btnFalto.setVisibility(gone);
            btnJustificado.setVisibility(gone);
        }
    }
}
