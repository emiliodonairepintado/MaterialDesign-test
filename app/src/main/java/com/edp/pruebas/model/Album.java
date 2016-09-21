package com.edp.pruebas.model;

import com.edp.pruebas.adapter.AlbumsAdapter;

import java.util.List;

/**
 * Created by Lincoln on 18/05/16.
 */
public class Album {
    private String name;
    private String version;
    private String thumbnail;
    private List<Album> albumList;
    private AlbumsAdapter adapter;

    public Album() {
    }

    public Album(String name, String version, String thumbnail) {
        this.name = name;
        this.version = version;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumOfVersion() {
        return version;
    }

    public void setNumOfSongs(String version) {
        this.version = version;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

}
