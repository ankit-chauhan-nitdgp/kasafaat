# Address Module

## Overview
Manages multiple addresses per user, including geolocation. Each order is tied to a user address.

## Responsibilities
- Add/update/delete addresses.
- Mark one address as default.
- Store latitude/longitude for darkstore assignment.

## API Endpoints
- `POST /api/users/{id}/addresses` – Add address.
- `GET /api/users/{id}/addresses` – List addresses.
- `PUT /api/addresses/{id}` – Update address.
- `DELETE /api/addresses/{id}` – Delete address.

## Database
**user_addresses**
- id (PK)
- user_id (FK → users.id)
- label (Home, Office, etc.)
- address_line1
- address_line2
- city, state, pincode
- latitude, longitude
- is_default (boolean)  
