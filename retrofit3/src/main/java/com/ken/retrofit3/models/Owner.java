package com.ken.retrofit3.models;

/**
 * Created by Ken on 28/02/17.
 */

public class Owner {

    private String html_url;
    private String url;
    private String teams_url;


    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTeams_url() {
        return teams_url;
    }

    public void setTeams_url(String teams_url) {
        this.teams_url = teams_url;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "html_url='" + html_url + '\'' +
                ", url='" + url + '\'' +
                ", teams_url='" + teams_url + '\'' +
                '}';
    }
}
