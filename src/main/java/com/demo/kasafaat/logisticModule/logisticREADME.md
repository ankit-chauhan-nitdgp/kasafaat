# Logistics Module

## Overview
Integrates with third-party logistics providers for pickup and drop.

## Responsibilities
- Send shipment requests when order is created.
- Store logistics tracking ID.
- Receive real-time updates via webhook.
- Poll status periodically if webhooks are unavailable.

## API Endpoints
- `POST /api/logistics/webhook` – Receive status updates from partner.

## Data Flow
- Outbound: Shipment request (pickup, drop, package details).
- Inbound: Webhook or polling updates (PICKED_UP, IN_TRANSIT, DELIVERED).
