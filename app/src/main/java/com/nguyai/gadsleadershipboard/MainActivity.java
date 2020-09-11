package com.nguyai.gadsleadershipboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int LEARNING_LEADERS = 0;
    public static final int SKILLS_LEADERS = 1;
    private SkillsFragment mSkillsFragment;
    private LearningFragment mLearningFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PagerAdapter fragmentsPagerAdapter = new PagerAdapter(getSupportFragmentManager());

        mLearningFragment = new LearningFragment();
        mSkillsFragment = new SkillsFragment();
        fragmentsPagerAdapter.addFragment(mLearningFragment);
        fragmentsPagerAdapter.addFragment(mSkillsFragment);

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(fragmentsPagerAdapter);

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        tabs.getTabAt(LEARNING_LEADERS).setText(getString(R.string.learning_title));
        tabs.getTabAt(SKILLS_LEADERS).setText(getString(R.string.skills_title));

        Button mSubmitApplication = (Button) findViewById(R.id.submit_application);
        mSubmitApplication.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.submit_application:
                startActivity(new Intent(this, SubmissionActivity.class));
                break;
        }
    }
}