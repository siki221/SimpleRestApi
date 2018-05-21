package com.pack.rest;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.*;

public interface PollsService {
    @POST("/user")
    Call<User> postNewUser(@Body User user);

    @GET("/user")
    Call<User> getUsers();

    @POST("/data")
    Call<Sensor> postNewData(@Body Sensor sensor);

    @POST("/device")
    Call<Device> postNewDevice(@Body Device device);

//    @GET("/api/users/{id}")
//    Call<User> getUser(@Path("id") Integer id);
//
//    @GET("/api/unknown")
//    Call<UnknowPage> getUnknowPage();
//
//    @GET("/api/unknown/{id}")
//    Call<Unknow> getUnknowData(@Path("id") Integer id);
//
//    @POST("/user")
//    Call<NewUser> postNewUser(@Body NewUser newuser);
//
//    @PUT("/api/users/2")
//    Call<NewUser> putNewUser(@Body NewUser newuser);
//
//    @PATCH("/api/users/2")
//    Call<NewUser> patchNewUser(@Body NewUser newuser);
//
//    @DELETE("/api/users/2")
//    Call<NewUser> DeleteUser();
}
