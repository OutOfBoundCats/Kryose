package com.kryose.kryose.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="resource")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "credits")
    private Long credits;
    @Column(name = "username")
    private String username;
    @Column(name="start_date")
    private Date startdate;
    @Column(name = "end_date")
    private String endDate;
    @Column(name = "current_plan")
    private String currentPlan;
    @Column(name = "current_plan_credits")
    private Long currentPlanCredits;
    @Column(name = "current_plan_surcharge")
    private Long currentPlanSurcharge;
    @Column(name = "surcharge_amount")
    private Long SurchargeAmount;
    @OneToMany(mappedBy = "myResource",fetch = FetchType.LAZY)
    private List<MyUserDetails> myUserDetailsList;

    public Resource() {
    }


    public Resource(Long credits, String username, Date startdate, String endDate, String currentPlan, Long currentPlanCredits, Long currentPlanSurcharge, Long surchargeAmount) {
        this.credits = credits;
        this.username = username;
        this.startdate = startdate;
        this.endDate = endDate;
        this.currentPlan = currentPlan;
        this.currentPlanCredits = currentPlanCredits;
        this.currentPlanSurcharge = currentPlanSurcharge;
        SurchargeAmount = surchargeAmount;
    }

    public List<MyUserDetails> getMyUserDetailsList() {
        return myUserDetailsList;
    }

    public void setMyUserDetailsList(List<MyUserDetails> myUserDetailsList) {
        this.myUserDetailsList = myUserDetailsList;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", credits=" + credits +
                ", username='" + username + '\'' +
                ", startdate=" + startdate +
                ", endDate='" + endDate + '\'' +
                ", currentPlan='" + currentPlan + '\'' +
                ", currentPlanCredits=" + currentPlanCredits +
                ", currentPlanSurcharge=" + currentPlanSurcharge +
                ", SurchargeAmount=" + SurchargeAmount +
                '}';
    }

    public Long getId() {
        return id;
    }


    public Long getCredits() {
        return credits;
    }

    public void setCredits(Long credits) {
        this.credits = credits;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCurrentPlan() {
        return currentPlan;
    }

    public void setCurrentPlan(String currentPlan) {
        this.currentPlan = currentPlan;
    }

    public Long getCurrentPlanCredits() {
        return currentPlanCredits;
    }

    public void setCurrentPlanCredits(Long currentPlanCredits) {
        this.currentPlanCredits = currentPlanCredits;
    }

    public Long getCurrentPlanSurcharge() {
        return currentPlanSurcharge;
    }

    public void setCurrentPlanSurcharge(Long currentPlanSurcharge) {
        this.currentPlanSurcharge = currentPlanSurcharge;
    }

    public Long getSurchargeAmount() {
        return SurchargeAmount;
    }

    public void setSurchargeAmount(Long surchargeAmount) {
        SurchargeAmount = surchargeAmount;
    }
}
