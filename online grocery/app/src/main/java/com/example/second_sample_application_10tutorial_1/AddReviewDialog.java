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

import com.example.second_sample_application_10tutorial_1.Models.GroceryItem;

public class AddReviewDialog extends DialogFragment {
    private static final String TAG = "AddReviewDialog";

    private EditText edtTxtName, edtTxtReview;
    private TextView txtItemName, txtWarning;
    private Button btnAddReview;


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
            txtItemName.setText(item.getName());
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
    private void addReview(){
        Log.d(TAG, "addReview:started ");
    }

    private void initViews(View view) {
        Log.d(TAG, "initViews: started");
        edtTxtName=(EditText)view.findViewById(R.id.editTxtName);
        edtTxtReview=(EditText)view.findViewById(R.id.editTxtReview);
        txtItemName=(TextView) view.findViewById(R.id.txtItemName);
        txtWarning=(TextView)view.findViewById(R.id.txtWarning);
        btnAddReview=(Button) view.findViewById(R.id.btnAdd);
    }
}

