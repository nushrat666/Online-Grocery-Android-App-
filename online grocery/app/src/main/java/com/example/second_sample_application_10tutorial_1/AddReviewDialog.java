package com.example.second_sample_application_10tutorial_1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import com.example.second_sample_application_10tutorial_1.Models.GroceryItem;
import com.example.second_sample_application_10tutorial_1.Models.Review;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddReviewDialog extends DialogFragment {
    private static final String TAG = "AddReviewDialog";

    private TextView reviewExplain,reviewName,txtWarning;
    private EditText editTxtName,editTxtReview;
 private Button btnAdd;



    private int itemId=0;

    public void show(FragmentManager supportFragmentManager, String add_review_dialog) {
    }

    public interface AddReview{
        void onAddReviewResult (Review review);
    }

    private AddReview addReview;

    @Nullable
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
            reviewExplain.setText(item.getName());

            this.itemId=item.getId();

        }catch(NullPointerException e){
            e.printStackTrace();
        }
        reviewExplain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addReview();
            }
        });


        return builder.create();
    }
    private void addReview(){
        Log.d(TAG, "addReview: started");
        String name =reviewExplain.getText().toString();
        String reviewText = reviewExplain.getText().toString();
        String date= getCurrentDate();

        Review review = new Review(itemId,name,reviewText,date);

        try{
            addReview=(AddReview) getActivity();
            addReview.onAddReviewResult(review);
        }catch (ClassCastException e){
            e.printStackTrace();
        }
    }

    private String getCurrentDate() {
        Log.d(TAG, "getCurrentDate: called");

        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(date);

    }

    private void initViews(View view) {
        Log.d(TAG, "initViews: started");


        reviewExplain=(TextView) view.findViewById(R.id.reviewExplain);
        reviewName=(TextView) view.findViewById(R.id.reviewName);
        txtWarning=(TextView) view.findViewById(R.id.txtWarning);

        editTxtName=(EditText) view.findViewById(R.id.editTxtName);
        editTxtReview=(EditText) view.findViewById(R.id.editTxtReview);
        btnAdd=(Button) view.findViewById(R.id.btnAdd);






    }
}

