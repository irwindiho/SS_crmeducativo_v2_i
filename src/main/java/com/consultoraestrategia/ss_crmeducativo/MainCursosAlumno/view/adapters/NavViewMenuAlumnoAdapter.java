package com.consultoraestrategia.ss_crmeducativo.MainCursosAlumno.view.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.consultoraestrategia.ss_crmeducativo.MainCursosAlumno.view.activities.MainCursosAlumnoActivity;
import com.consultoraestrategia.ss_crmeducativo.R;
import com.consultoraestrategia.ss_crmeducativo.TabsCursoDocente.view.activities.TabsCursoDocenteActivity;
import com.consultoraestrategia.ss_crmeducativo.entities.Curso;
import com.consultoraestrategia.ss_crmeducativo.entities.Cursos;
import com.consultoraestrategia.ss_crmeducativo.entities.Persona;
import com.consultoraestrategia.ss_crmeducativo.lib.GlideImageLoader;
import com.consultoraestrategia.ss_crmeducativo.lib.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;


/**
 * Created by irvinmarin on 27/02/2017.
 */

public class NavViewMenuAlumnoAdapter extends RecyclerView.Adapter<NavViewMenuAlumnoAdapter.ViewHolder> {
    List<Cursos> cursosList;

    private ArrayList<Curso> cursoArrayList;
    private MainCursosAlumnoActivity activity;
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
    public NavViewMenuAlumnoAdapter(List<Cursos> cursosList, MainCursosAlumnoActivity activity) {
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
        Persona persona = null;
        String nombreDocente = "";
        colors = activity.getResources().getIntArray(R.array.initial_colors);
        final Cursos curso = cursosList.get(position);
        Log.d(TAG, "curso: " + curso.toString() + "");
//        PlanCursos planCursos = PlanCursos.find(PlanCursos.class, "curso_Id=?", curso.getCursoId() + "").get(0);
//        Log.d(TAG, "planCursos: " + planCursos.toString() + "");
//        CargaCursos cargaCursos = CargaCursos.find(CargaCursos.class, "plan_Curso_Id=?", planCursos.getPlanCursoId() + "").get(0);
//        Log.d(TAG, "CargaCursos : " + cargaCursos.toString() + "");
//        if (cargaCursos.getEmpleadoId() != 0) {
//            Empleado empleado = Empleado.find(Empleado.class, "empleado_Id =?", cargaCursos.getEmpleadoId() + "").get(0);
//            persona = Persona.find(Persona.class, "persona_Id=?", empleado.getPersonaId() + "").get(0);
            nombreDocente = persona.getApellidoPaterno() + " " + persona.getApellidoMaterno() + ", " + persona.getNombres();
//        } else {
//            nombreDocente = "Docente no Asignado";

//        }
//        CargaAcademica cargaAcademica = CargaAcademica.find(CargaAcademica.class, "carga_Academica_Id=?", cargaCursos.getCargaAcademicaId() + "").get(0);
//        Log.d(TAG, "AnioAcademico : " + cargaAcademica.toString() + "");
//

//        Seccion seccion = Seccion.find(Seccion.class, "seccion_Id=?", cargaAcademica.getSeccionId() + "").get(0);
//        Periodos periodos = Periodos.find(Periodos.class, "periodo_Id=?", cargaAcademica.getPeriodoId() + "").get(0);
//        String urlBackgroundResource = "";
//        final int fondoSolid = colors[position];


//        final int idCargaCurso = cargaCursos.getCargaCursoId();

        final String nomCurso = cursosList.get(position).getNombre();//
        final int cursoId = cursosList.get(position).getCursoId();//
        //        final String nomPlan = "Programa: " + programasEducativo.getEvaluacionCapacidadList() + "- " + periodos.getEvaluacionCapacidadList();
//        final String nomPlan = "Grado: " + periodos.getNombre() + " -" + seccion.getDescripcion() + ": " + seccion.getNombre();






        char primeraLetra = nomCurso.charAt(0);

//        urlBackgroundResource = "http://www.curiosfera.com/wp-content/uploads/2016/11/Historia-de-los-n%C3%BAmeros.jpg";
        String url = "https://media.licdn.com/mpr/mpr/shrinknp_200_200/p/7/005/019/3f0/0c53a9f.jpg";


        vh.txtInicial.setText(String.format("%s", primeraLetra));
        vh.txtMenuCursoo.setText(nomCurso);
//        vh.txtNombrePeriodoPrograma.setText(nomPlan);
//        final String finalUrlBackgroundResource1 = urlBackgroundResource;
        final String finalNombreDocente = nombreDocente;
        vh.contentNavViewMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String[] curso = new String[]{nomCurso, nomPlan, finalNombreDocente};
//                Log.d("ListaCursosAlumnoAdapter", "drawable_STRING: " + finalFondoInt);
                Intent intent = new Intent(activity, TabsCursoDocenteActivity.class);

//                intent.putExtra("csoData", curso);
//                intent.putExtra("fondo", fondoSolid);
//                intent.putExtra("idCargaCurso", idCargaCurso);
//                intent.putExtra("backgroudResource", finalUrlBackgroundResource1);

                activity.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return cursosList.size();
    }


}
