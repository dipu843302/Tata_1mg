package com.example.tata1mg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tata1mg.databinding.ActivityNewRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.regex.Pattern;

public class NewRegister extends AppCompatActivity {
    private EditText mEtPassword, mEtName, mEtEmail;
    private Button mBtnRegister;

    private FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
    private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference=firebaseDatabase.getReference("users");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_register);

        initViewsAndListeners();

        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()){

                    firebaseAuth.createUserWithEmailAndPassword(mEtEmail.getText().toString(),mEtPassword.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()){
                                        User user=new User(
                                                mEtName.getText().toString(),
                                                mEtEmail.getText().toString()
                                        );
                                           databaseReference.child(firebaseAuth.getCurrentUser().getUid())
                                                   .setValue(user)
                                                   .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                       @Override
                                                       public void onComplete(@NonNull Task<Void> task) {
                                                           Intent intent=new Intent(NewRegister.this,Data.class);
                                                           startActivity(intent);
                                                           Toast.makeText(NewRegister.this, "Sign up Successfully", Toast.LENGTH_SHORT).show();
                                                       }
                                                   });
                                    }
                                }
                            });
                }
            }
        });

    }

    private boolean validate() {
        boolean isValid=true;
        if (!Patterns.EMAIL_ADDRESS.matcher(mEtEmail.getText().toString()).matches()){
            mEtEmail.setError("Invalid email");
            isValid=false;
        }
        if (mEtPassword.getText().toString().length()<8){
            mEtPassword.setError("Password is too short");
            isValid=false;
        }
        return isValid ;
    }


    private void initViewsAndListeners() {
        mEtPassword =findViewById(R.id.etPassword);
        mEtName=findViewById(R.id.etName);
        mEtEmail=findViewById(R.id.etEmail);
        mBtnRegister=findViewById(R.id.btnRegister);


    }
}