package br.com.lucasagw.mobile.rv.api;

import java.util.List;

import br.com.lucasagw.mobile.rv.model.Tarefa;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {

    @GET("users/{user}/followers")
    Call<List<Tarefa>> listFollowers(@Path("user") String user);

    static GitHubService create() {
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create()) //converte gson para objeto
                .build().create(GitHubService.class);
    }
}
