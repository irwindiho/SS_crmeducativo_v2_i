package com.consultoraestrategia.ss_crmeducativo.MainCursosDocente.view.activities;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.consultoraestrategia.ss_crmeducativo.MainCursosDocente.MainCursosPresenter;
import com.consultoraestrategia.ss_crmeducativo.MainCursosDocente.MainCursosPresenterImpl;
import com.consultoraestrategia.ss_crmeducativo.MainCursosDocente.MainCursosView;
import com.consultoraestrategia.ss_crmeducativo.MainCursosDocente.view.adapters.ListaCursosDocenteAdapter;
import com.consultoraestrategia.ss_crmeducativo.MainCursosDocente.view.adapters.NavViewMenuDocenteAdapter;
import com.consultoraestrategia.ss_crmeducativo.MainCursosDocente.view.fragments.AddNuevoCursoFragment;
import com.consultoraestrategia.ss_crmeducativo.R;
import com.consultoraestrategia.ss_crmeducativo.asyntasks.GetDatosAsyntask;
import com.consultoraestrategia.ss_crmeducativo.asyntasks.GetDatosInterface;
import com.consultoraestrategia.ss_crmeducativo.entities.Cursos;
import com.consultoraestrategia.ss_crmeducativo.entities.Persona;
import com.consultoraestrategia.ss_crmeducativo.entities.Persona_Table;
import com.consultoraestrategia.ss_crmeducativo.entities.Usuario;
import com.consultoraestrategia.ss_crmeducativo.entities.Usuario_Table;
import com.consultoraestrategia.ss_crmeducativo.lib.GlideImageLoader;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.consultoraestrategia.ss_crmeducativo.util.Utils.isOnlineNet;




public class MainCursosDocenteActivity extends AppCompatActivity implements MainCursosView, GetDatosInterface {
    GlideImageLoader imageLoader;
    Usuario us;
    private final String TAG = "MainCursosDocente";
    List<Cursos> cursosList;

    @BindView(R.id.rvListaClases)
    RecyclerView rvListaClases;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.contFragment)
    LinearLayout contFragment;
    @BindView(R.id.contentHeaderDrawer)
    ImageView contentHeaderDrawer;
    @BindView(R.id.imgProfile)
    ImageView imgProfile;
    @BindView(R.id.imgProfile3)
    ImageView imgProfile3;
    @BindView(R.id.imgProfile2)
    ImageView imgProfile2;
    @BindView(R.id.rvListaClasesDrawer)
    RecyclerView rvListaClasesDrawer;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.menu_nav_clases)
    TextView menuNavClases;
    @BindView(R.id.menu_nav_calendar)
    TextView menuNavCalendar;
    @BindView(R.id.menu_nav_notifications)
    TextView menuNavNotifications;
    @BindView(R.id.txtNombreApellidoDocente)
    TextView txtNombreApellidoDocente;
    @BindView(R.id.txtEmailDocente)
    TextView txtEmailDocente;
    @BindView(R.id.contendoPrincipal)
    CoordinatorLayout contendoPrincipal;
    private int[] colors;
    String userName;


    boolean conection = isOnlineNet();

    private MainCursosPresenter mainCursosPresenter;
    ProgressDialog ringProgressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cursos);
        ButterKnife.bind(this);

        String[] DataLogin = getIntent().getStringArrayExtra("DataLogin");
        userName = DataLogin[0];

        us = SQLite.select()
                .from(Usuario.class)
                .where(Usuario_Table.usuario.is(userName))
                .queryList().get(0);
        Log.d(TAG, "us :" + us.toString());
        imageLoader = new GlideImageLoader(this);
        mainCursosPresenter = new MainCursosPresenterImpl(this);
        mainCursosPresenter.onCreate();
        launchRingDialog();


    }

    public void launchRingDialog() {
        ringProgressDialog = ProgressDialog.show(this, "Cargando Datos", "Espere por favor ", true);
        ringProgressDialog.setCancelable(false);
        colors = getResources().getIntArray(R.array.initial_colors);
        if (!conection) {
            Snackbar.make(contendoPrincipal, "No tiene conexión  a internet", Snackbar.LENGTH_INDEFINITE).show();
            GetDatosCorrecto("exito");
        } else {
            List<Persona> persona = SQLite.select()
                    .from(Persona.class)
                    .queryList();
            if (persona.size() == 0) {
                getDatosAsyntask();
            } else {
                GetDatosCorrecto("exito");
            }
        }
    }

    private void getDatosAsyntask() {

        Log.d(TAG, "usuarioId :" + us.getUsuarioId());
        new GetDatosAsyntask(this, getApplicationContext()).execute(us.getUsuarioId());
    }

    private void getCursos(String userName) {
        cursosList = SQLite.select()
                .from(Cursos.class).queryList();
        Log.d(TAG, "cursosList :" + cursosList.size());
    }

    private void setupNavigationDrawer() {

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
//        navView.setNavigationItemSelectedListener(this);
        View navigationViewMenu = navView.getHeaderView(0);
        setupRecyclerHeader(navigationViewMenu);

    }

    private void setupRecyclerHeader(View menu) {


        rvListaClasesDrawer.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvListaClasesDrawer.setHasFixedSize(true);

        if (cursosList != null) {
            NavViewMenuDocenteAdapter listAdapter = new NavViewMenuDocenteAdapter(cursosList, this);
            rvListaClasesDrawer.setAdapter(listAdapter);
        }


    }

    @OnClick(R.id.menu_nav_clases)
    public void onClickMenuClases() {
        Toast.makeText(this, "Clases", Toast.LENGTH_LONG).show();
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    @OnClick(R.id.menu_nav_notifications)
    public void onClickMenuNotifications() {
        Toast.makeText(this, "Notifications", Toast.LENGTH_LONG).show();
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    private void setupToolbar() {
        toolbar.setTitle("Clases");
        setSupportActionBar(toolbar);
    }

    private void setupRecyclerWithAdapter() {

        rvListaClases.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvListaClases.setHasFixedSize(true);
        if (cursosList != null) {
            ListaCursosDocenteAdapter listAdapter = new ListaCursosDocenteAdapter(cursosList, this);
            rvListaClases.setAdapter(listAdapter);
        }
    }

    @Override
    public void onImageProfile1Load(String url) {
        String urlImageProfile = "https://media.licdn.com/mpr/mpr/shrinknp_200_200/p/7/005/019/3f0/0c53a9f.jpg";
        imageLoader.loadWithCircular(imgProfile, urlImageProfile);
    }

    @Override
    public void onImageProfile2Load(String url) {
        imageLoader.loadWithCircular(imgProfile2, url);
    }

    @Override
    public void onImageProfile3Load(String url) {
        imageLoader.loadWithCircular(imgProfile3, url);
    }

    @Override
    public void onImageBackgroudProfileLoad(String url) {
        String urlBackground = "https://assets.materialup.com/uploads/c0b9f1d9-3a2e-4c5f-b969-b9f26b6e6c14/preview.png";
        imageLoader.load(contentHeaderDrawer, urlBackground);
    }

    @Override
    public void onLoadSuccess() {

    }

    @Override
    public void onLoadError(String url) {

    }

    @Override
    public void onShowImagesProfile() {
        showImageProfiles(View.VISIBLE);
    }

    @Override
    public void onHideImagesProfile() {
        showImageProfiles(View.INVISIBLE);
    }

    @OnClick(R.id.menu_nav_calendar)
    @Override
    public void onClickCalendarMenu() {

        try {
            Intent i;
            PackageManager manager = getPackageManager();
            i = manager.getLaunchIntentForPackage("com.android.calendar");
            i.addCategory(Intent.CATEGORY_LAUNCHER);
            startActivity(i);
        } catch (Exception e) {
//                Toast.makeText(this, "No se pudo abrir el Calendario", Toast.LENGTH_LONG).show();
        }
        drawerLayout.closeDrawer(GravityCompat.START);

    }


    @Override
    public void onSetTextDataProfileNavView() {
        Log.d(TAG, "user:" + us.toString());
        List<Persona> personaList = SQLite.select()
                .from(Persona.class)
                .queryList();
        Log.d(TAG, "personaList:" + personaList.toString());
//        Persona persona = Persona.find(Persona.class, "persona_Id =?", us.getPersonaId() + "").get(0);
        Persona persona = SQLite.select()
                .from(Persona.class)
                .where(Persona_Table.personaId.is(us.getPersonaId()))
                .queryList().get(0);

        Log.d(TAG, "persona:" + persona.toString());

        String nombre = persona.getNombres();
        String apePaterno = persona.getApellidoPaterno();
        String apeMaterno = persona.getApellidoMaterno();
        String correo = persona.getCorreo();
        String nombreCompleto = apePaterno + " " + apeMaterno + ", " + nombre;


        txtNombreApellidoDocente.setText(nombreCompleto);
        if (correo == "") {
            txtEmailDocente.setText("Correo no Registrado");
        } else {
            txtEmailDocente.setText(correo);
        }
    }

    @Override
    public void onGetDatosDocente() {

    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.list_cursos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_add_class) {

            AddNuevoCursoFragment addNuevoCursoFragment = new AddNuevoCursoFragment();

            addNuevoCursoFragment.show(getFragmentManager(), "addNuevoCursoFragment");

            Fragment fragEstudiante = getFragmentManager().findFragmentByTag("addNuevoCursoFragment");


            if (fragEstudiante != null) {
                getFragmentManager().beginTransaction().remove(fragEstudiante).commit();
            }

            return true;
        }
        if (id == R.id.action_actualizar) {
            return true;
        }
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void showImageProfiles(int isVisible) {
//        imgProfile.setVisibility(isVisible);
        imgProfile2.setVisibility(isVisible);
        imgProfile3.setVisibility(isVisible);

    }

    @Override
    public void GetDatosCorrecto(String mensaje) {
        ringProgressDialog.dismiss();
        ringProgressDialog.hide();

//        Toast.makeText(getApplicationContext(), "Espere acargado datos", Toast.LENGTH_LONG).show();
        setContents();
    }

    private void setContents() {
        getCursos(userName);
        setupToolbar();
        setupNavigationDrawer();
        onHideImagesProfile();
        setupRecyclerWithAdapter();
        onImageProfile1Load("");
        onSetTextDataProfileNavView();
        onImageBackgroudProfileLoad("");
        onGetDatosDocente();
    }


    @Override
    public void GetDatosError(String mensaje) {
        ringProgressDialog.dismiss();
        ringProgressDialog.hide();
        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
        setContents();
    }

    @Override
    public void GetDatosErrorProcedimiento(String mensaje) {
        ringProgressDialog.dismiss();
        ringProgressDialog.hide();
        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
        setContents();
    }

}
