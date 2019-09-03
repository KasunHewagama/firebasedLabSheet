package com.example.student.it18165180firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class IT18165180firebase extends AppCompatActivity {

    EditText txt_id,txt_name,txt_address,txt_contact;
    Button btn_save,btn_show,btn_update,btn_delete;
    Student student;

    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it18165180firebase);

        txt_id = findViewById(R.id.txtid);
        txt_name = findViewById(R.id.txtname);
        txt_address = findViewById(R.id.txtaddress);
        txt_contact = findViewById(R.id.txtcontactno);

        btn_save = findViewById(R.id.btnsave);
        btn_show = findViewById(R.id.btnshow);
        btn_update = findViewById(R.id.btnupdate);
        btn_delete = findViewById(R.id.btndelete);

        student = new Student();

        btn_save.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Student");

                student.setId(txt_id.getText().toString().trim());
                student.setName(txt_name.getText().toString().trim());
                student.setAddress(txt_address.getText().toString().trim());
                student.setContctNo(Integer.parseInt(txt_contact.getText().toString().trim()));

//                dbRef.push().setValue(student);
                dbRef.child("st2").setValue(student);

                Toast.makeText(getApplicationContext(),"Adding Success",Toast.LENGTH_LONG).show();
                clearData();

            }
        });

    }

    public void clearData(){
        txt_id.setText("");
        txt_name.setText("");
        txt_address.setText("");
        txt_contact.setText("");
    }
}
