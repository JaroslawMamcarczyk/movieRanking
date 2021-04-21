package com.mamra.start.movies.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Getter
@Setter
@AllArgsConstructor
public class MovieResponse {
    private String title;
    private String logo;
    private int year;
}
