# Darkstore Module

## Overview
Darkstores are collection hubs where logistics partners deliver garbage bags.  
This module manages darkstore data and assignment.

## Responsibilities
- Store darkstore details and capacity.
- Find nearest darkstore using geo-coordinates.
- Assign orders to darkstores.

## API Endpoints
- `GET /api/darkstores/nearby?lat=..&lng=..` – Find nearest darkstore.
- `POST /api/darkstores` – Add new darkstore.
- `GET /api/darkstores/{id}` – Get darkstore details.

## Database
**darkstores**
- id (PK)
- name
- latitude, longitude
- capacity  
