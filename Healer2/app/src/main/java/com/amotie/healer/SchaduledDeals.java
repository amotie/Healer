package com.amotie.healer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SchaduledDeals extends Fragment {
    RecyclerView doctor,medicicene;
    RecyclerView.Adapter adapter,adaptorMedicene;
    private List<DoctorSchaduledDealsList> doctorSchaduledDealsLists;
    private List<MedicineSchauledDealList> medicineSchauledDealLists;
    Bitmap doctorImage,mediceneImage;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.scheduled_deals,container,false);
        doctor = (RecyclerView)view.findViewById(R.id.DoctorRecycleViewDeals);
        LinearLayoutManager layoutManager = new  LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        doctor.setHasFixedSize(true);
        doctor.setLayoutManager(layoutManager);
        doctorSchaduledDealsLists=new ArrayList<>();
        doctorImage= BitmapFactory.decodeResource(getResources(),R.drawable.noraelmahdy);

//        if (foryouImage == null){
//            Log.i("Image","Before");
//        }


            DoctorSchaduledDealsList doctorListItem=new DoctorSchaduledDealsList(doctorImage,"Nadia Mohamed","Dentest","10:00 AM","Nasr City","250 LE");

            doctorSchaduledDealsLists.add(doctorListItem);
        doctorImage= BitmapFactory.decodeResource(getResources(),R.drawable.salymohmad);
         doctorListItem=new DoctorSchaduledDealsList(doctorImage,"Salma mohmed","Bone","11:00 AM","Nasr City","200 LE");

        doctorSchaduledDealsLists.add(doctorListItem);
        doctorImage= BitmapFactory.decodeResource(getResources(),R.drawable.salmafrag);
         doctorListItem=new DoctorSchaduledDealsList(doctorImage,"Saly frag","heart","8:00 AM","Nasr City","150 LE");

        doctorSchaduledDealsLists.add(doctorListItem);

        adapter=new DoctorSchaduledDealsAdaptor(doctorSchaduledDealsLists,getContext());
        doctor.setAdapter(adapter);
//        ----------------------------------------DoctorDeals------------------------------------
        medicicene = (RecyclerView)view.findViewById(R.id.MediceneRecycleViewDeals);
        LinearLayoutManager layoutManager1 = new  LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        medicicene.setHasFixedSize(true);
        medicicene.setLayoutManager(layoutManager1);
        medicineSchauledDealLists=new ArrayList<>();
        mediceneImage= BitmapFactory.decodeResource(getResources(),R.drawable.panadol);

//        if (foryouImage == null){
//            Log.i("Image","Before");
//        }


            MedicineSchauledDealList medicineSchauledDealList=new MedicineSchauledDealList(mediceneImage,"panadol","elazaby","15/10/2020");

            medicineSchauledDealLists.add(medicineSchauledDealList);
        mediceneImage= BitmapFactory.decodeResource(getResources(),R.drawable.catflam);
         medicineSchauledDealList=new MedicineSchauledDealList(mediceneImage,"cataflam","elmasry","15/10/2020");

        medicineSchauledDealLists.add(medicineSchauledDealList);
        mediceneImage= BitmapFactory.decodeResource(getResources(),R.drawable.augmantien);
         medicineSchauledDealList=new MedicineSchauledDealList(mediceneImage,"augmanten","elazaby","15/10/2020");

        medicineSchauledDealLists.add(medicineSchauledDealList);

        adaptorMedicene=new MediceneSchaduledDealsAdaptor(medicineSchauledDealLists,getContext());
        medicicene.setAdapter(adaptorMedicene);
        return view;
    }
}
