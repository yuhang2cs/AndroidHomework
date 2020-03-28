package com.example.secondapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.secondapp.model.Message;
import com.example.secondapp.widget.CircleImageView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private static final String TAG="yuhang";

    private List<Message> assetMessage;
    private int viewHolderCount;
    private ListItemClickListener mListener;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // each data item is just a string in this case
        public TextView title;
        public TextView description;
        public TextView time;
        public CircleImageView avatar;
        public ImageView robot;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title=(TextView) itemView.findViewById(R.id.tv_title);
            time=(TextView) itemView.findViewById(R.id.tv_time);
            description=(TextView) itemView.findViewById(R.id.tv_description);
            avatar=(CircleImageView) itemView.findViewById(R.id.iv_avatar);
            robot=(ImageView) itemView.findViewById(R.id.robot_notice);
            itemView.setOnClickListener(this);
        }
        public void bind(int position){

        }
        @Override
        public void onClick(View v){
            int clickedPosition=getAdapterPosition();
            if(mListener!=null){
                mListener.onListItemClick(clickedPosition);
            }
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Message> messages,ListItemClickListener listener) {
        assetMessage = messages;
        viewHolderCount=0;
        mListener=listener;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup,int viewType) {
        // create a new view
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.activity_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        MyViewHolder viewHolder = new MyViewHolder(view);
        //设置TextView
        viewHolder.title.setText(assetMessage.get(viewHolderCount).getTitle());
        viewHolder.description.setText(assetMessage.get(viewHolderCount).getDescription());
        viewHolder.time.setText(assetMessage.get(viewHolderCount).getTime());
        //set ImageView and CircleImageView
        if(assetMessage.get(viewHolderCount).isOfficial()==true)
            viewHolder.robot.setVisibility(View.VISIBLE);
        else
            viewHolder.robot.setVisibility(View.INVISIBLE);
        switch (assetMessage.get(viewHolderCount).getIcon()){
            case "TYPE_ROBOT":viewHolder.avatar.setImageResource(R.drawable.session_robot);
            break;
            case "TYPE_GAME":viewHolder.avatar.setImageResource(R.drawable.icon_micro_game_comment);
            break;
            case "TYPE_SYSTEM":viewHolder.avatar.setImageResource(R.drawable.session_system_notice);
            break;
            case "TYPE_STRANGER":viewHolder.avatar.setImageResource(R.drawable.session_stranger);
            break;
            case "TYPE_USER":viewHolder.avatar.setImageResource(R.drawable.icon_girl);
            break;
            default:viewHolder.avatar.setImageResource(R.drawable.ic_launcher_background);
        }
        Log.d(TAG, "onCreateViewHolder: number of ViewHolders created: " + viewHolderCount);
        viewHolderCount++;
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return assetMessage.size();
    }

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }
}
    