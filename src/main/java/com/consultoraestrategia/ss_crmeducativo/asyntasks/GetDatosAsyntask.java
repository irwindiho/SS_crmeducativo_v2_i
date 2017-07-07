package com.consultoraestrategia.ss_crmeducativo.asyntasks;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.consultoraestrategia.ss_crmeducativo.api.RestAPI;
import com.consultoraestrategia.ss_crmeducativo.entities.AnioAcademico;
import com.consultoraestrategia.ss_crmeducativo.entities.Aula;
import com.consultoraestrategia.ss_crmeducativo.entities.BEDatosEnvio;
import com.consultoraestrategia.ss_crmeducativo.entities.CalendarioAcademico;
import com.consultoraestrategia.ss_crmeducativo.entities.CalendarioPeriodo;
import com.consultoraestrategia.ss_crmeducativo.entities.CargaAcademica;
import com.consultoraestrategia.ss_crmeducativo.entities.CargaCursos;
import com.consultoraestrategia.ss_crmeducativo.entities.ColorCondicional;
import com.consultoraestrategia.ss_crmeducativo.entities.Competencia;
import com.consultoraestrategia.ss_crmeducativo.entities.Contrato;
import com.consultoraestrategia.ss_crmeducativo.entities.CuentaCorriente;
import com.consultoraestrategia.ss_crmeducativo.entities.CursoCompetencia;
import com.consultoraestrategia.ss_crmeducativo.entities.Cursos;
import com.consultoraestrategia.ss_crmeducativo.entities.DesarrolloCompetenciaCurso;
import com.consultoraestrategia.ss_crmeducativo.entities.DetalleContratoAcad;
import com.consultoraestrategia.ss_crmeducativo.entities.Empleado;
import com.consultoraestrategia.ss_crmeducativo.entities.Estados;
import com.consultoraestrategia.ss_crmeducativo.entities.EvaluacionCapacidad;
import com.consultoraestrategia.ss_crmeducativo.entities.EvaluacionProceso;
import com.consultoraestrategia.ss_crmeducativo.entities.EvaluacionResultado;
import com.consultoraestrategia.ss_crmeducativo.entities.NivelAcademico;
import com.consultoraestrategia.ss_crmeducativo.entities.Periodo;
import com.consultoraestrategia.ss_crmeducativo.entities.Persona;
import com.consultoraestrategia.ss_crmeducativo.entities.PlanCursos;
import com.consultoraestrategia.ss_crmeducativo.entities.PlanCursosAlumno;
import com.consultoraestrategia.ss_crmeducativo.entities.PlanEstudios;
import com.consultoraestrategia.ss_crmeducativo.entities.Relaciones;
import com.consultoraestrategia.ss_crmeducativo.entities.RubroEvalRNPFormula;
import com.consultoraestrategia.ss_crmeducativo.entities.RubroEvalRNRFormula;
import com.consultoraestrategia.ss_crmeducativo.entities.RubroEvaluacionProceso;
import com.consultoraestrategia.ss_crmeducativo.entities.RubroEvaluacionResultado;
import com.consultoraestrategia.ss_crmeducativo.entities.Seccion;
import com.consultoraestrategia.ss_crmeducativo.entities.SilaboEvento;
import com.consultoraestrategia.ss_crmeducativo.entities.TipoNota;
import com.consultoraestrategia.ss_crmeducativo.entities.Tipos;
import com.consultoraestrategia.ss_crmeducativo.entities.ValorTipoNota;
import com.consultoraestrategia.ss_crmeducativo.util.Utils;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;

import java.util.Collections;


/**
 * Created by irvinmarin on 28/04/2017.
 */

public class GetDatosAsyntask extends AsyncTask<Integer, String, String> {
    private static final String TAG = "GetDatosAsyntask";

    private JSONObject jsonObject = null;
    private GetDatosInterface getDatosInterface;
    private RestAPI restAPI;
    private Context context;
    ObjectMapper mapper;
    private BEDatosEnvio beDatosEnvio;
    int estado = 0;


    public GetDatosAsyntask(GetDatosInterface getDatosInterface, Context context) {
        this.getDatosInterface = getDatosInterface;
        restAPI = new RestAPI();
        this.context = context;
    }


    @Override
    protected String doInBackground(Integer... params) {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            jsonObject = restAPI.flst_ObtenerDatos(params[0]);

            Log.d(TAG, jsonObject.toString());
            if (Utils.isSuccess(jsonObject)) {
                beDatosEnvio = mapper.readValue(Utils.getJsonObResult(jsonObject), BEDatosEnvio.class);
                if (beDatosEnvio != null) {
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


    public void SaveListImc(Collections collections) {
//        for (int i = 0; i < list.size(); i++) {
//            list.get(i).save();
//        }

    }


    private void manipulateInTransaction() {

        for (AnioAcademico model : beDatosEnvio.getAnioAcademicos()) {
            model.save();
        }
        for (Contrato model : beDatosEnvio.getContratos()) {
            model.save();
        }
        for (DetalleContratoAcad model : beDatosEnvio.getDetalleContratoAcad()) {
            model.save();
        }
        for (CargaAcademica model : beDatosEnvio.getCargasAcademicas()) {
            model.save();
        }
        for (CargaCursos model : beDatosEnvio.getCargaCursos()) {
            model.save();
        }
        for (Empleado model : beDatosEnvio.getEmpleados()) {
            model.save();
        }
        for (PlanCursos model : beDatosEnvio.getPlanCursos()) {
            model.save();
        }
        for (Cursos model : beDatosEnvio.getCursos()) {
            model.save();
        }
        for (Periodo model : beDatosEnvio.getPeriodos()) {
            model.save();
        }
        for (Seccion model : beDatosEnvio.getSecciones()) {
            model.save();
        }
        for (Aula model : beDatosEnvio.getAulas()) {
            model.save();
        }
        for (CuentaCorriente model : beDatosEnvio.getCuentaCorriente()) {
            model.save();
        }
        for (NivelAcademico model : beDatosEnvio.getNivelesAcademicos()) {
            model.save();
        }
//        for (ProgramasEducativo model : beDatosEnvio.getProgramasEducativos()) {
//            model.save();
//        }

        for (PlanEstudios model : beDatosEnvio.getPlanEstudios()) {
            model.save();
        }

        for (PlanCursosAlumno model : beDatosEnvio.getPlanCursosAlumno()) {
            model.save();
        }
        for (Estados model : beDatosEnvio.getEstados()) {
            model.save();
        }
        for (Tipos model : beDatosEnvio.getTipos()) {
            model.save();
        }
        for (Persona persona : beDatosEnvio.getPersonas()) {
            persona.save();
        }
        for (Relaciones model : beDatosEnvio.getRelaciones()) {
            model.save();
        }
        for (Competencia model : beDatosEnvio.getCompetencias()) {
            model.save();
        }
        for (CursoCompetencia model : beDatosEnvio.getCursoCompetencias()) {
            model.save();
        }
        for (CalendarioAcademico model : beDatosEnvio.getCalendarioAcademicos()) {
            model.save();
        }
        for (CalendarioPeriodo model : beDatosEnvio.getCalendarioPeriodos()) {
            model.save();
        }
//        SugarRecord.saveInTx(beDatosEnvio.getDesarrolloCompetenciaCursos());
        for (DesarrolloCompetenciaCurso model : beDatosEnvio.getDesarrolloCompetenciaCursos()) {
            model.save();
        }
//        SugarRecord.saveInTx(beDatosEnvio.getEvaluacionCapacidades());
        for (EvaluacionCapacidad model : beDatosEnvio.getEvaluacionCapacidades()) {
            model.save();
        }
        for (SilaboEvento model : beDatosEnvio.getSilaboEvento()) {
            model.save();
        }

//        for (RecursoDidacticoEvento model : beDatosEnvio.getRecursoDidactico()) {
//            model.save();
//        }
        for (TipoNota model : beDatosEnvio.getTipoNota()) {
            model.save();
        }
        for (ValorTipoNota model : beDatosEnvio.getValorTipoNota()) {
            model.save();
        }
        for (ColorCondicional model : beDatosEnvio.getColorCondicional()) {
            model.save();
        }
        for (RubroEvaluacionResultado model : beDatosEnvio.getRubroEvaluacionResultado()) {
            model.save();
        }
        for (RubroEvalRNRFormula model : beDatosEnvio.getRubroEvalResultadoFormula()) {
            model.save();
        }
        for (RubroEvaluacionProceso model : beDatosEnvio.getRubroEvaluacionProceso()) {
            model.save();
        }
        for (RubroEvalRNPFormula model : beDatosEnvio.getRubroEvalProcesoFormula()) {
            model.save();
        }
        for (EvaluacionResultado model : beDatosEnvio.getEvaluacionResultado()) {
            model.save();
        }
        for (EvaluacionProceso model : beDatosEnvio.getEvaluacionProceso()) {
            model.save();
        }

        Log.d(TAG, "personaList: " + beDatosEnvio.getPersonas().toString());

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
                getDatosInterface.GetDatosCorrecto("SuccessFull");

                break;
            case -1:
                getDatosInterface.GetDatosError("Error -1");
                break;
            case -2:
                getDatosInterface.GetDatosErrorProcedimiento("Error -2 ");
        }

        super.onPostExecute(s);
    }
}
