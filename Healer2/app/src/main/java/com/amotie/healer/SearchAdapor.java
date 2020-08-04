package com.amotie.healer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SearchAdapor extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {
    List<Object> objects;
    List<Object> objectsAll;
    Context context;

    public SearchAdapor(List<Object> objects, Context context) {
        this.objects = objects;
        objectsAll=new ArrayList<>(objects);
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (objects.get(position) instanceof DoctorSearchList){
            return 1;
        }
        else if(objects.get(position) instanceof MedicieneSearchList){
            return 0;
        }
        return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder viewHolder=null;
        if (viewType==1){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.search_doctor_list,parent,false);
            viewHolder=new DoctorViewHolder(view);
        }
        else if (viewType==0){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.search_medicine_list,parent,false);
            viewHolder=new MedicineViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType()==1){
            DoctorSearchList doctorSearchList= (DoctorSearchList) objects.get(position);
            DoctorViewHolder doctorViewHolder=(DoctorViewHolder)holder;
            doctorViewHolder.name.setText(doctorSearchList.name);
            doctorViewHolder.fees.setText(doctorSearchList.price);
            doctorViewHolder.rate.setRating(doctorSearchList.rate);
            doctorViewHolder.spicialist.setText(doctorSearchList.specilest);
            doctorViewHolder.imageView.setImageBitmap(doctorSearchList.image);
        }
        else if (holder.getItemViewType()==0){
            MedicieneSearchList medicieneSearchList= (MedicieneSearchList) objects.get(position);
            MedicineViewHolder medicineViewHolder=(MedicineViewHolder) holder;
            medicineViewHolder.name.setText(medicieneSearchList.name);
            medicineViewHolder.price.setText(medicieneSearchList.price);
            medicineViewHolder.provider.setText(medicieneSearchList.provider);
            medicineViewHolder.imageView.setImageBitmap(medicieneSearchList.image);
            medicineViewHolder.addToCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    @Override
    public Filter getFilter() {
        return searchFilter;
    }
    private Filter searchFilter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Object> filterList=new ArrayList<>();
            if (constraint==null || constraint.length()==0){
                filterList.addAll(objectsAll);
            }
            else{
                String filterPattern=constraint.toString().toLowerCase().trim();
                for (Object o : objectsAll){
                    if (o instanceof DoctorSearchList
                            && ((DoctorSearchList) o).name.toLowerCase().contains(filterPattern)){
                                filterList.add(o);
                    }
                    else if (o instanceof MedicieneSearchList
                    && ((MedicieneSearchList) o).name.toLowerCase().contains(filterPattern)){
                        filterList.add(o);
                    }
                }
            }
        FilterResults filterResults=new FilterResults();
            filterResults.values=filterList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            objects.clear();
            objects.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public class DoctorViewHolder extends RecyclerView.ViewHolder{
    CircularImageView imageView;
    TextView name,spicialist,fees;
    RatingBar rate;

        public DoctorViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=(CircularImageView)itemView.findViewById(R.id.circularImageView);
            name=(TextView)itemView.findViewById(R.id.DoctorNameSearchList);
            spicialist=(TextView)itemView.findViewById(R.id.DoctorspicialistSearchList);
            rate=(RatingBar)itemView.findViewById(R.id.ratingBar);
            fees=(TextView)itemView.findViewById(R.id.DoctorfeesSearchList);
        }
    }
    public class MedicineViewHolder extends RecyclerView.ViewHolder{
        CircularImageView imageView,addToCart;
        TextView name,provider,price;

        public MedicineViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=(CircularImageView)itemView.findViewById(R.id.circularImageView);
            name=(TextView)itemView.findViewById(R.id.MedicineNameSearchList);
            provider=(TextView)itemView.findViewById(R.id.MedicineProviderSearchList);
            price=(TextView)itemView.findViewById(R.id.MedicenePriceSearchList);
            addToCart=(CircularImageView)itemView.findViewById(R.id.circularImageView2);
        }
    }
}
