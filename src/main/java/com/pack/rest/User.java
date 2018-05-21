package com.pack.rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.logging.Level;
import java.util.logging.Logger;

class User {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("password")
    @Expose
    public String password;
    @SerializedName("role")
    @Expose
    public String role;

   /**
    * Konstruktor
    * @param name uzivatelske meno
    * @param password uzivatelske heslo
    * @param role uzivatelske prava
    */

   public User(String name, String password, String role){
      this.name = name;
      this.password= password;
      this.role = role;
   }

   /**
    * Metoda, ktora vykona POST poziadavku na server s uzivatelskymi datami pre
    * pridanie Usera
    * @param service - service
    */
    public void addUser(PollsService service) {
       service.postNewUser(this).enqueue(new Callback<User>() {
          public void onResponse(Call<User> call, Response<User> response) {
             Logger.getGlobal().log(Level.INFO, "" + response.code());
             if(response.code() == 200) {
                 Logger.getGlobal().log(Level.INFO, response.body().toString());
             }
          }
          public void onFailure(Call<User> call, Throwable throwable) {
             throw new UnsupportedOperationException("Error POST new User!");
          }
       });
    }

   public void getAllUsers(PollsService service){

   }

   @Override
   public String toString() {
      return new ToStringBuilder(this).append("name", name).append("password", password).append("role", role).toString();
   }
}
