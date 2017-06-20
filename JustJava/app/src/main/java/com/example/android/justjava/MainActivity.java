package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the plus button is clicked.
     */

    public void increment(View view) {
        if(quantity ==100){
            //show an error message as a toast
            Toast.makeText(this, "You cannot have more than 100 coffee", Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if (quantity==1){
            //show an error message as a toast
            Toast.makeText(this,"You cannot have less than 1 coffee",Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        // Find the user's name
        EditText nameField=(EditText) findViewById(R.id.customer_name_edittext);
        String name= nameField.getText().toString();

        // Figure out if the user want whipped cream topping
        CheckBox whippedCreamCheckBox=(CheckBox)findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream=whippedCreamCheckBox.isChecked();

        // Figure out if the user want chocolate topping
        CheckBox chocolateCheckBox= (CheckBox)findViewById(R.id.Chocolate_checkbox);
        boolean hasChocolate=chocolateCheckBox.isChecked();

        int price=calculatePrice(hasWhippedCream,hasChocolate);
        String priceMessage=createOrderSummary(price, hasWhippedCream,hasChocolate);




        // To submit the order through SMS.
        Uri uri = Uri.parse("smsto:03453235126");
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", priceMessage);
        startActivity(it);

//        // To submit the order through Email.
//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("mailto:gery_maz_555@hotmail.com")); // only email apps should handle this
//        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for "+ name);
//        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }
//        displayMessage(priceMessage);

    }
    /**
     * Calculates the price of the order.
     *@param addWhippedCream is whether or not the user wants whipped cream topping
     * @param addChocolate is whether or not the user wants chocolate topping
     * @return total price
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        int basePrice=5;
        if(addWhippedCream){
            basePrice +=1;
        }
        if (addChocolate){
            basePrice +=2;
        }
        return quantity *basePrice;

    }

    /**
     * Create summary of the order
     * @param price of the order
     * @param addWhippedCream is whether or not the user wants whopeed cream topping
     * @return text summary
     */
    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate){

        EditText nameField=(EditText) findViewById(R.id.customer_name_edittext);
        String name= nameField.getText().toString();
        String priceMessage= "Name: "+name;
        priceMessage += "\nAdd Whipped Cream? "+addWhippedCream;
        priceMessage += "\nAdd Chocolate? "+ addChocolate;
        priceMessage += "\nQuantity: "+ quantity;
        priceMessage += "\nTotal: $"+price ;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }


//    private void displayMessage(String message){
//        TextView orderSummaryTextView =(TextView) findViewById(R.id.order_summary_text_view);
//        orderSummaryTextView.setText(message);
//    }


}