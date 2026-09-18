# Java-Expense-Tracker

A Java-based personal expense management system that helps users track daily expenses, manage income and budgets, and analyze spending habits.

---

## Project Overview

Expense Controller is a console-based Java application developed to help students and individuals manage their personal finances efficiently.

The application allows users to record expenses, categorize transactions, set monthly budgets, track income, and generate expense reports. It uses Object-Oriented Programming, modular architecture, and file handling to provide a simple and organized financial management solution.

---

## Problem Statement

Students and individuals often spend money on food, transportation, education, shopping, and entertainment without maintaining proper records.

As a result, it becomes difficult to understand spending patterns, control unnecessary expenses, and manage monthly budgets effectively.

Expense Controller solves this problem by providing a centralized system to record, manage, and analyze personal financial transactions.

---

## Objectives

* To maintain records of daily expenses.
* To categorize expenses for better financial understanding.
* To manage monthly income and spending budgets.
* To calculate total expenses and remaining balance.
* To generate category-wise expense reports.
* To provide a simple and user-friendly financial management system.
* To demonstrate Java Object-Oriented Programming and modular design concepts.

---

## Features

### 1. Expense Management

* Add new expenses.
* View all recorded expenses.
* Update existing expense details.
* Delete expenses.
* Validate expense amounts and input data.

### 2. Income and Budget Management

* Add or update monthly income.
* Set a monthly spending budget.
* Calculate remaining budget.
* Calculate remaining balance after expenses.
* Detect whether expenses exceed the set budget.

### 3. Expense Reports and Analysis

* Calculate total expenses.
* Display category-wise spending.
* Identify the highest spending category.
* Generate a summary of income, expenses, and balance.

### 4. Data Storage

* Save expense records locally using text files.
* Load previously saved records when the application starts.
* Maintain data persistence between application sessions.

### 5. Input Validation

* Prevent negative or zero expense amounts.
* Handle invalid numeric inputs.
* Validate empty fields.
* Handle invalid menu choices.

---

## Technologies Used

| Technology                  | Purpose                                |
| --------------------------- | -------------------------------------- |
| Java 21+                    | Core programming language              |
| Object-Oriented Programming | Modular application design             |
| ArrayList                   | Store and manage expense records       |
| File Handling               | Save and load application data         |
| VS Code                     | Development environment                |
| Git & GitHub                | Version control and project submission |

---

## Project Architecture

The project follows a modular layered architecture.

```text
+-----------------------------+
|       User Interface        |
|       Main.java             |
|       ExpenseTracker.java   |
+-------------+---------------+
              |
              v
+-----------------------------+
|      Controller Layer       |
|    ExpenseController.java   |
+-------------+---------------+
              |
              v
+-----------------------------+
|       Service Layer         |
| ExpenseService.java         |
| BudgetService.java          |
| ReportService.java          |
+-------------+---------------+
              |
              v
+-----------------------------+
|        Model Layer          |
| Expense.java                |
+-------------+---------------+
              |
              v
+-----------------------------+
|        Data Layer           |
| FileManager.java            |
| expenses.txt                |
| settings.txt                |
+-----------------------------+
```

---

## Project Structure

```text
ExpenseController/
│
├── src/
│   ├── Main.java
│   ├── ExpenseTracker.java
│   ├── ExpenseController.java
│   ├── Expense.java
│   ├── ExpenseService.java
│   ├── BudgetService.java
│   ├── ReportService.java
│   ├── FileManager.java
│   └── InputValidator.java
│
├── data/
│   ├── expenses.txt
│   └── settings.txt
│
├── tests/
│   └── TestCases.md
│
├── README.md
├── statement.md
```

---

## Class Description

| Class                    | Responsibility                                     |
| ------------------------ | -------------------------------------------------- |
| `Main.java`              | Starting point of the application                  |
| `ExpenseTracker.java`    | Initializes the Expense Controller                 |
| `ExpenseController.java` | Controls user interaction and application workflow |
| `Expense.java`           | Represents an individual expense                   |
| `ExpenseService.java`    | Handles expense CRUD operations                    |
| `BudgetService.java`     | Manages income and budget calculations             |
| `ReportService.java`     | Generates expense reports and category analysis    |
| `FileManager.java`       | Handles saving and loading data                    |
| `InputValidator.java`    | Validates user input and prevents errors           |

---

## How to Run the Project

### Prerequisites

* Java Development Kit (JDK) 21 or above.
* Visual Studio Code or any Java-supported IDE.
* Java Extension Pack for VS Code (recommended).

### Step 1: Clone the Repository

```bash
git clone https://github.com/yourusername/ExpenseController.git
```

Replace `yourusername` with your GitHub username.

### Step 2: Open the Project

Open the project folder in VS Code.

### Step 3: Compile the Project

Open the VS Code terminal and run:

```powershell
javac -d out src/*.java
```

### Step 4: Run the Application

```powershell
java -cp out Main
```

Alternatively:

```powershell
java -cp out ExpenseTracker
```

---

## Application Menu

```text
=================================
       EXPENSE CONTROLLER
=================================

1. Add Expense
2. View All Expenses
3. Update Expense
4. Delete Expense
5. Set Monthly Budget
6. Add/Update Income
7. View Expense Report
8. Save Data
9. Exit

Enter your choice:
```

---

## Sample Usage

### Adding an Expense

```text
Amount: 150
Category: Food
Description: Lunch
Date (YYYY-MM-DD): 2026-09-18

Added: 1 | ₹150.00 | Food | Lunch | 2026-09-18
```

### Viewing Expense Report

```text
Total Expenses: ₹6,500.00
Income: ₹10,000.00
Balance: ₹3,500.00
Remaining Budget: ₹1,500.00
Highest Spending Category: Food

Category-wise Analysis:
Food: ₹2,500.00
Transport: ₹1,200.00
Shopping: ₹1,800.00
Education: ₹1,000.00
```

---

## Data Storage

The application stores data locally in the `data` folder.

### expenses.txt

Stores individual expense records.

```text
1|150.0|Food|Lunch|2026-09-18
2|50.0|Transport|Bus|2026-09-18
```

### settings.txt

Stores monthly income and budget information.

---

## Functional Requirements

The system provides the following major functional modules:

1. Expense Management
2. Income and Budget Management
3. Expense Reports and Analysis
4. Data Storage and Persistence

---

## Non-Functional Requirements

| Requirement     | Description                                             |
| --------------- | ------------------------------------------------------- |
| Usability       | Simple menu-driven interface for easy interaction       |
| Reliability     | Prevents invalid transactions and handles errors        |
| Performance     | Efficient calculations using Java collections           |
| Maintainability | Modular classes with separate responsibilities          |
| Error Handling  | Handles invalid inputs and file-related errors          |
| Scalability     | Can be extended with databases and graphical interfaces |

---

## Testing

The project includes basic test cases for validating application functionality.

Testing covers:

* Adding valid expenses.
* Rejecting negative amounts.
* Handling invalid input.
* Updating expenses.
* Deleting expenses.
* Managing budgets.
* Generating reports.
* Saving and loading data.

Detailed test cases are available in:

```text
tests/TestCases.md
```

---

## Future Enhancements

The following features can be added in future versions:

* MySQL or SQLite database integration.
* Graphical User Interface using Java Swing or JavaFX.
* User login and authentication.
* Monthly expense charts and graphs.
* Export reports to PDF or CSV.
* Automatic budget notifications.
* AI-based spending analysis and recommendations.
* Mobile application version.

---

## Learning Outcomes

Through this project, the following concepts were applied:

* Object-Oriented Programming.
* Classes and Objects.
* Encapsulation.
* ArrayList and Collections.
* File Handling.
* Exception Handling.
* Modular Programming.
* Input Validation.
* Basic Software Architecture.
* Git and GitHub Version Control.

---

## Academic Context

This project is developed as part of the VITyarthi Build Your Own Project evaluation.

The project focuses on identifying a real-world problem, designing a technical solution, implementing the solution using Java concepts, and documenting the complete development process.

---

## Author

**Ansh Tiwari**

25BAI10334

B.Tech Computer Science and Engineering (AI & ML)

VIT Bhopal University

---

