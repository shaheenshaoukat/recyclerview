package com.example.cardviewrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cardviewrecycler.adapter.novaladapter;
import com.example.cardviewrecycler.databinding.ActivityMainBinding;
import com.example.cardviewrecycler.databinding.ActivityRecyclerBinding;
import com.example.cardviewrecycler.modelclass.novalmodelclass;

import java.util.ArrayList;

public class recyclerActivity extends AppCompatActivity {


    ActivityRecyclerBinding binding;
    ArrayList<novalmodelclass> List = new ArrayList<>();
    novaladapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        binding = ActivityRecyclerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        List.add(new novalmodelclass("Alif", "umera ahmad Writer", R.drawable.img,"#FF5722"));
        List.add(new novalmodelclass("Namal", "Nimra ahmad writer", R.drawable.img_1,"#BA0932" ));
        List.add(new novalmodelclass("Janat ky paty", "Nimra Ahmad", R.drawable.img_2,"#2A3887"));
        List.add(new novalmodelclass("peer a Kamil", "Umera Ahmad", R.drawable.img_3,"#CDDC39" ));
        List.add(new novalmodelclass("Fateh", "Nimra Ahmad", R.drawable.img_4,"#FF018786" ));


        LinearLayoutManager obj = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(obj);
        adapter = new novaladapter(List, recyclerActivity.this);
        binding.recyclerView.setAdapter(adapter);


        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Dialog dialog = new Dialog(recyclerActivity.this);
                dialog.setContentView(R.layout.dialog);


                EditText mynovalname = dialog.findViewById(R.id.name);
                EditText novaldata = dialog.findViewById(R.id.details);
                Button btn_send = dialog.findViewById(R.id.btn);
                dialog.show();

                btn_send.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        if (mynovalname.getText().toString().equals("")) {
                            Toast.makeText(recyclerActivity.this, "fill Name", Toast.LENGTH_SHORT).show();
                        }

                        if (novaldata.getText().toString().equals("")) {
                            Toast.makeText(recyclerActivity.this, "fill Details", Toast.LENGTH_SHORT).show();
                        } else {

                            List.add(new novalmodelclass(mynovalname.getText().toString(), novaldata.getText().toString(), R.drawable.img_5,"#E91E63"));
                            adapter.notifyItemInserted(List.size() - 1);
                            binding.recyclerView.scrollToPosition(List.size() - 1);
                            dialog.dismiss();

                        }
                    }
                });

            }
        });


    }


}
