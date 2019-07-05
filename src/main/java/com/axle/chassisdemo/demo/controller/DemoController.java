package com.axle.chassisdemo.demo.controller;

import com.axle.chassisdemo.demo.entity.DemoEdittedRecord;
import com.axle.chassisdemo.demo.entity.UsersDO;
import ke.axle.chassis.ChasisResource;
import ke.axle.chassis.utils.LoggerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@RestController
@RequestMapping(value = "/demo")
public class DemoController extends ChasisResource<UsersDO, Long, DemoEdittedRecord> {

      public DemoController(LoggerService loggerService, EntityManager entityManager) {
           super(loggerService, entityManager);
      }
}
