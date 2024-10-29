package com.example.shahzaib.onlinegroceryapp.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.shahzaib.onlinegroceryapp.Class.My;
import com.example.shahzaib.onlinegroceryapp.R;
import com.example.shahzaib.onlinegroceryapp.databinding.ActivityLoginBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    ActivityLoginBinding activityLoginBinding;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    SharedPreferences sharedPreferences;

    My my;
    ProgressDialog dialog, dialog_integration;

    String mobilePattern, passwordPattern;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        mobilePattern = "^((\\+92)|(0092))-{0,1}\\d{3}-{0,1}\\d{7}$|^\\d{11}$|^\\d{4}-\\d{7}$";
        passwordPattern = "^([a-zA-Z0-9@#$%^&+=]{6,15})$";

        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference("data").child("users");
        dialog = new ProgressDialog(this);
        dialog.setTitle("please wait....");
        dialog.setMessage("verifying user");
        dialog.setCanceledOnTouchOutside(false);

        //integration dialog
        dialog_integration = new ProgressDialog(this);
        dialog_integration.setTitle("please wait....");
        dialog_integration.setMessage("verifying account");
        dialog_integration.setCanceledOnTouchOutside(false);

        sharedPreferences = getSharedPreferences("save", 0);

        if (sharedPreferences.getBoolean("status", false)) {
            Intent intent = new Intent(Login.this, HomePage.class);
            startActivity(intent);
            finish();
        }

        activityLoginBinding.Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });

        activityLoginBinding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(activityLoginBinding.Mobile.getText().toString()) && TextUtils.isEmpty(activityLoginBinding.editTextPassword.getText().toString())) {
                    Toast.makeText(Login.this, "both the fields are mandatory", Toast.LENGTH_SHORT).show();
                    activityLoginBinding.Mobile.setError(null);
                } else if (TextUtils.isEmpty(activityLoginBinding.Mobile.getText().toString())) {
                    activityLoginBinding.Mobile.setError("please enter mobile number");
                } else if (TextUtils.isEmpty(activityLoginBinding.editTextPassword.getText().toString())) {
                    activityLoginBinding.editTextPassword.setError("please enter a password");
//                } else if (!activityLoginBinding.Mobile.getText().toString().matches(mobilePattern)) {
//                    activityLoginBinding.Mobile.setError("mobile must be of 10 digits");
//                } else if (!activityLoginBinding.editTextPassword.getText().toString().matches(passwordPattern)) {
//                    activityLoginBinding.editTextPassword.setError("length range between 6-15");
                } else {

                    activityLoginBinding.editTextPassword.setError(null);
                    activityLoginBinding.Mobile.setError(null);

                    dialog.show();

                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            boolean userFound = false;

                            for (DataSnapshot data : dataSnapshot.getChildren()) {

                                my = data.getValue(My.class);

                                if (activityLoginBinding.Mobile.getText().toString().equals(my.getMobile())
                                        && activityLoginBinding.editTextPassword.getText().toString().equals(my.getPassword())) {


                                    userFound = true;

                                    break;
                                }
                            }

                            if (userFound) {
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putBoolean("status", true);
                                editor.putString("senderID", my.getID());
                                editor.putString("senderName", my.getName());
                                editor.putString("userMobile", my.getMobile());
                                editor.putString("userEmail", my.getEmail());
                                editor.apply();

//                                databaseReference.child(myPojo.getMobile()).child("cartStatus").child("totalCount").setValue(0);


                                dialog.cancel();

                                Intent intent = new Intent(Login.this, HomePage.class);
                                startActivity(intent);
                                finish();
                            } else {

                                dialog.cancel();
                                Toast.makeText(Login.this, "invalid Credentials", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(Login.this, "Database error", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
//        forgotPass();
    }

//    private void forgotPass() {
//        activityLoginBinding.forgotpass.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if (!isConnectingToInternet(Login.this)) {
//                    Toast.makeText(Login.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
//                } else {
//                    Intent intent = new Intent(Login.this, EnterEmail.class);
//                    startActivity(intent);
//                }
//            }
//        });
//    }

    public static boolean isConnectingToInternet(Context context) {
        ConnectivityManager connectivity =
                (ConnectivityManager) context.getSystemService(
                        Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            for (NetworkInfo networkInfo : info)
                if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


}
