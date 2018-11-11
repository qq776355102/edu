package com.tedu.dao.useridentityupgrade.mapper;

import java.util.List;

import com.tedu.domain.useridentityupgrade.UserIdentityUpgrade;

public interface UserIdentityUpgradeMapper {
    /**
     *
     * @mbg.generated 2018-09-02
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-09-02
     */
    int insert(UserIdentityUpgrade record);

    /**
     *
     * @mbg.generated 2018-09-02
     */
    int insertSelective(UserIdentityUpgrade record);

    /**
     *
     * @mbg.generated 2018-09-02
     */
    UserIdentityUpgrade selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-09-02
     */
    int updateByPrimaryKeySelective(UserIdentityUpgrade record);

    /**
     *
     * @mbg.generated 2018-09-02
     */
    int updateByPrimaryKey(UserIdentityUpgrade record);
    
    List<UserIdentityUpgrade> getFutureIdentityUpgrades();
}