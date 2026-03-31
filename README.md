
# Cryptography Projects (Java)

## Overview

This repository contains a collection of fundamental cryptographic algorithm implementations developed in **Java** as part of a Cryptography course. The project demonstrates both classical and modern encryption techniques, along with supporting mathematical concepts used in secure communication systems.

It showcases a strong understanding of **cryptographic principles, algorithm design, and secure data transformation techniques**.

---

##  Implemented Algorithms & Features

### 1. AES (Advanced Encryption Standard)

* Symmetric encryption algorithm
* Supports secure data encryption and decryption
* Demonstrates block cipher operations and key-based security

###  2. RSA (Rivest–Shamir–Adleman)

* Asymmetric encryption system
* Key pair generation (public & private keys)
* Encryption and decryption using modular arithmetic

###  3. Caesar Cipher

* Classical substitution cipher
* Character shifting based on a fixed key
* Demonstrates foundational cryptography concepts

###  4. Euler’s Totient Function

* Mathematical utility for number theory
* Used in RSA key generation
* Computes φ(n) for encryption algorithms

### 5. Key Generation Module

* Secure generation of cryptographic keys
* Supports RSA key pair creation
* Demonstrates randomness and number theory applications

---

## Tech Stack

* **Language:** Java
* **Paradigm:** Object-Oriented Programming (OOP)
* **Concepts Used:**

  * Symmetric & Asymmetric Cryptography
  * Modular Arithmetic
  * Number Theory
  * Secure Key Generation
  * Data Encoding & Transformation

---

## Project Structure

```
Cryptography-Projects/
│
├── AES/
│   ├── AES.java
│   └── ...
│
├── RSA/
│   ├── RSA.java
│   ├── KeyGeneration.java
│   └── ...
│
├── CaesarCipher/
│   ├── CaesarCipher.java
│   └── ...
│
├── MathUtils/
│   ├── EulerTotient.java
│   └── ...
│
└── README.md
```

---

## How to Run

### 1. Clone the repository

```bash
git clone https://github.com/your-username/Cryptography-Projects.git
cd Cryptography-Projects
```

### 2. Compile the Java files

```bash
javac */*.java
```

### 3. Run a specific module

Example (RSA):

```bash
java RSA.RSA
```

---

## Learning Outcomes

Through this project, I strengthened my understanding of:

* How modern encryption systems like RSA and AES work internally
* The mathematical foundations of cryptography
* Secure key generation techniques
* Implementation of classical ciphers for educational comparison
* Writing modular, reusable Java code

---

##  Future Improvements

* Add GUI for encryption/decryption
* Implement Diffie-Hellman key exchange
* Add file encryption support
* Improve AES implementation with padding modes
* Add unit testing (JUnit)



## Author

**Lisa Adisa Magada**


---

## 📄 License

This project is for educational purposes. Feel free to use and modify for learning.
