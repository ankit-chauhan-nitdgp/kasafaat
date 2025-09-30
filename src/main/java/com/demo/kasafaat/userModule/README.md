# User Module

## Overview
Handles user management and authentication.  
Authentication uses **DLT-based OTP**. After verification, backend issues **JWT** for session management.

## Responsibilities
- Register and login with phone number (OTP flow).
- Issue JWT tokens.
- Manage user profile (name, email, phone).

## API Endpoints
- `POST /api/users/signup` – Initiate OTP login/signup.
- `POST /api/users/verify-otp` – Verify OTP and return JWT.
- `GET /api/users/me` – Get profile of logged-in user.
- `PUT /api/users/me` – Update profile.

## Database
**users**
- id (PK)
- name
- phone
- email
- created_at
- updated_at  
