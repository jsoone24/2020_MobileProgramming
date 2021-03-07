package i20170404;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public abstract class VendingMachine { //자판기에 대한 추상클래스
    public int moneyRemainder; //자판기 내부에 남아있는 돈의 양
    public int productCount; //제품의 수
    public ArrayList<String> productName; //제품의 이름
    public ArrayList<Integer> productPrice; //제품의 가격
    public ArrayList<Integer> productRemainderCount; //제품의 잔여 수량
    Scanner scanner = new Scanner(System.in);

    public VendingMachine() { //기본 생성자
        this.moneyRemainder = 0;
        this.productCount = 0;
        this.productName = new ArrayList<>();
        this.productPrice = new ArrayList<>();
        this.productRemainderCount = new ArrayList<>();
    }

    public VendingMachine(int moneyRemainder, int productCount, String[] productName, Integer[] productPrice, Integer[] productRemainderCount) { //생성자 오버로딩
        this.moneyRemainder = moneyRemainder;
        this.productCount = productCount;
        this.productName = new ArrayList<String>(Arrays.asList(productName));
        this.productPrice = new ArrayList<Integer>(Arrays.asList(productPrice));
        this.productRemainderCount = new ArrayList<Integer>(Arrays.asList(productRemainderCount));
    }

    abstract public void ShowStatusMaster(); //관리자 관점에서 보여주는 자판기 상태

    abstract public void ShowStatusUser(); //사용자 관점에서 보여주는 자판기 상태

    abstract public void ModifyProduct(); //판매할 수 있는 목록 변경

    abstract public void SearchProduct(); //현재 자판기에서 판매하는 제품 검색

    abstract public void Buy(); //자판기 제품 구매 화면

    public int ShowGotMoney(int price) { //자판기에서 물품을 살때 돈을 계산해서 출력
        int gotMoney = 0;
        while (gotMoney < price) {
            System.out.println("Please put money");
            gotMoney += Integer.parseInt(scanner.nextLine());
            System.out.println("Price : " + price);
            System.out.println("Got : " + gotMoney);
            System.out.println("Remain : ".concat(((price - gotMoney)>=0)?Integer.toString(price - gotMoney):"0"));
            System.out.println();
        }
        return gotMoney - price;
    }

    public void Initialize(boolean whether) //자판기 초기화 함수
    {
        if (whether) {
            this.moneyRemainder = 0;
            this.productCount = 0;
            this.productName = new ArrayList<>();
            this.productPrice = new ArrayList<>();
            this.productRemainderCount = new ArrayList<>();
        }
    }
}