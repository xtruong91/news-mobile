package com.xtruong.petapp.data.network;

import com.xtruong.petapp.data.network.model.notes.Note;
import com.xtruong.petapp.data.network.model.notes.User;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by truongtx on 7/26/2019
 * /notes/user/register	POST	`device_id` – Unique identifier of the device
 * /notes/all	GET	NONE
 * /notes/new	POST	`note` – Notetbl text
 * /notes/{id}	PUT	`id` – Id of the note to be updated
 * (Replace the {id} with actual value in the URL)
 * /notes/{id}	DELETE	`id` – Id of the note to be deleted
 */
public interface ApiNoteService {
    // Register new user
    @FormUrlEncoded
    @POST("notes/user/register")
    Single<User> register(@Field("device_id") String deviceId);

    // Create note
    @FormUrlEncoded
    @POST("notes/new")
    Single<Note> createNote(@Field("note") String note);

    // Fetch all notes
    @GET("notes/all")
    Single<List<Note>> fetchAllNotes();

    // Update single note
    @FormUrlEncoded
    @PUT("notes/{id}")
    Completable updateNote(@Path("id") int noteId, @Field("note") String note);

    // Delete note
    @DELETE("notes/{id}")
    Completable deleteNote(@Path("id") int noteId);
}
