# Online Shopping Example with Microservices

## Requiremnent
### Micro Services:
- Customer Service:
    - Retrieve all Customers
    - Retrieve one Customer using Id.
    - Add Customer, When a customer is added, sales order service should also create a copy of the customer in it
    - Update Customer
    - Delete Customer
- Item Service:
    - Retrieve all Items
    - Retrieve one Item with Item Name.
    - Add Item
    - Update Item
    - Delete Item
- Sales Order Service:
    - Retrieve all Orders
    - Retrieve one Order with Order Id
    - Add Order
### Service Registry:
- All above services should Register them with this Registry
### API Gateway:
- All Services should be accessible with single gateway
### Configuration of the application should be centralized
