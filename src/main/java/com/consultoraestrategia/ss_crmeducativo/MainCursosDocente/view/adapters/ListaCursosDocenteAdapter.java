package com.consultoraestrategia.ss_crmeducativo.MainCursosDocente.view.adapters;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.consultoraestrategia.ss_crmeducativo.MainCursosDocente.view.activities.MainCursosDocenteActivity;
import com.consultoraestrategia.ss_crmeducativo.R;
import com.consultoraestrategia.ss_crmeducativo.TabsCursoDocente.view.activities.TabsCursoDocenteActivity;
import com.consultoraestrategia.ss_crmeducativo.entities.CargaAcademica;
import com.consultoraestrategia.ss_crmeducativo.entities.CargaAcademica_Table;
import com.consultoraestrategia.ss_crmeducativo.entities.CargaCursos;
import com.consultoraestrategia.ss_crmeducativo.entities.CargaCursos_Table;
import com.consultoraestrategia.ss_crmeducativo.entities.Cursos;
import com.consultoraestrategia.ss_crmeducativo.entities.DesarrolloCompetenciaCurso;
import com.consultoraestrategia.ss_crmeducativo.entities.DesarrolloCompetenciaCurso_Table;
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
import com.consultoraestrategia.ss_crmeducativo.entities.Tarea;
import com.consultoraestrategia.ss_crmeducativo.lib.GlideImageLoader;
import com.consultoraestrategia.ss_crmeducativo.lib.ImageLoader;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.shehabic.droppy.DroppyClickCallbackInterface;
import com.shehabic.droppy.DroppyMenuPopup;
import com.shehabic.droppy.animations.DroppyFadeInAnimation;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

//import com.shehabic.droppy.DroppyClickCallbackInterface;
//import com.shehabic.droppy.DroppyMenuPopup;
//import com.shehabic.droppy.animations.DroppyFadeInAnimation;


/**
 * Created by irvinmarin on 27/02/2017.
 */

public class ListaCursosDocenteAdapter extends RecyclerView.Adapter<ListaCursosDocenteAdapter.ViewHolder> {
    List<Cursos> cursosList;

    public static ArrayList<Tarea> tareaArrayList;
    private static MainCursosDocenteActivity activity;
    private ImageLoader imageLoader;
    private static Context context;
    private int[] colors;

    public ListaCursosDocenteAdapter(List<Cursos> cursosList, MainCursosDocenteActivity activity) {
        this.cursosList = cursosList;
        this.activity = activity;
        this.imageLoader = new GlideImageLoader(activity.getApplicationContext());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txtNombreCurso)
        TextView txtNombreCurso;
        @BindView(R.id.cardviewCurso)
        CardView cardviewCurso;
        @BindView(R.id.txtPerido)
        TextView txtPerido;
        @BindView(R.id.txtNombreDocente)
        TextView txtNombreDocente;
        @BindView(R.id.imgAccionClase)
        ImageButton accionClase;
        @BindView(R.id.imgDocente)
        ImageView imgDocente;
        @BindView(R.id.fondo)
        ImageView fondo;
        @BindView(R.id.btnOpenTabsCurso)
        View btnOpenTabsCurso;
        @BindView(R.id.contTareas)
        LinearLayout contTareas;
        @BindView(R.id.contentDataCurso)
        RelativeLayout contentDataCurso;
        @BindView(R.id.contItemView)
        LinearLayout contItemView;

        @BindView(R.id.rvListaTareas)
        RecyclerView rvListaTareas;


        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);

            context = activity.getApplicationContext();


        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cursos, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder vh, final int position) {

        colors = activity.getResources().getIntArray(R.array.initial_colors);


        final Cursos curso = cursosList.get(position);
        Log.d(TAG, "curso: " + curso.toString() + "");


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

        final List<DesarrolloCompetenciaCurso> desComCursoGeneral = SQLite.select()
                .from(DesarrolloCompetenciaCurso.class)
                .where(DesarrolloCompetenciaCurso_Table.planCursoId.is(planCursos.getPlanCursoId()))
                .queryList();


        tareaArrayList = null;
        Animation animationIn = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        vh.cardviewCurso.setAnimation(animationIn);
        String urlBackgroundImage = "";
        int color = 0;

        final String nomCurso = cursosList.get(position).getNombre();//
        final int cursoId = cursosList.get(position).getCursoId();//

        final String nomPlan = "Grado: " + periodos.getNombre() + "- " + seccion.getDescripcion() + ": " + seccion.getNombre();
        final int idCargaCurso = cargaCursos.getCargaCursoId();
        final String nombreDocente = persona.getApellidoPaterno() + " " + persona.getApellidoMaterno() + ", " + persona.getNombres();
//        final String nombreDocente ="Guillermo Mamani ";


        final int fondoSolid = colors[position];


        vh.contentDataCurso.setBackgroundColor(fondoSolid);

        urlBackgroundImage = "http://www.curiosfera.com/wp-content/uploads/2016/11/Historia-de-los-n%C3%BAmeros.jpg";
        String urlPerfil = "https://media.licdn.com/mpr/mpr/shrinknp_200_200/p/7/005/019/3f0/0c53a9f.jpg";
//
        vh.txtNombreCurso.setText(nomCurso);
        vh.txtPerido.setText(nomPlan);
        vh.txtNombreDocente.setText(nombreDocente);
        imageLoader.loadWithCircular(vh.imgDocente, urlPerfil);
//


        if ((position % 2) == 0) {

            urlBackgroundImage = "http://www.sumatealexito.com/wp-content/uploads/2013/05/libros-plan-de-negocio.jpg";
            imageLoader.load(vh.fondo, urlBackgroundImage);

        } else if ((position % 3) == 0) {
//            populateTareas();
//                vh.txtTarea.setText("");
            urlBackgroundImage = "https://previews.123rf.com/images/kurhan/kurhan1410/kurhan141000111/32818471-Familia-feliz-cerca-del-nuevo-hogar--Foto-de-archivo.jpg";
            imageLoader.load(vh.fondo, urlBackgroundImage);
            vh.rvListaTareas.setLayoutManager(new LinearLayoutManager(context));
            vh.rvListaTareas.setHasFixedSize(true);

//            if (tareaArrayList.size() > 0) {
//                ListaTareaCursoAlumnoAdapter listAdapter = new ListaTareaCursoAlumnoAdapter(tareaArrayList, activity);
//                vh.rvListaTareas.setAdapter(listAdapter);
//            }

        } else {

            imageLoader.load(vh.fondo, urlBackgroundImage);
        }

        final ViewGroup.LayoutParams paramsContTareas = vh.contTareas.getLayoutParams();

        final int finalFondoInt = color;
        final String finalUrlBackgroundResource = urlBackgroundImage;

        if (tareaArrayList == null) {
            paramsContTareas.height = 0;
            vh.contTareas.setLayoutParams(paramsContTareas);
            vh.contTareas.setPadding(0, 0, 0, 0);
        }

        vh.accionClase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GenerateMenu(v);
            }
        });

        vh.contItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (desComCursoGeneral.size() > 0) {
                    String[] csoData = new String[]{nomCurso, nomPlan, nombreDocente};
                    goToActivity(TabsCursoDocenteActivity.class, v, fondoSolid, curso, csoData, finalUrlBackgroundResource, idCargaCurso, cursoId);
                } else {
                    Toast.makeText(v.getContext(), "Curso  pendiente", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return cursosList.size();
    }


    private void populateTareas() {
        tareaArrayList = new ArrayList<>();
        tareaArrayList.add(new Tarea("Resolver libro cap2", ""));
        tareaArrayList.add(new Tarea("Resolver libro cap3", ""));
        tareaArrayList.add(new Tarea("Leer y aprenderse salmos 8 ", ""));
    }

    private void goToActivity(Class<?> cls, View view, int fondoSolid, Cursos curso, String[] csoData, String urlBackgroundResource, int idCargaCurso, int cursoId) {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().setExitTransition(new Explode());
            Intent intent = new Intent(activity.getApplicationContext(), cls);
            intent.putExtra("csoData", csoData);
            intent.putExtra("fondo", fondoSolid);
            intent.putExtra("idCargaCurso", idCargaCurso);
            intent.putExtra("cursoId", cursoId);
            intent.putExtra("backgroudResource", urlBackgroundResource);

            ActivityOptions options = view != null ?
                    ActivityOptions.makeSceneTransitionAnimation(
                            activity, view, "view") :
                    ActivityOptions.makeSceneTransitionAnimation(
                            activity);
            activity.startActivityForResult(intent, 19, options.toBundle());

        } else {
            Intent intent = new Intent(activity, cls);
            intent.putExtra("csoData", csoData);
            intent.putExtra("fondo", fondoSolid);
            intent.putExtra("idCargaCurso", idCargaCurso);
            intent.putExtra("cursoId", cursoId);
            intent.putExtra("backgroudResource", urlBackgroundResource);
            activity.startActivity(intent);
        }
    }

    private void GenerateMenu(final View v) {
        DroppyMenuPopup.Builder droppyBuilder = new DroppyMenuPopup.Builder(v.getContext(), v);
        DroppyMenuPopup droppyMenu = droppyBuilder.fromMenu(R.menu.menu_curso_accion)
                .triggerOnAnchorClick(false)
                .setOnClick(new DroppyClickCallbackInterface() {
                    @Override
                    public void call(View v, int id) {
                        Log.d("Id:", String.valueOf(id));
                    }
                })
                .setOnDismissCallback(new DroppyMenuPopup.OnDismissCallback() {
                    @Override
                    public void call() {
//                        Toast.makeText(v.getContext(), "Menu dismissed", Toast.LENGTH_SHORT).show();
                    }
                })
                .setPopupAnimation(new DroppyFadeInAnimation())
                .setXOffset(1)
                .setYOffset(1)
                .build();
        droppyMenu.show();
    }
}
