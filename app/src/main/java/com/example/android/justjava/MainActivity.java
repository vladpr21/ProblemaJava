package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    int quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */

    public void increment(View view) {
        quantity = quantity +1;
        display(quantity);
    }

    public void decrement(View view) {
       if(quantity>0)
           quantity = quantity-1;
        display(quantity);
    }

    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox= (CheckBox) findViewById(R.id.whipped_cream)
        boolean hasWhippedCream=whippedCreamCheckBox.isChecked();
        int price=calculatePrice();
        String message = createOrderSummary(price,hasWhippedCream);
        displayPrice(message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     * @param
     */
    private void displayPrice(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
    /**
     * Calculates the price of the order based on the current quantity.
     *
     * @return the price
     */
    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }

    private String createOrderSummary(int price, boolean hasWhippedCream){
        String message = "Name: Vlad\nAdd whipped cream ?" + hasWippedCream + "Quantity: "+ quantity + "\nTotal: $" + price + "\nThank you!";
        return message;
    }
}