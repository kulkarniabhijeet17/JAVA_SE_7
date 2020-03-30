package com.javase7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.javase7.exception.BankOrganizerException;
import com.javase7.model.LinkedDepositVO;
import com.javase7.model.ParentAccountVO;

public class BankDepositAccountOrganizer {
	public static void main(String[] args) {
		try {
			Map<String, List<ParentAccountVO>> trainDetailsVOMap = processBankDepositData("accountdetails.txt");
			Iterator it = trainDetailsVOMap.entrySet().iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
			}
		} catch (BankOrganizerException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Map<String, List<ParentAccountVO>> processBankDepositData(String filePath)
			throws BankOrganizerException, FileNotFoundException {
		Map<String, List<ParentAccountVO>> finalMap = new HashMap<String, List<ParentAccountVO>>();
		File file = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			BankDepositAccountOrganizer bao = new BankDepositAccountOrganizer();

			String s1 = null;
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			System.out.println("filePath" + filePath);
			file = new File(filePath);
			System.out.println(file.exists());
			if (file.exists()) {
				fr = new FileReader(file);
				br = new BufferedReader(fr);

				try {
					List<ParentAccountVO> pst1 = new ArrayList<ParentAccountVO>();
					List<ParentAccountVO> pst2 = new ArrayList<ParentAccountVO>();
					List<ParentAccountVO> pst3 = new ArrayList<ParentAccountVO>();

					while ((s1 = br.readLine()) != null) {
						String[] values = s1.split(",");
						for (String s : values)
							System.out.println(s);
						boolean valResult = validateData(values);
						System.out.println(" validation Result is : " + valResult);

						ParentAccountVO po = new ParentAccountVO();

						if (!valResult) {
							String message = "validation failed";
							throw new BankOrganizerException(message);
						} else {
							List<LinkedDepositVO> lst = new ArrayList<LinkedDepositVO>();

							LinkedDepositVO ld = new LinkedDepositVO();
							int depositamount = Integer.parseInt(values[4]);
							ld.setDepositAmount(depositamount);
							String da = values[5];
							Date date1 = formatter.parse(da);
							String db = values[6];
							Date date2 = formatter.parse(db);
							System.out.println("Deposit Start Date" + formatter.format(date1));
							System.out.println("Deposit Maturity Date" + formatter.format(date2));
							System.out.println("Deposit Amount" + Integer.parseInt(values[4]));
							System.out.println("Deposit No" + values[3]);
							System.out.println(
									"Maturity Amount" + bao.calculateMaturityAmount(date1, date2, depositamount));
							ld.setLinkedDepositNo(values[3]);
							ld.setDepositStartDate(date1);
							ld.setDepositMaturityDate(date2);
							ld.setMaturityAmount(bao.calculateMaturityAmount(date1, date2, depositamount));

							boolean flag = false;

							if (values[2].equals("WM")) {
								for (ParentAccountVO parentAccountVO : pst1) {
									if (parentAccountVO.getParentAccNo() == Integer.parseInt(values[0])) {
										flag = true;
										List<LinkedDepositVO> linkedDepositVOs = parentAccountVO.getLinkedDeposits();
										linkedDepositVOs.add(ld);
									}
								}
							}

							if (values[2].equals("SAV")) {
								for (ParentAccountVO parentAccountVO : pst2) {
									if (parentAccountVO.getParentAccNo() == Integer.parseInt(values[0])) {
										flag = true;
										List<LinkedDepositVO> linkedDepositVOs = parentAccountVO.getLinkedDeposits();
										linkedDepositVOs.add(ld);
									}
								}
							}
							if (values[2].equals("NRI")) {
								for (ParentAccountVO parentAccountVO : pst3) {
									if (parentAccountVO.getParentAccNo() == Integer.parseInt(values[0])) {
										flag = true;
										List<LinkedDepositVO> linkedDepositVOs = parentAccountVO.getLinkedDeposits();
										linkedDepositVOs.add(ld);
									}
								}
							}

							if (!flag) {
								lst.add(ld);
								po.setAccType(values[2]);
								po.setName(values[1]);
								po.setParentAccNo(Integer.parseInt(values[0]));
								po.setLinkedDeposits(lst);
								if (values[2].equals("WM")) {
									pst1.add(po);
								}
								if (values[2].equals("SAV")) {
									pst2.add(po);
								}
								if (values[2].equals("NRI")) {
									pst3.add(po);
								}
							}
						}
					}

					finalMap.put("WM", pst1);
					finalMap.put("SAV", pst2);
					finalMap.put("NRI", pst3);
				} catch (IOException e) {
					throw new BankOrganizerException("FIle io exception: " + e.getMessage());
				}
			} else {
				throw new FileNotFoundException("FIle Not found exception: ");
			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("FIle Not found exception: " + e.getMessage());
		} catch (ParseException e) {
			throw new BankOrganizerException("FIle Parse exception: " + e.getMessage());
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Final Map is " + finalMap.entrySet());
		return finalMap;
	}

	private float calculateMaturityAmount(Date date1, Date date2, int depositamount) {
		float maturity_amount = 0.00f;
		int noofdays = daysBetween(date1, date2);

		System.out.println("noofdays" + noofdays);

		if (noofdays >= 0 && noofdays <= 200) {
			maturity_amount = (float) (depositamount + (depositamount * 6.75 / 100));
		} else if (noofdays >= 201 && noofdays <= 400) {
			maturity_amount = (float) (depositamount + (depositamount * 7.5 / 100));
		} else if (noofdays >= 401 && noofdays <= 600) {
			maturity_amount = (float) (depositamount + (depositamount * 8.75 / 100));
		} else {
			maturity_amount = (float) (depositamount + (depositamount * 10 / 100));
		}

		return maturity_amount;
	}

	public int daysBetween(Date d1, Date d2) {
		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}

	public static boolean validateData(String[] str) {
		boolean result = true;
		// field checks

		if (str[0].isEmpty() || str[1].isEmpty() || str[2].isEmpty() || str[3].isEmpty() || str[4].isEmpty()
				|| str[5].isEmpty()) {
			System.out.println("All fileds are mandatory validation failed");
			result = false;
		}

		if (str[0].charAt(0) == '0') {
			System.out.println("Hello" + str[0].charAt(0));
			System.out.println("account number is not valid");
			result = false;
		} else {
			for (Character c : str[0].toCharArray()) {
				if (!Character.isDigit(c)) {
					result = false;
					System.out.println("account number is not valid");
					break;
				}
			}
		}

		// Account type
		if (!(str[2].equals("WM") || str[2].equals("SAV") || str[2].equals("NRI"))) {
			System.out.println("Type of account is not valid");
			result = false;
		}

		// Linked Deposit validation
		if (!(str[3].startsWith("FD") || str[3].startsWith("RD") || str[3].startsWith("MUT"))) {
			System.out.println("Linked Deposit  account is not valid");
			result = false;
		}

		// Deposit Start date validation
		if (!isValidDate(str[5])) {
			result = false;
		}

		// Deposit Maturity date validation
		if (!isValidDate(str[6])) {
			result = false;
		}

		return result;
	}

	public static boolean isValidDate(String inDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(inDate.trim());
		} catch (ParseException pe) {
			return false;
		}
		return true;
	}
}