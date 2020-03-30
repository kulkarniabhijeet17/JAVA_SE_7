package com.javase7.model;

import java.util.Date;

public class LinkedDepositVO {
	private String linkedDepositNo;
	private int depositAmount;
	private Date depositStartDate;
	private Date depositMaturityDate;
	private float maturityAmount;

	public String getLinkedDepositNo() {
		return linkedDepositNo;
	}

	public void setLinkedDepositNo(String linkedDepositNo) {
		this.linkedDepositNo = linkedDepositNo;
	}

	public int getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(int depositAmount) {
		this.depositAmount = depositAmount;
	}

	public Date getDepositStartDate() {
		return depositStartDate;
	}

	public void setDepositStartDate(Date depositStartDate) {
		this.depositStartDate = depositStartDate;
	}

	public Date getDepositMaturityDate() {
		return depositMaturityDate;
	}

	public void setDepositMaturityDate(Date depositMaturityDate) {
		this.depositMaturityDate = depositMaturityDate;
	}

	public float getMaturityAmount() {
		return maturityAmount;
	}

	public void setMaturityAmount(float maturityAmount) {
		this.maturityAmount = maturityAmount;
	}

	public boolean equals(Object object) {
		boolean isEquals = false;
		LinkedDepositVO depositVO = (LinkedDepositVO) object;
		if (this.linkedDepositNo.equals(depositVO.getLinkedDepositNo())
				&& (this.depositAmount == depositVO.getDepositAmount())
				&& (this.depositStartDate.equals(depositVO.getDepositStartDate()))
				&& (this.maturityAmount == depositVO.getMaturityAmount())) {
			isEquals = true;
		}

		return isEquals;
	}

	@Override
	public String toString() {
		return "LinkedDepositVO [linkedDepositNo=" + linkedDepositNo + ", depositAmount=" + depositAmount
				+ ", depositStartDate=" + depositStartDate + ", depositMaturityDate=" + depositMaturityDate
				+ ", maturityAmount=" + maturityAmount + "]";
	}
}