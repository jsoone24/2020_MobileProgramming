package i20170404;

import java.util.ArrayList;
import java.util.Arrays;

public class DrinkVendingMachine extends VendingMachine { //추상 클래스인 자판기를 상속받아 음료자판기 생성
    public ArrayList<String> beverageStatus;

    public DrinkVendingMachine() { //생성자
        super();
        this.beverageStatus = new ArrayList<>();
    }

    public DrinkVendingMachine(int moneyRemainder, int productCount, String[] productName, Integer[] productPrice, Integer[] productRemainderCount, String[] beverageStatus) { //생성자 오버로딩
        super(moneyRemainder, productCount, productName, productPrice, productRemainderCount);
        this.beverageStatus = new ArrayList<>(Arrays.asList(beverageStatus));
    }

    @Override
    public void ModifyProduct() { //관리자 관점 제품 목록 수정 메서드
        System.out.print("\n1. Add\n2. Delete\nInput : ");
        switch (Integer.parseInt(scanner.nextLine())) {
            case 1: //추가
                System.out.println("You selected Add.\n\nPlease write information.");
                System.out.print("ProductName : ");
                this.productName.add(scanner.nextLine());
                System.out.print("Amount : ");
                this.productRemainderCount.add(Integer.parseInt(scanner.nextLine()));
                System.out.print("State : ");
                this.beverageStatus.add(scanner.nextLine());
                System.out.print("Price : ");
                this.productPrice.add(Integer.parseInt(scanner.nextLine()));
                this.productCount += 1;
                ShowStatusMaster();
                System.out.println("Add complete.");
                break;
            case 2: //삭제
                if (this.productCount > 0) {
                    System.out.println("You selected Delete.");
                    ShowStatusMaster();
                    System.out.print("Please choose product : ");
                    int t = Integer.parseInt(scanner.nextLine());
                    this.productName.remove(t);
                    this.productRemainderCount.remove(t);
                    this.beverageStatus.remove(t);
                    this.productPrice.remove(t);
                    this.productCount -= 1;
                    ShowStatusMaster();
                    System.out.println("Delete complete");
                } else
                    System.out.println("There's nothing to delete.");
                break;
            default:
                System.out.println("Wrong number.");
                break;
        }
    }

    @Override
    public void ShowStatusMaster() { //관리자 관점에서 목록 출력 메서드
        System.out.println("\nNum of Product : " + productCount);
        System.out.println("Money Remainder : " + moneyRemainder);
        System.out.printf("%20s%20s%20s%20s%20s\n", "Index", "Name", "State", "Price", "Amount");
        System.out.println("====================================================================================================");
        for (int i = 0; i < this.productCount; i++)
            System.out.printf("%20d%20s%20s%20s%20s\n", i, this.productName.get(i), this.beverageStatus.get(i), this.productPrice.get(i), this.productRemainderCount.get(i));
        System.out.println("====================================================================================================\n");
    }

    @Override
    public void ShowStatusUser() { //사용자 관점에서 목록 출력 메서드
        System.out.println("\nNum of Product : " + productCount);
        System.out.printf("%20s%20s%20s%20s%20s\n", "Index", "Name", "State", "Price", "Status");
        System.out.println("====================================================================================================");
        for (int i = 0; i < this.productCount; i++)
            System.out.printf("%20d%20s%20s%20s%20s\n", i, this.productName.get(i), this.beverageStatus.get(i), this.productPrice.get(i), (this.productRemainderCount.get(i) > 0) ? "" : "Sold Out");
        System.out.println("====================================================================================================\n");
    }

    @Override
    public void SearchProduct() { //자판기 내부에 상품 목록 출력 메서드
        ShowStatusUser();
        System.out.print("Please choose product name : ");
        String t = scanner.nextLine();
        int i;
        for (i = 0; i < productCount; i++)
            if (t.equals(this.productName.get(i)))
                break;

        if (i >= productCount) //찾는 물품이 없을때
            System.out.println("No such item.");
        else {
            System.out.printf("\n%20s%20s%20s%20s\n", "Name", "Status", "Price", "Amount");
            System.out.println("================================================================================");
            System.out.printf("%20s%20s%20s%20s\n", this.productName.get(i), this.beverageStatus.get(i), this.productPrice.get(i), this.productRemainderCount.get(i));
            System.out.println("================================================================================\n");
        }
    }

    @Override
    public void Buy() { //사용자 관점 상품 구매 창 출력
        int returnCash; //거스름돈
        ShowStatusUser();
        System.out.print("Please choose product\nInput : ");
        int n = Integer.parseInt(scanner.nextLine());
        if (this.productRemainderCount.get(n) > 0) { //상품이 품절인지 확인
            returnCash = ShowGotMoney(this.productPrice.get(n));
            if (returnCash > this.moneyRemainder) {
                System.out.println("There's no change. Purchase denied.\n");
            } else {
                System.out.println("Purchase complete.");
                System.out.println("Change : " + returnCash + "\n");
                this.moneyRemainder -= returnCash;
                this.productRemainderCount.set(n, this.productRemainderCount.get(n) - 1);
            }
        } else
            System.out.println("Sold out. Please choose other.\n");
    }

    @Override
    public void Initialize(boolean whether) { //자판기 초기화 함수
        if (whether) {
            this.beverageStatus = new ArrayList<>();
            super.Initialize(whether);
        }
    }
}