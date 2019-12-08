# Medical Division PoC | Customer Base System (CBS)

### My Markdown Site
[TLabs-Streams](https://tstreams.netlify.com/)
---

### Overview
The system we will cover in this article is part of the Spring Framework :: A gentle introduction series. Specifically, in line with the PoC functionalities, we will develop the functionalities necessary to manage the customer base of our product.  

It manages the customer base: each user can be either a patient or a doctor or a service person in a doctor's office. Each user has an account to access the services provided by the system. Each account is provided with additional information that the system uses for the correct attribution of the services belonging to that particular user, both as a patient and medical staff.  

---
We are going to develop some business scenarios, even if simple, that will concern the following:  

- The registration of a generic user profile, intended by default as patient.
- Account activation for the first access to the system
- Access to the platform as a generic user that initiates the platform's verification of its profile as a doctor qualified to practice its profession.

The details of these three features will be discussed in detail in the next articles, also in terms of User Stories and Acceptance criteria

---

### Technical asset
It is a Spring Web Application deployed to Apache Tomcat as a WAR package.
The developed code is used to have a simple web application with the following topics, in according to actual articles provided by my personal web-site:
- Maven multi-modules Parent-Child Layout
- Spring 5 Web Application
- SOAP Web Services with Apache CXF
- Persistence with Hibernate/JPA
- Apache Tomcat
- PostgreSQL DB
- Docker/Docker-Compose project to manage Apache Tomcat Image and PostgreSQL DB

> Note: at this time in according to articles published, the application contains only SOAP Web Service definition and Docker/Docker-Compose for Tomcat

---
### Build and Run

#### First step

Clone the main project

```bash
git clone https://github.com/ant-giannone/tlabs-md-customer-base-sys
```

The **master branch** contains the merges of all other branches focused on a specific article published on my web-site
If you what view code for a specific articles, you only need to checkout on a specific branch


#### Final step

Open your console and position yourself in the project folder **tlabs-md-customer-base-sys**  

Type on console the following command and build all:

```bash
mvn clean package
```
---

**I hope I have done something pleasant!**
**Good code to all, see you next time...**
