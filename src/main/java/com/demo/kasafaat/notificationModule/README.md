# Notification Module

## Overview
Handles sending updates to users via push, SMS, or email.

## Responsibilities
- Push notifications via FCM.
- SMS via DLT-compliant gateway.
- Email via AWS SES.
- Triggered by order status changes.

## API Endpoints
- Internal only – triggered by events from OrderService.

## Database
**notifications**
- id (PK)
- user_id (FK → users.id)
- order_id (FK → orders.id)
- channel (PUSH, SMS, EMAIL)
- message
- status (SENT, FAILED)
- sent_at  
