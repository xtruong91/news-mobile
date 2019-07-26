package com.xtruong.petapp.data.network.model.notes;

import com.xtruong.petapp.data.network.model.BaseResponse;

/**
 * Created by truongtx on 7/26/2019
 */
public class Note  extends BaseResponse {
    int id;
    String note;
    String timestamp;

    public int getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTimestamp() {
        return timestamp;
    }

}
