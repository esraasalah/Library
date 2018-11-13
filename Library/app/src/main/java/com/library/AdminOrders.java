package  com.library;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdminOrders extends AppCompatActivity {

    FirebaseUser user;
    DatabaseReference ref;
    Orders[] orders;
    Orders objOrder;
    int index = 0;
    ListView customList;
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
        orders = new Orders[100];

        ref = FirebaseDatabase.getInstance().getReference();
        try {

            ref.child("students").child("printingOrders").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        objOrder = new Orders();


                        objOrder.setUrl(ds.child("url").getValue(String.class));
                        objOrder.setEmail(ds.child("email").getValue(String.class));

                        orders[index] = objOrder;
                        Log.i("index", String.valueOf(index));
                        index++;


                    }


                    Log.i("index", orders[0].getUrl());
                    Log.i("index", orders[0].getEmail());
                    CustomAdapter adapter = new CustomAdapter(AdminOrders.this, R.layout.print_node, orders);
                    customList.setAdapter(adapter);

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