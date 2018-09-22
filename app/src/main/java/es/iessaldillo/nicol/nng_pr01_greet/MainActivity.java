package es.iessaldillo.nicol.nng_pr01_greet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private TextView lbl_Result;
    private EditText txt_NameBox,txt_SurnameBox;
    private CheckBox cbx_ChangeGreetMode;
    private Button btn_Greet,btn_Reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        txt_NameBox = findViewById(R.id.txt_NameBox);
        txt_SurnameBox = findViewById(R.id.txt_SurnameBox);
        cbx_ChangeGreetMode = findViewById(R.id.cbx_ChangeGreetMode);
        btn_Greet = findViewById(R.id.btn_Greet);
        btn_Reset = findViewById(R.id.btn_Reset);
        lbl_Result = findViewById(R.id.lbl_Result);

        cbx_ChangeGreetMode.setOnCheckedChangeListener(this);
        btn_Greet.setOnClickListener(this);
        btn_Reset.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == btn_Greet.getId()){
            greet();
        }else if(id == btn_Reset.getId()){
            reset();
        }

    }

    private void greet() {
        String msg;

        if(cbx_ChangeGreetMode.isChecked()){
            msg = getString(R.string.PoliteGreet);
        }else{
            msg = getString(R.string.CasualGreet);
        }

        msg += getString(R.string.mainAct_lbl_Result," " + txt_NameBox.getText(),txt_SurnameBox.getText());

        lbl_Result.setText(msg);
    }

    private void reset() {
        txt_NameBox.setText("");
        txt_SurnameBox.setText("");
        cbx_ChangeGreetMode.setChecked(false);
        lbl_Result.setText("");

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            cbx_ChangeGreetMode.setText(R.string.mainAct_cbx_PoliteMode);
        }else{
            cbx_ChangeGreetMode.setText(R.string.mainAct_cbx_CasualMode);
        }
    }
}
