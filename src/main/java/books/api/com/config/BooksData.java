package books.api.com.config;

import static books.api.com.constants.BooksConstant.REGION_DYNAMO;
import static books.api.com.constants.BooksConstant.ENDPOINT_DYNAMO;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;

public class BooksData {
    public static void main(String[] args) throws Exception {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();
        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Books_Table");

        Item book = new Item()
                .withPrimaryKey("id", 1)
                .withString("name", "The Hitchhiker's Guide to the Galaxy")
                .withString("category", "Science fiction")
                .withNumber("trilogy", 5);

        PutItemOutcome outcome = table.putItem(book);
    }
}
