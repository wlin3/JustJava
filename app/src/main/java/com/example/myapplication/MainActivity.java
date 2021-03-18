package com.example.myapplication;

/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the + button is clicked.
     */
    int quantity = 0;

    public void increment(View view) {
        quantity = quantity + 1 ;
        display(quantity);
    }
    /**
     * This method is called when the + button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        display(quantity);
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        Log.v("MainActivity", "Haswhipped cream: "+ hasWhippedCream);
        int price = calculatePrice();
        String priceMessage = createOrderSummary(price);
        displayMessage(createOrderSummary(price));

    }

    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }

    private String createOrderSummary(int price, boolean addWhippedCream) {
        String priceMessage = "\nName: Will";
        priceMessage += "\nadd whipped cream?" + addWhippedCream;
        priceMessage += priceMessage + "\nQuantity: " + quantity;
        priceMessage += priceMessage + "\nTotal: $" + price;
        priceMessage += priceMessage + "\nThank You!";
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}