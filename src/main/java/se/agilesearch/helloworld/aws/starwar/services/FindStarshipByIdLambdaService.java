package se.agilesearch.helloworld.aws.starwar.services;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import se.agilesearch.helloworld.aws.starwar.dao.StarshipDao;
import se.agilesearch.helloworld.aws.starwar.domain.Starship;

public class FindStarshipByIdLambdaService implements RequestHandler<FindStarshipByIdLambdaService.FindStarshipByIdCommand, Starship> {
    @Override
    public Starship handleRequest(FindStarshipByIdCommand command, Context context) {
        final var starshipDao = StarshipDao.getInstance();
        return starshipDao.findById(command.getStarshipId());
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    static class FindStarshipByIdCommand {
        private Integer starshipId;
    }
}
