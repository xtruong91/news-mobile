package com.xtruong.petapp.data.network;

import com.xtruong.petapp.data.network.model.flightticket.Price;
import com.xtruong.petapp.data.network.model.flightticket.Ticket;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by truongtx on 7/26/2019
 */
public interface ApiFlightService {
    @GET("airline-tickets.php")
    Single<List<Ticket>> searchTickets(@Query("from") String from, @Query("to") String to);

    @GET("airline-tickets-price.php")
    Single<Price> getPrice(@Query("flight_number") String flightNumber, @Query("from") String from, @Query("to") String to);
}
