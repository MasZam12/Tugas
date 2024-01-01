package Other;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class AlertMessage 
{
    private Alert alert;
    
    public void  errorMessage(String message)
    {
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Eror Message");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public void succesMessage(String message)
    {
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Infomation Message");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public boolean confirmationMessage(String message)
    {
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText(message);
        Optional<ButtonType> option = alert.showAndWait();
        if(option.get().equals(ButtonType.OK))
        {
            return true;
        }
        else
        {
            return false;
        }
   }
}
