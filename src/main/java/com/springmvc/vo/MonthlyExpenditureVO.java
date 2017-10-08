package com.springmvc.vo;

import com.springmvc.entity.MonthlyExpenditure;

import java.time.Month;
import java.time.Year;
import java.util.List;

/**
 * Created by jalajtagra on 08/10/17.
 */
public class MonthlyExpenditureVO {

    private List<MonthlyExpenditure> monthlyExpenditureList;

    private Month month;

    private Year year;

    public List<MonthlyExpenditure> getMonthlyExpenditureList() {
        return monthlyExpenditureList;
    }

    public void setMonthlyExpenditureList(List<MonthlyExpenditure> monthlyExpenditureList) {
        this.monthlyExpenditureList = monthlyExpenditureList;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }
}
