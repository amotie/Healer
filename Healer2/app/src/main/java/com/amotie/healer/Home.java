package com.amotie.healer;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;
import java.util.List;

public class Home extends Fragment {
    RecyclerView foryou,doctors,medicine;
    RecyclerView.Adapter adapter,adapterdoctor,adaptermedicine;
    private List<ForYouListItem> forYouListItems;
    private List<DoctorHomeListItem> doctorHomeListItemList;
    private List<MedicineHomeListItem> medicineHomeListItems;
    Bitmap foryouImage,doctorImage,medicineImage;
    ProgressDialog dialog;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home,container,false);
//        dialog=new ProgressDialog(getContext());
//        dialog.show();
//        dialog.setContentView(R.layout.lodding);
//        Window window=dialog.getWindow();
//        window.setBackgroundDrawableResource(R.color.colorBackground);
//        window.setLayout(250, 250);
//        dialog.setCancelable(false);
//        -------------------------------------------ProgressBar-----------------------------------------------------
        foryou = (RecyclerView)view.findViewById(R.id.ForYouList);
        LinearLayoutManager layoutManager = new  LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        foryou.setHasFixedSize(true);
        foryou.setLayoutManager(layoutManager);
        forYouListItems=new ArrayList<>();
        foryouImage= BitmapFactory.decodeResource(getResources(),R.drawable.nabilaelkhalfawy);

//        if (foryouImage == null){
//            Log.i("Image","Before");
//        }

            ForYouListItem doctorListItem=new ForYouListItem(foryouImage,"Nadia Mohamed","dermatology");
            forYouListItems.add(doctorListItem);
            foryouImage=BitmapFactory.decodeResource(getResources(),R.drawable.salmafrag);
         doctorListItem=new ForYouListItem(foryouImage,"Salma frag","Dentistry");
        forYouListItems.add(doctorListItem);
        foryouImage=BitmapFactory.decodeResource(getResources(),R.drawable.salymohmad);
         doctorListItem=new ForYouListItem(foryouImage,"saly mohmed","cardiology");
        forYouListItems.add(doctorListItem);
        foryouImage=BitmapFactory.decodeResource(getResources(),R.drawable.noraelmahdy);
         doctorListItem=new ForYouListItem(foryouImage,"nora elmahdy","bone");
        forYouListItems.add(doctorListItem);

        adapter=new ForYouAdaptor(forYouListItems,getContext());
        foryou.setAdapter(adapter);
//        -------------------------------------FORYOU----------------------------------------------------------------
        doctors = (RecyclerView)view.findViewById(R.id.DoctorsList);
        doctors.setHasFixedSize(true);
        LinearLayoutManager layoutManager1 = new  LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        doctors.setLayoutManager(layoutManager1);
        doctorHomeListItemList=new ArrayList<>();
        doctorImage= BitmapFactory.decodeResource(getResources(),R.drawable.nabilaelkhalfawy);



            DoctorHomeListItem doctorHomeListItem=new DoctorHomeListItem(doctorImage,"Nadia mohamed","dermatology");

            doctorHomeListItemList.add(doctorHomeListItem);
        doctorImage= BitmapFactory.decodeResource(getResources(),R.drawable.gourgemelad);
         doctorHomeListItem=new DoctorHomeListItem(doctorImage,"Gourge Melad","dermatology");

        doctorHomeListItemList.add(doctorHomeListItem);
        doctorImage= BitmapFactory.decodeResource(getResources(),R.drawable.noraelmahdy);
         doctorHomeListItem=new DoctorHomeListItem(doctorImage,"nora ahmed","dermatology");

        doctorHomeListItemList.add(doctorHomeListItem);
        doctorImage= BitmapFactory.decodeResource(getResources(),R.drawable.salymohmad);
         doctorHomeListItem=new DoctorHomeListItem(doctorImage,"Saly mohmed","dermatology");

        doctorHomeListItemList.add(doctorHomeListItem);
        adapterdoctor=new DoctorHomeAdaptor(doctorHomeListItemList,getContext());
        doctors.setAdapter(adapterdoctor);

        //--------------------------------------------------Doctor--------------------------------------------------
        medicine = (RecyclerView)view.findViewById(R.id.MedicinesList);
        medicine.setHasFixedSize(true);
        LinearLayoutManager layoutManager2 = new  LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        medicine.setLayoutManager(layoutManager2);
        medicineHomeListItems=new ArrayList<>();
        medicineImage= BitmapFactory.decodeResource(getResources(),R.drawable.catflam);



            MedicineHomeListItem medicineHomeListItem=new MedicineHomeListItem(medicineImage,"Cataflam","Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo");
            medicineHomeListItems.add(medicineHomeListItem);
         medicineHomeListItem=new MedicineHomeListItem(medicineImage,"Cataflam","Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo");
        medicineHomeListItems.add(medicineHomeListItem);
        medicineImage= BitmapFactory.decodeResource(getResources(),R.drawable.panadol);
         medicineHomeListItem=new MedicineHomeListItem(medicineImage,"Panadol","Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo");
        medicineHomeListItems.add(medicineHomeListItem);
        medicineHomeListItem=new MedicineHomeListItem(medicineImage,"Panadol","Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo");
        medicineHomeListItems.add(medicineHomeListItem);
        medicineImage= BitmapFactory.decodeResource(getResources(),R.drawable.augmantien);
         medicineHomeListItem=new MedicineHomeListItem(medicineImage,"augmantien","Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo");
        medicineHomeListItems.add(medicineHomeListItem);
        medicineHomeListItem=new MedicineHomeListItem(medicineImage,"augmantien","Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo");
        medicineHomeListItems.add(medicineHomeListItem);

        adaptermedicine=new MedicineHomeAdaptor(medicineHomeListItems,getContext());
        medicine.setAdapter(adaptermedicine);
        return view;
    }
}
