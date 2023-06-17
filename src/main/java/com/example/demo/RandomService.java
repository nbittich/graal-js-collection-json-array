package com.example.demo;

import java.util.Collection;
import java.util.List;

public class RandomService {
  public void randomStuffList(List<String> collectionOfUuids) {
    randomStuffCollection(collectionOfUuids);
  }

  public void randomStuffCollection(Collection<String> collectionOfUuids) {
    for (var uuid : collectionOfUuids) {
      System.out.println("UUID %s".formatted(uuid));
    }
  }
}
