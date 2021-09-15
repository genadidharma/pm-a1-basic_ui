package org.aplas.basicappx;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Distance dist = new Distance();
    private Weight weight = new Weight();
    private Temperature temp = new Temperature();
    private Button convertBtn;
    private EditText inputTxt;
    private EditText outputTxt;
    private Spinner unitOri;
    private Spinner unitConv;
    private RadioGroup unitType;
    private CheckBox roundBox;
    private CheckBox formBox;
    private ImageView imgView;

    private AlertDialog startDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convertBtn = findViewById(R.id.convertButton);
        inputTxt = findViewById(R.id.inputText);
        outputTxt = findViewById(R.id.outputText);
        unitOri = findViewById(R.id.oriList);
        unitConv = findViewById(R.id.convList);
        unitType = findViewById(R.id.radioGroup);
        roundBox = findViewById(R.id.chkRounded);
        formBox = findViewById(R.id.chkFormula);
        imgView = findViewById(R.id.img);
    }

    @Override
    protected void onStart() {
        super.onStart();

        startDialog = new AlertDialog.Builder(MainActivity.this).create();
        startDialog.setTitle("Application started");
        startDialog.setMessage("This app can use to convert any units");
        startDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        startDialog.show();
    }

    protected double convertUnit(String type, String oriUnit, String convUnit, double value) {
        double result;

        switch (type) {
            case "Temperature":
                result = temp.convert(oriUnit, convUnit, value);
                break;
            case "Distance":
                result = dist.convert(oriUnit, convUnit, value);
                break;
            case "Weight":
                result = weight.convert(oriUnit, convUnit, value);
                break;
            default:
                result = 0;
        }

        return result;
    }

    protected String strResult(double val, boolean rounded) {
        if (rounded) {
            return new DecimalFormat("#.##").format(val);
        } else {
            return new DecimalFormat("#.#####").format(val);
        }
    }
}