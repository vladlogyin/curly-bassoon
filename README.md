
![Logo](https://see.fontimg.com/api/renderfont4/L3L0n/eyJyIjoiZnMiLCJoIjo2NSwidyI6MTAwMCwiZnMiOjY1LCJmZ2MiOiIjMDAwMDAwIiwiYmdjIjoiI0ZGRkZGRiIsInQiOjF9/Q3VybHkgQmFzc29vbg/reactive-anchor.png)



#
Curly Bassoon is a full stacked Java Web API linked to the northwind database. This API runs on a Web Server allowing remote connections. This API allows you to 'Add', 'remove', 'update' elements within the database.



## Links

- localhost:8080/
- localhost:8080/employees/
- localhost:8080/orders/
- localhost:8080/customers/
- localhost:8080/product/


## Language

[![Java](https://img.shields.io/badge/l/java.svg?)](https://github.com/tterb/atomic-design-ui/blob/master/LICENSEs)
[![HTML](https://img.shields.io/badge/html.svg)](https://opensource.org/licenses/)
[![CSS](https://img.shields.io/badge/licensecss.svg)](http://www.gnu.org/licenses/agpl-3.0)


## Authors

- [@vlad](https://www.github.com/octokatherine)
- [@bart](https://www.github.com/octokatherine)
- [@kira-coke](https://www.github.com/octokatherine)
- [@dk](https://www.github.com/octokatherine)
- [@billie](https://www.github.com/octokatherine)
- [@toby](https://www.github.com/octokatherine)


## API Reference - Example

#### Get all employees

```http
  GET /employees/all
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api-type` | `string` | **Required**. Your Parameter |

#### Get specific item

```http
  GET /employee/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `integer` | **Required**. Id of employee to fetch |

## Features

- Full Web Server Browsing
- All Browser Support
- Security Checks
- Account logins


## Roadmap

- Full secure user accounts

- Add more testing & implementation


## Running Tests

To run tests, run the following package

```bash
  com.sparta.change_me
```


## Screenshots

![App Screenshot](https://cdn.discordapp.com/attachments/1002201069876686869/1004745985521635328/unknown.png)


## Usage/Examples

```java
import com.sparta.changeme

public static void main(String[] args) {
  // application.run()
}
```


## Support

For support, email support@spartaglobal.com.


