package com.chivorn.resourcemodule;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.chivorn.smartmaterialspinner.SmartMaterialSpinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainApp<T> extends AppCompatActivity implements View.OnClickListener {
    private final String repoUrl = "https://github.com/Chivorns/SmartMaterialSpinner";

    protected SmartMaterialSpinner<String> spSearchable;
    protected SmartMaterialSpinner<String> spProvince;
    protected SmartMaterialSpinner<String> spProvinceNoHint;
    protected SmartMaterialSpinner<String> spProvinceDialog;
    protected SmartMaterialSpinner<String> spCustomColor;
    protected SmartMaterialSpinner<String> spEmptyItem;

    private LinearLayout githubRepo;
    private Button btnShowError;
    private Button btnGotoRuntimeRender;
    private Button githubRepoBtn;
    protected Intent intent;

    protected List<String> provinceList;
    protected List<String> countryList;

    public void initBaseView() {
        spSearchable = findViewById(R.id.sp_searchable);
        spProvince = findViewById(R.id.sp_provinces);
        spProvinceNoHint = findViewById(R.id.sp_provinces_no_hint);
        spProvinceDialog = findViewById(R.id.sp_provinces_dialog);
        spCustomColor = findViewById(R.id.sp_custom_color);
        spEmptyItem = findViewById(R.id.sp_empty_item);
        githubRepo = findViewById(R.id.git_repo_container);
        btnShowError = findViewById(R.id.btn_show_error);
        btnGotoRuntimeRender = findViewById(R.id.btn_goto_runtime_render);
        githubRepoBtn = findViewById(R.id.github_repo_btn);
    }

    public void initItemList() {
        provinceList = new ArrayList<>();
        countryList = new ArrayList<>();

        provinceList.add("Banteay Meanchey");
        provinceList.add("Battambang");
        provinceList.add("Kampong Cham");
        provinceList.add("Kampong Chhnang");
        provinceList.add("Kampong Speu");
        provinceList.add("Kampong Thom");
        provinceList.add("Kampot");
        provinceList.add("Kandal");
        provinceList.add("Kep");
        provinceList.add("Koh Kong");
        provinceList.add("Kratie");
        provinceList.add("Mondulkiri");
        provinceList.add("Oddar Meanchey");
        provinceList.add("Pailin");
        provinceList.add("Phnom Penh");
        provinceList.add("Preah Vihear");
        provinceList.add("Prey Veng");
        provinceList.add("Pursat");
        provinceList.add("Ratanakiri");
        provinceList.add("Siem Reap");
        provinceList.add("Sihanoukville");
        provinceList.add("Stung Treng");
        provinceList.add("Svay Rieng");
        provinceList.add("Takeo");
        provinceList.add("Tbong Khmum");
        provinceList.add("The best Android spinner library for your android application with more customization");


        String[] isoCountryCodes = Locale.getISOCountries();
        for (String countryCode : isoCountryCodes) {
            Locale locale = new Locale("", countryCode);
            String countryName = locale.getDisplayCountry();
            countryList.add(countryName);
        }
    }

    public void onClickListener() {
        if (githubRepo != null && githubRepoBtn != null) {
            githubRepo.setOnClickListener(this);
            githubRepoBtn.setOnClickListener(this);
        }

        if (btnShowError != null) {
            btnShowError.setOnClickListener(this);
        }

        if (btnGotoRuntimeRender != null) {
            btnGotoRuntimeRender.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.git_repo_container || v.getId() == R.id.github_repo_btn) {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(repoUrl));
            startActivity(intent);
        } else if (v.getId() == R.id.btn_show_error) {
            spSearchable.setErrorText(getResources().getString(R.string.sample_error_message));
            spProvince.setErrorText(getResources().getString(R.string.sample_error_message));
            spProvinceNoHint.setErrorText(getResources().getString(R.string.sample_error_message));
            spProvinceDialog.setErrorText(getResources().getString(R.string.sample_error_message));
            spCustomColor.setErrorText(getResources().getString(R.string.sample_error_message));
        }
    }
}
