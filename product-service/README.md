# Product Service - API Routes

Quick reference for the Product Service routes and example request bodies.

Base URL (example): http://localhost:8080

## Routes

- GET /products
  - Description: Return all products
  - Method: GET
  - Response: 200 OK — JSON array of product objects

- GET /products/getProduct/{id}
  - Description: Get a product by its id
  - Method: GET
  - Path param: `id` (integer)
  - Example: GET /products/getProduct/123
  - Responses:
    - 200 OK — product JSON
    - 404 Not Found — if no product with that id

- POST /products/addProduct
  - Description: Create a new product
  - Method: POST
  - Headers:
    - `Content-Type: application/json`
  - Required body fields (JSON):
    - `productID` (integer) — required
    - `name` (string)
    - `weight` (number)
  - Example JSON body:
    {
      "productID": 123,
      "name": "Example Widget",
      "weight": 1.75
    }
  - Responses:
    - 201 Created — returns saved product and Location header `/products/getProduct/{id}`
    - 400 Bad Request — missing product body or missing `productID`
    - 409 Conflict — product with same `productID` already exists

- DELETE /products/removeProduct/{id}
  - Description: Remove a product by id
  - Method: DELETE
  - Path param: `id` (integer)
  - Example: DELETE /products/removeProduct/123
  - Responses:
    - 204 No Content — deleted successfully
    - 404 Not Found — if no product with that id

---

This file is strictly a quick reference for using the API routes. For implementation details or server configuration, see the source files in this module.
