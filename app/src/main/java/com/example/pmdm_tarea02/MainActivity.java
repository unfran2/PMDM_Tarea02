package com.example.pmdm_tarea02;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.pmdm_tarea02.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

/**
 * La clase MainActivity es la actividad principal de la aplicación.
 * Gestiona la interfaz principal, incluida la configuración de la barra de herramientas,
 * el controlador de navegación y la interacción con los fragmentos.
 */
public class MainActivity extends AppCompatActivity {

    // Enlaza los elementos del diseño mediante ViewBinding.
    private ActivityMainBinding binding;

    // Controlador de navegación para gestionar la navegación entre fragmentos.
    private NavController navController;

    // Barra de herramientas personalizada utilizada en la actividad.
    private Toolbar toolbar;

    /**
     * Método que se llama cuando la actividad se crea por primera vez.
     * Configura el enlace de vistas, la barra de herramientas y el controlador de navegación.
     *
     * @param savedInstanceState estado guardado de la actividad.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configuración de la barra de herramientas personalizada.
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Obtiene el controlador de navegación del NavHostFragment.
        navController = ((NavHostFragment) binding.navHostFragment.getFragment()).getNavController();
        NavigationUI.setupWithNavController(toolbar, navController);

        // Muestra un mensaje utilizando Snackbar al iniciar la actividad.
        Snackbar.make(binding.navHostFragment, R.string.mensajesnackbar, Snackbar.LENGTH_SHORT).show();
    }

    /**
     * Navega al detalle del personaje seleccionado.
     * Prepara un Bundle con los datos del personaje y navega al fragmento de detalles.
     *
     * @param personaje objeto Personaje que contiene los datos a mostrar.
     * @param view la vista desde donde se realiza la navegación.
     */
    public void personajeClicked(Personaje personaje, View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("imagen", personaje.getImagen());
        bundle.putString("nombre", personaje.getNombre());
        bundle.putInt("descripcion", personaje.getDescripcion());
        bundle.putInt("habilidades", personaje.getHabilidades());

        Navigation.findNavController(view).navigate(R.id.detallesPersonaje, bundle);
    }

    /**
     * Infla el menú de opciones para la barra de herramientas.
     *
     * @param menu el menú donde se infla.
     * @return true si el menú se muestra correctamente.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * Maneja las selecciones del menú de opciones.
     *
     * @param item el elemento del menú seleccionado.
     * @return true si la selección se maneja correctamente.
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.acerca_de) {
            mostrarDialogo();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Muestra un cuadro de diálogo con información sobre la aplicación.
     */
    private void mostrarDialogo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.about));
        builder.setMessage(getString(R.string.about_description));
        builder.setPositiveButton("Ok", (dialog, which) -> dialog.dismiss());
        builder.show();
    }
}
