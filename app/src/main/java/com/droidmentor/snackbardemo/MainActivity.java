package com.droidmentor.snackbardemo;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public static final int SNACKBAR_DURATION = 2000;

    CoordinatorLayout coordinatorLayout;
    TextView tv_import;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        coordinatorLayout=(CoordinatorLayout)findViewById(R.id.coordinatorLayout);
        tv_import=(TextView)findViewById(R.id.tv_import);
        tv_import.setVisibility(View.VISIBLE);

        tv_import.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkStorage();
            }
        });

        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Contact saved", SNACKBAR_DURATION).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_delete) {
            deleteContact();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void deleteContact()
    {
        Snackbar snackbar = Snackbar
                .make(coordinatorLayout, "Contact removed",SNACKBAR_DURATION)
                .setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("", " The contact is restored ");
                    }
                });

        View snackView = snackbar.getView();
        snackView.setBackgroundColor(ContextCompat.getColor(this, R.color.snackBarBg));
        TextView snackViewText = (TextView) snackView.findViewById(android.support.design.R.id.snackbar_text);
        snackViewText.setTextColor(ContextCompat.getColor(this, R.color.colorWhite));
        Button snackViewButton = (Button) snackView.findViewById(android.support.design.R.id.snackbar_action);
        snackViewButton.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));

        // You can replace the above lines by using the below single line :)
        //snackbar=SnackBarUtil.getColorfulSnackBar(snackbar,this,R.color.snackBarBg,R.color.colorWhite,R.color.colorAccent);

        snackbar.show();
    }

    public void checkStorage()
    {
        final Snackbar customSnackBar = Snackbar.make(coordinatorLayout, "", SNACKBAR_DURATION);

        Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) customSnackBar.getView();

        View customsnackView = getLayoutInflater().inflate(R.layout.storage_check, null);

        TextView tvConnection = (TextView) customsnackView.findViewById(R.id.tv_connection);
        ImageView ivConnection = (ImageView) customsnackView.findViewById(R.id.iv_connection);

        // We can also customize the above controls

        layout.setPadding(0,0,0,0);
        layout.addView(customsnackView, 0);

        customSnackBar.show();
    }

}
