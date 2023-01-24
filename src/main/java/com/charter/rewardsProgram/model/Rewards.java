package com.charter.rewardsProgram.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Rewards {
    private long customerId;
	private long lastMonthRewardPoints;
    private long lastSecondMonthRewardPoints;
    private long lastThirdMonthRewardPoints;
    private long totalRewards;

	public void setLastMonthRewardPoints(long lastMonthRewardPoints) {
		this.lastMonthRewardPoints = lastMonthRewardPoints;
	}

	public void setLastSecondMonthRewardPoints(long lastSecondMonthRewardPoints) {
		this.lastSecondMonthRewardPoints = lastSecondMonthRewardPoints;
	}

	public void setLastThirdMonthRewardPoints(long lastThirdMonthRewardPoints) {
		this.lastThirdMonthRewardPoints = lastThirdMonthRewardPoints;
	}

	public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public void setTotalRewards(long totalRewards) {
        this.totalRewards = totalRewards;
    }

	@Override
	public String toString() {
		return "Rewards{" + "customerId=" + customerId + ", lastMonthRewardPoints=" + lastMonthRewardPoints + ", lastSecondMonthRewardPoints=" + lastSecondMonthRewardPoints + ", lastThirdMonthRewardPoints=" + lastThirdMonthRewardPoints + ", totalRewards=" + totalRewards + '}';
	}
}
