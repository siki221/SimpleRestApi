package com.pack.rest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.xml.ws.Service;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Matus Bodorik!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://private-fb2f0c-pools7.apiary-mock.com")
                //.baseUrl("https://reqres.in")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PollsService service = retrofit.create(PollsService.class);


        //List of users page
        service.getUserPage(2).enqueue(new Callback<UsersPage>() {
            public void onResponse(Call<UsersPage> call, Response<UsersPage> response) {
                Logger.getGlobal().log(Level.INFO, "" + response.code());
                Logger.getGlobal().log(Level.INFO, response.body().toString());

            }

            public void onFailure(Call<UsersPage> call, Throwable throwable) {
                Logger.getGlobal().log(Level.INFO,  throwable.getMessage().toString());
                throw new UnsupportedOperationException("Error GET UsersPage!");
            }
        });

        //Single user
        service.getUser(2).enqueue(new Callback<User>() {
            public void onResponse(Call<User> call, Response<User> response) {
                Logger.getGlobal().log(Level.INFO, "" + response.code());
                Logger.getGlobal().log(Level.INFO, response.body().toString());
            }

            public void onFailure(Call<User> call, Throwable throwable) {
                Logger.getGlobal().log(Level.INFO,  throwable.getMessage().toString());
                throw new UnsupportedOperationException("Error GET User!");
            }
        });

        //User is not exist
        service.getUser(23).enqueue(new Callback<User>() {
            public void onResponse(Call<User> call, Response<User> response) {
                Logger.getGlobal().log(Level.INFO, "" + response.code());
                if (response.code() == 404){Logger.getGlobal().log(Level.INFO, "User Not found");}
            }

            public void onFailure(Call<User> call, Throwable throwable) {
                Logger.getGlobal().log(Level.INFO,  throwable.getMessage().toString());
                throw new UnsupportedOperationException("Error GET User!");
            }
        });

        //Call Unknow page
        service.getUnknowPage().enqueue(new Callback<UnknowPage>() {
            public void onResponse(Call<UnknowPage> call, Response<UnknowPage> response) {
                Logger.getGlobal().log(Level.INFO, "" + response.code());
                Logger.getGlobal().log(Level.INFO, response.body().toString());
            }

            public void onFailure(Call<UnknowPage> call, Throwable throwable) {
                throw new UnsupportedOperationException("Error GET Unknow page!");
            }
        });

        //Call single object from Unkonw page
        service.getUnknowData(2).enqueue(new Callback<Unknow>() {
            public void onResponse(Call<Unknow> call, Response<Unknow> response) {
                Logger.getGlobal().log(Level.INFO, "" + response.code());
                Logger.getGlobal().log(Level.INFO, response.body().toString());
            }

            public void onFailure(Call<Unknow> call, Throwable throwable) {
                throw new UnsupportedOperationException("Error GET Unknow Object!");
            }
        });

        service.getUnknowData(23).enqueue(new Callback<Unknow>() {
            public void onResponse(Call<Unknow> call, Response<Unknow> response) {
                Logger.getGlobal().log(Level.INFO, "" + response.code());
                if (response.code() == 404){Logger.getGlobal().log(Level.INFO, "Unknow object Not found");}
            }

            public void onFailure(Call<Unknow> call, Throwable throwable) {
                throw new UnsupportedOperationException("Error GET Unknow Object!");
            }
        });

        NewUser user = new NewUser();
        user.name = "morpheus";
        user.job = "leader";
        service.postNewUser(user).enqueue(new Callback<NewUser>() {
            public void onResponse(Call<NewUser> call, Response<NewUser> response) {
                Logger.getGlobal().log(Level.INFO, "" + response.code());
                Logger.getGlobal().log(Level.INFO, response.body().toString());
            }

            public void onFailure(Call<NewUser> call, Throwable throwable) {
                throw new UnsupportedOperationException("Error POST new User!");
            }
        });


        NewUser user2 = new NewUser();
        user.name = "morpheus";
        user.job = "zion resident";
        service.putNewUser(user2).enqueue(new Callback<NewUser>() {
            public void onResponse(Call<NewUser> call, Response<NewUser> response) {
                Logger.getGlobal().log(Level.INFO, "" + response.code());
                Logger.getGlobal().log(Level.INFO, response.body().toString());
            }

            public void onFailure(Call<NewUser> call, Throwable throwable) {
                throw new UnsupportedOperationException("Error PUT new User!");
            }
        });

        NewUser user3 = new NewUser();
        user.name = "morpheus";
        user.job = "zion resident";
        service.patchNewUser(user3).enqueue(new Callback<NewUser>() {
            public void onResponse(Call<NewUser> call, Response<NewUser> response) {
                    Logger.getGlobal().log(Level.INFO, "" + response.code());
                    Logger.getGlobal().log(Level.INFO, response.body().toString());
            }

            public void onFailure(Call<NewUser> call, Throwable throwable) {
                throw new UnsupportedOperationException("Error PATCH new User!");
            }
        });

        service.DeleteUser().enqueue(new Callback<NewUser>() {
            public void onResponse(Call<NewUser> call, Response<NewUser> response) {
                if (response.code() == 204) {
                    Logger.getGlobal().log(Level.INFO, "" + response.code());
                    Logger.getGlobal().log(Level.INFO, "DELETE was Successfull" );
                }
            }

            public void onFailure(Call<NewUser> call, Throwable throwable) {
                throw new UnsupportedOperationException("Error DELETE new User!");
            }
        });
    }
}
