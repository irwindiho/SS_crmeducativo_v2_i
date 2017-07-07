package com.consultoraestrategia.ss_crmeducativo.asyntasks;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.consultoraestrategia.ss_crmeducativo.api.RestAPI;
import com.consultoraestrategia.ss_crmeducativo.entities.Entidad;
import com.consultoraestrategia.ss_crmeducativo.entities.Georeferencia;
import com.consultoraestrategia.ss_crmeducativo.entities.PersonaGeoreferencia;
import com.consultoraestrategia.ss_crmeducativo.entities.Rol;
import com.consultoraestrategia.ss_crmeducativo.entities.Usuario;
import com.consultoraestrategia.ss_crmeducativo.entities.UsuarioRolGeoreferencia;
import com.consultoraestrategia.ss_crmeducativo.util.Utils;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;


/**
 * Created by irvinmarin on 28/04/2017.
 */

public class LoginAsyntask extends AsyncTask<String, String, String> {
    private static final String TAG = "LoginAsyntask";

    private JSONObject jsonObject = null;
    private LoginInterface loginInterface;
    private RestAPI restAPI;
    private Context context;
    Usuario usuario;
    ObjectMapper mapper;

    int estado = 0;


    public LoginAsyntask(LoginInterface loginInterface, Context context) {
        this.loginInterface = loginInterface;
        restAPI = new RestAPI();
        this.context = context;
    }


    @Override
    protected String doInBackground(String... params) {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            jsonObject = restAPI.fobj_ObtenerUsuario(params[0], params[1]);

            Log.d(TAG, jsonObject.toString());
            if (Utils.isSuccess(jsonObject)) {
                usuario = mapper.readValue(Utils.getJsonObResult(jsonObject), Usuario.class);
                if (usuario.getUsuarioId() >= 1) {
                    manipulateInTransaction();
                } else {
                    estado = -1;
                }
            } else {
                estado = -2;
            }
        } catch (Exception e) {
            e.printStackTrace();
            estado = -2;
        }

        return null;
    }


    public void manipulateInTransaction() {

        for (Entidad model : usuario.getEntidades()) {
            model.save();
        }

        for (Georeferencia model : usuario.getGeoreferencias()) {
            model.save();
        }

        for (Rol model : usuario.getRoles()) {
            model.save();
        }

        for (UsuarioRolGeoreferencia model : usuario.getUsuarioRolGeoreferencias()) {
            model.save();
        }

        for (PersonaGeoreferencia model : usuario.getPersonaGeoreferencias()) {
            model.save();
        }


        usuario.save();
        estado = 1;
    }

    @Override
    protected void onCancelled(String s) {
        super.onCancelled(s);
    }

    @Override
    protected void onPostExecute(String s) {
        switch (estado) {
            case 1:
                loginInterface.loginCorrecto("SuccessFull");

                break;
            case -1:
                loginInterface.loginError("Error Usuario");
                break;
            case -2:
                loginInterface.loginErrorProcedimiento("Error Procedimiento ");
        }

        super.onPostExecute(s);
    }
}
