package com.pack.rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Device {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("ip")
    @Expose
    public String ip;

    /**
     * Konstruktor
     *
     * @param name nazov zariadenia
     * @param ip ip zariadenia
     */
    public Device(String name, String ip){
        this.name = name;
        this.ip = ip;
    }

    /**
     * Metoda na odoslanie POST poziadavky na server. Pridanie noveho zariadenia
     *
     */
    public void sendDevice(PollsService service) {
        service.postNewDevice(this).enqueue(new Callback<Device>() {
            public void onResponse(Call<Device> call, Response<Device> response) {
                Logger.getGlobal().log(Level.INFO, "" + response.code());
                if(response.code() == 200) {
                    Logger.getGlobal().log(Level.INFO, response.body().toString());
                }
            }
            public void onFailure(Call<Device> call, Throwable throwable) {
                throw new UnsupportedOperationException("Error POST new Device!");
            }
        });
    }

    @Override
    public String toString() {
        return "Device{" +
                "name='" + name + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
