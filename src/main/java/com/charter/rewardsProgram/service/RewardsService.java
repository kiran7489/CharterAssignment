package com.charter.rewardsProgram.service;


import com.charter.rewardsProgram.model.Rewards;

public interface RewardsService {
    public Rewards getRewardsByCustomerId(Long customerId);
}
