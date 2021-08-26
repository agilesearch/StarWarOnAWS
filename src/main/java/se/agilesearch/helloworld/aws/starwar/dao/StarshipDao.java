package se.agilesearch.helloworld.aws.starwar.dao;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import se.agilesearch.helloworld.aws.starwar.domain.Starship;

import java.util.List;

public class StarshipDao {

    private static StarshipDao starshipDao;

    private final AmazonDynamoDB client;
    private final DynamoDB dynamoDB;
    private final String DYNAMODB_TABLE_NAME = "Starship";

    private StarshipDao(AmazonDynamoDB client, DynamoDB dynamoDB) {
        this.client = client;
        this.dynamoDB = dynamoDB;
    }

    public static StarshipDao getInstance() {
        if (starshipDao == null) {
            final AmazonDynamoDB client = AmazonDynamoDBClientBuilder
                    .standard()
                    .build();
            starshipDao = new StarshipDao(client, new DynamoDB(client));
        }

        return starshipDao;
    }

    public Starship findById(Integer id) {

        final var mapper = new DynamoDBMapper(client);
        return mapper.load(Starship.class, id);
    }

    public List<Starship> findAll() {
        // TODO search how can find all the items!
        return null;
    }
}
