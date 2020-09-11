package com.nguyai.gadsleadershipboard;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SubmissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);

        EditText firstName = findViewById(R.id.first_name);
        firstName.setText("Kevin");

        EditText lastName = findViewById(R.id.last_name);
        lastName.setText("Nguyai");
//        informationDialog(R.drawable.ic_baseline_report_problem_24,"Submission not Successful");
        informationDialog(R.drawable.ic_baseline_check_circle_24,"Submission Successful");
//        confirmDialog();
    }

    private void informationDialog(int image, String message){
        final View customLayout = getLayoutInflater().inflate(R.layout.information_dialog, null);
        TextView dialogMessage = customLayout.findViewById(R.id.message);
        dialogMessage.setText(message);

        ImageView imageView = customLayout.findViewById(R.id.image);
        imageView.setImageResource(image);

        AlertDialog.Builder infoDialogBuilder = new AlertDialog.Builder(this, R.style.CustomAlertDialog);
        infoDialogBuilder.setView(customLayout);

        AlertDialog infoDialog = infoDialogBuilder.create();
        infoDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        infoDialog.show();


    }

    private void confirmDialog(){

        final View customLayout = getLayoutInflater().inflate(R.layout.confirmation_dialog, null);

        AlertDialog.Builder confirmDialogBuilder = new AlertDialog.Builder(this, R.style.CustomAlertDialog);
        confirmDialogBuilder.setView(customLayout);

        AlertDialog confirmDialog = confirmDialogBuilder.create();
        confirmDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        confirmDialog.show();

    }


}