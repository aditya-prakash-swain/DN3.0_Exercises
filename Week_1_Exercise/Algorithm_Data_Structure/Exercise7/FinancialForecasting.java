package Exercise7;

public class FinancialForecasting {

    public static double calculateFutureValue(double initialValue, double growthRate, int periods) {
        if (periods == 0) {
            return initialValue;
        }
        return calculateFutureValue(initialValue * (1 + growthRate), growthRate, periods - 1);
    }
    
    public static double calculateFutureValueIteratively(double initialValue, double growthRate, int periods) {
        double futureValue = initialValue;
        for (int i = 0; i < periods; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

    public static void main(String[] args) {
        double initialValue = 1000.0; 
        double growthRate = 0.05; 
        int periods = 10; 

        double futureValue = calculateFutureValue(initialValue, growthRate, periods);
        System.out.println("Future Value after " + periods + " periods: " + futureValue);
        
        double futureValue2 = calculateFutureValueIteratively(initialValue, growthRate, periods);
        System.out.println("Future Value after " + periods + " periods: " + futureValue2);
    }
}


