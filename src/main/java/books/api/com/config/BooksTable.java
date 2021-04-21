package books.api.com.config;

import java.util.Collections;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import static books.api.com.constants.BooksConstant.ENDPOINT_DYNAMO;
import static books.api.com.constants.BooksConstant.REGION_DYNAMO;

public class BooksTable {
    public static void main(String[] args) {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        String tableName = "Books_Table";

        try {
            System.out.println("Creating...");
            Table table = dynamoDB.createTable
                    (
                        tableName,
                            Collections.singletonList(new KeySchemaElement("id", KeyType.HASH)),
                            Collections.singletonList(new AttributeDefinition("id", ScalarAttributeType.S)),
                        new ProvisionedThroughput(5L, 5L)
                    );

            table.waitForActive();
            System.out.println("Success " + table.getDescription().getTableStatus());

        }
        catch (Exception e) {
            System.err.println("Error");
            System.err.println(e.getMessage());
        }
    }
}
