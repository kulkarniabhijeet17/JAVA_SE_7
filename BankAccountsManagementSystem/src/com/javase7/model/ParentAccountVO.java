package com.javase7.model;

import java.util.List;

public class ParentAccountVO {
	private int parentAccNo;
	private String name;
	private String AccType;
	private List<LinkedDepositVO> linkedDeposits;

	public int getParentAccNo() {
		return parentAccNo;
	}

	public void setParentAccNo(int parentAccNo) {
		this.parentAccNo = parentAccNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccType() {
		return AccType;
	}

	public void setAccType(String accType) {
		AccType = accType;
	}

	public List<LinkedDepositVO> getLinkedDeposits() {
		return linkedDeposits;
	}

	public void setLinkedDeposits(List<LinkedDepositVO> linkedDeposits) {
		this.linkedDeposits = linkedDeposits;
	}

	public boolean equals(Object object) {
		boolean isEqual = false;
		ParentAccountVO otherAccount = (ParentAccountVO) object;
		if ((this.parentAccNo == otherAccount.parentAccNo) && (this.AccType.equals(otherAccount.getAccType())
				&& (this.linkedDeposits.equals(otherAccount.getLinkedDeposits())))) {
			isEqual = true;
		}

		return isEqual;
	}

	@Override
	public String toString() {
		return "ParentAccountVO [parentAccNo=" + parentAccNo + ", name=" + name + ", AccType=" + AccType
				+ ", linkedDeposits=" + linkedDeposits + "]";
	}
}