package com.example.cardviewrecycler.adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardviewrecycler.R;
import com.example.cardviewrecycler.modelclass.novalmodelclass;

import java.util.ArrayList;

public class novaladapter extends RecyclerView.Adapter<novaladapter.myviewholder> {


    ArrayList<novalmodelclass> List;
    Context context;


    public novaladapter(ArrayList<novalmodelclass> list, Context context) {
        List = list;
        this.context = context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);
        return new myviewholder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, @SuppressLint("RecyclerView") int position) {

        final novalmodelclass myMovieDataList = List.get(position);
        holder.textViewName.setText(myMovieDataList.getMynovalname());
        holder.textViewDate.setText(myMovieDataList.getNovaldata());
        holder.novalImage.setImageResource(myMovieDataList.getNovalimage());

        holder.layout.setBackgroundColor(Color.parseColor(myMovieDataList.getColor()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog);
                EditText edname = dialog.findViewById(R.id.name);
                EditText eddetails = dialog.findViewById(R.id.details);
                Button btn = dialog.findViewById(R.id.btn);
                TextView txt = dialog.findViewById(R.id.text);

                btn.setText("update");
                txt.setText("Update Data");

                edname.setText(myMovieDataList.getMynovalname());
                eddetails.setText(myMovieDataList.getNovaldata());


                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        List.set(position, new novalmodelclass(edname.getText().toString(), eddetails.getText().toString(), R.drawable.img_5,"#E91E63"));
                        notifyItemChanged(position);
                        dialog.dismiss();
                    }
                });

                dialog.show();

            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {


                AlertDialog.Builder builder=new AlertDialog.Builder(context)
                        .setTitle("Deleted").
                        setMessage("Are you Sure deleted massege").
                        setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                List.remove(position);
                                notifyItemRemoved(position);

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {


                            }
                        });
                builder.show();

                return false;
            }
        });


    }

    @Override
    public int getItemCount() {
        return List.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {

        ImageView novalImage;
        TextView textViewName;
        TextView textViewDate;
       CardView layout;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            novalImage = itemView.findViewById(R.id.imageview);
            textViewName = itemView.findViewById(R.id.textName);
            textViewDate = itemView.findViewById(R.id.textdate);
            layout = itemView.findViewById(R.id.linearlayout);
        }
    }
}
