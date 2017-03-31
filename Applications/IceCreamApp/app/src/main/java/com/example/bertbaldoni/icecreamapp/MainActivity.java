package com.example.bertbaldoni.icecreamapp;

//import android.icu.text.NumberFormat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

import static com.example.bertbaldoni.icecreamapp.R.string.aboutSelected;
import static com.example.bertbaldoni.icecreamapp.R.string.hotFudge1oz;
import static com.example.bertbaldoni.icecreamapp.R.string.hotFudge2oz;
import static com.example.bertbaldoni.icecreamapp.R.string.hotFudge3oz;
import static com.example.bertbaldoni.icecreamapp.R.string.hotFudgeNone;
import static com.example.bertbaldoni.icecreamapp.R.string.orderButtonPressed;
import static com.example.bertbaldoni.icecreamapp.R.string.orderHistorySelected;

public class MainActivity extends AppCompatActivity {

    private String totalCostAsString;
    private OrderHistory orders;
    private TextView totalCostTextView;
    private CheckBox peanutsCheckBox;
    private CheckBox almondsCheckBox;
    private CheckBox strawberriesCheckBox;
    private CheckBox gummyBearsCheckBox;
    private CheckBox mAndMsCheckBox;
    private CheckBox browniesCheckBox;
    private CheckBox oreosCheckBox;
    private CheckBox marshmallowsCheckBox;
    private Spinner flavorSpinner;
    private Spinner sizeSpinner;
    private SeekBar hotFudgeSeekBar;
    private TextView hotFudgeValueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        orders = new OrderHistory();
        totalCostTextView = (TextView) findViewById(R.id.totalCostTextView);
        peanutsCheckBox = (CheckBox) findViewById(R.id.peanutsCheckBox);
        almondsCheckBox = (CheckBox) findViewById(R.id.almondsCheckBox);
        strawberriesCheckBox = (CheckBox) findViewById(R.id.strawberriesCheckBox);
        gummyBearsCheckBox = (CheckBox) findViewById(R.id.gummyBearsCheckBox);
        mAndMsCheckBox = (CheckBox) findViewById(R.id.mAndMsCheckBox);
        browniesCheckBox = (CheckBox) findViewById(R.id.browniesCheckBox);
        oreosCheckBox = (CheckBox) findViewById(R.id.oreosCheckBox);
        marshmallowsCheckBox = (CheckBox) findViewById(R.id.marshmallowsCheckBox);
        flavorSpinner = (Spinner) findViewById(R.id.flavorSpinner);
        flavorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                orders.getCurrentSundae().setFlavorIndex(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sizeSpinner = (Spinner) findViewById(R.id.sizeSpinner);
        sizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                orders.getCurrentSundae().setSizeIndex(position);
                updateUI();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        hotFudgeValueTextView = (TextView) findViewById(R.id.hotFudgeValueTextView);
        hotFudgeSeekBar = (SeekBar) findViewById(R.id.hotFudgeSeekBar);
        hotFudgeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                orders.getCurrentSundae().setHotFudgeIndex(progress);
                updateUI();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        newSundae();
        updateUI();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.aboutMenuItem) {
            Toast.makeText(this, aboutSelected, Toast.LENGTH_SHORT).show();
            Intent aboutIntent = new Intent(MainActivity.this, AboutActivity.class);
            aboutIntent.putExtra("DataKey", "Albert Baldoni");
            startActivity(aboutIntent);

        } else if (id  == R.id.orderHistoryMenuItem) {
            Toast.makeText(this, orderHistorySelected, Toast.LENGTH_SHORT).show();
            Intent orderHistoryIntent = new Intent(MainActivity.this, OrderHistoryActivity.class);
            orderHistoryIntent.putExtra("OrdersDataKey", orders);

            startActivity(orderHistoryIntent);
        }

        return super.onOptionsItemSelected(item);
    }


    public void newSundae() {
        orders.addSundae(new Sundae());
    }

    public void updateTotalCostString() {
        orders.getCurrentSundae().updatePrice();
        totalCostAsString = formatToCurrency();
    }

    public String formatToCurrency() {
        Locale locale = new Locale("en", "US");
        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
        return fmt.format(orders.getCurrentSundae().getTotalCost());
    }

    public void updateUI() {
        updateTotalCostString();
        totalCostTextView.setText(totalCostAsString);
        if (orders.getCurrentSundae().getHotFudgeIndex() == 0)
            hotFudgeValueTextView.setText(hotFudgeNone);
        else if (orders.getCurrentSundae().getHotFudgeIndex() == 1)
            hotFudgeValueTextView.setText(hotFudge1oz);
        else if (orders.getCurrentSundae().getHotFudgeIndex() == 2)
            hotFudgeValueTextView.setText(hotFudge2oz);
        else
            hotFudgeValueTextView.setText(hotFudge3oz);
        flavorSpinner.setSelection(orders.getCurrentSundae().getFlavorIndex());
        sizeSpinner.setSelection(orders.getCurrentSundae().getSizeIndex());
        hotFudgeSeekBar.setProgress(orders.getCurrentSundae().getHotFudgeIndex());
    }

    public void processCheckBoxChanges(View view) {
        if (view.getId() == R.id.peanutsCheckBox) {
            if (peanutsCheckBox.isChecked())
                orders.getCurrentSundae().setPeanuts(true);
            else
                orders.getCurrentSundae().setPeanuts(false);
        } else if (view.getId() == R.id.almondsCheckBox) {
            if (almondsCheckBox.isChecked())
                orders.getCurrentSundae().setAlmonds(true);
            else
                orders.getCurrentSundae().setAlmonds(false);
        } else if (view.getId() == R.id.strawberriesCheckBox) {
            if (strawberriesCheckBox.isChecked())
                orders.getCurrentSundae().setStrawberries(true);
            else
                orders.getCurrentSundae().setStrawberries(false);
        } else if (view.getId() == R.id.gummyBearsCheckBox) {
            if (gummyBearsCheckBox.isChecked())
                orders.getCurrentSundae().setGummyBears(true);
            else
                orders.getCurrentSundae().setGummyBears(false);
        } else if (view.getId() == R.id.mAndMsCheckBox) {
            if (mAndMsCheckBox.isChecked())
                orders.getCurrentSundae().setMAndMs(true);
            else
                orders.getCurrentSundae().setMAndMs(false);
        } else if (view.getId() == R.id.browniesCheckBox) {
            if (browniesCheckBox.isChecked())
                orders.getCurrentSundae().setBrownies(true);
            else
                orders.getCurrentSundae().setBrownies(false);
        } else if (view.getId() == R.id.oreosCheckBox) {
            if (oreosCheckBox.isChecked())
                orders.getCurrentSundae().setOreos(true);
            else
                orders.getCurrentSundae().setOreos(false);
        } else if (view.getId() == R.id.marshmallowsCheckBox) {
            if (marshmallowsCheckBox.isChecked() )
                orders.getCurrentSundae().setMarshmallows(true);
            else
                orders.getCurrentSundae().setMarshmallows(false);
        }
        updateUI();
    }

    public void theWorksButtonPressed(View view) {
        peanutsCheckBox.setChecked(true);
        almondsCheckBox.setChecked(true);
        strawberriesCheckBox.setChecked(true);
        gummyBearsCheckBox.setChecked(true);
        mAndMsCheckBox.setChecked(true);
        browniesCheckBox.setChecked(true);
        oreosCheckBox.setChecked(true);
        marshmallowsCheckBox.setChecked(true);
        orders.getCurrentSundae().theWorks();
        updateUI();
    }

    public void resetButtonPressed(View view) {
        peanutsCheckBox.setChecked(false);
        almondsCheckBox.setChecked(false);
        strawberriesCheckBox.setChecked(false);
        gummyBearsCheckBox.setChecked(false);
        mAndMsCheckBox.setChecked(false);
        browniesCheckBox.setChecked(false);
        oreosCheckBox.setChecked(false);
        marshmallowsCheckBox.setChecked(false);
        orders.getCurrentSundae().reset();
        updateUI();
    }

    public void orderButtonPressed(View view) {
        orders.addSundae(new Sundae());
        resetButtonPressed(view);
        Toast.makeText(this, orderButtonPressed, Toast.LENGTH_SHORT).show();

    }

}
