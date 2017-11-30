package fabricadeprogramador.com.br.retrofitbasic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


import fabricadeprogramador.com.br.retrofitbasic.model.Pessoa;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String URL = "http://192.168.25.53:8080";

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv_1);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        final PessoaAPI pessoaAPI = retrofit.create(PessoaAPI.class);

        //Chamada GET buscarPorId
        ///////////////////////////////////////////////////////////
        Call<Pessoa> call = pessoaAPI.getPessoa(1);

        call.enqueue(new Callback<Pessoa>() {
            @Override
            public void onResponse(Call<Pessoa> call, Response<Pessoa> response) {
                Pessoa pessoaEncontrada = response.body();

                if(pessoaEncontrada != null){
                    tv.setText(pessoaEncontrada.getNome());
                }
            }

            @Override
            public void onFailure(Call<Pessoa> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Não funcionou GET", Toast.LENGTH_SHORT).show();
            }
        });

        //Chamada POST cadastrar
        ///////////////////////////////////////////////////////////
        Pessoa pessoa = new Pessoa("Marcelo Oliveira");
        Call<Pessoa> call2 = pessoaAPI.cadastrar(pessoa);

       call2.enqueue(new Callback<Pessoa>() {
           @Override
           public void onResponse(Call<Pessoa> call, Response<Pessoa> response) {
               Toast.makeText(MainActivity.this, "Cadastrou!", Toast.LENGTH_SHORT).show();
           }

           @Override
           public void onFailure(Call<Pessoa> call, Throwable t) {
               Toast.makeText(MainActivity.this, "Não funcionou POST", Toast.LENGTH_SHORT).show();
           }
       });
    }
}
