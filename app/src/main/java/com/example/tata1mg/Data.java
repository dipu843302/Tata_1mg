package com.example.tata1mg;

import static com.example.tata1mg.R.layout.activity_data;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Data extends AppCompatActivity {
    private BottomNavigationView bnv;

private RecyclerView recyclerView;
private DataAdapter dataAdapter;
private ArrayList<ModelClass>arrayList=new ArrayList<ModelClass>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        intit();

        recyclerView=findViewById(R.id.recyclerView1);
        buildData();
        setRecyclerView();
    }

    private void intit() {

       bnv=findViewById(R.id.bottomNavigation);

       bnv.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
           @Override
           public void onNavigationItemReselected(@NonNull MenuItem item) {
               switch (item.getItemId()){

                   case R.id.menu_profile:
                       Intent intent=new Intent(Data.this,Home.class);
                       startActivity(intent);
                       break;
                   case R.id.menu_offer:
                       Intent intent2=new Intent(Data.this,Offer.class);
                       startActivity(intent2);
                       break;
                   case R.id.menu_search:
                       Intent intent3=new Intent(Data.this,Brand.class);
                       startActivity(intent3);
                       break;

               }
           }
       });

    }

    private void setRecyclerView() {
        dataAdapter=new DataAdapter(arrayList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setAdapter(dataAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    private void buildData() {
     for (int i=0;i<20;i++){
         arrayList.add(new ModelClass(R.drawable.neem,"Neem Skin Wellness","60 Tablets","Rs 165","Add to cart"));
         arrayList.add(new ModelClass(R.drawable.tentex_forte_1024x1024,"Tentex Forte","10 Tablets","Rs 80","Add to cart"));
         arrayList.add(new ModelClass(R.drawable.mutlivitamain,"1mg Multivitamin Supreme Immunity Booster Zinc","60 Capsules","Rs 498","Add to cart"));
         arrayList.add(new ModelClass(R.drawable.him2,"Bjain Guatteria Gaumeri Drop","200 ml","Rs 255","Add to cart"));
         arrayList.add(new ModelClass(R.drawable.him4,"Dermicool Prickly Powder with Dettol Soap","125 gm","Rs 115","Add to cart"));
         arrayList.add(new ModelClass(R.drawable.him6,"Itch Guard Plus Cream","20 gm","Rs 94","Add to cart"));
         arrayList.add(new ModelClass(R.drawable.him8,"Organic India Lipid Care Capsule","50 capsule","Rs 203","Add to cart"));
         arrayList.add(new ModelClass(R.drawable.hm3,"1mg Salmon Omega 3 Fish oil Capsule","60 capsule","Rs 498","Add to cart"));
         arrayList.add(new ModelClass(R.drawable.hm5,"Axiom Aloevera Amla Juice","1 ltr","Rs 237","Add to cart"));
         arrayList.add(new ModelClass(R.drawable.him4,"Dermicool Prickly Powder with Dettol Soap","125 gm","Rs 115","Add to cart"));
     }
    }

}