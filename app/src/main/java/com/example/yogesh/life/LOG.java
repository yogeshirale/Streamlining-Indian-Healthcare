package com.example.yogesh.life;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.util.Linkify;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LOG extends Activity {

    private UserLoginTask userLoginTask = null;
    private View loginFormView;
    private View progressView;
    private AutoCompleteTextView emailTextView;
    private EditText passwordTextView;
    private TextView signUpTextView;
    LoginDataBaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();

        emailTextView = (AutoCompleteTextView) findViewById(R.id.email);
        //loadAutoComplete();

        passwordTextView = (EditText) findViewById(R.id.password);
        passwordTextView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_NULL) {
                    initLogin();
                    return true;
                }
                return false;
            }
        });
        Button loginButton = (Button) findViewById(R.id.email_sign_in_button);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                initLogin();
                //Toast.makeText(getApplicationContext(), "Successfully Created ", Toast.LENGTH_LONG).show();
            }
        });

        loginFormView = findViewById(R.id.login_form);
        progressView = findViewById(R.id.login_progress);
        signUpTextView = (TextView) findViewById(R.id.signUpTextView);
        signUpTextView.setPaintFlags(signUpTextView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        Linkify.addLinks(signUpTextView, Linkify.ALL);

        signUpTextView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_LONG).show();
                // Log.i("SignupActivity", "Sign Up Activity activated.");
                // this is where you should start the signup Activity
                // LoginActivity.this.startActivity(new Intent(LoginActivity.this, SignupActivity.class));
                final Dialog dialog = new Dialog(LOG.this);
                dialog.setContentView(R.layout.signup);
                dialog.setTitle("Signup");
                dialog.show();
                final EditText editTextUserName = (EditText) dialog.findViewById(R.id.editTextUserName);
                final EditText editTextPassword = (EditText) dialog.findViewById(R.id.editTextPassword);
                final EditText editTextConfirmPassword = (EditText) dialog.findViewById(R.id.editTextConfirmPassword);
                Button btnCreateAccount = (Button) dialog.findViewById(R.id.buttonCreateAccount);
                btnCreateAccount.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        String userName = editTextUserName.getText().toString();
                        String password = editTextPassword.getText().toString();
                        String confirmPassword = editTextConfirmPassword.getText().toString();

                        // check if any of the fields are vaccant
                        if (userName.equals("") || password.equals("") || confirmPassword.equals("")) {
                            Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
                            return;
                        }
                        // check if both password matches
                        if (!password.equals(confirmPassword)) {
                            Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                            return;
                        } else {
                            // Save the Data in Database
                            loginDataBaseAdapter.insertEntry(userName, password);
                            Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
                            dialog.dismiss();
                        }

                    }
                });
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void initLogin() {
        if (userLoginTask != null) {
            return;
        }

        emailTextView.setError(null);
        passwordTextView.setError(null);

        String email = emailTextView.getText().toString();
        String password = passwordTextView.getText().toString();

        boolean cancelLogin = false;
        View focusView = null;

        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            passwordTextView.setError(getString(R.string.invalid_password));
            focusView = passwordTextView;
            cancelLogin = true;
        }

        if (TextUtils.isEmpty(email)) {
            emailTextView.setError(getString(R.string.field_required));
            focusView = emailTextView;
            cancelLogin = true;
        } else if (!isEmailValid(email)) {
            emailTextView.setError(getString(R.string.invalid_email));
            focusView = emailTextView;
            cancelLogin = true;
        }

        if (cancelLogin) {
            // error in login
            focusView.requestFocus();
        } else {
            // show progress spinner, and start background task to login
            showProgress(true);
            userLoginTask = new UserLoginTask(email, password);
            if (userLoginTask.doInBackground()) {
                Toast.makeText(LOG.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();

            } else
                Toast.makeText(LOG.this, "qqq", Toast.LENGTH_LONG).show();
        }
    }

    private boolean isEmailValid(String email) {
        //add your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //add your own logic
        return password.length() > 4;
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            loginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            loginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    loginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            progressView.setVisibility(show ? View.VISIBLE : View.GONE);
            progressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    progressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            progressView.setVisibility(show ? View.VISIBLE : View.GONE);
            loginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    public class UserLoginTask {

        private final String emailStr;
        private final String passwordStr;

        UserLoginTask(String email, String password) {
            emailStr = email;
            passwordStr = password;
        }

        protected Boolean doInBackground() {
            //this is where you should write your authentication code
            // or call external service
            // following try-catch just simulates network access
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                return false;
            }
            String storedPassword = loginDataBaseAdapter.getSinlgeEntry(emailStr);

            if (passwordStr.equals(storedPassword)) {
                Toast.makeText(LOG.this, "!! Successfull Sign in !!", Toast.LENGTH_LONG).show();
                Intent intent=new Intent(LOG.this,MainActivity.class);
                intent.putExtra("uid", emailStr);
                startActivity(intent);
                finish();
                return true;
            } else {
                return false;
            }


        }


    }
}