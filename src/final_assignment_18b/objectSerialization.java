
package final_assignment_18b;
import java.io.*;

public class objectSerialization implements Serializable{
    private String fullExpression;
    private Double expressionTotal;
    
    public objectSerialization(String dataValue, Double value){
        setFullExpression(dataValue);
        setExpressionTotal(value);
    }
    
    public void setFullExpression(String dataValue){
        fullExpression = dataValue;
    }
    public void setExpressionTotal(Double value){
        expressionTotal = value;
    }
    public String getFullExpression(){
        return fullExpression;
    }
    public Double getExpressionTotal(){
        return expressionTotal;
    }      
}
