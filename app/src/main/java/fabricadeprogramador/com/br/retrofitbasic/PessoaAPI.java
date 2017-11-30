package fabricadeprogramador.com.br.retrofitbasic;

import java.util.List;

import fabricadeprogramador.com.br.retrofitbasic.model.Pessoa;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by viniciuspodi on 30/11/17.
 */

public interface PessoaAPI {

    @GET("/pessoas/{id}")
    Call<Pessoa> getPessoa(@Path("id") Integer id);

    @GET("/pessoas")
    Call<List<Pessoa>> buscarTodos();

    @POST("/pessoas")
    Call<Pessoa> cadastrar(@Body Pessoa pessoa);

}
