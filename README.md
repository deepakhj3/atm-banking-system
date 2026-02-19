# ATM Banking Project
# 🏦 Secure Digital ATM Banking System

A full-stack ATM Banking System developed using Spring Boot for backend and HTML, CSS, JavaScript for frontend.

## 🚀 Live Features

- 🔐 User Login (Account Number & PIN)
- 💰 Check Account Balance
- ➕ Deposit Money
- ➖ Withdraw Money
- 📄 View Transaction History
- 🔄 Loading Spinner for Better User Experience
- 🎨 Modern Glassmorphism UI Design
- 🌐 REST API Integration

---

## 🛠️ Tech Stack

### Backend:
- Java
- Spring Boot
- Spring Data JPA
- H2 Database
- REST APIs

### Frontend:
- HTML5
- CSS3
- JavaScript (Fetch API)

---

## 🏗️ Project Architecture

Controller → Service → Repository → Entity

- ATMController – Handles REST endpoints
- ATMService – Business logic
- AccountRepository & TransactionRepository – Database operations
- Account & Transaction – Entity models

---

## 💡 How It Works

1. User logs in using Account Number and PIN.
2. System validates credentials.
3. User can perform:
   - Balance check
   - Deposit
   - Withdraw
   - View transaction history
4. All transactions are stored in the database.
5. UI dynamically updates using JavaScript fetch calls.

---

## 📂 Project Structure
src
├── main
│ ├── java/com/example/demo
│ │ ├── controller
│ │ ├── service
│ │ ├── repository
│ │ └── entity
│ └── resources
│ ├── static (index.html)
│ └── application.properties
---

## ▶️ How To Run

1. Clone the repository
2. Open in IntelliJ / Eclipse
3. Run `DemoApplication`
4. Open browser:https://atm-banking-system-3ugv.onrender.com/
5.UserID == 1001,1002,1003.
6.Password == 1234,2222,3333.
 

---

## 🎯 Future Enhancements

- JWT Authentication
- Account creation feature
- Money transfer between accounts
- Deployment to cloud (Render)

---

## 👨‍💻 Author

Deepak HJ  
Aspiring Full Stack Java Developer



