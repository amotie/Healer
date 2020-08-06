package com.amotie.healer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TypesOfExaminationAdaptor extends RecyclerView.Adapter<TypesOfExaminationAdaptor.ViewHolder> {
    private List<TypesOfExamination> typesOfExaminationList;
    private Context context;

    public TypesOfExaminationAdaptor(List<TypesOfExamination> typesOfExaminationList, Context context) {
        this.typesOfExaminationList = typesOfExaminationList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.types_of_examintions_list,parent,false);
        return new TypesOfExaminationAdaptor.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final TypesOfExamination typesOfExamination=typesOfExaminationList.get(position);
        holder.examination.setText(typesOfExamination.examin);
        holder.selected.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                holder.selected.setSelected(isChecked);
                typesOfExamination.chiecked=isChecked;
                typesOfExaminationList.set(position,typesOfExamination);
            }
        });
    }

    @Override
    public int getItemCount() {
        return typesOfExaminationList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        TextView examination;
        CheckBox selected;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            examination=(TextView) itemView.findViewById(R.id.textView25);
            selected=(CheckBox) itemView.findViewById(R.id.checkBox);



        }
    }

}
