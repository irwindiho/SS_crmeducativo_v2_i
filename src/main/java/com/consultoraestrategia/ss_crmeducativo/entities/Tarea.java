package com.consultoraestrategia.ss_crmeducativo.entities;

import com.consultoraestrategia.ss_crmeducativo.lib.FlowMangerImpl;


/**
 * Created by irvinmarin on 27/02/2017.
 */

//@Table(database = FlowMangerImpl.AppDatabase.class)
public class Tarea {

  String titulo;
  String contenido;

  public Tarea() {
  }

  public Tarea(String titulo, String contenido) {
    this.titulo = titulo;
    this.contenido = contenido;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getContenido() {
    return contenido;
  }

  public void setContenido(String contenido) {
    this.contenido = contenido;
  }
}
