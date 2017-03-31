package com.example.bertbaldoni.icecreamapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.bertbaldoni.icecreamapp.R.string.action_orderHistory;

public class OrderHistoryActivity extends AppCompatActivity {

    OrderHistory orders;
    ArrayList<String> stringOrders;
    ListView orderHistoryListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);

        setTitle(action_orderHistory);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent orderHistoryIntent = getIntent();
        orders = (OrderHistory) orderHistoryIntent.getSerializableExtra("OrdersDataKey");
        orderHistoryListView = (ListView) findViewById(R.id.orderHistoryListView);
        stringOrders = new ArrayList<String>();
        for (int i = 0; i < orders.getSundaeCount() - 1; i++) {
            stringOrders.add(orders.getSundaes()[i].toString());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, stringOrders);

        orderHistoryListView.setAdapter(adapter);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        else
            return super.onOptionsItemSelected(item);
    }
}
