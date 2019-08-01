package com.example.akash.vector;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;


public class Solve_Process_1 extends ActionBarActivity {

    TextView a_vector;
    TextView b_vector;
    TextView v_solve;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solve__process_1);
        a_vector = (TextView)findViewById(R.id.vector_a);
        b_vector = (TextView)findViewById(R.id.vector_b);
        v_solve = (TextView)findViewById(R.id.solve);

        a_vector.setText(getIntent().getStringExtra("Avector"));
        b_vector.setText(getIntent().getStringExtra("Bvector"));
        v_solve.setText(getIntent().getStringExtra("resultAB"));
    }
}
