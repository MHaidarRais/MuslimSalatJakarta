package com.rais.haidar.muslimsalatjakarta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.rais.haidar.muslimsalatjakarta.ApiRetrofit.ApiService;
import com.rais.haidar.muslimsalatjakarta.ApiRetrofit.InstanceRetrofit;
import com.rais.haidar.muslimsalatjakarta.ResponseServer.ItemsItem;
import com.rais.haidar.muslimsalatjakarta.ResponseServer.Response;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tvState)
    TextView tvState;
    @BindView(R.id.tvCountry)
    TextView tvCountry;
    @BindView(R.id.tvClock)
    TextView tvClock;
    @BindView(R.id.tvShubuh)
    TextView tvShubuh;
    @BindView(R.id.tvShuruq)
    TextView tvShuruq;
    @BindView(R.id.tvDzuhur)
    TextView tvDzuhur;
    @BindView(R.id.tvAshar)
    TextView tvAshar;
    @BindView(R.id.tvMaghrib)
    TextView tvMaghrib;
    @BindView(R.id.tvIsya)
    TextView tvIsya;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getData();


    }

    private void getData() {
        ApiService api = InstanceRetrofit.getInstance();
        Call<Response> call = api.readJadwalSholat();
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                Toast.makeText(MainActivity.this, ""+response.body().getTitle(), Toast.LENGTH_SHORT).show();
                if (response.body().getStatusCode() == 1) {
                    tvCountry.setText(response.body().getCountry());
                    tvState.setText(response.body().getState());

                    List<ItemsItem> jadwalSholat = response.body().getItems();
                    tvClock.setText(jadwalSholat.get(0).getDateFor());
                    tvShubuh.setText(jadwalSholat.get(0).getFajr());
                    tvShuruq.setText(jadwalSholat.get(0).getShurooq());
                    tvDzuhur.setText(jadwalSholat.get(0).getDhuhr());
                    tvAshar.setText(jadwalSholat.get(0).getAsr());
                    tvMaghrib.setText(jadwalSholat.get(0).getMaghrib());
                    tvIsya.setText(jadwalSholat.get(0).getIsha());
                }

            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Toast.makeText(MainActivity.this, "abc"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
