# Garbage Pickup System – Modular Monolith (Spring Boot)

## Table of Contents
- [Overview](#overview)
- [High-Level Architecture](#high-level-architecture)
- [Modules](#modules)
- [Order Lifecycle](#order-lifecycle)
- [AWS Deployment](#aws-deployment)
- [Authentication](#authentication)

---

## Overview
This application manages **garbage pickup scheduling** using **darkstores** and third-party **logistics partners**.  
It is built as a **modular monolith in Java Spring Boot**, deployable on **AWS ECS (Fargate)** with **RDS** and **CodePipeline** for CI/CD.

Users schedule pickups, third-party couriers transport garbage bags to darkstores, and the system tracks order status and notifies users in real-time.

---

## High-Level Architecture
- **Frontend**: Mobile app (customers) + Admin dashboard (darkstore management)
- **Backend**: Spring Boot modular monolith
- **Database**: AWS RDS (Postgres/MySQL)
- **Deployment**: AWS ECS Fargate + ALB + CodePipeline/CodeBuild
- **Notifications**: Push (FCM), SMS (DLT), Email (SES)
- **Logistics**: External API integration with webhook/polling support

---

## Modules
The backend is divided into functional modules for separation of concerns:

- [**User Module**](src/main/java/com/demo/kasafaat/userModule/README.md) – Authentication (DLT OTP), JWT sessions, profile management
- [**Address Module**](src/main/java/com/demo/kasafaat/addressModule/README.md) – Multiple addresses per user with geo-coordinates
- [**Darkstore Module**](src/main/java/com/demo/kasafaat/darkstoreModule/README.md) – Manage darkstores, capacity, and nearest-store assignment
- [**Order Module**](src/main/java/com/demo/kasafaat/orderModule/README.md) – Core order lifecycle, linking users, addresses, and darkstores
- [**Logistics Module**](src/main/java/com/demo/kasafaat/logisticsModule/README.md) – Integration with third-party logistics providers (APIs, webhooks, polling)
- [**Notification Module**](src/main/java/com/demo/kasafaat/notificationModule/README.md) – Push/SMS/Email alerts for order status updates
- [**Common Module**](src/main/java/com/demo/kasafaat/commonModule/README.md) – Shared code: JWT, error handling, configs

---

## Order Lifecycle
1. User creates order → chooses bag size, pickup time, and address
2. Backend assigns nearest darkstore using geo-coordinates
3. Backend sends shipment request to logistics partner → stores tracking ID
4. Logistics partner updates status (via webhook or periodic polling)
5. Order status updated in DB → Notification module sends push/SMS/email to user
6. Order completes when parcel delivered to darkstore

---

## AWS Deployment
- **ECS (Fargate)** – Runs backend container
- **RDS** – Stores relational data (postgreSQL)
- **Secrets Manager** – Holds DB credentials + API keys
- **ALB** – Routes traffic to ECS tasks
- **CloudWatch** – Logs & monitoring
- **CodePipeline + CodeBuild** – CI/CD pipeline for building and deploying Dockerized Spring Boot app

---

## Authentication
- **DLT OTP** for login/signup
- **JWT** issued after OTP verification for secure API calls

---
