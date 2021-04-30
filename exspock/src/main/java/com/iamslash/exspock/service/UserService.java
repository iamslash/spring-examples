package com.iamslash.exspock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class UserService {

  public AssetService assetService;

  public void setAssetService(AssetService assetService) {
    this.assetService = assetService;
  }

  public String getName(Long id) {
    return "iamslash";
  }
  public Long getMoney(Long id) {
    return assetService.getMoney(id);
  }
}
