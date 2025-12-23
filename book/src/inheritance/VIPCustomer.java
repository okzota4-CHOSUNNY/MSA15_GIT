package inheritance;


public class VIPCustomer extends Customer {

    private int agentID;   // VIPCustomer만 갖는 필드
    double saleRatio;      // VIPCustomer만 갖는 필드

    public VIPCustomer() {
        customerGrade = "VIP";
        bonusRatio = 0.05;
        saleRatio = 0.1;
    }

    public VIPCustomer(int customerID, String customerName, int agentID) {
        super(customerID, customerName);  // 부모 필드 초기화
        this.customerGrade = "VIP";
        this.bonusRatio = 0.05;
        this.saleRatio = 0.1;
        this.agentID = agentID;
    }

    @Override
    public int calcPrice(int price) {
        bonusPoint += price * bonusRatio;
        return price - (int)(price * saleRatio);
    }

    public int getAgentID() {
        return agentID;
    }

    @Override
    public String showCustomerInfo() {
        return customerName + "님의 등급은 " + customerGrade +
                "이며, 보너스 포인트는 " + bonusPoint + "입니다.";
    }
}