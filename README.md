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

---

### 👨‍⚕️ Doctor Module

| Method | Endpoint            | Description                                     |
|--------|---------------------|-------------------------------------------------|
| POST   | `/api/v1/doctors`   | Create a new doctor profile                    |
| GET    | `/api/v1/doctors`   | Retrieve all doctors                           |
| GET    | `/api/v1/doctors/{id}` | Get doctor details by ID                   |
| PUT    | `/api/v1/doctors/{id}` | Update doctor profile by ID                |
| DELETE | `/api/v1/doctors/{id}` | Delete a doctor profile by ID              |

---

### 📅 Appointment Module

| Method | Endpoint                 | Description                                       |
|--------|--------------------------|---------------------------------------------------|
| POST   | `/api/v1/appointments`   | Book a new appointment                            |
| GET    | `/api/v1/appointments`   | Get all appointments                              |
| GET    | `/api/v1/appointments/{id}` | Get specific appointment by ID                |
| PUT    | `/api/v1/appointments/{id}` | Update appointment details by ID             |
| DELETE | `/api/v1/appointments/{id}` | Cancel an appointment by ID                  |

---

### 💳 Billing Module

| Method | Endpoint               | Description                                         |
|--------|------------------------|-----------------------------------------------------|
| POST   | `/api/v1/bills`        | Generate a new bill for a patient                   |
| GET    | `/api/v1/bills`        | Retrieve all billing records                        |
| GET    | `/api/v1/bills/{id}`   | View bill details by ID                             |
| PUT    | `/api/v1/bills/{id}`   | Update billing info (e.g., status: paid/unpaid)     |
| DELETE | `/api/v1/bills/{id}`   | Delete a bill by ID                                 |

---

## 🚀 Tech Stack

- **Backend**: Java, Spring Boot, Spring Data JPA
- **Database**: H2 / MySQL (switchable)
- **API Style**: RESTful
- **Logging**: SLF4J + Logback
- **Build Tool**: Maven

---

## 📦 Sample Data (for Testing)

- **Patients**: 6 sample records
- **Doctors**: 4 sample records
- **Appointments**: Can be generated using patientId & doctorId
- **Bills**: Linked to patients with amount & payment status

---

## ✅ Actuator & Monitoring

Spring Boot Actuator is enabled:
application.properties:
management.endpoints.web.exposure.include=*
management.endpoint.health.show-details=always



Check status: http://localhost:8080/actuator/health



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
