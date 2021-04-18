package books.api.com.document;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import org.springframework.data.annotation.Id;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@DynamoDBTable(tableName = "Books_Table")

public class Books {
    @Id
    @DynamoDBHashKey(attributeName = "id")
    private String id;

    @DynamoDBHashKey(attributeName = "name")
    private String name;

    @DynamoDBHashKey(attributeName = "category")
    private String category;

    @DynamoDBHashKey(attributeName = "trilogy")
    private int trilogy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getTrilogy() {
        return trilogy;
    }

    public void setTrilogy(int trilogy) {
        this.trilogy = trilogy;
    }

    public Books(String id, String name, String category, int trilogy){
        this.id = id;
        this.name = name;
        this.category = category;
        this.trilogy = trilogy;
    }

}
