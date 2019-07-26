package com.xtruong.petapp.data.network;

import com.xtruong.petapp.data.network.model.contact.Contact;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by truongtx on 7/26/2019
 */
public interface ApiContactService {
    @GET("contacts.php")
    Single<List<Contact>> getContacts(@Query("source") String source, @Query("search") String query);
}

