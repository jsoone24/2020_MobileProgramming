package i20170404;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class MyUI implements StringToInteger {
    String data; //데이터 위치
    Scanner inp; //파일 불러오기 위함
    PrintWriter out; //파일 저장하기 위함
    Scanner scanner = new Scanner(System.in); //키보드 입력
    DrinkVendingMachine drinkVendingMachine; // 객체 생성

    public MyUI(String data) { //UI 생성및, 초기화
        this.data = data;
        read();
    }

    public void MainMenu() { //자판기의 메인메뉴 출력
        int selection;
        do {
            System.out.println("This is VendingMachine. Please choose what to do.");
            System.out.print("1. Lookup Product\n2. Search Product\n3. Buy Product\n4. Leave\nInput : ");
            selection = Integer.parseInt(scanner.nextLine());
            switch (selection) {
                case 1 -> drinkVendingMachine.ShowStatusUser();
                case 2 -> drinkVendingMachine.SearchProduct();
                case 3 -> drinkVendingMachine.Buy();
                case 4 -> {
                    try {
                        write();
                    } catch (IOException ignored) {
                    }
                    System.out.println("\nThanks for visiting!\n");
                    out.close();
                }
                case 10 -> drinkVendingMachine.ShowStatusMaster(); //관리자 모드로 자판기 상태 보기
                case 11 -> drinkVendingMachine.ModifyProduct(); //관리자 모드로 자판기 목록 수정
                default -> System.out.println("Wrong number.\n");
            }
        } while (selection != 4);
    }

    public void read() {
        try {
            inp = new Scanner(new File(this.data));
            int moneyRemainder = Integer.parseInt(inp.nextLine());
            int productCount = Integer.parseInt(inp.nextLine());
            String[] productName = inp.nextLine().split(",");
            Integer[] productPrice = change(inp.nextLine().split(","));
            Integer[] productRemainderCount = change(inp.nextLine().split(","));
            String[] beverageStatus = inp.nextLine().split(",");
            inp.close();
            drinkVendingMachine = new DrinkVendingMachine(moneyRemainder, productCount, productName, productPrice, productRemainderCount, beverageStatus);
        } catch (FileNotFoundException e) {
            System.out.println("[Error] File Not Found."); // exception
            drinkVendingMachine = new DrinkVendingMachine();
        }
    }

    // write
    public void write() throws IOException {
        File file = new File(data);
        if (!file.exists()) {
            boolean created = file.createNewFile();
        }

        out = new PrintWriter(this.data);
        out.println(drinkVendingMachine.moneyRemainder);
        out.println(drinkVendingMachine.productCount);
        for (String s : drinkVendingMachine.productName) out.print(s + ",");
        out.println();
        for (Integer i : drinkVendingMachine.productPrice) out.print(i + ",");
        out.println();
        for (Integer i : drinkVendingMachine.productRemainderCount) out.print(i + ",");
        out.println();
        for (String s : drinkVendingMachine.beverageStatus) out.print(s + ",");
        out.println();
    }

    @Override
    public Integer[] change(String[] arr) {
        return Arrays.stream(Arrays.stream(arr).mapToInt(Integer::parseInt).toArray()).boxed().toArray(Integer[]::new);
    }
}
