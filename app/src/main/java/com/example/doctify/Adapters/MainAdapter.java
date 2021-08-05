package com.example.doctify.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doctify.DetailActivity;
import com.example.doctify.Models.MainModel;
import com.example.doctify.R;
import com.example.doctify.ResultActivity;
import com.example.doctify.ResultEightActivity;
import com.example.doctify.ResultElevenActivity;
import com.example.doctify.ResultFiveActivity;
import com.example.doctify.ResultFourActivity;
import com.example.doctify.ResultNineActivity;
import com.example.doctify.ResultSevenActivity;
import com.example.doctify.ResultSixActivity;
import com.example.doctify.ResultTenActivity;
import com.example.doctify.ResultThreeActivity;
import com.example.doctify.ResultThreetenActivity;
import com.example.doctify.ResultTweleveActivity;
import com.example.doctify.ResultTwoActivity;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends  RecyclerView.Adapter<MainAdapter.viewholder> {
    ArrayList<MainModel> list;
    List<MainModel> filtersUserDataList;
    Context context;


    public MainAdapter(ArrayList<MainModel> list,List<MainModel> filtersUserDataList, Context context) {
        this.list = list;
        this.filtersUserDataList = filtersUserDataList;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.job_sample, parent,false);

        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        final MainModel model = list.get(position);
        holder.medicalImage.setImageResource(model.getImage());
        holder.medicalName.setText(model.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                switch (position){
                    case 0:
                        Intent intent = new Intent(context, ResultActivity.class);
                        intent.putExtra("name",model.getName());
                        context.startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(context, ResultTwoActivity.class);
                        intent1.putExtra("name",model.getName());
                        context.startActivity(intent1);
                        break;

                    case 2:
                        Intent intent2 = new Intent(context, ResultThreeActivity.class);
                        intent2.putExtra("name",model.getName());
                        context.startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(context, ResultFourActivity.class);
                        intent3.putExtra("name",model.getName());
                        context.startActivity(intent3);
                        break;

                    case 4:
                        Intent intent4 = new Intent(context, ResultFiveActivity.class);
                        intent4.putExtra("name",model.getName());
                        context.startActivity(intent4);
                        break;


                    case 5:
                        Intent intent5 = new Intent(context, ResultSixActivity.class);
                        intent5.putExtra("name",model.getName());
                        context.startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6 = new Intent(context, ResultSevenActivity.class);
                        intent6.putExtra("name",model.getName());
                        context.startActivity(intent6);
                        break;

                    case 7:
                        Intent intent7 = new Intent(context, ResultEightActivity.class);
                        intent7.putExtra("name",model.getName());
                        context.startActivity(intent7);
                        break;
                    case 8:
                        Intent intent8 = new Intent(context, ResultNineActivity.class);
                        intent8.putExtra("name",model.getName());
                        context.startActivity(intent8);
                        break;

                    case 9:
                        Intent intent9 = new Intent(context, ResultTenActivity.class);
                        intent9.putExtra("name",model.getName());
                        context.startActivity(intent9);
                        break;

                    case 10:
                        Intent intent10 = new Intent(context, ResultElevenActivity.class);
                        intent10.putExtra("name",model.getName());
                        context.startActivity(intent10);
                        break;
                    case 11:
                        Intent intent11 = new Intent(context, ResultTweleveActivity.class);
                        intent11.putExtra("name",model.getName());
                        context.startActivity(intent11);
                        break;

                    case 12:
                        Intent intent12 = new Intent(context, ResultThreetenActivity.class);
                        intent12.putExtra("name",model.getName());
                        context.startActivity(intent12);
                        break;
                }

            }
        });

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, ResultActivity.class);
//
//                intent.putExtra("name",model.getName());
//                context.startActivity(intent);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return filtersUserDataList.size();
    }

    public  class  viewholder extends RecyclerView.ViewHolder {
        ImageView medicalImage;
        TextView medicalName;
        public viewholder(@NonNull View itemView) {
            super(itemView);

            medicalImage = itemView.findViewById(R.id.imageView);
            medicalName =  (TextView)itemView.findViewById(R.id.medName);

        }
    }
    public  Filter getFilter(){
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {


                String Key = constraint.toString();
                if (Key.isEmpty()){
                    filtersUserDataList = list;
                }
                else {
                    List<MainModel> lstFiltered = new ArrayList<>();
                    for (MainModel row : list){
                        if (row.getName().toLowerCase().contains(Key.toLowerCase())){
                            lstFiltered.add(row);
                        }
                    }
                    filtersUserDataList = lstFiltered;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filtersUserDataList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {


                filtersUserDataList = (List<MainModel>)results.values;
                notifyDataSetChanged();

            }
        };
    }
}
