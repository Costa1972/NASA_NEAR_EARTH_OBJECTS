package ru.costa.nasa_near_earth_objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PhotoObject {
    List<Photo> photos;

    @Override
    public String toString() {
        return "ExampleObject{" +
                "photos=" + photos +
                '}';
    }
}
