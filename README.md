# 🏥 Hospital Management System (HMS)

A comprehensive and modular Hospital Management System built with **Spring Boot**. It supports patient profile management, doctor profiles, appointment scheduling, and billing/payment processing with RESTful APIs.

---

## ✨ Features & Functionalities

### 1. **Patient Profile Management**
- Allows the management of patient profiles, including:
  - Personal information
  - Medical history
  - Current treatment plans

### 2. **Appointment Scheduling**
- Enables scheduling and rescheduling of appointments
- Automated notifications for both **patients** and **doctors**

### 3. **Billing and Payment Management**
- Streamlined billing and payment handling
- Automatic invoice generation
- Real-time payment tracking

---

## 🧩 Modules & API Endpoints

---

### 📘 Patient Module

| Method | Endpoint            | Description                                       |
|--------|---------------------|---------------------------------------------------|
| POST   | `/api/v1/patients`  | Create a new patient record                      |
| GET    | `/api/v1/patients`  | Retrieve a paginated list of all patients        |
| GET    | `/api/v1/patients/{id}` | Get a specific patient’s details by ID       |
| PUT    | `/api/v1/patients/{id}` | Update an existing patient’s details by ID  |
| DELETE | `/api/v1/patients/{id}` | Delete a patient’s record by ID             |


![image](https://github.com/user-attachments/assets/7d52d7c2-3806-4fcb-9e5a-568e0fbf5d1c)

---

### 👨‍⚕️ Doctor Module

| Method | Endpoint            | Description                                     |
|--------|---------------------|-------------------------------------------------|
| POST   | `/api/v1/doctors`   | Create a new doctor profile                    |
| GET    | `/api/v1/doctors`   | Retrieve all doctors                           |
| GET    | `/api/v1/doctors/{id}` | Get doctor details by ID                   |
| PUT    | `/api/v1/doctors/{id}` | Update doctor profile by ID                |
| DELETE | `/api/v1/doctors/{id}` | Delete a doctor profile by ID              |

![image](https://github.com/user-attachments/assets/231b42ef-f266-4588-a5bd-7b77a4f7e370)


---

### 📅 Appointment Module

| Method | Endpoint                 | Description                                       |
|--------|--------------------------|---------------------------------------------------|
| POST   | `/api/v1/appointments`   | Book a new appointment                            |
| GET    | `/api/v1/appointments`   | Get all appointments                              |
| GET    | `/api/v1/appointments/{id}` | Get specific appointment by ID                |
| PUT    | `/api/v1/appointments/{id}` | Update appointment details by ID             |
| DELETE | `/api/v1/appointments/{id}` | Cancel an appointment by ID                  |

![image](https://github.com/user-attachments/assets/2c5e34b8-8ca8-4eca-897b-414aca4b2b91)

---

### 💳 Billing Module

| Method | Endpoint               | Description                                         |
|--------|------------------------|-----------------------------------------------------|
| POST   | `/api/v1/bills`        | Generate a new bill for a patient                   |
| GET    | `/api/v1/bills`        | Retrieve all billing records                        |
| GET    | `/api/v1/bills/{id}`   | View bill details by ID                             |
| PUT    | `/api/v1/bills/{id}`   | Update billing info (e.g., status: paid/unpaid)     |
| DELETE | `/api/v1/bills/{id}`   | Delete a bill by ID                                 |

![image](https://github.com/user-attachments/assets/7e57588b-c728-49cb-9170-e5c6b3da6e6b)

---

## 🚀 Tech Stack

- **Backend**: Java, Spring Core , Spring Boot, Spring Data JPA
- **Database**:  MySQL WorkBench
- **API Style**: RESTful
- **Logging**: SLF4J 
- **Build Tool**: Maven

---

## 📦 Sample Data (for Testing)

- **Patients**: 6 sample records
- **Doctors**: 5 sample records
- **Appointments**: Can be generated using patientId & doctorId
- **Bills**: Linked to patients with amount & payment status

  ![image](https://github.com/user-attachments/assets/74f721d3-dadc-4633-a7de-36eabf4e2933)

  ![image](https://github.com/user-attachments/assets/f63e0a39-be76-4857-8481-8a20a8496e86)

  ![image](https://github.com/user-attachments/assets/d191df68-5c78-417a-a103-07e240857a4e)

  ![image](https://github.com/user-attachments/assets/d274d1c4-cb25-4233-8d9d-7c4c2bb4b964)





---

## ✅ Actuator & Monitoring

Spring Boot Actuator is enabled:
application.properties:
management.endpoints.web.exposure.include=*
management.endpoint.health.show-details=always


![image](https://github.com/user-attachments/assets/d2430c60-366a-4234-8afc-28959bbebd89)


Check status: http://localhost:8080/actuator/health


![image](https://github.com/user-attachments/assets/da3e92fb-563a-48f1-b076-01cb200a9dbd)




## 🧪 Future Enhancements

- 🔐 **JWT-Based Authentication**  
  Implement secure login systems for both patients and doctors using JSON Web Tokens (JWT), ensuring stateless authentication and enhanced session security.

- 🛡️ **Role-Based Access Control (RBAC)**  
  Define granular access rules and roles (e.g., admin, doctor, receptionist, patient) to ensure that users only access data and features relevant to their role.

- ✉️ **Email/SMS Notifications**  
  Integrate automated notifications for:
  - Appointment booking confirmations
  - Appointment reminders
  - Payment due alerts
  - Report availability

- 📊 **Admin Dashboard with Analytics**  
  Design and implement a real-time dashboard to visualize:
  - Daily appointments
  - Revenue reports
  - Patient inflow statistics
  - Doctor activity & workload metrics
