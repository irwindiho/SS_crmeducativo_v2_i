package com.consultoraestrategia.ss_crmeducativo.MainCursosAlumno;

/**
 * Created by irvinmarin on 23/02/2017.
 */

public interface MainCursosView {

    void onImageProfile1Load(String url);
    void onImageProfile2Load(String url);
    void onImageProfile3Load(String url);
    void onImageBackgroudProfileLoad(String url);
    void onLoadSuccess();
    void onLoadError(String url);
    void onShowImagesProfile();
    void onHideImagesProfile();

    void onClickCalendarMenu();
    void onSetTextDataProfileNavView();
    void onGetDatosDocente();





}
