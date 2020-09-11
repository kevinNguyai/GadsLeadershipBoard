package com.nguyai.gadsleadershipboard;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nguyai.gadsleadershipboard.models.Learner;

import java.util.List;

public class LearningRecyclerAdapter extends RecyclerView.Adapter<LearningRecyclerAdapter.ViewHolder> {
    final private String TAG = "LearningRecyclerAdapter";
    private  final Context mContext;
    private final List<Learner> mLearners;
    private final LayoutInflater mLayoutInflater;

    public LearningRecyclerAdapter(Context context, List<Learner> leaners) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mLearners = leaners;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.learning_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: " + position);
        Learner learner = mLearners.get(position);
        holder.mLearnerName.setText(learner.getName());
        holder.mLearnerDescription.setText(learner.getHours()+" "+
                holder.itemView.getResources().getString(R.string.learning_desc)+" "+
                learner.getCountry());
        holder.mCurrentPosition = position;
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "count: " + mLearners.size()); return mLearners.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{

        public final TextView mLearnerName;
        public final TextView mLearnerDescription;
        public int mCurrentPosition;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            mLearnerName = (TextView) itemView.findViewById(R.id.learner_name);
            mLearnerDescription = (TextView) itemView.findViewById(R.id.learner_description);

        }
    }
}
