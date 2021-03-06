package com.soufianekre.smallhub.data.network.service;

import androidx.annotation.NonNull;

import com.soufianekre.smallhub.data.network.model.Pageable;
import com.soufianekre.smallhub.data.network.model.Repo;
import com.soufianekre.smallhub.data.network.model.User;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface UserRestService {

    @GET("users/{username}")
    Observable<User> getUser(@Path("username") @NonNull String username);

    @GET("users/{username}/repos")
    Observable<Pageable<Repo>> getRepos(@Path("username") @NonNull String username, @QueryMap(encoded = true) Map<String, String> filterParams,
                                        @Query("page") int page);

    @GET("user/repos")
    Observable<Pageable<Repo>> getRepos(@QueryMap(encoded = true) Map<String, String> filterParams, @Query(value = "page") int page);

    @GET("users/{username}/starred") Observable<Pageable<Repo>>
    getStarred(@Path("username") @NonNull String username, @Query("page") int page);

    @GET("users/{username}/starred?per_page=1") Observable<Pageable<Repo>>
    getStarredCount(@Path("username") @NonNull String username);

    @GET("users/{username}/following")
    Observable<Pageable<User>> getFollowing(@Path("username") @NonNull String username, @Query("page") int page);

    @GET("users/{username}/followers")
    Observable<Pageable<User>> getFollowers(@Path("username") @NonNull String username, @Query("page") int page);

    @GET("user/following/{username}")
    Observable<Response<Boolean>> getFollowStatus(@Path("username") @NonNull String username);

    @PUT("user/following/{username}")
    Observable<Response<Boolean>> followUser(@Path("username") @NonNull String username);

    @DELETE("user/following/{username}")
    Observable<Response<Boolean>> unfollowUser(@Path("username") @NonNull String username);

    @GET Observable<String> getContributions(@Url String url);

    @GET("user/blocks/{username}")
    @Headers("Accept: application/vnd.github.giant-sentry-fist-preview+json")
    Observable<Response<Boolean>> isUserBlocked(@Path("username") @NonNull String username);

    @PUT("user/blocks/{username}")
    @Headers("Accept: application/vnd.github.giant-sentry-fist-preview+json")
    Observable<Response<Boolean>> blockUser(@Path("username") @NonNull String username);

    @DELETE("user/blocks/{username}")
    @Headers("Accept: application/vnd.github.giant-sentry-fist-preview+json")
    Observable<Response<Boolean>> unBlockUser(@Path("username") @NonNull String username);
}
