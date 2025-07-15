# 🏥 Hospital Management System (Mini JDBC Project)

A basic Hospital Management System built using Java and JDBC for practice purposes. This mini project demonstrates CRUD operations for managing doctors and patients stored in a MySQL database.

---

## 📁 Project Structure

<pre> 
  Hospital-management-sys/
│
├── .idea/ # IntelliJ config files
├── out/ # Compiled output (ignore)
├── src/
│ ├── Database_config/
│ │ ├── hospital_sys.sql # SQL script to create and populate the database
│ │ └── schema_hospital_sys.png # Database schema image
│ ├── Doctor.java # Doctor class - model and logic
│ ├── Patient.java # Patient class - model and logic
│ └── Main.java # Entry point with menu/operations
</pre>


---

## ⚙️ Technologies Used

- Java (JDK 8 or above)
- JDBC (Java Database Connectivity)
- MySQL
- IntelliJ IDEA (Recommended IDE)

---

## 🧠 Features

- Add new doctors and patients
- View existing doctors and patients
- Update patient/doctor details
- Delete records
- Simple CLI-based menu navigation

---

## 🗄️ Database Setup

1. Open MySQL Workbench (or any SQL client).
2. Execute the SQL file provided:
    <pre>
   src/Database_config/hospital_sys.sql
 </pre>
 
3. This will create the necessary tables and insert some initial data.
4. Make sure your MySQL JDBC URL, username, and password in the code are correctly set.

## ▶️ How to Run
1. Clone this repository:
<pre>
  git clone https://github.com/Chetanpatil03/Hospital-management-sys.git
cd Hospital-management-sys
</pre>

2. Open the project in IntelliJ IDEA (or any Java IDE).
3. Ensure your MySQL server is running.
4. Run Main.java — this file contains the main menu for interaction.

## Database Schema

<img width="1920" height="1080" alt="schema_hospital_sys" src="https://github.com/user-attachments/assets/033a5a81-ec5c-4c86-bb41-f2f9d761d3ad" />


## 🙋‍♂️ Author <br>
Chetan Patil <br>
Mini project for personal learning (Java + MySQL)
