package com.test.whatever

import javax.validation.Validator

object Demo {
  private val validator: Validator = {
      val configuration = javax.validation.Validation.byDefaultProvider().configure()
      val factory = configuration.buildValidatorFactory()
      factory.getValidator
    }

  def main(str: Array[String]) {
    validateUser(User(age = -5, addr = Address(city = "1")))
  }

  private def validateUser(user: User) {
    import scala.collection.JavaConversions._
    val result = validator.validate(user)
      for (value <- result) {
        System.out.println(value)
      }
    }
  }