package android.example.hw_recyclerview.adapter;

import android.content.Context;
import android.example.hw_recyclerview.R;
import android.example.hw_recyclerview.model.user;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterUser extends RecyclerView.Adapter<AdapterUser.MyViewHolder> {

    Context context;
    ArrayList<user> mlist;
    LayoutInflater inflater;

    public AdapterUser(Context context,ArrayList<user> list){
        this.context=context;
        mlist=list;
        inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=inflater.inflate(R.layout.custom_linear_list_view,viewGroup,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        user u=mlist.get(i);
        myViewHolder.imageView.setImageResource(u.getImage());
        myViewHolder.textView_title.setText(u.getTitle());
        myViewHolder.textView_description.setText(u.getDescripton());
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView_title,textView_description;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image_view);
            textView_title=itemView.findViewById(R.id.text_view_title);
            textView_description=itemView.findViewById(R.id.text_view_description);
        }


    }
}
