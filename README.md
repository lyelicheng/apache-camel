# Sample Camel-ActiveMQ-MyBatis-H2 Application

## Introduction

The Camel routes in MyRoute.java are configured to listen for messages from ActiveMQ and process them.

The H2 database is automatically initialized and used by the application for data storage.

## Prerequisites

### 1. Apache ActiveMQ Installation

#### macOS (Using Homebrew):
1. Install Apache ActiveMQ using Homebrew:
    ```
    brew install apache-activemq
    ```
2. Start ActiveMQ:
    ```
    brew services start activemq
    ```

#### Windows:
1. Download ActiveMQ distribution from https://activemq.apache.org/download.html
2. Extract the downloaded archive.
3. Navigate to the extracted directory and run the following command to start ActiveMQ:
   ```
   bin\activemq.bat start
   ```

After the installation, access the ActiveMQ admin console at http://localhost:8161
![ActiveMQ admin console](image/activemq-admin-console.png)

## Run the Application
```
mvn spring-boot:run
```