# Order Module

## Overview
Central domain module that manages the lifecycle of garbage pickup orders.

## Responsibilities
- Create pickup orders linked to user, address, and darkstore.
- Assign nearest darkstore automatically.
- Track order status and logistics tracking ID.

## API Endpoints
- `POST /api/orders` – Create order.
- `GET /api/orders/{id}` – Get order details.
- `GET /api/orders/{id}/status` – Get status.
- `GET /api/users/{id}/orders` – List orders for user.

## Database
**orders**
- id (PK)
- user_id (FK → users.id)
- address_id (FK → user_addresses.id)
- darkstore_id (FK → darkstores.id)
- bag_size (SMALL, MEDIUM, LARGE)
- scheduled_time
- status (SCHEDULED, IN_TRANSIT, COMPLETED)
- tracking_id (from logistics API)  
