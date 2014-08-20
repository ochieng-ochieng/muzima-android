/*
 * Copyright (c) 2014. The Trustees of Indiana University.
 *
 * This version of the code is licensed under the MPL 2.0 Open Source license with additional
 * healthcare disclaimer. If the user is an entity intending to commercialize any application
 * that uses this code in a for-profit venture, please contact the copyright holder.
 */

package com.muzima.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.muzima.R;

public class HelpActivity extends BaseActivity {

    public static final String HELP_TYPE = "HELP_TYPE";
    public static final int COHORT_WIZARD_HELP = 1;
    public static final int COHORT_PREFIX_HELP = 2;
    public static final int CUSTOM_CONCEPT_HELP = 3;
    public static final String MUZIMA_INITAL_SETUP_GUIDE = "file:///android_asset/help-content/mUzima_initial_setup.html";
    public static final String PATIENT_FILLING_FORM = "file:///android_asset/help-content/filling-forms-for-a-patient.html";
    public static final String MUZIMA_USER_GUIDE = "file:///android_asset/help-content/mUzima-user-guide.html";
    public static final String MUZIMA_TRAINING_MANUAL = "file:///android_asset/help-content/mUzima-training-manual.html";
    public static final String INTRODUCTION_VIDEO = "https://www.youtube.com/watch?v=xnFACOHGzKg";
    public static final String SETTING_UP_MUZIMA_VIDEO = "https://www.youtube.com/watch?v=nn7k1TL1qG0&feature=youtu.be";
    public static final String TAGGING_FORMS_VIDEO = "https://www.youtube.com/watch?v=Ls4qpSYRep8&feature=youtu.be";
    public static final String DOWNLOADING_COHORTS_VIDEO = "https://www.youtube.com/watch?v=uvVT9tRpCxY&feature=youtu.be";
    public static final String CHANGE_SETTING_VIDEO = "https://www.youtube.com/watch?v=4VtkXUEP11k&feature=youtu.be";
    public static final String DOWNLOADING_FORMS_VIDEO = "https://www.youtube.com/watch?v=8uNCq1EK8V8&feature=youtu.be";
    private TextView helpContentView;
    private View scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        setHelpContent();
    }

    private void setHelpContent() {
        helpContentView = (TextView) findViewById(R.id.helpContent);
        scrollView = findViewById(R.id.helpInfoMenu);
        int helpType = getIntent().getIntExtra(HELP_TYPE, 0);
        switch (helpType) {
            case COHORT_WIZARD_HELP:
                showHelpContentView();
                helpContentView.setText(getResources().getText(R.string.cohort_wizard_help));
                setTitle(R.string.cohort_wizard_help_title);
                break;
            case COHORT_PREFIX_HELP:
                showHelpContentView();
                helpContentView.setText(getResources().getText(R.string.cohort_prefix_help));
                setTitle(R.string.cohort_prefix_help_title);
                break;
            case CUSTOM_CONCEPT_HELP:
                showHelpContentView();
                helpContentView.setText(getResources().getText(R.string.custom_concept_help));
                setTitle(R.string.custom_concept_help_title);
                break;
            default:
                helpContentView.setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);
                setTitle(R.string.title_activity_help);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.help, menu);
        super.onCreateOptionsMenu(menu);
        removeHelpMenu(menu);
        return true;
    }

    public void viewPatientFormFillingHelpContent(View view) {
        startHelpContentDisplayActivity(PATIENT_FILLING_FORM,getText(R.string.filling_patient_forms_help).toString());
    }

    public void viewMuzimaInitialSetupGuide(View view) {
        startHelpContentDisplayActivity(MUZIMA_INITAL_SETUP_GUIDE,getText(R.string.muzima_initial_setup_guide).toString());
    }

    public void viewMuzimaUserGuide(View view) {
        startHelpContentDisplayActivity(MUZIMA_USER_GUIDE,getText(R.string.muzima_user_guide).toString());
    }

    public void viewMuzimaTrainingManual(View view) {
        startHelpContentDisplayActivity(MUZIMA_TRAINING_MANUAL,getText(R.string.muzima_training_manual).toString());
    }

    public void viewIntroductionVideo(View view) {
        Intent introductionVideo = new Intent(Intent.ACTION_VIEW);
        introductionVideo.setData(Uri.parse(INTRODUCTION_VIDEO));
        startActivity(introductionVideo);
    }

    private void startHelpContentDisplayActivity(String filePath, String title) {
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra(WebViewActivity.HELP_FILE_PATH_PARAM, filePath);
        intent.putExtra(WebViewActivity.HELP_TITLE,title);
        startActivity(intent);
    }

    private void showHelpContentView() {
        helpContentView.setVisibility(View.VISIBLE);
        scrollView.setVisibility(View.GONE);
    }

    private void removeHelpMenu(Menu menu) {
        MenuItem menuSettings = menu.findItem(R.id.action_help);
        menuSettings.setVisible(false);
    }

    public void viewSettingUpMuzimaVideo(View view) {
        Intent settingUpMuzimaVideo = new Intent(Intent.ACTION_VIEW);
        settingUpMuzimaVideo.setData(Uri.parse(SETTING_UP_MUZIMA_VIDEO));
        startActivity(settingUpMuzimaVideo);
    }

    public void viewTaggingFormsVideo(View view) {
        Intent taggingFormsVideo = new Intent(Intent.ACTION_VIEW);
        taggingFormsVideo.setData(Uri.parse(TAGGING_FORMS_VIDEO));
        startActivity(taggingFormsVideo);
    }

    public void viewDownloadingCohortsVideo(View view) {
        Intent downloadingCohortsVideo = new Intent(Intent.ACTION_VIEW);
        downloadingCohortsVideo.setData(Uri.parse(DOWNLOADING_COHORTS_VIDEO));
        startActivity(downloadingCohortsVideo);
    }

    public void viewChangeSettingsVideo(View view) {
        Intent changeSettingsVideo = new Intent(Intent.ACTION_VIEW);
        changeSettingsVideo.setData(Uri.parse(CHANGE_SETTING_VIDEO));
        startActivity(changeSettingsVideo);
    }

    public void viewDownloadingFormsVideo(View view) {
        Intent downloadingFormsVideo = new Intent(Intent.ACTION_VIEW);
        downloadingFormsVideo.setData(Uri.parse(DOWNLOADING_FORMS_VIDEO));
        startActivity(downloadingFormsVideo);
    }
}
