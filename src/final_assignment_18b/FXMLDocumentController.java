
package final_assignment_18b;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.Math;
import java.io.*;
import java.util.regex.*; 
import java.util.ArrayList;
import java.util.List;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private Button minusButton;
    
    @FXML
    private Button plusButton;
    
    @FXML
    private Button sqrtButton;
    
    @FXML
    private Button clearExpression;
    
    @FXML
    private Button clearInput;
    
    @FXML
    private Button divideButton;
    
    @FXML
    private Button sevenButton;
    
    @FXML
    private Button eightButton;
    
    @FXML
    private Button nineButton;
    
    @FXML
    private Button sixButton;
    
    @FXML
    private Button fiveButton;
    
    @FXML
    private Button fourButton;
    
    @FXML
    private Button threeButton;
    
    @FXML
    private Button twoButton;
    
    @FXML
    private Button oneButton;
    
    @FXML
    private Button multiplyButton;
    
    @FXML
    private Button equalsButton;
    
    @FXML 
    private TextField inputTextField;
    
    @FXML
    private TextField expressionTextField;
    
    Double first = 0.0;
    Double second = 0.0;
    
    @FXML
    private void handle_EqualButtonAction(ActionEvent event) {

        try{
            second = Double.parseDouble(inputTextField.getText());
            expressionTextField.appendText(inputTextField.getText());

            Pattern p = Pattern.compile("(\\d+)-(\\d+)");
            Matcher m = p.matcher(expressionTextField.getText());
            
            Pattern d = Pattern.compile("(\\d+)/(\\d+)");
            Matcher q = d.matcher(expressionTextField.getText());
            
            if(m.find()){

                Double total = first - second;
                inputTextField.setText(String.valueOf(total));

                System.out.print("Here is the equation: ");
                System.out.println(expressionTextField.getText());
                System.out.print("Total: ");

            }   
            else if(q.find()){
                Double total = first / second;
                inputTextField.setText(String.valueOf(total));

                System.out.print("Here is the equation: ");
                System.out.println(expressionTextField.getText());
                System.out.print("Total: ");
                System.out.println(inputTextField.getText());
            }
            else{
                Double n = compute(expressionTextField.getText());
                inputTextField.setText(String.valueOf(n));
                System.out.print("Here is the equation: ");
                System.out.println(expressionTextField.getText());
                System.out.print("Total: ");
                System.out.println(inputTextField.getText());
            }
        }
        catch(NumberFormatException e){
            System.out.print("Here is the equation: ");
            System.out.println(expressionTextField.getText());
            System.out.print("Total: ");
            System.out.println("Syntax Error");
            inputTextField.setText("Syntax Error");
        }
        textFile();
        
        objectSerialization ser = new objectSerialization(expressionTextField.getText(), Double.parseDouble(inputTextField.getText()));
        try(ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream("objectSerialization.ser")))
        {
            objOutput.writeObject(ser);
        }catch(Exception e)
        {
            System.out.println("Could not serialize");
        }
        try(ObjectInputStream objInput = new ObjectInputStream(new FileInputStream("objectSerialization.ser")))
        {
            Object obj = objInput.readObject();
            if(obj instanceof objectSerialization){
                objectSerialization retrieved = (objectSerialization) obj;  
            }
        }catch(Exception e)
        {
            System.out.println("Exception for serialization");
        } 
    }
    
    @FXML
    private void handle_SQRTButtonAction(ActionEvent event) {
        Double val = 0.0;
        Double sqrt = 0.0;
        
        expressionTextField.setText("sqrt(");
        expressionTextField.appendText(inputTextField.getText());
        expressionTextField.appendText(")");
        
        try{
            sqrt = Double.parseDouble(inputTextField.getText());
            sqrt = Math.sqrt(sqrt);
            inputTextField.setText(String.valueOf(sqrt));
        }
        catch(Exception e){
            inputTextField.setText("SYNTAX ERROR");
        }
        textFile();
    }
    @FXML
    private void handle_DivideButtonAction(ActionEvent event) {
        expressionTextField.setText(inputTextField.getText());
        first = Double.parseDouble(inputTextField.getText());
        expressionTextField.appendText("/");
        inputTextField.clear();
    }
    @FXML
    private void handle_SevenButtonAction(ActionEvent event) {
        inputTextField.appendText("7");
    }
    @FXML
    private void handle_EightButtonAction(ActionEvent event) {
        inputTextField.appendText("8");
    }
    @FXML
    private void handle_NineButtonAction(ActionEvent event) {
        inputTextField.appendText("9");
    }
    @FXML
    private void handle_FourButtonAction(ActionEvent event) {
        inputTextField.appendText("4");
    }
    
    @FXML
    private void handle_FiveButtonAction(ActionEvent event) {
        inputTextField.appendText("5");
    }
    @FXML
    private void handle_SixButtonAction(ActionEvent event) {
        inputTextField.appendText("6");
    }
    @FXML
    private void handle_OneButtonAction(ActionEvent event) {
        inputTextField.appendText("1");
    }
    @FXML
    private void handle_TwBouttonAction(ActionEvent event) {
        inputTextField.appendText("2");
    }
    @FXML
    private void handle_ThreeButtonAction(ActionEvent event) {
        inputTextField.appendText("3");
    }
    @FXML
    private void handle_OneOverXButtonAction(ActionEvent event) {
        double num = 1;
        double divide = 0;
        expressionTextField.setText("1/");
        expressionTextField.appendText(inputTextField.getText());
        
        try{
            divide = Double.parseDouble(inputTextField.getText());
            inputTextField.clear();
            num = num/divide;
            inputTextField.setText(String.valueOf(num));
            
            String newLine = System.getProperty("line.separator");
        }
        catch(Exception e){
            inputTextField.setText("SYNTAX ERROR");
        }
        textFile();
    }
    @FXML
    private void handle_ZeroButtonAction(ActionEvent event) {
        inputTextField.appendText("0");
    }
    @FXML
    private void handle_DecimalButtonAction(ActionEvent event) {
        inputTextField.appendText(".");
    }
    @FXML
    private void handle_MultiplyButtonAction(ActionEvent event) {
        expressionTextField.setText(inputTextField.getText());
        expressionTextField.appendText(" * ");
        
        inputTextField.clear();
        
    }
    @FXML
    private void handle_MinusButtonAction(ActionEvent event) {
        expressionTextField.setText(inputTextField.getText());
        first = Double.parseDouble(inputTextField.getText());
        expressionTextField.appendText("-");
        inputTextField.clear();
    }
    @FXML
    private void handle_PlusButtonAction(ActionEvent event) {
        expressionTextField.setText(inputTextField.getText());
        expressionTextField.appendText(" + ");
        inputTextField.clear();
    }
    @FXML
    private void handle_ClearAllButtonAction(ActionEvent event) {
        inputTextField.clear();
        expressionTextField.clear();
    }
    @FXML
    private void handle_ClearButtonAction(ActionEvent event) {
        inputTextField.clear();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    static double compute(String equation) {
        double result = 0.00;
        String []byPluses = equation.split("\\+");
        //String []byMinus = equation.split("\\-");
        for (String multipl : byPluses) {
            String []byMultipl = multipl.split("\\*");
            double multiplResult = 1;
            for (String operand : byMultipl) {
                multiplResult *= Double.parseDouble(operand);
            }
            result += multiplResult;
        }
        
        return result;
    }
    
    public void textFile(){
       
        String newLine = System.getProperty("line.separator");
        try{
            FileWriter fileWriter = new FileWriter("data.txt", true);
            fileWriter.write(expressionTextField.getText());
            fileWriter.write("    ");
            fileWriter.write(inputTextField.getText());
            fileWriter.write(newLine);
            fileWriter.close();
        }
        catch(IOException e){
            System.out.println("Could not transfer to file.");
        }
    }   
}
