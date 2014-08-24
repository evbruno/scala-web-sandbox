package duh.models

abstract sealed class Transaction(amount: Double, date: Option[java.util.Date])

case class Transfer(
  amount: Double,
  date: Option[java.util.Date],
  in: Account,
  out: Account) extends Transaction(amount, date)

case class Payment(amount: Double,
  date: Option[java.util.Date],
  out: Account) extends Transaction(amount, date)

case class Balance(account: String, amount: Double)