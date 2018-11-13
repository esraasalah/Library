package com.library;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StudentOrders extends AppCompatActivity {

    FirebaseUser user ;
    DatabaseReference ref;
 //   FirebaseDatabase mFirebaseDatabase ;
    String userId ;
    Orders objOrder;
    ArrayList<Orders> ordersList;
    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapter2;
    ListView listview;
    ArrayList<String> urlList;
    ArrayList<String> emailList;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_orders);

        listview = findViewById(R.id.listview);
        auth = FirebaseAuth.getInstance();
     //   mFirebaseDatabase = FirebaseDatabase.getInstance();
        user = auth.getCurrentUser();
        Log.i("userrrrrrrrrr", user.getDisplayName());


        userId = user.getUid() ;


        ordersList = new ArrayList<Orders>();
        urlList = new ArrayList<String>();
        emailList = new ArrayList<String>();

        adapter = new ArrayAdapter<String>(this, R.layout.student_orderlist_node, R.id.orderurl, urlList);


        ref = FirebaseDatabase.getInstance().getReference();


        ref.child("students").child(user.getDisplayName()).child("orders").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    objOrder = new Orders();

                    objOrder.setColor(ds.child("color").getValue(String.class));
                    objOrder.setUrl(ds.child("url").getValue(String.class));
                    objOrder.setPrice(ds.child("price").getValue(String.class));
                    objOrder.setFinishing(ds.child("finishing").getValue(String.class));
                    objOrder.setNumberOfPages(ds.child("numberOfPages").getValue(String.class));
                    objOrder.setPaperType(ds.child("paperType").getValue(String.class));
                    objOrder.setSide(ds.child("side").getValue(String.class));
                    objOrder.setType(ds.child("type").getValue(String.class));


                    ordersList.add(objOrder);
                    urlList.add(objOrder.getUrl());


                    //  Log.i("listcountfromthread",String.valueOf(ordersList.size()));

                }
                listview.setAdapter(adapter);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {


            }


        });


    }


//  class OrderStudentList extends BaseAdapter
//  {
//
//
//
//        Context context ;
//      OrderStudentList( Context context)
//      {
//
//          this.context=context;
//
//
//
//
//
//
//
//
//      }
//
//      @Override
//      public int getCount() {
//          return ordersList.size() ;
//      }
//
//
//      @Override
//      public Object getItem(int i) {
//          return ordersList.get(i);
//      }
//
//
//      @Override
//      public long getItemId(int i) {
//          return i;
//      }
//
//      @Override
//      public View getView(int i, View view, ViewGroup viewGroup) {
//
//          Log.i("message", "welcome from getview");
//
//          LayoutInflater inflater = getLayoutInflater();
//          View row = inflater.inflate(R.layout.student_orderlist_node,viewGroup,false);
//          TextView url = (TextView) row.findViewById(R.id.orderurl);
//          ImageView image = (ImageView) row.findViewById(R.id.orderimage);
//          Orders ord=ordersList.get(i);
//
//          url.setText(ord.getUrl());
//
//
//          Log.i("count" , String.valueOf(getCount()));
//
//          return  row ;
//
//
//
//      }
//
//
//  }


}
