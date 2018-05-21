package com.pack.rest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.xml.ws.Service;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.apache.commons.lang3.RandomUtils.nextInt;

/**
 * Matus&Pato!
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PollsService service = retrofit.create(PollsService.class);

        User user1 = new User("mato", "123456", "ADMIN");
        user1.addUser(service);

        Device device = new Device("arduino", "198.168.0.10");
        device.sendDevice(service);

        Sensor sensor = new Sensor("temp-sensor", "arduino");
        while(true){
            int randomNum = nextInt(0, 30 + 1);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            sensor.sendData(service ,dateFormat.format(date), String.valueOf(randomNum));
            Thread.sleep(5000);
        }


    }
}
