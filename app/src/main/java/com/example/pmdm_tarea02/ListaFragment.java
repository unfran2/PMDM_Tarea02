package com.example.pmdm_tarea02;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.pmdm_tarea02.databinding.FragmentListaBinding;

import java.util.Arrays;
import java.util.List;

/**
 * El fragmento ListaFragment muestra una lista de personajes utilizando un RecyclerView.
 * Cada personaje contiene información como nombre, imagen, descripción y habilidades.
 */
public class ListaFragment extends Fragment {

    // Enlace para acceder a los elementos del diseño del fragmento.
    private FragmentListaBinding bindeo;

    /**
     * Constructor vacío requerido para el funcionamiento del fragmento.
     */
    public ListaFragment() {
    }

    /**
     * infla el diseño del fragmento y crea la vista raíz.
     *
     * @param inflater LayoutInflater para inflar las vistas del fragmento.
     * @param container Contenedor padre donde se agregará el diseño del fragmento.
     * @param savedInstanceState Estado guardado del fragmento, si existe.
     * @return La vista raíz del fragmento.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bindeo = FragmentListaBinding.inflate(inflater, container, false);
        return bindeo.getRoot();
    }

    /**
     * Se llama después de que la vista del fragmento se ha creado.
     * Configura el RecyclerView con un LinearLayoutManager y un adaptador que contiene la lista de personajes.
     *
     * @param view La vista creada por el fragmento.
     * @param savedInstanceState Estado guardado del fragmento, si existe.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Configura el RecyclerView para usar un LinearLayoutManager.
        bindeo.recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        // Crea una lista de personajes con sus detalles.
        List<Personaje> list = Arrays.asList(
                new Personaje(1, "Mario", R.drawable.mario, R.string.mario_description, R.string.mario_skills),
                new Personaje(2, "Luigi", R.drawable.luigi, R.string.luigi_description, R.string.luigi_skills),
                new Personaje(3, "Boo", R.drawable.boo, R.string.boo_description, R.string.boo_skills),
                new Personaje(4, "Bowser", R.drawable.bowser, R.string.bowser_description, R.string.bowser_skills),
                new Personaje(5, "Daisy", R.drawable.daisy, R.string.daisy_description, R.string.daisy_skills),
                new Personaje(6, "Diddy Kong", R.drawable.diddy_kong, R.string.diddykong_description, R.string.diddykong_skills),
                new Personaje(7, "Donkey Kong", R.drawable.donkey_kong, R.string.donkeykong_description, R.string.donkeykong_skills),
                new Personaje(8, "Peach", R.drawable.peach, R.string.peach_description, R.string.peach_skills),
                new Personaje(9, "Rosalina", R.drawable.rosalina, R.string.rosalina_description, R.string.rosalina_skills),
                new Personaje(10, "Toad", R.drawable.toad, R.string.toad_description, R.string.toad_skills),
                new Personaje(11, "Waluigi", R.drawable.waluigi, R.string.waluigi_description, R.string.waluigi_skills),
                new Personaje(12, "Wario", R.drawable.wario, R.string.wario_descrption, R.string.wario_skills),
                new Personaje(13, "Yoshi", R.drawable.yoshi, R.string.yoshi_description, R.string.yoshi_skills)
        );

        // Asigna el adaptador al RecyclerView para mostrar la lista de personajes.
        bindeo.recycler.setAdapter(new PersonajeAdapter(list, getContext()));
    }

    /**
     * Se llama cuando el fragmento pasa al estado "Start".
     * Actualiza el título de la barra de herramientas para reflejar el contenido del fragmento.
     */
    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity) requireActivity()).getSupportActionBar().setTitle(R.string.lista_titulo);
    }
}
