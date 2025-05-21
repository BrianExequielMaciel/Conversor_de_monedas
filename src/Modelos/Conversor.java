package Modelos;

import com.google.gson.annotations.SerializedName;

public record Conversor(@SerializedName("time_last_update_utc") String time_last_update_utc ,
                       @SerializedName("base_code") String base_code,
                       @SerializedName("result") String result,
                        @SerializedName("conversion_rates") Monedas monedas) {
}

