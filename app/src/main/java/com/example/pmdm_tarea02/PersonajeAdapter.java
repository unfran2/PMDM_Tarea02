package com.example.pmdm_tarea02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm_tarea02.databinding.TarjetaPersonajeBinding;

import java.util.List;

/**
 * Adaptador para manejar y mostrar una lista de personajes en un RecyclerView.
 * Utiliza la clase {@link PersonajeViewHolder} para enlazar los datos de cada personaje con su vista.
 */
public class PersonajeAdapter extends RecyclerView.Adapter<PersonajeViewHolder> {

    // Lista de personajes a mostrar.
    private final List<Personaje> lista;
    // Contexto de la aplicación o actividad.
    private final Context context;

    /**
     * Constructor del adaptador.
     *
     * @param lista   Lista de objetos {@link Personaje} que se mostrarán en el RecyclerView.
     * @param context Contexto de la actividad o fragmento que utiliza el adaptador.
     */
    public PersonajeAdapter(List<Personaje> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    /**
     * Crea y devuelve un nuevo ViewHolder inflando el diseño de la tarjeta del personaje.
     *
     * @param parent   El ViewGroup padre donde se añadirá el ViewHolder.
     * @param viewType Tipo de vista (no utilizado aquí ya que todas las tarjetas son iguales).
     * @return Un nuevo {@link PersonajeViewHolder} con la tarjeta inflada.
     */
    @NonNull
    @Override
    public PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TarjetaPersonajeBinding binding = TarjetaPersonajeBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        );
        return new PersonajeViewHolder(binding);
    }

    /**
     * Enlaza los datos de un personaje con el ViewHolder correspondiente.
     *
     * @param holder   ViewHolder que representa una tarjeta de personaje.
     * @param position Posición del personaje en la lista.
     */
    @Override
    public void onBindViewHolder(@NonNull PersonajeViewHolder holder, int position) {
        Personaje personajeActual = this.lista.get(position);
        holder.bind(personajeActual);

        // Configura un listener para manejar el evento de clic en la tarjeta.
        holder.itemView.setOnClickListener(view -> clickado(personajeActual, view));
    }

    /**
     * Devuelve el número total de elementos en la lista.
     *
     * @return Número de elementos en la lista de personajes.
     */
    @Override
    public int getItemCount() {
        return lista.size();
    }

    /**
     * Maneja el evento de clic en un personaje, delegando la acción a la actividad principal.
     *
     * @param personajeActual El personaje seleccionado.
     * @param view            La vista donde se realizó el clic.
     */
    private void clickado(Personaje personajeActual, View view) {
        ((MainActivity) context).personajeClicked(personajeActual, view);
    }
}

