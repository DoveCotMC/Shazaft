package team.dovecotmc.shazaft.config;

import com.google.gson.annotations.SerializedName;

public class ShazaftConfig {
    @SerializedName("centered")
    public boolean centered = false;
    @SerializedName("height_coefficient_screen_height")
    public double height_coefficient_screen_height = 1.0;
    @SerializedName("height_constant")
    public int height_constant = -15;
    @SerializedName("width_coefficient_screen_width")
    public double width_coefficient_screen_width = 0.0;
    @SerializedName("width_constant")
    public int width_constant = 5;
}
