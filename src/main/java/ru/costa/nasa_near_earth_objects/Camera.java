package ru.costa.nasa_near_earth_objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Camera {
    private int id;
    private String name;
    private int rover_id;
    private String full_name;

    @Override
    public String toString() {
        return "Camera\n{" +
                "\nid=" + id +
                ", \nname='" + name + '\'' +
                ", \nrover_id=" + rover_id +
                ", \nfull_name='" + full_name + '\'' +
                "\n}";
    }
}
