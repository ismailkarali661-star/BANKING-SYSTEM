# Banking System – UML Design Explanation

## Class Diagram Overview

### Account (Abstract Class)
- Fields:
    - accountNumber : String
    - balance : double
    - transactions : List<Transaction>
- Methods:
    - deposit(double)
    - withdraw(double) (abstract)
    - getBalance()
- Purpose:
    - Defines common behavior for all account types
    - Uses abstraction and encapsulation

### SavingsAccount (extends Account)
- Overrides:
    - withdraw(double)
- Rule:
    - Does not allow overdraft
- Relationship:
    - Inheritance from Account

### CheckingAccount (extends Account)
- Overrides:
    - withdraw(double)
- Rule:
    - Allows limited overdraft
- Relationship:
    - Inheritance from Account

### Transaction
- Fields:
    - type : String
    - amount : double
    - timestamp : LocalDateTime
- Purpose:
    - Represents a banking operation
- Relationship:
    - Composition (Account has a list of Transactions)

### Transferable (Interface)
- Method:
    - transfer(Account from, Account to, double amount)
- Purpose:
    - Defines transfer behavior

### BankService (implements Transferable)
- Implements:
    - transfer(...)
- Purpose:
    - Contains business logic
- Relationship:
    - Implements interface
    - Uses Account objects

## OOP Principles Used
- Abstraction: Account abstract class
- Inheritance: SavingsAccount, CheckingAccount
- Polymorphism: Overridden withdraw methods
- Encapsulation: Private/protected fields
- Composition: Account contains Transaction list
- Interface: Transferable
## Usage Example

1. Create accounts (Savings / Checking)
2. Deposit and withdraw money
3. Transfer money using BankService
4. View transaction history

Run `Main.java` to see a simple console demonstration.
