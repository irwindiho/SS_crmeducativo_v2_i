package com.consultoraestrategia.ss_crmeducativo.TabsCursoDocente.view.activities;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;

import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.consultoraestrategia.ss_crmeducativo.R;
import com.consultoraestrategia.ss_crmeducativo.TabsCursoDocente.TabsCursoPresenter;
import com.consultoraestrategia.ss_crmeducativo.TabsCursoDocente.TabsCursoView;
import com.consultoraestrategia.ss_crmeducativo.TabsCursoDocente.view.adapters.PagerCursoAdapter;
import com.consultoraestrategia.ss_crmeducativo.evaluacion.view.fragments.DialogFragmentVerSessiones;
import com.consultoraestrategia.ss_crmeducativo.TabsCursoDocente.view.interfacesUtils.OnDialogVerSesionListener;
import com.consultoraestrategia.ss_crmeducativo.lib.GlideImageLoader;
import com.consultoraestrategia.ss_crmeducativo.lib.ImageLoader;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.StringTokenizer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TabsCursoDocenteActivity extends AppCompatActivity implements TabsCursoView, OnDialogVerSesionListener {


    private static final String TAG = "TabsCursoAlumnoActivity";


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.txtNombreCurso)
    TextView txtNombreCurso;
    @BindView(R.id.txtPeriodoSeccion)
    TextView txtPeriodoSeccion;
    @BindView(R.id.tab_curso)
    TabLayout tabCurso;
    @BindView(R.id.vp_Curso)
    ViewPager vpCurso;
    @BindView(R.id.app_bar)
    AppBarLayout appbar;
    @BindView(R.id.img_iconCurso)
    ImageView img_iconCurso;
    @BindView(R.id.imgBackgroundAppbar)
    ImageView imgBackgroundAppbar;
    @BindView(R.id.ctl_tabcursos)
    CollapsingToolbarLayout collapsingToolbarLayout;


    TabsCursoPresenter cursoPresenter;
    @BindView(R.id.txtSeccion)
    TextView txtSeccion;

    static TextView txtMes;
    static TextView txtNombreDia;
    static TextView txtDia;


    @BindView(R.id.contentDataCursoToolbar)
    LinearLayout contentDataCursoToolbar;
    @BindView(R.id.contentFechaSesiones)
    LinearLayout contentFechaSesiones;
    @BindView(R.id.txtNroSesion)
    TextView txtNroSesion;
    private ImageLoader imageLoader;


    boolean getFondo = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs_curso);
        imageLoader = new GlideImageLoader(this);


        initViews();
        ButterKnife.bind(this);
        setupToolbar();
        setupTabWihtPager();
        setupFechaActual("");
        getAlumnosCurso();

    }

    private void getAlumnosCurso() {

    }


    private void setupFechaActual(String fechaSession) {

        Date date;

        Calendar cal = Calendar.getInstance();
        int yy = cal.get(Calendar.YEAR);
        int mm = cal.get(Calendar.MONTH);
        int dd = cal.get(Calendar.DAY_OF_MONTH);
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        if (fechaSession!= "") {
            StringTokenizer tokens = new StringTokenizer(fechaSession, "/");
            dd = Integer.parseInt(tokens.nextToken());
            mm = Integer.parseInt(tokens.nextToken()) - 1;
            yy = Integer.parseInt(tokens.nextToken());
            date = new Date(yy, mm, dd - 1);
        } else {
            date = new Date(yy, mm, dd - 1);
        }
        String dayOfTheWeek = sdf.format(date);
        String yearMonth = new DateFormatSymbols().getShortMonths()[mm];

        Log.d(TAG, "NOMB/DIA/MES: " + dayOfTheWeek + ", " + dd + " de " + yearMonth);

        txtMes.setText(yearMonth);
        txtDia.setText(" " + dd);
        txtNombreDia.setText(dayOfTheWeek);
    }

    private void initViews() {
        txtMes = (TextView) findViewById(R.id.txtMes);
        txtDia = (TextView) findViewById(R.id.txtDia);
        txtNombreDia = (TextView) findViewById(R.id.txtNombreDia);
    }

    public void setupToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            appbar.setTransitionName("view");
        }

        onSetDataTitle();
    }

    private void setupTabWihtPager() {
        toolbar.setTitle("Portal Academico");
        setSupportActionBar(toolbar);
        tabCurso.addTab(tabCurso.newTab().setText("Asistencia"));
        tabCurso.addTab(tabCurso.newTab().setText("Evaluación"));
        tabCurso.addTab(tabCurso.newTab().setText("Sesiones"));
        tabCurso.addTab(tabCurso.newTab().setText("Tarea"));
        tabCurso.setTabGravity(TabLayout.GRAVITY_CENTER);

        tabCurso.setTabMode(TabLayout.MODE_SCROLLABLE);

        PagerCursoAdapter pagerCursoAdapter = new PagerCursoAdapter(getSupportFragmentManager(), tabCurso.getTabCount(), fondoInt, idCargaCurso,cursoId);

        vpCurso.setAdapter(pagerCursoAdapter);
        vpCurso.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabCurso));

        tabCurso.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vpCurso.setCurrentItem(tab.getPosition());
                Log.d(TAG, "setCurrentItem: " + tab.getPosition());
                setVisibleSessionPickDate(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


    private void disableTabs(TabLayout.Tab tab, int position) {
        if (tab.getText() == "Evaluación") {


        }
    }

    private void setVisibleSessionPickDate(int position) {
        int gone = View.GONE;
        int vis = View.VISIBLE;
        contentDataCursoToolbar.setVisibility(vis);

        if (position != 0) {
            contentFechaSesiones.setVisibility(gone);
            contentDataCursoToolbar.setVisibility(vis);
        } else {
            contentDataCursoToolbar.setVisibility(vis);
            contentFechaSesiones.setVisibility(vis);
        }
    }


    @OnClick(R.id.contFecha)
    public void onClickConFecha() {
        DialogFragment newFragment = new SelectDateFragment();
        newFragment.show(getSupportFragmentManager(), "DatePicker");
    }

    @OnClick(R.id.contSession)
    public void onClickcontSession() {
        DialogFragment newFragment = new DialogFragmentVerSessiones();
        newFragment.show(getSupportFragmentManager(), "newFragment");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tabs_curso, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            finish();
            return true;
        }

        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_quitar_fondo) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onImageCursoLoad(String url) {
    }

    int fondoInt;
    int idCargaCurso;
    int cursoId;
    @Override
    public void onSetDataTitle() {
        String[] csoData = getIntent().getExtras().getStringArray("csoData");
        String urlBackgroudResource = getIntent().getStringExtra("backgroudResource");
        idCargaCurso = getIntent().getIntExtra("idCargaCurso", 1);
        cursoId = getIntent().getIntExtra("cursoId", 0);
        fondoInt = getIntent().getIntExtra("fondo", 0);

        assert csoData != null;

        txtNombreCurso.setText(csoData[0]);
        txtPeriodoSeccion.setText(csoData[1]);
        imageLoader.load(imgBackgroundAppbar, urlBackgroudResource);


        String url = "https://assets.materialup.com/uploads/c0b9f1d9-3a2e-4c5f-b969-b9f26b6e6c14/preview.png";
        imageLoader.load(img_iconCurso, url);
        appbar.setBackgroundColor(fondoInt);
    }


    @Override
    public void onLoadSuccess() {

    }

    @Override
    public void onLoadError(String url) {

    }


    @Override
    public void onPossitiveButtonClick(String fechaSession, int NroSesion) {
        txtNroSesion.setText(NroSesion + "");
        setupFechaActual(fechaSession);
    }

    @Override
    public void onNegativeButtonClick() {

    }

    public static class SelectDateFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        Calendar calendar;
        int diaSemana;


        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            calendar = Calendar.getInstance();
            int yy = calendar.get(Calendar.YEAR);
            int mm = calendar.get(Calendar.MONTH);
            int dd = calendar.get(Calendar.DAY_OF_MONTH);
            diaSemana = calendar.get(Calendar.DAY_OF_WEEK);

            return new DatePickerDialog(getActivity(), this, yy, mm, dd);
        }


        public void onDateSet(DatePicker view, int yy, int mm, int dd) {


            SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
            Date date = new Date(yy, mm, dd - 1);
            String dayOfTheWeek = sdf.format(date);


//            String weekday = new DateFormatSymbols().getWeekdays()[diaSemana];
            String yearMonth = new DateFormatSymbols().getShortMonths()[mm];

            Log.d(TAG, "NOMB/DIA/MES: " + dayOfTheWeek + ", " + dd + " de " + yearMonth);

            int mesCorrect = mm + 1;

            txtMes.setText(yearMonth);
            txtDia.setText(" " + dd);
            txtNombreDia.setText(dayOfTheWeek);
        }


    }
}



