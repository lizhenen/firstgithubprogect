import java.util.Scanner;

public class CopyOfDVDmanager2 {

	/**
	 * ����
	 *  DVD����С�ֻ꣬�ܳ����Ƭ6�ţ�
	 * һ�ŵ�Ƭÿ��1Ԫ ��������ϵͳ 
	 * ���DVD���鿴DVD��ɾ��DVD�����DVD���黹DVD
	 * 
	 * ������
	 *      1.��Ƭ������Щ��Ϣ�� 
	 * 		���ƣ�������ڣ�������������״̬ 
	 * 		2.���ݳ�ʼ��
	 * 
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String[] names = {"����������","�����","����A��",null,null,null};// ��Ƭ������
		int[] dates = {3,4,2,0,0,0}; // ��Ƭ�������
		int[] counts = {20,10,3,0,0,0};// �������
		int[] states = {1,0,1,0,0,0};// ���״̬,1��������0����ɽ�
		//���ݳ�ʼ��
		
		
		do {
			// ����ϵͳ������
			System.out.println("***************************************");
			System.out.println("***********��ӭ����DvD����С��***********");
			System.out.println("\t\t1.�鿴��Ƭ");
			System.out.println("\t\t2.��ӵ�Ƭ");
			System.out.println("\t\t3.ɾ����Ƭ");
			System.out.println("\t\t4.�����Ƭ");
			System.out.println("\t\t5.�黹��Ƭ");
			System.out.println("\t\t6.�˳�ϵͳ");
			System.out.println("***************************************");
			System.out.print("��ѡ��");
			String choose = input.next();
			if("1".equals(choose)||"2".equals(choose)||"3".equals(choose)||"4".equals(choose)||"5".equals(choose)||"6".equals(choose)){
				switch (choose) {
				case "1"://1.�鿴��Ƭ
					System.out.println("***�鿴��Ƭ***");
					//��������
					System.out.println("���\t��Ƭ����\t\t�������\t\t�������\t\t���״̬");
					for (int i = 0; i < names.length; i++) {
						String state="�ɽ�";
						String count=counts[i]+"��";
						if(states[i]==1){
							state="�ѽ��";
						}
						String date=dates[i]+"��";
						if(states[i]==0){
							date="";
						}
						if(names[i]!=null){
							System.out.println((i+1)+"\t��"+names[i]+"��\t"+date+"\t\t"+count+"\t\t"+state);
						}
						
					}

					System.out.println("****************************************");
					continue;
				case "2"://2.��ӵ�Ƭ
					System.out.println("***��ӵ�Ƭ***");
					boolean flag=false;
					System.out.print("��������Ҫ��ӵĵ�Ƭ���ƣ�");
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
						System.out.println("��ӳɹ���");
					}else{
						System.out.println("δ��ӳɹ���ϵͳ������");
					}
					
					System.out.println("****************************************");
					continue;
				case "3"://3.ɾ����Ƭ
					System.out.println("***ɾ����Ƭ***");
					boolean flag2=false;
					boolean flag3=false;
					int index=-1;
					
					boolean flag7=false;
					
					do {
						System.out.print("��������Ҫɾ���ĵ�Ƭ��ţ�");
						int num = input.nextInt();
						for (int i = 0; i < names.length; i++) {
							if (names[i] == null) {
								index = i;
								break;
							}
						}
						while (num < 1 || num > index) {
							System.out.print("Ҫɾ���ĵ�Ƭ��Ų���ȷ�����������룺");
							num = input.nextInt();
						}
						for (int i = 0; i < names.length; i++) {
							if (i == num - 1) {//˵����ѭ�����ҵ���������
								if (states[i] == 0) {//��ʾ��Ƭ�ɽ裬˵����Ƭ�ڵ�����Խ���ɾ������
									flag2 = true;
									index = num;
									break;
								} else {//��ʾ��Ƭ�Ѿ���������ڵ�������Խ���ɾ������
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
							System.out.println("ɾ���ɹ���");

							System.out.print("������ɾ����Ƭ��y/n������");
							String choose2 = input.next();
							if ("y".equals(choose2)) {
								flag7=true;
							} else {
								break;
							}

						} else {
							if (flag3) {
								System.out.println("��Ƭ�Ѿ������������ɾ����");
							} else {
								System.out.println("ɾ��ʧ�ܣ���Ҫɾ���ı�Ų����ڣ�");
							}

						}
					} while (flag7);
					continue;
				case "4"://4.�����Ƭ
					System.out.println("***�����Ƭ***");
					//��ѭ���жϵ��ﻹ��û�пɽ�ĵ�Ƭ
					boolean flag4=false;
					for (int i = 0; i < states.length; i++) {
						if(states[i]==0 && names[i]!=null){//˵���пɽ�ĵ�Ƭ
							flag4=true;
						
						}
					}
					
					if(flag4){//չʾ���ڵ�Ƭ��Ϣ
						System.out.println("���\t��Ƭ����\t\t�������\t\t�������\t\t���״̬");
						for (int i = 0; i < names.length; i++) {
							String state="�ɽ�";
							String count=counts[i]+"��";
							if(states[i]==1){
								state="�ѽ��";
							}
							String date=dates[i]+"��";
							if(states[i]==0){
								date="";
							}
							if(names[i]!=null){
								System.out.println((i+1)+"\t��"+names[i]+"��\t"+date+"\t\t"+count+"\t\t"+state);
							}
							
						}
						boolean flag5=false;
						boolean flag6=false;
						
						do {
							System.out.print("��ѡ����Ҫ��ĵ�Ƭ��ţ�");
							int num1 = input.nextInt();
							
							for (int i = 0; i < names.length; i++) {
								
								if ((i + 1) == num1 && states[i]==0 && names[i]!=null) {//˵���ҵ���Ҫ��ĵ�Ƭ��Ų���״̬Ϊ�ɽ�
									flag5 = true;
									flag6=true;
								}
							}
							if (flag5 && flag6) {
								
									System.out.print("�������Ƭ��������ڣ�1-31֮�䣩��");
									int date = input.nextInt();
									
									//�ж�����������Ƿ���1-31֮��
									while(date>31 || date<1){
										System.out.print("������������������������루1-31֮�䣩��");
										date = input.nextInt();
									}
									
										states[num1-1]=1; //�ҵ���Ƭ��ź󣬸ı����Ľ��״̬��
										dates[num1-1]=date;//�ı����Ľ������
										counts[num1-1]++;//�ı����Ľ������
										
									System.out.println("����ɹ���");
									
									flag6=false;
								

							} else {//��ʾ��Ƭ���ܽ�

								System.out.print("��Ҫ�ҵĵ�Ƭ���ܽ裬����������!\n");
								flag6=true;
							}
						} while (flag6);
						
					}else{
						
						System.out.println("����û�п��Խ�ĵ�Ƭ��");
					}
					flag4=false;
					
					continue;
					
					
				case "5"://5.�黹��Ƭ
					System.out.println("***�黹��Ƭ***");
					
					String ll="";
					do {
						//��ѭ���жϵ�����û�п��Թ黹�ĵ�Ƭ
						boolean flag5 = false;
						boolean flag6 = false;
						for (int i = 0; i < names.length; i++) {

							if (names[i] != null && states[i] == 1) {//��С����ķ�Χ
								flag5 = true;

							}

						}
						if (flag5) {
							int num1;
							int index1 = -1;
							System.out.print("ѡ��Ҫ�黹�ĵ�Ƭ��ţ�");
							num1 = input.nextInt();
							for (int i = 0; i < names.length; i++) {
								if (names[i] == null) {
									index1 = i;
									break;
								}
							}
							while (num1 < 1 || num1 > index1) {
								System.out.print("����ĵ�Ƭ��Ų���ȷ�����������룺");
								num1 = input.nextInt();
							}

							int returndate;
							if (states[num1 - 1] == 1) {
								System.out.print("�������Ƭ�黹�����ڣ�1-31֮�䣩��");
								returndate = input.nextInt();
								//�ж������Ƿ���1-31֮��
								while (returndate < 1 || returndate > 31) {
									System.out
											.print("����������ڲ���ȷ�����������루1-31֮�䣩��");
									returndate = input.nextInt();
								}
								//�жϹ黹�����Ƿ���ڽ������
								while (returndate < dates[num1 - 1]) {
									System.out.print("������Ĺ黹����С�ڽ�����ڣ����������룺");
									returndate = input.nextInt();
								}
								int yingfu = returndate - dates[num1 - 1];
								System.out.print("Ӧ�����Ϊ��"
										+ (returndate - dates[num1 - 1])
										+ "Ԫ\n");

								System.out.print("ʵ�����Ϊ��");
								int money = input.nextInt();
								while (money < yingfu) {
									System.out.print("��ʵ�����С��Ӧ�������������룺");
									money = input.nextInt();
								}
								int zhaoqian = money - yingfu;
								states[num1 - 1] = 0;
								System.out.println("***************");
								System.out.print("������ڣ�" + dates[num1 - 1]
										+ "��\n");
								System.out.print("�黹���ڣ�" + returndate + "��\n");
								System.out.print("Ӧ�����Ϊ��"
										+ (returndate - dates[num1 - 1])
										+ "Ԫ\n");
								System.out.print("ʵ�����Ϊ��" + money + "Ԫ\n");
								System.out.print("��Ǯ��" + zhaoqian + "Ԫ\n");
								System.out.println("***************");
								System.out.println("��Ƭ�黹�ɹ���");

							} else {
								System.out.println("��Ƭ�ڵ�����ù黹��");
							}

						} else {
							System.out.println("����û����Ҫ�黹�ĵ�Ƭ��");
							break;
						}
						
						System.out.print("��Ҫ�黹��Ƭ�𣿣�y/n����");
						 ll = input.next();
						if (!ll.equals("y")) {
							break;
						}
					} while (ll.equals("y"));
					
					continue;
					
				case "6"://6.�˳�ϵͳ
					System.out.println("лл����ʹ�ã�");
					
					break;

				
				}
				break;
			}else{
				System.out.println("������������������1-6֮���������");
			}
			
		} while (true);
		

	}

}
