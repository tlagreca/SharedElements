package com.thomasjamesdev.thomas.sharedelementanimation;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/**
 * Created by Thomas on 22/09/2016.
 */

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private List<Person> personList;
    private final Activity activity;


    //Make sure to add the activity to the manifest.


    public PersonAdapter(Activity activity, List<Person> pList) {
        this.personList = pList;
        this.activity = activity;
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    @Override
    public void onBindViewHolder(final PersonViewHolder holder, int position) {
        Person p = personList.get(position);
        holder.tvFirstName.setText(p.firstName);

    }


    @Override
    public PersonViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.layout_card, parent, false);
        return new PersonViewHolder(itemView);

    }


    //The view holder for the recyclerView also deals with the item click listener.

    class PersonViewHolder extends RecyclerView.ViewHolder {

        TextView tvFirstName;

        PersonViewHolder(View v) {
            super(v);

            final ImageView imageView = (ImageView) v.findViewById(R.id.image);
            tvFirstName = (TextView) v.findViewById(R.id.txt_first_name);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {


                    Intent intent = new Intent(activity, DetailsActivity.class);


                    //Construct the object to pass through the intent
                    Person p = personList.get(getAdapterPosition());
                    String fName = p.firstName;
                    String lName = p.lastName;
                    String Addy = p.address;
                    String ph = p.phoneNumber;

                    //Add the items to the intent

                    intent.putExtra("firstName", fName);
                    intent.putExtra("lastName", lName);
                    intent.putExtra("address", Addy);
                    intent.putExtra("phone", ph);


                    //The sharedElements transition types need to be defined in the styles.
                    //The makeSceneTransition method takes a Context, the shared elements and transition name.
                    //The transition name is what defines the shared elements.

                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(activity, imageView, imageView.getTransitionName());

                    activity.startActivity(intent, options.toBundle());
                }
            });

        }
    }


}
