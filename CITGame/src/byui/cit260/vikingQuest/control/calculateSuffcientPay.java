
package byui.cit260.vikingQuest.control;

/**
 *
 * @author Amy
 */
public class calculateSuffcientPay {
    public static void main(){
        
        //Declare Variables
        double itemCost, pay, difference;
        
        //Placeholder values
        itemCost = 10.00;
        pay = 10.00;
        difference = itemCost - pay;
        
        if (difference == 0){
            System.out.println("Thank you! Is there anything else you want?");
        }
        else
            System.out.println("That ammount is not correct.");
    }
}
