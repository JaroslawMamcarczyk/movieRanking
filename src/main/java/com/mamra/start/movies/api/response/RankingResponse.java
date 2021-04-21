package com.mamra.start.movies.api.response;

import com.mamra.start.movies.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;
@ResponseBody
@Getter
@Setter
@AllArgsConstructor
public class RankingResponse {
    private String rankingCategory;
    private String description;
}