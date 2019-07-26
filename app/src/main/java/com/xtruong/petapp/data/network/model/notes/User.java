package com.xtruong.petapp.data.network.model.notes;

import com.google.gson.annotations.SerializedName;
import com.xtruong.petapp.data.network.model.BaseResponse;

/**
 * Created by truongtx on 7/26/2019
 */
public class User extends BaseResponse {

    @SerializedName("api_key")
    String apiKey;

    public String getApiKey() {
        return apiKey;
    }
}
