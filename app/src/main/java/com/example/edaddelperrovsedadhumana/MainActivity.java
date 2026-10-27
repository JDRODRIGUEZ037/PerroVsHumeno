package com.example.edaddelperrovsedadhumana;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText etEdadPerro;
    Button btnCalcular;
    Button btnLimpiar;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etEdadPerro = findViewById(R.id.etEdadPerro);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        tvResultado = findViewById(R.id.tvResultado);

        // Aquí le decimos al botón que preste atención cuando lo toquen
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 1. Obtener el texto que el usuario escribió en el campo etEdadPerro
                String edadIngresada = etEdadPerro.getText().toString();

                // 2. Validación básica: Comprobar que no esté vacío
                if(edadIngresada.isEmpty()) {
                    // Si está vacío, mostramos un error en el campo
                    etEdadPerro.setError("Por favor ingrese una edad");
                } else {
                    // 3. Si no está vacío, convertimos el texto a un número entero
                    int edadPerro = Integer.parseInt(edadIngresada);

                    // 4. AQUI VA LA FÓRMULA MATEMÁTICA
                    // TAREA: Multiplica la edadPerro por 7 y guardalo en una variable entera llamada edadHumana
                    int edadHumana = edadPerro * 7;

                    // 5. Mostrar el resultado en el tvResultado (Quítale las dos barras // a la línea de abajo cuando tengas la fórmula)
                    tvResultado.setText("La edad en años humanos es: " + edadHumana);
                }
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dejamos los textos en blanco ("")
                etEdadPerro.setText("");
                tvResultado.setText("");
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}