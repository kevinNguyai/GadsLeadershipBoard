package com.nguyai.gadsleadershipboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.nguyai.gadsleadershipboard.models.Learner;
import com.nguyai.gadsleadershipboard.models.SkillsIQLeader;
import com.nguyai.gadsleadershipboard.services.LearningHoursService;
import com.nguyai.gadsleadershipboard.services.ServiceBuilder;
import com.nguyai.gadsleadershipboard.services.SkillsIQService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SkillsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SkillsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "Skills Fragment";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SkillsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SkillsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SkillsFragment newInstance(String param1, String param2) {
        SkillsFragment fragment = new SkillsFragment();
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
        Log.d(TAG, "onCreate: Skills created");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_skills, container, false);
        final RecyclerView skillsRecyclerView = view.findViewById(R.id.skills_recycler_view);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        skillsRecyclerView.setLayoutManager(layoutManager);

        SkillsIQService skillsService = ServiceBuilder.buildService(SkillsIQService.class);
        Call<List<SkillsIQLeader>> request = skillsService.getIQScores();

        final ProgressBar spinnerSkills = view.findViewById(R.id.skills_loader);
        spinnerSkills.setVisibility(View.VISIBLE);

        request.enqueue(new Callback<List<SkillsIQLeader>>() {
            @Override
            public void onResponse(Call<List<SkillsIQLeader>> request, Response<List<SkillsIQLeader>> response) {
                skillsRecyclerView.setAdapter(new SkillsRecyclerAdapter(getContext(),response.body()));
                spinnerSkills.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<SkillsIQLeader>> request, Throwable t) {
                spinnerSkills.setVisibility(View.GONE);
            }
        });
        return view;
    }
}