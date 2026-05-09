package com.areso.Chapter8.HouseRentalSys;

import java.util.Scanner;

public class HouserRSys {
    public static void main(String[] args) {
        //0. 菜单
        boolean loop = true;
        String skip = "-------------------------------房屋出租系统-------------------------------";
        String key = "";
        Scanner scanner = new Scanner(System.in);
        String[] order = { "\t\t\t1 新 增 房 屋",
                           "\t\t\t2 查 找 房 屋",
                           "\t\t\t3 删 除 房 屋",
                           "\t\t\t4 修 改 房 屋 信 息",
                           "\t\t\t5 房 屋 列 表",
                           "\t\t\t6 退      出"};
        //1. 新增房屋
        String details;
        int court = 0;
        int userAnswer;
        String[] arrNew = {"我是帅哥"};
        String[] arr = {"我可以学好Java"};
        int index = -1;//用于判断，是否找到房源
        char userReply;
        String name = null;
        String telephone = null;
        String address = null;
        double monthMoney = 0.0;
        String state = null;
        do{
            System.out.println(skip);
            for (int i = 0; i < order.length; i++) {
                System.out.println(order[i]);
            }
            System.out.println("请选择(1-6)");
            key = scanner.next();
            switch (key) {
                case "1" :
                                 /*
                    思路分析：提示用户输入，增加房屋的户数，将户数作为数组的长度
                    输出信息，把details保存到数组中（顺序）,用court作为编号
                     */
                    //提示用户输入
                    System.out.println("您要增加几户房源呢？ = =");
                    userAnswer = scanner.nextInt();
                    //将户数作为数组的长度
                    arr = new String[userAnswer];
                    //for循环遍历数组元素
                    for (int i = 0; i < arr.length; i++) {
                        System.out.println("姓名：");
                         name = scanner.next();
                        System.out.println("电话：");
                        telephone = scanner.next();
                        System.out.println("地址：");
                        address = scanner.next();
                        System.out.println("月租：");
                        monthMoney = scanner.nextDouble();
                        System.out.println("状态(未出租/已出租)：");
                         state = scanner.next();
                        System.out.println("-------------------------------添加房屋-------------------------------");
                        //输出信息
                        System.out.println("姓名：" + name + "\n电话：" + telephone + "\n地址：" + address +
                                "\n月租：" + monthMoney + "\n状态(未出租/已出租)：" + state);
                        System.out.println("-------------------------------添加完成-------------------------------");
                        court++;
                        details = court + "\t\t" + name + "\t\t" + telephone + "\t\t" + address + "\t\t" + monthMoney + "\t\t" + state;
                        arr[i] = details;
                    }
                    //让arr和arrNew指向同一个数据空间，扩大作用域
                    arrNew = arr;
                    System.out.println("已为您添加" + court + "户房源，感谢您的支持！");
                    break;
                case "2" :
                    //2. 查找房屋
                    /*
                    1. for循环遍历arr数组元素
                    2. if 输入的数 -1 == i 输出对应信息
                    3. 巧用index
                     */
                    //提示用户输入
                    System.out.println("请输入您要查找的id：");
                    userAnswer = scanner.nextInt();
                    for (int i = 0; i < arr.length; i++) {
                        if(userAnswer - 1 == i) {
                            System.out.println(arr[i]);
                            index = i;
                            break;
                        }
                    }
                    if(index == -1) {
                        System.out.println("-------------------------------没有找到该房源-------------------------------");
                    }
                    break;
                case "3" :
                    /*
                    1. for循环遍历arr数组元素，如果userAnswer -1 < i，arrNew[j] = arr[i],else arrNew[j] = arr[i + 1];
                     */
                    System.out.println("请选择待删除房屋编号(-1退出)");
                    userAnswer = scanner.nextInt();
                    if(userAnswer == -1) {
                        break;
                    }
                    System.out.println("确认是否删除(Y/N)：请小心选择:");
                     userReply = scanner.next().charAt(0);
                    if(userReply != 'Y') {
                        break;
                    }
                    System.out.println("请输入你的选择(Y/N)");
                    userReply = scanner.next().charAt(0);
                    if(userReply == 'N') {
                        break;
                    }
                    arrNew = new String[arr.length - 1];
                    System.out.println("-------------------------------删除房屋-------------------------------");
                    //for循环遍历arr数组元素
                    for (int i = 0,j = 0; i < arrNew.length; i++,j++) {
                        if(userAnswer - 1 < i) {
                            arrNew[j] = arr[i];
                        }else {
                            arrNew[j] = arr[i + 1];
                        }
                    }
                    System.out.println("-------------------------------删除完成-------------------------------");
                    //输出原数组情况
                    System.out.println("-------------------------------原数组情况-------------------------------");
                    for (int i = 0; i < arr.length; i++) {
                        System.out.println(arr[i]);
                    }
                    System.out.println("-------------------------------修改后数组情况-------------------------------");
                    for (int i = 0; i < arrNew.length; i++) {
                        System.out.println(arrNew[i]);
                    }
                    arr = arrNew;
                    break;
                case "4" :
                    /*
                    1. for循环遍历arr数组元素，如果userAnswer - 1 == i
                    2. 提示用户输入，接收用户输入，把信息赋值details，把detail赋值给arr[i]
                    3. for循环遍历输入数组元素
                    4. 让arr指向arrNew
                     */
                    System.out.println("请选择待修改房屋编号(-1退出)");
                    userAnswer = scanner.nextInt();
                    if (userAnswer == -1) {
                        break;
                    }
                    System.out.println("-------------------------------修改客户-------------------------------");
                    for (int i = 0; i < arr.length; i++) {
                        if(userAnswer - 1  == i) {
                            System.out.print("\t姓名(" + name + ")：");
                            String name1 = scanner.next();
                            System.out.print("\t电话(" + telephone + ")：");
                            String telephone1 = scanner.next();
                            System.out.print("\t地址(" + address + ")：");
                            String address1 = scanner.next();
                            System.out.print("\t租金(" + monthMoney + ")：");
                            double monthMoney1 = scanner.nextDouble();
                            System.out.print("\t状态(" + state + ")：");
                            String state1 = scanner.next();
                            details = (i+1) + "\t\t" + name1 + "\t\t" + telephone1 + "\t\t" + address1 + "\t\t"
                                            + monthMoney1 + "\t\t" + state1;
                            arr[i] = details;
                        }
                    }
                    arrNew = arr;
                    System.out.println("-------------------------------修改完成-------------------------------");
                    break;
                case "5" :
                    /*
                    思路分析：
                    1. for循环遍历arr数组元素
                     */
                    System.out.println("--------------------------------房屋列表-------------------------------");
                    System.out.println("编号"+ "\t\t" + "房主" + "\t\t" + "电话" + "\t\t" + "地址" + "\t\t" + "月租 "+
                                        "\t\t" + "状态(未出租/已出租)");
                    for (int i = 0; i < arr.length; i++) {
                        System.out.println(arr[i]);
                    }
                    System.out.println("-------------------------------房屋列表完成-------------------------------");
                    break;
                case "6" :
                    System.out.println("您真的要退出吗(Y/N) =.=");
                    userReply = scanner.next().charAt(0);
                    if(userReply == 'Y' || userReply == 'N') {
                        if(userReply != 'Y') {
                            break;
                        }
                        loop = false;
                    }else {
                        System.out.println("选择错误，请重新输入");
                    }
                    break;
                default  :
                    System.out.println("您输入的数字，不在(1-6)的范围内:)");
            }
        }while(loop);
        System.out.println("我可以学好Java");
    }
}
