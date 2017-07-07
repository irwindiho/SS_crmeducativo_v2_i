package com.consultoraestrategia.ss_crmeducativo.evaluacion.view.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.consultoraestrategia.ss_crmeducativo.R;
import com.consultoraestrategia.ss_crmeducativo.entities.Alumnos;
import com.consultoraestrategia.ss_crmeducativo.entities.Competencia;
import com.consultoraestrategia.ss_crmeducativo.entities.EvaluacionCapacidad;
import com.consultoraestrategia.ss_crmeducativo.entities.EvaluacionCapacidad_Table;
import com.consultoraestrategia.ss_crmeducativo.entities.TrimestresNotas;
import com.consultoraestrategia.ss_crmeducativo.evaluacion.view.fragments.DialogFragmentRecomendacion;
import com.consultoraestrategia.ss_crmeducativo.evaluacion.view.fragments.TabsFragmentVerAlumnoDetalle;
import com.consultoraestrategia.ss_crmeducativo.evaluacion.view.interfaces.OnItemCheckTrimestreClick;
import com.consultoraestrategia.ss_crmeducativo.evaluacion.view.interfaces.SetDataChanges;
import com.consultoraestrategia.ss_crmeducativo.lib.GlideImageLoader;
import com.consultoraestrategia.ss_crmeducativo.lib.ImageLoader;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.shehabic.droppy.DroppyClickCallbackInterface;
import com.shehabic.droppy.DroppyMenuPopup;
import com.shehabic.droppy.animations.DroppyFadeInAnimation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by kelvi on 24/02/2017.
 */

public class TableAlumnosAdapter extends BaseTableAdapter {
    private int nroColumnaActual;
    private static final String TAG = "MyAdapter";
    private final int width;
    private final int height;
    private Context context;
    private List<Alumnos> alumnoses = new ArrayList<>();
    private List<Competencia> competencias = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private HashMap<Integer, TrimestresNotas> boxListHashMap;
    private int INDEX_COLUMN = -1;
    private OnItemCheckTrimestreClick onClickListener;
    private FragmentManager fragmentManager;
    FragmentManager supportfragmentManager;
    private ImageLoader imageLoader;
    SetDataChanges setDataChanges;
    boolean isChecked;

    public TableAlumnosAdapter(boolean isChecked, SetDataChanges setDataChanges, FragmentManager supportfragmentManager, FragmentManager fragmentManager, Context context, List<Alumnos> alumnoses, List<Competencia> competencias, OnItemCheckTrimestreClick onClickListener) {
        // super(context);

        this.isChecked = isChecked;
        Resources resources = context.getResources();
        this.context = context;
        this.width = resources.getDimensionPixelSize(R.dimen.table_width);
        this.height = resources.getDimensionPixelSize(R.dimen.table_height);
        this.fragmentManager = fragmentManager;
        this.supportfragmentManager = supportfragmentManager;
        this.alumnoses = alumnoses;
        this.competencias = competencias;
        layoutInflater = getLayoutInflater();
        boxListHashMap = new HashMap<>();
        Log.d(TAG, "RELOAD?");
        this.onClickListener = onClickListener;
        this.setDataChanges = setDataChanges;
        imageLoader = new GlideImageLoader(context);
    }

    @Override
    public int getRowCount() {
        return alumnoses.size();
    }

    @Override
    public int getColumnCount() {
        return competencias.size();
    }

    CheckBox checkBox;
    String idCompetencia;

    @Override
    public View getView(final int row, final int column, View convertView, ViewGroup parent) {
        final View layoutResource;
        nroColumnaActual = column;
        TextView txtShowNotaEvalCap = null;
        if (convertView != null) {
            return convertView;
        }
        switch (getItemViewType(row, column)) {

            case -1:
//                String numPos = Integer.toString(row + 1);
                int numPos = (row + 1);

                String nomAlum = alumnoses.get(row).getNombres();
                String imagen = alumnoses.get(row).getImagen();
                final String[] datosAlumno = new String[2];

                datosAlumno[0] = nomAlum;
                datosAlumno[1] = imagen;


                layoutResource = layoutInflater.inflate(R.layout.layout_item_alumno, parent, false);


                ImageView imgProfile = (ImageView) layoutResource.findViewById(R.id.imgProfile);


                imgProfile.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        TabsFragmentVerAlumnoDetalle fragment = TabsFragmentVerAlumnoDetalle.newInstance();
                        Bundle bundle = new Bundle();
                        bundle.putInt("idAlumno", alumnoses.get(row).getId());
                        bundle.putString("urlProfile", "https://www.invest-direct-online.com/images/img-school-fee-planning-profile.jpg");
//                        bundle.putString("nombreCompetencia", alumnoses.get(row).getCompetenciaList().get(column).getNombre() + "");
//                        bundle.putString("urlImage", "https://www.invest-direct-online.com/images/img-school-fee-planning-profile.jpg");
                        fragment.setArguments(bundle);

                        fragment.show(fragmentManager, "FragmentRecomendacion");

                    }
                });
                TextView textView3 = (TextView) layoutResource.findViewById(R.id.text1);
                textView3.setText(alumnoses.get(row).getNombres() + " " + alumnoses.get(row).getImagen());
                textView3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


//                        Persona persona = Persona.find(Persona.class, "persona_Id=?", alumnoses.get(row).getId() + "").get(0);
//                        try {
//                            Intent i = new Intent(Intent.ACTION_MAIN);
//                            PackageManager manager = getActivity().getPackageManager();
//                            i = manager.getLaunchIntentForPackage("com.consultoraestrategia.messengeracademico");
//                            i.putExtra("NroTelefono", persona.getTelefono());
//                            i.addCategory(Intent.CATEGORY_LAUNCHER);
//                            v.getContext().startActivity(i);
//                        } catch (Exception e) {
//                            Toast.makeText(v.getContext(), "No tiene instalado ChatAcademico", Toast.LENGTH_LONG).show();
//                        }

                    }
                });


                textView3.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        GenerateMenuChat(v, row, column);
                        return false;
                    }
                });


                imageLoader.loadWithCircular(imgProfile, "https://www.invest-direct-online.com/images/img-school-fee-planning-profile.jpg");

                if ((row % 2) == 0) {
                    layoutResource.setBackgroundColor(Color.parseColor("#ffffff"));
                } else {
                    layoutResource.setBackgroundColor(Color.parseColor("#BBDEFB"));
                }

                break;
            case 0:
                layoutResource = layoutInflater.inflate(R.layout.item_table1_header, parent, false);
                TextView textView = (TextView) layoutResource.findViewById(R.id.textAlumnos);
                final TextView txtNroCapacidad = (TextView) layoutResource.findViewById(R.id.txtNroCapacidad);
                final TextView txtNroColumna = (TextView) layoutResource.findViewById(R.id.txtNroColumna);
                checkBox = (CheckBox) layoutResource.findViewById(R.id.text1);


                if (column == -1) {

                    layoutResource.findViewById(R.id.text1).setVisibility(View.GONE);
                    txtNroCapacidad.setVisibility(View.GONE);
                    txtNroColumna.setVisibility(View.GONE);
                    textView.setVisibility(View.VISIBLE);
                    textView.setText("Alumnos");
                } else {

                    checkBox.setVisibility(View.VISIBLE);


                    idCompetencia = competencias.get(column).getCompetenciaId() + "";
                    int nroColumna = column + 1;
                    txtNroCapacidad.setText(idCompetencia + "");
                    txtNroColumna.setText(nroColumna + "");
                    checkBox.setTag(column);
                    nroColumnaActual = column;

                    boxListHashMap.put(column, new TrimestresNotas(column, checkBox, new ArrayList<EditText>()));
//                    checkBox.setChecked(isChecked);
                    final TextView finalTxtShowNotaEvalCap = txtShowNotaEvalCap;
                    checkBox.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            idCompetencia = txtNroCapacidad.getText().toString();
                            onClickListener.onItemClickListener(boxListHashMap, v, idCompetencia);
                        }
                    });
                }


                break;
            case 1:
                Log.d(TAG, "TAM: " + boxListHashMap.size());
                layoutResource = layoutInflater.inflate(R.layout.item_table1, parent, false);
                final EditText editText = (EditText) layoutResource.findViewById(R.id.txtNotaEvalCap);
                txtShowNotaEvalCap = (TextView) layoutResource.findViewById(R.id.txtShowNotaEvalCap);
                final TextView txtIdEvalcap = (TextView) layoutResource.findViewById(R.id.txtIdEvalcap);
                final LinearLayout contentNotaAlumno = (LinearLayout) layoutResource.findViewById(R.id.contentNotaAlumno);
                editText.setEnabled(false);


                if (INDEX_COLUMN != boxListHashMap.get(column).getColumna()) {


                    if (!editText.isEnabled()) {
                        contentNotaAlumno.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                GenerateMenu(v, row, column);
                            }
                        });

                    }


                    String nota = alumnoses.get(row).getEvaLuacionCapacidadesList().get(column).getNota() + "";

                    String idDesComp = alumnoses.get(row).getEvaLuacionCapacidadesList().get(column).getDesCompetenciaId() + "";
                    String idAlumno = alumnoses.get(row).getId() + "";
                    final String id = alumnoses.get(row).getEvaLuacionCapacidadesList().get(column).getEvalCapacidadId() + "";

                    editText.setText(nota);
                    txtShowNotaEvalCap.setText(nota);
                    txtIdEvalcap.setText(id);

                    editText.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {


                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {

                        }

                        @Override
                        public void afterTextChanged(Editable s) {
//
                            String notaString = editText.getText().toString();

                            if (notaString == "") {

                            } else {
                                if (notaString.length() >= 2) {


                                    try {

                                        final String idevalCap = alumnoses.get(row).getEvaLuacionCapacidadesList().get(column).getEvalCapacidadId() + "";
                                        EvaluacionCapacidad evaluacionCapacidad = SQLite.select().
                                                from(EvaluacionCapacidad.class)
                                                .where(EvaluacionCapacidad_Table.evalCapacidadId.is(Integer.parseInt(idevalCap)))
                                                .queryList().get(0);
//
// EvaluacionCapacidad.find(EvaluacionCapacidad.class,
//                                                "eval_Capacidad_Id=?", idevalCap).get(0);


                                        int notaEvalCap = Integer.parseInt(notaString);
                                        if (notaEvalCap > 0) {
                                            evaluacionCapacidad.setNota(notaEvalCap);
                                            evaluacionCapacidad.save();


//                                            Toast.makeText(getActivity().getApplicationContext(), "Se ha cambiado la nota", Toast.LENGTH_LONG).show();

                                            notifyDataSetChanged();
                                            if (column == alumnoses.size() - 1) {
                                                createSimpleDialog(column);
                                            }
                                        }
                                    } catch (Exception e) {//

                                    }


                                }


                            }
                        }
                    });

                    editText.setEnabled(false);

                    boxListHashMap.get(column).getEditTexts().add(editText);
//                    textViews=new ArrayList<>();
//                    textViews.add(txtShowNotaEvalCap);

                    INDEX_COLUMN = boxListHashMap.get(column).getColumna();
                }
                if ((row % 2) == 0) {
                    layoutResource.setBackgroundColor(Color.parseColor("#ffffff"));
                } else {
                    layoutResource.setBackgroundColor(Color.parseColor("#BBDEFB"));
                }


                break;
            default:
                throw new RuntimeException("wtf?");
        }


        return layoutResource;
    }

    private void GenerateMenu(final View v, final int row, final int column) {
        DroppyMenuPopup.Builder droppyBuilder = new DroppyMenuPopup.Builder(v.getContext(), v);
        DroppyMenuPopup droppyMenu = droppyBuilder.fromMenu(R.menu.menu_evaluacion_nota)
                .triggerOnAnchorClick(false)
                .setOnClick(new DroppyClickCallbackInterface() {
                    @Override
                    public void call(View v, int id) {
                        switch (id) {
                            case R.id.nota:

                                break;
                            case R.id.icono:
                                break;
                            case R.id.comentario:
                                DialogFragmentRecomendacion fragment = new DialogFragmentRecomendacion();
                                Bundle bundle = new Bundle();
                                bundle.putString("idAlumno", alumnoses.get(row).getId() + "");
                                bundle.putString("nombreAlumno", alumnoses.get(row).getNombres() + "");
                                bundle.putString("nombreCompetencia", alumnoses.get(row).getCompetenciaList().get(column).getNombre() + "");
                                bundle.putString("urlImage", "https://www.invest-direct-online.com/images/img-school-fee-planning-profile.jpg");
                                fragment.setArguments(bundle);

                                fragment.show(fragmentManager, "FragmentRecomendacion");
                                break;
                            default:
                        }
                    }
                })
                .setPopupAnimation(new DroppyFadeInAnimation())
                .setXOffset(5)
                .setYOffset(5)
                .build();

        droppyMenu.show();
    }

    private void GenerateMenuChat(final View v, final int row, final int column) {
        DroppyMenuPopup.Builder droppyBuilder = new DroppyMenuPopup.Builder(v.getContext(), v);
        DroppyMenuPopup droppyMenu = droppyBuilder.fromMenu(R.menu.menu_chat)
                .triggerOnAnchorClick(false)
                .setOnClick(new DroppyClickCallbackInterface() {
                    @Override
                    public void call(View v, int id) {
                        switch (id) {
                            case R.id.action_chat_alumno:

                                break;
                            case R.id.action_chat_padre:
                                break;
                            case R.id.action_chat_madre:
                                try {
                                    Intent i = new Intent(Intent.ACTION_MAIN);
                                    PackageManager manager = getActivity().getPackageManager();
                                    i = manager.getLaunchIntentForPackage("com.consultoraestrategia.messengeracademico");
                                    i.addCategory(Intent.CATEGORY_LAUNCHER);
                                    v.getContext().startActivity(i);
                                } catch (Exception e) {
                                    Toast.makeText(v.getContext(), "No tiene instalado ChatAcademico", Toast.LENGTH_LONG).show();
                                }
//
                                break;
                            default:
                        }
                    }
                })
                .setPopupAnimation(new DroppyFadeInAnimation())
                .setXOffset(5)
                .setYOffset(5)
                .build();

        droppyMenu.show();
    }


    public AlertDialog createSimpleDialog(final int column) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Actulizar lista de notas")

                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                dialog.dismiss();
                            }
                        })
                .setNegativeButton("CANCELAR",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

        return builder.create();
    }

    @Override
    public int getWidth(int column) {
//obtener header


        if (column == -1) {
            return 230;
        } else {
            return width;
        }

    }

    @Override
    public int getHeight(int row) {
        return height;
    }


    @Override
    public int getItemViewType(int row, int column) {

        if (row >= 0 && column == -1) {
            return -1;
        }

        if (row < 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }


    private LayoutInflater getLayoutInflater() {
        return getActivity().getLayoutInflater();
    }

    private Activity getActivity() {
        return ((Activity) context);
    }


}
