package com.example.cursoudemy;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private EditText campoNome;
    private TextView textoResultado;
    private TextInputEditText campoEmail;
    private RadioButton sexoMasculino, sexoFeminino;

    private CheckBox checkVerde, checkBranco, checkVermelho;
    private RadioGroup sexoGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.campoNome = findViewById(R.id.editNome);
        this.textoResultado = findViewById(R.id.textResult);
        this.campoEmail = findViewById(R.id.editEmail);

        //checkBox
        this.checkVerde = findViewById(R.id.checkVerde);
        this.checkBranco = findViewById(R.id.checkBranco);
        this.checkVermelho = findViewById(R.id.checkVermelho);

        //RadioButton
        this.sexoFeminino = findViewById(R.id.radioButtonFeminino);
        this.sexoMasculino = findViewById(R.id.radioButtonMasculino);

        //RadioGroup
        this.sexoGroup = findViewById(R.id.radioGroupSexo);

        radioButton();

    }

    public void radioButton(){

        sexoGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioButtonMasculino){
                    textoResultado.setText("Masculino");
                }else{
                    textoResultado.setText("Feminino");
                }

            }
        });

        /*String texto = "";

        if(sexoMasculino.isChecked()){
            String sexoSelecionado = sexoMasculino.getText().toString();
            texto = sexoSelecionado;
        }else{
            String sexoSelecionado = sexoFeminino.getText().toString();
            texto = sexoSelecionado;
        }*/




    }

    public void checkbox(){

        String texto = "";

        if(checkVerde.isChecked()){
            String corSelecionado = checkVerde.getText().toString();
            texto = corSelecionado;
        }

        if(checkBranco.isChecked()){
            String corSelecionado  = checkBranco.getText().toString();
            texto = corSelecionado;
        }

        if(checkVermelho.isChecked()){
            String corSelecionado  = checkVermelho.getText().toString();
            texto = corSelecionado;
        }

        textoResultado.setText(texto);
    }



    public void enviar(View view){
        //radioButton();
        //checkbox();

        /*String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();
        textoResultado.setText("nome: " + nome + " email: " + email);*/
    }

    public void limpar(View view){
        campoEmail.setText("");
        campoNome.setText("");
        textoResultado.setText("resultado");
    }


}