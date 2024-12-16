package com.example.pmdm_tarea02;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pmdm_tarea02.databinding.FragmentDetallesPersonajeBinding;

/**
 * El fragmento DetallesPersonaje muestra los detalles de un personaje seleccionado.
 * Utiliza ViewBinding para enlazar el diseño del fragmento con la lógica de la clase.
 */
public class DetallesPersonaje extends Fragment {

    // Binding para acceder a los elementos del diseño del fragmento.
    private FragmentDetallesPersonajeBinding binding;

    /**
     * Aquí se infla el diseño del fragmento y crea la vista raíz.
     *
     * @param inflater LayoutInflater para inflar las vistas del fragmento.
     * @param container Contenedor padre donde se agregará el diseño del fragmento.
     * @param savedInstanceState Estado guardado del fragmento, si existe.
     * @return La vista raíz del fragmento.
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetallesPersonajeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    /**
     * Se llama cuando la vista del fragmento se ha creado.
     * Configura los datos del personaje recibido como argumentos y los muestra en la interfaz.
     *
     * @param view La vista creada por el fragmento.
     * @param savedInstanceState Estado guardado del fragmento, si existe.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Verifica si hay argumentos disponibles para mostrar los detalles del personaje.
        if (getArguments() != null) {
            int imagen = getArguments().getInt("imagen");
            String nombre = getArguments().getString("nombre");
            int descripcion = getArguments().getInt("descripcion");
            int habilidades = getArguments().getInt("habilidades");

            // Muestra un mensaje tipo Toast con el nombre del personaje.
            Toast.makeText(getContext(), getText(R.string.mensajetoast) + " " + nombre, Toast.LENGTH_SHORT).show();

            // Configura los datos del personaje en los elementos de la interfaz.
            binding.imagenDetalle.setImageResource(imagen);
            binding.nombrePersonaje.setText(nombre);
            binding.descripcion.setText(descripcion);
            binding.habilidades.setText(habilidades);
        }
    }

    /**
     * Se llama cuando el fragmento pasa al estado "Start".
     * Actualiza el título de la barra de herramientas para reflejar el contenido del fragmento.
     */
    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity) requireActivity()).getSupportActionBar().setTitle(R.string.detalles_personaje);
    }
}
