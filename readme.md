# 📚 Library Management System (Core Java)

### 💡 Overview
This is a **console-based Library Management System** built using **Core Java**, showcasing strong fundamentals in **Object-Oriented Programming (OOP)**, **Collections**, and **File Handling**.  
It allows managing books, members, and borrowing operations efficiently.

---

### 🚀 Features
- 📘 Add new books  
- 👤 Register library members  
- 📖 Borrow and return books  
- 🔍 Search books by title or author  
- 💾 Persistent storage using serialized files (`.ser`)  
- 🧠 Modular design using **model**, **service**, and **util** packages  

---

### 🧩 Technologies & Concepts
| Category | Technology / Concept |
|-----------|---------------------|
| Language | Core Java |
| OOP Concepts | Encapsulation, Classes, Objects |
| Data Storage | File Handling (`ObjectInputStream`, `ObjectOutputStream`) |
| Collections | HashMap, ArrayList |
| IDE Recommended | IntelliJ IDEA / Eclipse / VS Code |

---

### 🗂 Project Structure
``` bash
LibraryManagementSystem/
│
├── model/
│ ├── Book.java
│ └── Member.java
│
├── service/
│ └── LibraryService.java
│
├── util/
│ └── FileUtil.java
│
└── Main.java 
```
---

### ⚙️ How to Run
1. Clone the repository:
```bash
git clone https://github.com/Lakshit2604/BYOP-Java.git
cd BYOP-Java
javac -d . model/*.java util/*.java service/*.java Main.java
java Main