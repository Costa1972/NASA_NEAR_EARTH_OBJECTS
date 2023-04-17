package ru.costa.nasa_near_earth_objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Rover {

    private int id;
    private String name;
    private String landing_date;
    private String launch_date;
    private String status;


    @Override
    public String toString() {
        return "Rover\n{" +
                "\nid=" + id +
                ", \nname='" + name + '\'' +
                ", \nlanding_date='" + landing_date + '\'' +
                ", \nlaunch_date='" + launch_date + '\'' +
                ", \nstatus='" + status + '\'' +
                "\n}";
    }
}
