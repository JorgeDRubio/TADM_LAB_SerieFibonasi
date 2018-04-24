package com.example.jorge.tadm_lab_seriefibonasi;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Numero;
    TextView Resultado;
    Button Calcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Numero = findViewById(R.id.edtNumero);
        Resultado = findViewById(R.id.txtResultado);
        Calcular = findViewById(R.id.btnCalcular);

        Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Numero.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "No se ha ingresado ni un numero", Toast.LENGTH_SHORT).show();
                }
                else{
                    AsyncTarea asyncTarea = new AsyncTarea();
                    asyncTarea.execute(Integer.parseInt(Numero.getText().toString()));
                }
            }
        });
    }
    private class  AsyncTarea extends AsyncTask<Integer, Integer,Boolean> {
        String resultado="0,1,";
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Boolean doInBackground(Integer... params) {
            int n1 = 0;
            int n2 = 1;
            int aux;
            int limite = params[0];
            int i=1;
            while ((i) <= limite) {

                aux = n1;
                n1 = n2;
                n2 = aux + n1;
                i++;
                resultado += n2+",";
            }

            return true;
        }
        private void UnSegundo() {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);


        }

        @Override
        protected void onPostExecute(Boolean aVoid) {
            //super.onPostExecute(aVoid);
            Resultado.setText(resultado);
        }


        @Override
        protected void onCancelled() {
            super.onCancelled();

            Toast.makeText(getApplicationContext(),"Tarea NO finaliza AsyncTask",Toast.LENGTH_SHORT).show();

        }


    }
}
