package com.example.second_sample_application_10tutorial_1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.second_sample_application_10tutorial_1.Models.GroceryItem;
import com.example.second_sample_application_10tutorial_1.Models.Review;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddReviewDialog extends DialogFragment {
    private static final String TAG = "AddReviewDialog";

    private EditText editTxtName,editTxtReview;
    private TextView reviewExplain,txtWarning   ,txtItemName;
    private Button btnAddReview;
    private int itemId=0;
    public interface AddReview{
       void onAddReviewResult (Review review);
    }
    private AddReview addReview;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_add_review,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle("Add Review")
                .setView(view);

        initViews(view);

        Bundle bundle = getArguments();
        try{
            GroceryItem item = bundle.getParcelable("item");
            txtItemName.setText(item.getName());
            this.itemId=item.getId();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
btnAddReview.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        addReview();
    }
});

        return builder.create();
    }
private  void addReview(){
    Log.d(TAG, "addReview: started");    
    String name =editTxtName.getText().toString();
    String reviewText = editTxtReview.getText().toString();
    String date = getCurrentDate();
    Review review = new Review(itemId,name,reviewText,date);

    try{
        addReview=(AddReview) getActivity();
        addReview.onAddReviewResult(review);
    }catch (ClassCastException e){
        e.printStackTrace();
    }
   

}
private String getCurrentDate(){
    Log.d(TAG, "getCurrentDate: called");
    Date date = Calendar.getInstance().getTime();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    return sdf.format(date);
}
    private void initViews(View view) {
        Log.d(TAG, "initViews: started");

        editTxtName=(EditText) view.findViewById(R.id.editTxtName);
        editTxtReview=(EditText) view.findViewById(R.id.editTxtReview);

        btnAddReview=(Button) view.findViewById(R.id.btnAdd);
        txtItemName=(TextView) view.findViewById(R.id.reviewName);
        txtWarning=(TextView) view.findViewById(R.id.txtWarning);
        reviewExplain=(TextView) view.findViewById(R.id.reviewExplain);


    }
}
