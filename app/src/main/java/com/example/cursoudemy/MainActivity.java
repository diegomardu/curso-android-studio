package com.example.cursoudemy;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toogleSenha;
    private Switch aSwitch;
    private TextView textResultado;

    private CheckBox checkBoxSenha;

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

        this.toogleSenha = findViewById(R.id.toggleSenha);
        this.aSwitch = findViewById(R.id.senha);
        this.textResultado = findViewById(R.id.textResultado);
        this.checkBoxSenha = findViewById(R.id.checkSenha);

    }

    public void enviar(View view){

        /*if(aSwitch.isChecked()){
            textResultado.setText("Switch ligado");
        }else{
            textResultado.setText("Switch desligado");
        }*/

        if(checkBoxSenha.isChecked()){
            textResultado.setText("checkBox ligado");
        }else{
            textResultado.setText("checkBox desligado");
        }

        adicionarListener();

        /*if(toogleSenha.isChecked()){
            textResultado.setText("toogle ligado");
        }else{
            textResultado.setText("toogle desligado");
        }*/

    }

    public void adicionarListener(){
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    textResultado.setText("ligado");
                }else{
                    textResultado.setText("desligado");
                }
            }
        });
    }

}