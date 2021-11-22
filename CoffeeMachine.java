package machine;

import java.util.*;

public class CoffeeMachine {


    int mlOfWaterInMachine = 400;
    int mlOfMilkInMachine = 540;
    int beansInMachine = 120;
    int disposableCups = 9;
    int amountOfCashInMachine = 550;

    public static void main(String[] args) {

        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Scanner scanner = new Scanner(System.in);
        boolean isWorking = true;


        while (isWorking) {
            System.out.println();
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next().toLowerCase(Locale.ROOT);
            isWorking = coffeeMachine.chooseAnOption(action, scanner);

        }


    }

    private void remainingIngredients() {
        System.out.println("The coffee machine has:");
        System.out.println(mlOfWaterInMachine + " ml of water");
        System.out.println(mlOfMilkInMachine + " ml of milk");
        System.out.println(beansInMachine + " g of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println("$" + amountOfCashInMachine + " of money");
    }

    private void completingAnOrder(int mlOfWaterInMachine, int mlOfMilkInMachine, int beansInMachine, int amountOfCashInMachine) {


        if (this.mlOfWaterInMachine - mlOfWaterInMachine >= 0 && this.mlOfMilkInMachine - mlOfMilkInMachine >= 0 && this.beansInMachine - beansInMachine >= 0 && this.disposableCups - 1 >= 0) {
            System.out.println("I have enough resources, making you a coffee!");
            System.out.println();
            this.mlOfWaterInMachine -= mlOfWaterInMachine;
            this.mlOfMilkInMachine -= mlOfMilkInMachine;
            this.beansInMachine -= beansInMachine;
            this.disposableCups -= 1;
            this.amountOfCashInMachine += amountOfCashInMachine;

        } else if (this.mlOfWaterInMachine - mlOfWaterInMachine < 0 || this.mlOfMilkInMachine - mlOfMilkInMachine < 0 || this.beansInMachine - beansInMachine < 0 && this.disposableCups < 1) {
            System.out.print("Sorry, not enough ");
            if (this.mlOfWaterInMachine - mlOfWaterInMachine < 0) {
                System.out.print("water");
            } else if (this.mlOfMilkInMachine - mlOfMilkInMachine < 0) {
                System.out.print("milk");
            } else if (this.beansInMachine - beansInMachine < 0) {
                System.out.print("beans");
            } else if (disposableCups < 1) {
                System.out.print("cups");
            }
            System.out.println("!");
            System.out.println();
        }
    }


    private boolean chooseAnOption(String action, Scanner scanner) {
        switch (action) {

            case "buy":
                System.out.println();
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                String numberOfDrink = scanner.next();

                switch (numberOfDrink) {
                    case "1":
                        completingAnOrder(250, 0, 16, 4);
                        break;

                    case "2":
                        completingAnOrder(350, 75, 20, 7);
                        break;

                    case "3":
                        completingAnOrder(200, 100, 12, 6);
                        break;

                    case "back":
                        System.out.println();
                        break;
                }

                break;

            case "fill":
                System.out.println();
                System.out.println("Write how many ml of water you want to add:");
                int addedMlOfWater = scanner.nextInt();
                this.mlOfWaterInMachine += addedMlOfWater;

                System.out.println("Write how many ml of milk you want to add:");
                int addedMlOfMilk = scanner.nextInt();
                this.mlOfMilkInMachine += addedMlOfMilk;

                System.out.println("Write how many grams of coffee beans you want to add:");
                int addedGramsOfBeans = scanner.nextInt();
                this.beansInMachine += addedGramsOfBeans;

                System.out.println("Write how many disposable cups of coffee you want to add:");
                int addedAmountOfDisposableCups = scanner.nextInt();
                this.disposableCups += addedAmountOfDisposableCups;

                break;


            case "remaining":
                remainingIngredients();
                System.out.println();
                break;


            case "take":
                System.out.println();
                System.out.println("I gave you $" + this.amountOfCashInMachine + " of money");
                this.amountOfCashInMachine = 0;
                break;

            case "exit":
                System.out.println("Machine is shutting down.");
                return false;

            default:
                break;

        }

        return true;
    }
}
