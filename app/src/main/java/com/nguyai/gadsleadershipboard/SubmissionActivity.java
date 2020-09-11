package com.nguyai.gadsleadershipboard;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nguyai.gadsleadershipboard.services.GoogleFormService;
import com.nguyai.gadsleadershipboard.services.GoogleServiceBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmissionActivity extends AppCompatActivity {
    private static String firstNameText;
    private static String lastNameText;
    private static String emailText;
    private static String linkText;
    private  static AlertDialog confirmDialog;
    private static  ProgressBar spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);

        Button completeApplication = findViewById(R.id.complete_application);
        completeApplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmApplication();
            }
        });

        spinner = findViewById(R.id.loader);
        spinner.setVisibility(View.GONE);


    }

    private void informationDialog(int image, String message){
        final View customLayout = getLayoutInflater().inflate(R.layout.information_dialog, null);
        TextView dialogMessage = customLayout.findViewById(R.id.message);
        dialogMessage.setText(message);

        ImageView imageView = customLayout.findViewById(R.id.image);
        imageView.setImageResource(image);

        AlertDialog.Builder infoDialogBuilder = new AlertDialog.Builder(this, R.style.CustomAlertDialog);
        infoDialogBuilder.setView(customLayout);

        final AlertDialog infoDialog = infoDialogBuilder.create();
        infoDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        infoDialog.show();
    }

    private void confirmDialog(){

        final View customLayout = getLayoutInflater().inflate(R.layout.confirmation_dialog, null);

        AlertDialog.Builder confirmDialogBuilder = new AlertDialog.Builder(this, R.style.CustomAlertDialog);
        confirmDialogBuilder.setView(customLayout);

        confirmDialog = confirmDialogBuilder.create();
        confirmDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        confirmDialog.show();

        Button confirmApplication = customLayout.findViewById(R.id.confirm_application);
        ImageButton closeDialog = customLayout.findViewById(R.id.close_dialog);

        confirmApplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitApplication();
            }
        });

        closeDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog.dismiss();
            }
        });

    }

    public void confirmApplication(){
        EditText firstName = findViewById(R.id.first_name);
        firstNameText = firstName.getText().toString();
        EditText lastName = findViewById(R.id.last_name);
        lastNameText = lastName.getText().toString();
        EditText email = findViewById(R.id.email_address);
        emailText = email.getText().toString();
        EditText link = findViewById(R.id.github_link);
        linkText = link.getText().toString();

        if(TextUtils.isEmpty(firstNameText)){
            firstName.setError(getString(R.string.first_name_message));
            return;
        }

        if(TextUtils.isEmpty(lastNameText)){
            lastName.setError(getString(R.string.last_name_message));
            return;
        }

        if(TextUtils.isEmpty(emailText)){
            email.setError(getString(R.string.email_message));
            return;
        }

        if(TextUtils.isEmpty(linkText)){
            link.setError(getString(R.string.link_message));
            return;
        }

        confirmDialog();
    }


    public void submitApplication() {
                confirmDialog.dismiss();
                GoogleFormService googleFormService = GoogleServiceBuilder.buildService(GoogleFormService.class);

                spinner.setVisibility(View.VISIBLE);
                Call<Void> request = googleFormService.postToGoogleForm(firstNameText,lastNameText,emailText,linkText);

                request.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> request, Response<Void> response) {
                        spinner.setVisibility(View.GONE);
                        informationDialog(R.drawable.ic_baseline_check_circle_24,"Submission Successful");
                    }

                    @Override
                    public void onFailure(Call<Void> request, Throwable t) {
                        spinner.setVisibility(View.GONE);
                        informationDialog(R.drawable.ic_baseline_report_problem_24,"Submission not Successful");
                    }
                });
    }
}