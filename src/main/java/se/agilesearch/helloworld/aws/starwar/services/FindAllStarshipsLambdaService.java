package se.agilesearch.helloworld.aws.starwar.services;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import se.agilesearch.helloworld.aws.starwar.dao.StarshipDao;
import se.agilesearch.helloworld.aws.starwar.domain.Starship;

import java.util.List;

public class FindAllStarshipsLambdaService implements RequestHandler<String, List<Starship>> {

    @Override
    public List<Starship> handleRequest(String s, Context context) {

        final var starshipDao = StarshipDao.getInstance();

        return starshipDao.findAll();
    }
}
