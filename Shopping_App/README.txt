Problem statement uploaded.
To run the project use tomcat configuration as:
context path as: /
server port: as per your use (I have used 8000)

Assume: There is only one product and only one user(1)

There are a few packages in the project.
config package which contains all the configurations.
JSONPrettyPrintConfig: Configuration to intend the JSON output.
WebAllConfig: contains webApp configurations, enabled MVC and component scan
WebAppInitializer: Contains root config class, servlet config class, and servlet-mapping.
controller package contains RestController and is responsible for all the operations
model package which has all the classes or services

Links and operations:
1. Inventory 
	Display the default inventory: 	http://localhost:8000/shopping/inventory
	Change the order and availability: 	http://localhost:8000/shopping/inventory?ordered=10

2. Fetch Coupons: http://localhost:8000/shopping/fetchCoupons

3. Order
	Order 50 items and apply coupon OFF10 i.e. 10% discount: 	http://localhost:8000/shopping/1/order?qty=50&coupon=OFF10
	Order 10 items and apply coupon OFF5 i.e. 5% discount: 	http://localhost:8000/shopping/1/order?qty=10&coupon=OFF5

4. Pay
	Pay amount for orderId=100: 	http://localhost:8000/shopping/1/100/pay?amount=950
	Pay amount for orderId=101: 	http://localhost:8000/shopping/1/101/pay?amount=950

5. Display Order Details: http://localhost:8000/shopping/1/orders

6. Display Payment Record: http://localhost:8000/shopping/1/payments
