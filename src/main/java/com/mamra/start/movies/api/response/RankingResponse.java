package com.mamra.start.movies.api.response;
import com.mamra.start.movies.domain.Ranking;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RankingResponse {
private String category;
private String description;

    public RankingResponse(Ranking ranking){
        category = ranking.getRankingCategory();
        description = ranking.getDescription();
    }
}
