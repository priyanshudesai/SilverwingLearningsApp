package com.example.myapplication.Database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class emp_list_Activity extends AppCompatActivity {

    List<Employee> employeeList;
    SQLiteDatabase mDatabase;
    ListView listViewEmployees;
    EmployeeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_emp_list);

        listViewEmployees= findViewById(R.id.database_emp_list);
        employeeList=new ArrayList<>();

        mDatabase=openOrCreateDatabase(EmpActivity.DATABASE_NAME,MODE_PRIVATE,null);

        showEmployeesFromDatabase();
    }

    private void showEmployeesFromDatabase() {

        Cursor cursorEmployees =mDatabase.rawQuery("SELECT * FROM employees",null);


        if (cursorEmployees.moveToFirst()) {
            //looping through all the records
            do {
                //pushing each record in the employee list
                employeeList.add(new Employee(
                        cursorEmployees.getInt(0),
                        cursorEmployees.getString(1),
                        cursorEmployees.getString(2),
                        cursorEmployees.getString(3),
                        cursorEmployees.getDouble(4)
                ));
            } while (cursorEmployees.moveToNext());
        }

        cursorEmployees.close();

        adapter = new EmployeeAdapter(emp_list_Activity.this, R.layout.database_emp_listcard, employeeList);

        listViewEmployees.setAdapter(adapter);
    }
}
