package com.example.myapplication.Database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EmpActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String DATABASE_NAME = "myemployeedatabase";

    TextView empview;
    EditText empname,empsal;
    Spinner empdept;

    SQLiteDatabase mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_emp_entries);

        empview=(TextView) findViewById(R.id.datbase_emp_viewemp);
        empname=(EditText) findViewById(R.id.datbase_emp_name);
        empsal=(EditText) findViewById(R.id.datbase_emp_salary);
        empdept=(Spinner) findViewById(R.id.datbase_emp_dept);

        findViewById(R.id.datbase_emp_add_btn).setOnClickListener(this);
        empview.setOnClickListener(this);

        mDatabase=this.openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);
        createEmployeeTable();
    }

    private boolean inputsAreCorrect(String name, String salary) {
        if (name.isEmpty()) {
            empname.setError("Please enter a name");
            empname.requestFocus();
            return false;
        }

        if (salary.isEmpty() || Integer.parseInt(salary) <= 0) {
            empsal.setError("Please enter salary");
            empsal.requestFocus();
            return false;
        }
        return true;
    }

    private void addemp(){

        String name = empname.getText().toString().trim();
        String salary = empsal.getText().toString().trim();
        String dept = empdept.getSelectedItem().toString();

        //getting the current time for joining date
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String joiningDate = sdf.format(cal.getTime());

        //validating the inptus
        if (inputsAreCorrect(name, salary)) {

            String insertSQL = "INSERT INTO employees \n" +
                    "(name, department, joiningdate, salary)\n" +
                    "VALUES \n" +
                    "(?, ?, ?, ?);";

            //using the same method execsql for inserting values
            //this time it has two parameters
            //first is the sql string and second is the parameters that is to be binded with the query
            mDatabase.execSQL(insertSQL, new String[]{name, dept, joiningDate, salary});

            Toast.makeText(this, "Employee Added Successfully", Toast.LENGTH_SHORT).show();
        }
    }


    private void createEmployeeTable() {
        mDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS employees (\n" +
                        "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                        "    name varchar(200) NOT NULL,\n" +
                        "    department varchar(200) NOT NULL,\n" +
                        "    joiningdate datetime NOT NULL,\n" +
                        "    salary double NOT NULL\n" +
                        ");"
        );
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.datbase_emp_add_btn:
                addemp();
                break;
            case R.id.datbase_emp_viewemp:
                startActivity(new Intent(this,emp_list_Activity.class));
                break;
        }
    }
}
