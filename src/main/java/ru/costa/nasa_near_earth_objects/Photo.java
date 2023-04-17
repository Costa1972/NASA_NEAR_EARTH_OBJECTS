package ru.costa.nasa_near_earth_objects;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Photo {

    private int id;
    private int sol;
    private Camera camera;
    private String img_src;
    private String earth_date;
    private Rover rover;


    @Override
    public String toString() {
        return "Photo\n{" +
                "\nid=" + id +
                ", \nsol=" + sol +
                ", \ncamera=" + camera +
                ", \nimg_src='" + img_src + '\'' +
                ", \nearth_date='" + earth_date + '\'' +
                ", \nrover=" + rover +
                "\n}";
    }
}
