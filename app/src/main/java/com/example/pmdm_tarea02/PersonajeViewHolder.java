package com.example.pmdm_tarea02;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm_tarea02.databinding.TarjetaPersonajeBinding;

/**
 * ViewHolder para representar una tarjeta de personaje en el RecyclerView.
 * Enlaza los datos del personaje con las vistas correspondientes.
 */
public class PersonajeViewHolder extends RecyclerView.ViewHolder {

    // Enlace a las vistas de la tarjeta del personaje.
    private final TarjetaPersonajeBinding binding;

    /**
     * Constructor del ViewHolder.
     *
     * @param binding El binding que enlaza las vistas de la tarjeta con los datos.
     */
    public PersonajeViewHolder(@NonNull TarjetaPersonajeBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    /**
     * Enlaza los datos del personaje con las vistas de la tarjeta.
     *
     * @param personaje El objeto {@link Personaje} con los datos a mostrar.
     */
    public void bind(Personaje personaje){
        binding.nombre.setText(personaje.getNombre());
        binding.fotoPersonaje.setImageResource(personaje.getImagen());
    }
}

