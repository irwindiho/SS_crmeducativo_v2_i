package com.consultoraestrategia.ss_crmeducativo.MainCursosDocente.view.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.consultoraestrategia.ss_crmeducativo.MainCursosDocente.view.activities.MainCursosDocenteActivity;
import com.consultoraestrategia.ss_crmeducativo.R;
import com.consultoraestrategia.ss_crmeducativo.TabsCursoDocente.view.activities.TabsCursoDocenteActivity;
import com.consultoraestrategia.ss_crmeducativo.entities.CargaAcademica;

import com.consultoraestrategia.ss_crmeducativo.entities.CargaAcademica_Table;
import com.consultoraestrategia.ss_crmeducativo.entities.CargaCursos;
import com.consultoraestrategia.ss_crmeducativo.entities.CargaCursos_Table;
import com.consultoraestrategia.ss_crmeducativo.entities.Cursos;
import com.consultoraestrategia.ss_crmeducativo.entities.Empleado;
import com.consultoraestrategia.ss_crmeducativo.entities.Empleado_Table;
import com.consultoraestrategia.ss_crmeducativo.entities.Periodo;
import com.consultoraestrategia.ss_crmeducativo.entities.Periodo_Table;
import com.consultoraestrategia.ss_crmeducativo.entities.Persona;
import com.consultoraestrategia.ss_crmeducativo.entities.Persona_Table;
import com.consultoraestrategia.ss_crmeducativo.entities.PlanCursos;
import com.consultoraestrategia.ss_crmeducativo.entities.PlanCursos_Table;
import com.consultoraestrategia.ss_crmeducativo.entities.Seccion;
import com.consultoraestrategia.ss_crmeducativo.entities.Seccion_Table;
import com.consultoraestrategia.ss_crmeducativo.lib.GlideImageLoader;
import com.consultoraestrategia.ss_crmeducativo.lib.ImageLoader;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by irvinmarin on 27/02/2017.
 */

public class NavViewMenuDocenteAdapter extends RecyclerView.Adapter<NavViewMenuDocenteAdapter.ViewHolder> {
    List<Cursos> cursosList;

    private MainCursosDocenteActivity activity;
    private boolean tareaVisible = false;
    private ImageLoader imageLoader;

    // Provee una referencia a cada item dentro de una vista y acceder a ellos facilmente
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Cada uno de los elementos de mi vista

        @BindView(R.id.txtInicial)
        TextView txtInicial;
        @BindView(R.id.txtMenuCursoo)
        TextView txtMenuCursoo;
        @BindView(R.id.txtNombrePeriodoPrograma)
        TextView txtNombrePeriodoPrograma;

        @BindView(R.id.content_navViewMenu)
        LinearLayout contentNavViewMenu;


        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);


        }
    }

    // Constructor
    public NavViewMenuDocenteAdapter(List<Cursos> cursosList, MainCursosDocenteActivity activity) {
        this.cursosList = cursosList;
        this.activity = activity;
        this.imageLoader = new GlideImageLoader(activity.getApplicationContext());
    }

    // Create new views (invoked by the layout managxer)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflo la vista (vista padre)
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.nav_item_menu_curso, parent, false);
        // creo el grupo de vistas


        return new ViewHolder(v);
    }

    private int[] colors;

    // Reemplaza en contenido de la vista
    @Override
    public void onBindViewHolder(final ViewHolder vh, final int position) {

        colors = activity.getResources().getIntArray(R.array.initial_colors);
        Cursos curso = cursosList.get(position);
//        PlanCursos planCursos = PlanCursos.find(PlanCursos.class, "curso_Id =?", cursosList.get(0).getCursoId() + "").get(0);
        PlanCursos planCursos = SQLite.select()
                .from(PlanCursos.class)
                .where(PlanCursos_Table.cursoId.is(curso.getCursoId()))
                .queryList().get(0);

//        CargaCursos cargaCursos = CargaCursos.find(CargaCursos.class, "plan_Curso_Id =?", planCursos.getPlanCursoId() + "").get(0);
        CargaCursos cargaCursos = SQLite.select()
                .from(CargaCursos.class)
                .where(CargaCursos_Table.planCursoId.is(planCursos.getPlanCursoId()))
                .queryList().get(0);
//        Empleado empleado = Empleado.find(Empleado.class, "empleado_Id =?", cargaCursos.getEmpleadoId() + "").get(0);
        Empleado empleado = SQLite.select()
                .from(Empleado.class)
                .where(Empleado_Table.empleadoId.is(cargaCursos.getEmpleadoId()))
                .queryList().get(0);
//        Persona persona = Persona.find(Persona.class, "persona_Id=?", empleado.getPersonaId() + "").get(0);
        Persona persona = SQLite.select()
                .from(Persona.class)
                .where(Persona_Table.personaId.is(empleado.getPersonaId()))
                .queryList().get(0);
//        CargaAcademica cargaAcademica = CargaAcademica.find(CargaAcademica.class, "carga_Academica_Id=?", cargaCursos.getCargaAcademicaId() + "").get(0);
        CargaAcademica cargaAcademica = SQLite.select()
                .from(CargaAcademica.class)
                .where(CargaAcademica_Table.cargaAcademicaId.is(cargaCursos.getCargaAcademicaId()))
                .queryList().get(0);
//        Seccion seccion = Seccion.find(Seccion.class, "seccion_Id=?", cargaAcademica.getSeccionId() + "").get(0);
        Seccion seccion = SQLite.select()
                .from(Seccion.class)
                .where(Seccion_Table.seccionId.is(cargaAcademica.getSeccionId()))
                .queryList().get(0);
//        Periodos periodos = Periodos.find(Periodos.class, "periodo_Id=?", cargaAcademica.getPeriodoId() + "").get(0);
        Periodo periodos = SQLite.select()
                .from(Periodo.class)
                .where(Periodo_Table.periodoId.is(cargaAcademica.getPeriodoId()))
                .queryList().get(0);

        String urlBackgroundResource = "";
        final int fondoSolid = colors[position];


        final int idCargaCurso = cargaCursos.getCargaCursoId();

        final String nomClase = cursosList.get(position).getNombre() + " - " + seccion.getDescripcion() + " " + seccion.getNombre();
        final String idCurso = cursosList.get(position).getCursoId() + "";
        final String peridoClase = "Programa: " + periodos.getNombre();
        final String nombreDocente = persona.getApellidoPaterno() + " " + persona.getApellidoMaterno() + ", " + persona.getNombres();


        char primeraLetra = nomClase.charAt(0);

        urlBackgroundResource = "http://www.curiosfera.com/wp-content/uploads/2016/11/Historia-de-los-n%C3%BAmeros.jpg";
        String url = "https://media.licdn.com/mpr/mpr/shrinknp_200_200/p/7/005/019/3f0/0c53a9f.jpg";


        vh.txtInicial.setText(String.format("%s", primeraLetra));
        vh.txtMenuCursoo.setText(nomClase);
        vh.txtNombrePeriodoPrograma.setText(peridoClase);
        final String finalUrlBackgroundResource1 = urlBackgroundResource;
        vh.contentNavViewMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] curso = new String[]{nomClase, peridoClase, nombreDocente, idCurso};
//                Log.d("ListaCursosAlumnoAdapter", "drawable_STRING: " + finalFondoInt);
                Intent intent = new Intent(activity, TabsCursoDocenteActivity.class);

                intent.putExtra("csoData", curso);
                intent.putExtra("fondo", fondoSolid);
                intent.putExtra("idCargaCurso", idCargaCurso);
                intent.putExtra("backgroudResource", finalUrlBackgroundResource1);

                activity.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return cursosList.size();
    }


}
