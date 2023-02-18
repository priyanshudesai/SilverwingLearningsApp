package com.example.myapplication.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;

import java.util.List;

public class EmployeeAdapter extends ArrayAdapter<Employee> {

    Context mCtx;
    int listLayoutRes;
    List<Employee> employeeList;
    SQLiteDatabase mDatabase;
    public EmployeeAdapter(Context mCtx, int listLayoutRes, List<Employee> employeeList) {
        super(mCtx, listLayoutRes, employeeList);

        this.mCtx = mCtx;
        this.listLayoutRes = listLayoutRes;
        this.employeeList = employeeList;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(listLayoutRes, null);

        //getting employee of the specified position
        Employee employee = employeeList.get(position);


        //getting views
        TextView textViewName = view.findViewById(R.id.db_list_name);
        TextView textViewDept = view.findViewById(R.id.db_list_dept);
        TextView textViewSalary = view.findViewById(R.id.db_list_sal);
        TextView textViewJoiningDate = view.findViewById(R.id.db_list_joindate);

        //adding data to views
        textViewName.setText(employee.getName());
        textViewDept.setText(employee.getDept());
        textViewSalary.setText(String.valueOf(employee.getSalary()));
        textViewJoiningDate.setText(employee.getJoiningDate());

        //we will use these buttons later for update and delete operation
        Button buttonDelete = view.findViewById(R.id.db_list_dlt_btn);
        Button buttonEdit = view.findViewById(R.id.db_list_edit_btn);

        return view;
    }
}
