package  com.library;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AdminOrders extends AppCompatActivity {

    static ArrayList<Orders> orderArrayList;
    static int flag;
    static int pos;
    FirebaseUser user;
    DatabaseReference ref;
    Orders[] orders;
    Orders objOrder;
    int index = 0;
    ListView customList, presentationList, translationList;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_orders);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        Log.i("emaillll", user.getEmail());
        // printOrders = new ArrayList<Orders>();

        customList = findViewById(R.id.listview);
        presentationList = findViewById(R.id.presentationlistview);
        translationList = findViewById(R.id.translationlistview);
        //orders = new Orders[2];
        orderArrayList = new ArrayList<Orders>();

        ref = FirebaseDatabase.getInstance().getReference();
        try {

            ref.child("students").child("printingOrders").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        objOrder = new Orders();


                        objOrder.setUrl(ds.child("url").getValue(String.class));
                        objOrder.setEmail(ds.child("email").getValue(String.class));
                        objOrder.setType(ds.child("type").getValue(String.class));
                        objOrder.setSide(ds.child("side").getValue(String.class));
                        objOrder.setFinishing(ds.child("finishing").getValue(String.class));
                        objOrder.setNumberOfPages(ds.child("numberOfPages").getValue(String.class));
                        objOrder.setPrice(ds.child("price").getValue(String.class));


                        orderArrayList.add(objOrder);


                        //   orders[index] = objOrder;
                        // Log.i("index", String.valueOf(index));
                        //  index++;


                    }

                    orders = new Orders[orderArrayList.size()];

                    for (int i = 0; i < orderArrayList.size(); i++) {
                        orders[i] = orderArrayList.get(i);

                    }


                    CustomAdapter adapter = new CustomAdapter(AdminOrders.this, R.layout.print_node, orders);
                    customList.setAdapter(adapter);
                    customList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> listView, View itemView, int itemPosition, long itemId) {
                            flag = 1;
                            pos = itemPosition;
                            startActivity(new Intent(getApplicationContext(), OrderDetails.class));
                        }
                    });


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {


                }


            });


        } catch (Exception e) {

            Log.i("exception", "exception");

        }


        ref = FirebaseDatabase.getInstance().getReference();
        try {

            ref.child("students").child("presentationOrders").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        objOrder = new Orders();


                        objOrder.setUrl(ds.child("url").getValue(String.class));
                        objOrder.setEmail(ds.child("email").getValue(String.class));
                        objOrder.setNote(ds.child("note").getValue(String.class));
                        objOrder.setNumberOfPages(ds.child("numberOfPages").getValue(String.class));
                        objOrder.setPrice(ds.child("price").getValue(String.class));

                        orderArrayList.add(objOrder);


                        //   orders[index] = objOrder;
                        // Log.i("index", String.valueOf(index));
                        //  index++;


                    }

                    orders = new Orders[orderArrayList.size()];

                    for (int i = 0; i < orderArrayList.size(); i++) {
                        orders[i] = orderArrayList.get(i);

                    }


                    CustomAdapter adapter = new CustomAdapter(AdminOrders.this, R.layout.print_node, orders);
                    presentationList.setAdapter(adapter);

                    presentationList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> listView, View itemView, int itemPosition, long itemId) {

                            flag = 2;
                            pos = itemPosition;
                            startActivity(new Intent(getApplicationContext(), OrderDetails.class));
                        }
                    });


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {


                }


            });


        } catch (Exception e) {

            Log.i("exception", "exception");

        }


        /////////////////////////////////
        ref = FirebaseDatabase.getInstance().getReference();
        try {

            ref.child("students").child("TranslationOrders").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        objOrder = new Orders();


                        objOrder.setUrl(ds.child("url").getValue(String.class));
                        objOrder.setEmail(ds.child("email").getValue(String.class));
                        objOrder.setType(ds.child("type").getValue(String.class));
                        objOrder.setSide(ds.child("side").getValue(String.class));
                        objOrder.setFinishing(ds.child("finishing").getValue(String.class));
                        objOrder.setNumberOfPages(ds.child("numberOfPages").getValue(String.class));
                        objOrder.setPrice(ds.child("price").getValue(String.class));
                        objOrder.setColor(ds.child("color").getValue(String.class));

                        orderArrayList.add(objOrder);


                        //   orders[index] = objOrder;
                        // Log.i("index", String.valueOf(index));
                        //  index++;


                    }

                    orders = new Orders[orderArrayList.size()];

                    for (int i = 0; i < orderArrayList.size(); i++) {
                        orders[i] = orderArrayList.get(i);

                    }


                    CustomAdapter adapter = new CustomAdapter(AdminOrders.this, R.layout.print_node, orders);
                    translationList.setAdapter(adapter);
                    translationList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> listView, View itemView, int itemPosition, long itemId) {
                            flag = 3;
                            pos = itemPosition;
                            startActivity(new Intent(getApplicationContext(), OrderDetails.class));
                        }
                    });


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {


                }


            });


        } catch (Exception e) {

            Log.i("exception", "exception");

        }


    }


}