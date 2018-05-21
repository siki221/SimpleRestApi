package com.pack.rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.logging.Level;
import java.util.logging.Logger;

class Sensor {

    /**
     * Informacie o senzore
     */
    @SerializedName("info")
    @Expose
    private String info = "";
    /**
     * Zariadenie, ku ktoremu je senzor pripojeny
     */
    @SerializedName("device")
    @Expose
    private String device = "";
    /**
     * Datum
     */
    @SerializedName("date")
    @Expose
    private String date = "";
    /**
     * Data
     */
    @SerializedName("data")
    @Expose
    private String data = "";

    /**
     * @param info info informacie o senzore
     * @param device device zariadenie, ku ktoremu senzor patri
     */
    public Sensor(String info, String device) {
        this.info = info;
        this.device = device;
    }


    /**
     * Metoda, ktora vykona POST poziadavku na server s pridanim dat
     * @param service - service
     */
    public void sendData(PollsService service, String date, String data){
        Sensor sensor = new Sensor(this.info, this.device);
        sensor.data = data;
        sensor.date = date;
        service.postNewData(sensor).enqueue(new Callback<Sensor>() {
            public void onResponse(Call<Sensor> call, Response<Sensor> response) {
                Logger.getGlobal().log(Level.INFO, "" + response.code());
                if(response.code() == 200) {
                    Logger.getGlobal().log(Level.INFO, response.body().toString());
                }
            }
            public void onFailure(Call<Sensor> call, Throwable throwable) {
                throw new UnsupportedOperationException("Error POST new Data!");
            }
        });
    }

}