package com.pack.rest;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.*;

public interface PollsService {
    @GET("/api/users?page=id")
    Call<UsersPage> getUserPage(@Query("id") Integer id); //@Query("id") Integer id

    @GET("/api/users/{id}")
    Call<User> getUser(@Path("id") Integer id);

    @GET("/api/unknown")
    Call<UnknowPage> getUnknowPage();

    @GET("/api/unknown/{id}")
    Call<Unknow> getUnknowData(@Path("id") Integer id);

    @POST("/api/users")
    Call<NewUser> postNewUser(@Body NewUser newuser);

    @PUT("/api/users/2")
    Call<NewUser> putNewUser(@Body NewUser newuser);

    @PATCH("/api/users/2")
    Call<NewUser> patchNewUser(@Body NewUser newuser);

    @DELETE("/api/users/2")
    Call<NewUser> DeleteUser();
}
