package com.example.meteo.model.apiobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ApiResponse {

    @JsonProperty("list")
    public List<ApiMeteoPrevision> apiMeteoPrevisions;

    @JsonProperty("city")
    public ApiVille apiVille;
}
