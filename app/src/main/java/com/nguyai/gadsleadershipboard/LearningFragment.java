package com.nguyai.gadsleadershipboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nguyai.gadsleadershipboard.models.Learner;
import com.nguyai.gadsleadershipboard.services.LearningHoursService;
import com.nguyai.gadsleadershipboard.services.ServiceBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LearningFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LearningFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "Learning Fragment";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LearningFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LearningFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LearningFragment newInstance(String param1, String param2) {
        LearningFragment fragment = new LearningFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        Log.d(TAG, "onCreate: learning created");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_learning, container, false);
        final RecyclerView learningRecyclerView = view.findViewById(R.id.learning_recycler_view);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        learningRecyclerView.setLayoutManager(layoutManager);

        LearningHoursService learningService = ServiceBuilder.buildService(LearningHoursService.class);
        Call<List<Learner>> request = learningService.getLearningHours();

        request.enqueue(new Callback<List<Learner>>() {
            @Override
            public void onResponse(Call<List<Learner>> request, Response<List<Learner>> response) {
                Log.d(TAG, "onBindViewHolder: "+response.body().size());
                learningRecyclerView.setAdapter(new LearningRecyclerAdapter(getContext(),response.body()));
            }

            @Override
            public void onFailure(Call<List<Learner>> request, Throwable t) {

            }
        });
        return  view;
    }
}