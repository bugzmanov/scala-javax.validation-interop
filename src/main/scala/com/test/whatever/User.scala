package com.test.whatever

import annotation.target.field

package object vscala { //http://stackoverflow.com/questions/3769624/annotating-constructor-parameters-in-scala
  type Size = javax.validation.constraints.Size @field
  type Min = javax.validation.constraints.Min @field
  type Max = javax.validation.constraints.Max @field
  type Valid = javax.validation.Valid @field
}

case class User(
  @vscala.Min(0) @vscala.Max(100) age: Int,
  @vscala.Valid addr: Address
)

case class Address(
  @vscala.Size(min =2, max = 10) city: String
)