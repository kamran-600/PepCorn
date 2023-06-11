package com.example.pepcorn;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.pepcorn.databinding.ActivityMainBinding;
import com.example.pepcorn.retrofitHelper.APIDataModal;
import com.example.pepcorn.retrofitHelper.ApiFetch;
import com.example.pepcorn.retrofitHelper.RetrofitClient;
import com.faltenreich.skeletonlayout.Skeleton;
import com.faltenreich.skeletonlayout.SkeletonLayoutUtils;
import com.google.android.material.divider.MaterialDividerItemDecoration;
import com.google.firebase.auth.FirebaseAuth;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();

        Menu menu = binding.topAppBar.getMenu();
        MenuItem logout = menu.findItem(R.id.logout);

        // LogOut

        binding.topAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.equals(logout)){
                    mAuth.signOut();
                    Toast.makeText(MainActivity.this, "Log Out", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finishAffinity();
                }
                return true;
            }
        });


        ApiFetch apiFetch = RetrofitClient.getInstance().getApi();
        Call<APIDataModal> repo = apiFetch.getApiData();

        // show shimmer
        Skeleton skeleton = SkeletonLayoutUtils.applySkeleton(binding.recyclerView, R.layout.single_row_finance, 10);
        skeleton.showSkeleton();

        // process the get request
        repo.enqueue(new Callback<APIDataModal>() {
            @Override
            public void onResponse(@NonNull Call<APIDataModal> call, @NonNull Response<APIDataModal> response) {

                skeleton.showOriginal();

                if(response.body() != null) {

                    APIDataModal apiDataModal = response.body();

                    MyAdapter adapter = new MyAdapter( apiDataModal.getMeta());
                    adapter.submitList(apiDataModal.getData());
                    binding.recyclerView.setHasFixedSize(true);
                    binding.recyclerView.setAdapter(adapter);
                    binding.recyclerView.addItemDecoration(new MaterialDividerItemDecoration(MainActivity.this, MaterialDividerItemDecoration.VERTICAL));
                    adapter.notifyDataSetChanged();

                }
                else Toast.makeText(MainActivity.this, response.message(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(@NonNull Call<APIDataModal> call, @NonNull Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage()+"\nCheck Internet Collection ?", Toast.LENGTH_SHORT).show();
            }
        });
    }
}