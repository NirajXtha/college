package com.example.mychess;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    GoogleSignInClient signInClient;
    ShapeableImageView profilePic;
    SignInButton signInButton;
    GoogleApiClient mGoogleApiClient;
    Button play, signOutBtn;
    TextView username, email;
//    private String android_id = Settings.Secure.getString(getContext().getContentResolver(),
//            Settings.Secure.ANDROID_ID);
    private final ActivityResultLauncher<Intent> activityResultLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == RESULT_OK) {
                        Task<GoogleSignInAccount> accountTask = GoogleSignIn.getSignedInAccountFromIntent(result.getData());
                        try{
                            GoogleSignInAccount signInAccount = accountTask.getResult(ApiException.class);
                            AuthCredential authCredential = GoogleAuthProvider.getCredential(signInAccount.getIdToken(), null);
                            auth.signInWithCredential(authCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        auth = FirebaseAuth.getInstance();
                                        Glide.with(MainActivity.this).load(Objects.requireNonNull(auth.getCurrentUser()).getPhotoUrl()).into(profilePic);
                                        username.setText(auth.getCurrentUser().getDisplayName());
                                        email.setText(auth.getCurrentUser().getEmail());
                                        email.setVisibility(View.VISIBLE);
                                        signInButton.setVisibility(View.GONE);
                                        signOutBtn.setVisibility(View.VISIBLE);
                                        Toast.makeText(MainActivity.this, "Signed In Successfully!", Toast.LENGTH_SHORT).show();
                                    } else{
                                        Toast.makeText(MainActivity.this, "Failed to sign in: " + task.getException(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        } catch (ApiException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseApp.initializeApp(this);
        profilePic = findViewById(R.id.profilePic);
        signInButton = findViewById(R.id.googleSignIn);
        signOutBtn = findViewById(R.id.signOutBtn);
        play = findViewById(R.id.buttonPlayGame);
        username = findViewById(R.id.username);
        email = findViewById(R.id.emailAddress);

        GoogleSignInOptions options = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.client_id))
                .requestEmail()
                .build();
        signInClient = GoogleSignIn.getClient(MainActivity.this, options);

        auth = FirebaseAuth.getInstance();

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = signInClient.getSignInIntent();
                activityResultLauncher.launch(intent);
            }
        });

        // ~ signout ~
        signOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().addAuthStateListener(new FirebaseAuth.AuthStateListener() {
                    @Override
                    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                        try{
                            signInClient.signOut().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    email.setVisibility(View.GONE);
                                    signInButton.setVisibility(View.VISIBLE);
                                    signOutBtn.setVisibility(View.GONE);
                                    profilePic.setImageResource(R.mipmap.ic_launcher);
                                    Toast.makeText(MainActivity.this, "Signed out Successfully!", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(MainActivity.this, MainActivity.class));
                                }
                            });
                        } catch (Exception e) {
                            Toast.makeText(MainActivity.this, "Failed to sign out: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                FirebaseAuth.getInstance().signOut();
            }
        });

        if(auth.getCurrentUser() != null){
            Glide.with(MainActivity.this).load(Objects.requireNonNull(auth.getCurrentUser()).getPhotoUrl()).into(profilePic);
            username.setText(auth.getCurrentUser().getDisplayName());
            email.setText(auth.getCurrentUser().getEmail());
            email.setVisibility(View.VISIBLE);
            signInButton.setVisibility(View.GONE);
            signOutBtn.setVisibility(View.VISIBLE);
        }
    }

}