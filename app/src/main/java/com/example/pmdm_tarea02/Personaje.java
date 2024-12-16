package com.example.pmdm_tarea02;

import androidx.annotation.NonNull;

/**
 * Clase que representa a un personaje del universo de Super Mario.
 * Contiene atributos como ID, nombre, imagen, descripción y habilidades específicas del personaje.
 */
public class Personaje {

    // Identificador único del personaje.
    private int id;
    // Nombre del personaje.
    private String nombre;
    // Recurso de imagen asociado al personaje (ID de recurso drawable).
    private int imagen;
    // Recurso de descripción del personaje (ID de recurso string).
    private int descripcion;
    // Recurso de habilidades del personaje (ID de recurso string).
    private int habilidades;

    /**
     * Constructor de la clase Personaje.
     *
     * @param id          Identificador único del personaje.
     * @param nombre      Nombre del personaje.
     * @param imagen      ID del recurso de la imagen asociada al personaje.
     * @param descripcion ID del recurso de la descripción del personaje.
     * @param habilidades ID del recurso de las habilidades del personaje.
     */
    public Personaje(int id, String nombre, int imagen, int descripcion, int habilidades) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.habilidades = habilidades;
    }

    /**
     * Devuelve el ID del recurso de la imagen asociada al personaje.
     *
     * @return ID del recurso de imagen.
     */
    public int getImagen() {
        return imagen;
    }

    /**
     * Devuelve el identificador único del personaje.
     *
     * @return ID del personaje.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece un nuevo identificador único para el personaje.
     *
     * @param id Nuevo ID del personaje.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre del personaje.
     *
     * @return Nombre del personaje.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el ID del recurso de la descripción del personaje.
     *
     * @return ID del recurso de descripción.
     */
    public int getDescripcion() {
        return descripcion;
    }

    /**
     * Devuelve el ID del recurso de las habilidades del personaje.
     *
     * @return ID del recurso de habilidades.
     */
    public int getHabilidades() {
        return habilidades;
    }

    /**
     * Convierte el objeto Personaje a una representación en forma de cadena.
     *
     * @return Representación en cadena del personaje.
     */
    @NonNull
    @Override
    public String toString() {
        return "Personaje{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", habilidades=" + habilidades +
                ", descripcion=" + descripcion +
                '}';
    }
}

