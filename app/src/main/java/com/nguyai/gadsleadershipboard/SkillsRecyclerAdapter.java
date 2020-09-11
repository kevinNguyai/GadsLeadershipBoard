package com.nguyai.gadsleadershipboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nguyai.gadsleadershipboard.models.SkillsIQLeader;

import java.util.List;

public class SkillsRecyclerAdapter extends RecyclerView.Adapter<SkillsRecyclerAdapter.ViewHolder> {

    private  final Context mContext;
    private final List<SkillsIQLeader> mLeaders;
    private final LayoutInflater mLayoutInflater;

    public SkillsRecyclerAdapter(Context context, List<SkillsIQLeader> leaders) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mLeaders = leaders;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.skills_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SkillsIQLeader leader = mLeaders.get(position);
        holder.mLeaderName.setText(leader.getName());
        holder.mDescription.setText(leader.getScore()+" "+holder.itemView.getResources().getString(R.string.skills_desc)+" "+leader.getCountry());
        holder.mCurrentPosition = position;
    }

    @Override
    public int getItemCount() {
        return mLeaders.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{

        public final TextView mLeaderName;
        public final TextView mDescription;
        public int mCurrentPosition;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            mLeaderName = (TextView) itemView.findViewById(R.id.leader_name);
            mDescription = (TextView) itemView.findViewById(R.id.description);

        }
    }
}
