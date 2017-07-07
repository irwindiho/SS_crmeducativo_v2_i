package com.consultoraestrategia.ss_crmeducativo.login.view;

import android.app.ActivityOptions;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.consultoraestrategia.ss_crmeducativo.MainCursosAlumno.view.activities.MainCursosAlumnoActivity;
import com.consultoraestrategia.ss_crmeducativo.MainCursosDocente.view.activities.MainCursosDocenteActivity;
import com.consultoraestrategia.ss_crmeducativo.R;
import com.consultoraestrategia.ss_crmeducativo.asyntasks.LoginAsyntask;
import com.consultoraestrategia.ss_crmeducativo.asyntasks.LoginInterface;
import com.consultoraestrategia.ss_crmeducativo.entities.Rol;
import com.consultoraestrategia.ss_crmeducativo.entities.Usuario;
import com.consultoraestrategia.ss_crmeducativo.lib.GlideImageLoader;
import com.consultoraestrategia.ss_crmeducativo.lib.ImageLoader;
import com.consultoraestrategia.ss_crmeducativo.login.LoginPresenter;
import com.consultoraestrategia.ss_crmeducativo.login.LoginPresenterImpl;
import com.consultoraestrategia.ss_crmeducativo.login.LoginView;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.tapadoo.alerter.Alerter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.consultoraestrategia.ss_crmeducativo.util.Utils.isOnlineNet;


public class LoginActivity extends AppCompatActivity implements LoginView, LoginInterface {

    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.imgCover)
    ImageView imageViewCover;
    @BindView(R.id.layoutSession)
    ViewGroup viewGroupSession;
    @BindView(R.id.btnIngresar)
    AppCompatButton buttonSignIn;
    @BindView(R.id.btnIngresardemo)
    AppCompatButton btnIngresardemo;
    @BindView(R.id.editTextUsuario)
    EditText editTextUser;
    @BindView(R.id.editTextClave)
    EditText editTextPassword;
    @BindView(R.id.cvRecordarme)
    CheckBox cvRecordarme;
    @BindView(R.id.progress)
    ProgressBar progressDialog;
    @BindView(R.id.contendoPrincipal)
    CoordinatorLayout contendoPrincipal;

    ProgressDialog ringProgressDialog;

    boolean conection = isOnlineNet();


    String userNameDB;
    String userPassDB;


    private static final int REQUEST_CODE_READ_QR = 19;
    private static final String TAG = "LoginActivity";

    private LoginPresenter loginPresenter;
    private ImageLoader imageLoader;

    public void launchRingDialog() {
        ringProgressDialog = ProgressDialog.show(this, "Comprobando Usuario", "Espere ", true);
        ringProgressDialog.setCancelable(false);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        CargarPreferencias();

        if (!conection) {
            Snackbar.make(contendoPrincipal, "No se pudo conectar al Servidor, \n conectarse a internet.", Snackbar.LENGTH_INDEFINITE).show();
        } else {
            Log.d(TAG, "Conexion exitosa al Servidor");
        }
        imageLoader = new GlideImageLoader(this);
        loginPresenter = new LoginPresenterImpl(this);
        loginPresenter.onCreate();
        loginPresenter.onCheckForAutentificatedUser();
        /*probando*/
        fab.setEnabled(true);


        editTextUser.setEnabled(true);
        editTextPassword.setEnabled(true);
    }

    public void getDataFromDb(String userName, String userPass) {
        new LoginAsyntask(this, getApplicationContext()).execute(userName, userPass);
//
    }


    @OnClick(R.id.btnIngresardemo)
    public void onClickbtnIngresardemo() {
        launchRingDialog();
        userNameDB = editTextUser.getText().toString();
        userPassDB = editTextPassword.getText().toString();
        Drawable d = getResources().getDrawable(android.R.drawable.stat_sys_warning);
        d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
        if (userNameDB == "") {
            editTextUser.setError("Campo requerido", d);
        } else if (userPassDB == "") {
            editTextPassword.setError("Campo requerido", d);
        } else {

            if (conection) {
                try {
                    getDataFromDb(userNameDB, userPassDB);
                } catch (Exception e) {
                    Snackbar.make(contendoPrincipal, "Usuario o Password inconrrectos", Snackbar.LENGTH_INDEFINITE).show();
                }

            } else {
                String[] datosLogin = {userNameDB, userPassDB};


                Rol rol = SQLite.select().from(Rol.class).queryList().get(0);
                if (rol != null) {
                    int rolId = rol.getRolId();
                    if (rolId == 6) {
                        startActivity(new Intent(this, MainCursosAlumnoActivity.class).putExtra("DataLogin", datosLogin));
                    } else if (rolId == 4) {
                        startActivity(new Intent(this, MainCursosDocenteActivity.class).putExtra("DataLogin", datosLogin));
                    }
                } else {
                    Snackbar.make(contendoPrincipal, "No hay Roles Registrados", Snackbar.LENGTH_INDEFINITE).show();
                }
            }
        }

    }


    Usuario usuario;

    @Override
    protected void onRestart() {
        super.onRestart();
        ringProgressDialog.dismiss();
    }

    @Override
    protected void onDestroy() {
        loginPresenter.onDestroy();
        super.onDestroy();
    }

    @OnClick(R.id.fab)
    public void clickToScannerQr(View v) {
        goToActivity(QrScanner.class, fab);

    }

    @OnClick((R.id.btnIngresar))
    public void clickSignIn(View v) {
        loginPresenter.onSignInValidate(editTextUser.getText().toString(), editTextPassword.getText().toString());
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_READ_QR && data != null) {
            String info = data.getStringExtra("data_qr");
            Log.d(TAG, "REQUEST_CODE_READ_QR: " + REQUEST_CODE_READ_QR + " VALUE: " + info);
            loginPresenter.onValidateCodeQr(info);
        }


    }

    private void goToActivity(Class<?> cls, View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setExitTransition(new Explode());
            Intent intent = new Intent(LoginActivity.this, cls);

            ActivityOptions options = view != null ?
                    ActivityOptions.makeSceneTransitionAnimation(
                            LoginActivity.this, view, "view") :
                    ActivityOptions.makeSceneTransitionAnimation(
                            LoginActivity.this);
            startActivityForResult(intent, REQUEST_CODE_READ_QR, options.toBundle());

        } else {
            Intent intent = new Intent(LoginActivity.this, cls);
            startActivity(intent);
        }
    }

    @Override
    public void onSuccessReadQr(String nameParam, String descriptionParam) {
        String name = String.format(getString(R.string.login_configurarion_success_title), nameParam);
        String description = String.format(getString(R.string.login_configurarion_success_descripcion), descriptionParam);
        setMessage(name, description);
    }

    @Override
    public void onErrorReadQr() {

    }

    @Override
    public void onShowProgress() {
        progressDialog.setVisibility(View.VISIBLE);
    }

    @Override
    public void onHideProgress() {
        progressDialog.setVisibility(View.GONE);
    }

    @Override
    public void onShowViews() {
        viewGroupSession.setVisibility(View.VISIBLE);
    }

    @Override
    public void onHideViews() {
        viewGroupSession.setVisibility(View.GONE);
    }

    @Override
    public void onGoNextActivity() {
        Log.d(TAG, "onGoNextActivity");
        startActivity(new Intent(this, QrScanner.class));
        this.finish();
    }

    @Override
    public void onSuccessSignIn() {
        Snackbar.make(fab, "onSuccessSignIn", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onErrorSignIn(String error) {
        Snackbar.make(fab, "onErrorSignIn", Snackbar.LENGTH_SHORT).show();

    }

    @Override
    public void onEnableInputs() {
        enableWidgets(true);
    }

    @Override
    public void onDisableInputs() {
        enableWidgets(false);
    }

    @Override
    public void onLogoImageLoad(String url) {
        imageLoader.load(imageViewCover, url);
    }

    private void setMessage(String title, String description) {
        Alerter.create(this).setTitle(title).setText(description).setDuration(10000).show();
    }

    private void enableWidgets(boolean isEnable) {
        fab.setEnabled(isEnable);
        editTextUser.setEnabled(isEnable);
        editTextPassword.setEnabled(isEnable);
        buttonSignIn.setEnabled(isEnable);
    }

    @Override
    public void loginCorrecto(String mensaje) {
        ringProgressDialog.dismiss();
        ringProgressDialog.hide();
        GuardarPreferecia();
        String[] datosLogin = {userNameDB, userPassDB};


//        Usuario usuario = SQLite.select()
//                .from(Usuario.class)
//                .where(Usuario_Table.usuario.is(userNameDB))
//                .and(Usuario_Table.password.is(userPassDB))
//                .querySingle();
//
//        Log.d(TAG, "usuario: " + usuario.toString());
        List<Rol> rols = SQLite.select().
                from(Rol.class).queryList();

        String rolUsuario = rols.get(0).getNombre() + "";
        Log.d(TAG, "rolUsuario: " + rolUsuario);
        if (rolUsuario.equals("Alumno")) {
            startActivity(new Intent(this.getApplicationContext(), MainCursosAlumnoActivity.class).putExtra("DataLogin", datosLogin));
        } else if (rolUsuario.equals("Docente")) {
            startActivity(new Intent(this.getApplicationContext(), MainCursosDocenteActivity.class).putExtra("DataLogin", datosLogin));
        }


    }

    @Override
    public void loginError(String mensaje) {
        Snackbar.make(fab, "loginError : " + mensaje, Snackbar.LENGTH_SHORT).show();
        ringProgressDialog.dismiss();
        ringProgressDialog.hide();

    }

    @Override
    public void loginErrorProcedimiento(String mensaje) {
        Snackbar.make(fab, "loginErrorProcedimiento : " + mensaje, Snackbar.LENGTH_SHORT).show();
        ringProgressDialog.dismiss();
        ringProgressDialog.hide();

    }

    public void CargarPreferencias() {
        SharedPreferences miPreferencia = getSharedPreferences("PreferenciaUsuario", Context.MODE_PRIVATE);
        editTextUser.setText(miPreferencia.getString("nombre", ""));
        editTextPassword.setText(miPreferencia.getString("password", ""));
//        estado.setChecked(miPreferencia.getBoolean("checked", true));
    }

    public void GuardarPreferecia() {

        SharedPreferences miPreferencia = getSharedPreferences("PreferenciaUsuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = miPreferencia.edit();
        boolean valor = cvRecordarme.isChecked();
        String nombre = editTextUser.getText().toString();
        String password = editTextPassword.getText().toString();
        editor.putBoolean("checked", valor);
        editor.putString("nombre", nombre);
        editor.putString("password", password);
        editor.apply();
    }
}
