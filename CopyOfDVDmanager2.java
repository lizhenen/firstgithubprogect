import java.util.Scanner;

public class CopyOfDVDmanager2 {

	/**
	 * 需求：
	 *  DVD出租小店，只能出租碟片6张，
	 * 一张碟片每张1元 开发管理系统 
	 * 添加DVD，查看DVD，删除DVD，借出DVD，归还DVD
	 * 
	 * 分析：
	 *      1.碟片包含哪些信息？ 
	 * 		名称，借出日期，借出次数，借出状态 
	 * 		2.数据初始化
	 * 
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String[] names = {"复仇者联盟","金刚狼","哆啦A梦",null,null,null};// 碟片的名称
		int[] dates = {3,4,2,0,0,0}; // 碟片借出日期
		int[] counts = {20,10,3,0,0,0};// 借出次数
		int[] states = {1,0,1,0,0,0};// 借出状态,1代表借出，0代表可借
		//数据初始化
		
		
		do {
			// 租赁系统主界面
			System.out.println("***************************************");
			System.out.println("***********欢迎来到DvD租赁小店***********");
			System.out.println("\t\t1.查看碟片");
			System.out.println("\t\t2.添加碟片");
			System.out.println("\t\t3.删除碟片");
			System.out.println("\t\t4.借出碟片");
			System.out.println("\t\t5.归还碟片");
			System.out.println("\t\t6.退出系统");
			System.out.println("***************************************");
			System.out.print("请选择：");
			String choose = input.next();
			if("1".equals(choose)||"2".equals(choose)||"3".equals(choose)||"4".equals(choose)||"5".equals(choose)||"6".equals(choose)){
				switch (choose) {
				case "1"://1.查看碟片
					System.out.println("***查看碟片***");
					//遍历数组
					System.out.println("序号\t碟片名称\t\t借出日期\t\t借出次数\t\t借出状态");
					for (int i = 0; i < names.length; i++) {
						String state="可借";
						String count=counts[i]+"次";
						if(states[i]==1){
							state="已借出";
						}
						String date=dates[i]+"日";
						if(states[i]==0){
							date="";
						}
						if(names[i]!=null){
							System.out.println((i+1)+"\t《"+names[i]+"》\t"+date+"\t\t"+count+"\t\t"+state);
						}
						
					}

					System.out.println("****************************************");
					continue;
				case "2"://2.添加碟片
					System.out.println("***添加碟片***");
					boolean flag=false;
					System.out.print("请输入您要添加的碟片名称：");
					String adddp=input.next();
					for (int i = 0; i < names.length; i++) {
						if(names[i]==null || "".equals(names[i])){
							flag=true;
							names[i]=adddp;
							states[i]=0;
							counts[i]=0;
							dates[i]=0;
							break;
						}
						
					}
					if(flag){
						System.out.println("添加成功！");
					}else{
						System.out.println("未添加成功，系统已满！");
					}
					
					System.out.println("****************************************");
					continue;
				case "3"://3.删除碟片
					System.out.println("***删除碟片***");
					boolean flag2=false;
					boolean flag3=false;
					int index=-1;
					
					boolean flag7=false;
					
					do {
						System.out.print("请输入您要删除的碟片序号：");
						int num = input.nextInt();
						for (int i = 0; i < names.length; i++) {
							if (names[i] == null) {
								index = i;
								break;
							}
						}
						while (num < 1 || num > index) {
							System.out.print("要删除的碟片编号不正确，请重新输入：");
							num = input.nextInt();
						}
						for (int i = 0; i < names.length; i++) {
							if (i == num - 1) {//说明在循环中找到这个编号了
								if (states[i] == 0) {//表示碟片可借，说明碟片在店里，可以进行删除操作
									flag2 = true;
									index = num;
									break;
								} else {//表示碟片已经借出，不在店里，不可以进行删除操作
									flag3 = true;
								}
							}

						}
						if (flag2) {
							for (int j = index; j < names.length - 1; j++) {
								names[j - 1] = names[j];
								states[j - 1] = states[j];
								counts[j - 1] = counts[j];
								dates[j - 1] = dates[j];
							}

							names[names.length - 1] = null;
							states[names.length - 1] = 0;
							counts[names.length - 1] = 0;
							dates[names.length - 1] = 0;
							System.out.println("删除成功！");

							System.out.print("还继续删除碟片吗（y/n）？：");
							String choose2 = input.next();
							if ("y".equals(choose2)) {
								flag7=true;
							} else {
								break;
							}

						} else {
							if (flag3) {
								System.out.println("碟片已经借出，不可以删除！");
							} else {
								System.out.println("删除失败，您要删除的编号不存在！");
							}

						}
					} while (flag7);
					continue;
				case "4"://4.借出碟片
					System.out.println("***借出碟片***");
					//先循环判断店里还有没有可借的碟片
					boolean flag4=false;
					for (int i = 0; i < states.length; i++) {
						if(states[i]==0 && names[i]!=null){//说明有可借的碟片
							flag4=true;
						
						}
					}
					
					if(flag4){//展示店内碟片信息
						System.out.println("序号\t碟片名称\t\t借出日期\t\t借出次数\t\t借出状态");
						for (int i = 0; i < names.length; i++) {
							String state="可借";
							String count=counts[i]+"次";
							if(states[i]==1){
								state="已借出";
							}
							String date=dates[i]+"日";
							if(states[i]==0){
								date="";
							}
							if(names[i]!=null){
								System.out.println((i+1)+"\t《"+names[i]+"》\t"+date+"\t\t"+count+"\t\t"+state);
							}
							
						}
						boolean flag5=false;
						boolean flag6=false;
						
						do {
							System.out.print("请选择你要借的碟片编号：");
							int num1 = input.nextInt();
							
							for (int i = 0; i < names.length; i++) {
								
								if ((i + 1) == num1 && states[i]==0 && names[i]!=null) {//说明找到了要借的碟片编号并且状态为可借
									flag5 = true;
									flag6=true;
								}
							}
							if (flag5 && flag6) {
								
									System.out.print("请输入碟片借出的日期（1-31之间）：");
									int date = input.nextInt();
									
									//判断输入的日期是否在1-31之间
									while(date>31 || date<1){
										System.out.print("您输入的日期有误，请重新输入（1-31之间）：");
										date = input.nextInt();
									}
									
										states[num1-1]=1; //找到碟片编号后，改变它的借出状态，
										dates[num1-1]=date;//改变它的借出日期
										counts[num1-1]++;//改变它的借出次数
										
									System.out.println("借出成功！");
									
									flag6=false;
								

							} else {//表示碟片不能借

								System.out.print("您要找的碟片不能借，请重新输入!\n");
								flag6=true;
							}
						} while (flag6);
						
					}else{
						
						System.out.println("店内没有可以借的碟片！");
					}
					flag4=false;
					
					continue;
					
					
				case "5"://5.归还碟片
					System.out.println("***归还碟片***");
					
					String ll="";
					do {
						//先循环判断店里有没有可以归还的碟片
						boolean flag5 = false;
						boolean flag6 = false;
						for (int i = 0; i < names.length; i++) {

							if (names[i] != null && states[i] == 1) {//缩小数组的范围
								flag5 = true;

							}

						}
						if (flag5) {
							int num1;
							int index1 = -1;
							System.out.print("选择要归还的碟片编号：");
							num1 = input.nextInt();
							for (int i = 0; i < names.length; i++) {
								if (names[i] == null) {
									index1 = i;
									break;
								}
							}
							while (num1 < 1 || num1 > index1) {
								System.out.print("输入的碟片编号不正确，请重新输入：");
								num1 = input.nextInt();
							}

							int returndate;
							if (states[num1 - 1] == 1) {
								System.out.print("请输入碟片归还的日期（1-31之间）：");
								returndate = input.nextInt();
								//判断日期是否在1-31之间
								while (returndate < 1 || returndate > 31) {
									System.out
											.print("您输入的日期不正确，请重新输入（1-31之间）：");
									returndate = input.nextInt();
								}
								//判断归还日期是否大于借出日期
								while (returndate < dates[num1 - 1]) {
									System.out.print("您输入的归还日期小于借出日期，请重新输入：");
									returndate = input.nextInt();
								}
								int yingfu = returndate - dates[num1 - 1];
								System.out.print("应付金额为："
										+ (returndate - dates[num1 - 1])
										+ "元\n");

								System.out.print("实付金额为：");
								int money = input.nextInt();
								while (money < yingfu) {
									System.out.print("您实付金额小于应付金额，请重新输入：");
									money = input.nextInt();
								}
								int zhaoqian = money - yingfu;
								states[num1 - 1] = 0;
								System.out.println("***************");
								System.out.print("借出日期：" + dates[num1 - 1]
										+ "号\n");
								System.out.print("归还日期：" + returndate + "号\n");
								System.out.print("应付金额为："
										+ (returndate - dates[num1 - 1])
										+ "元\n");
								System.out.print("实付金额为：" + money + "元\n");
								System.out.print("找钱：" + zhaoqian + "元\n");
								System.out.println("***************");
								System.out.println("碟片归还成功！");

							} else {
								System.out.println("碟片在店里，不用归还！");
							}

						} else {
							System.out.println("店里没有需要归还的碟片！");
							break;
						}
						
						System.out.print("还要归还碟片吗？（y/n）：");
						 ll = input.next();
						if (!ll.equals("y")) {
							break;
						}
					} while (ll.equals("y"));
					
					continue;
					
				case "6"://6.退出系统
					System.out.println("谢谢您的使用！");
					
					break;

				
				}
				break;
			}else{
				System.out.println("您的输入有误，请输入1-6之间的整数！");
			}
			
		} while (true);
		

	}

}
