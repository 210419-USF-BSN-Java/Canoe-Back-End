# Canoe Travel Application - Back-End #

## Overview ##
All the details of traveling can be difficult to plan and manage. Canoe is an application designed to streamline the process and reduce stress to help travelers enjoy their experience more fully. Users simply build a "Trip" in Canoe by moving through a guided sequence of steps and selecting flights, great places to eat, tourist attractions, and other points of interest from crowd-reviewed options. Upon arrival, users can then refer to Canoe to guide them on their daily activites and even add photos to help them remember and share their Trip with others.

### Getting Started ###
#### Clone the project to the local environment ####
git clone https://github.com/210419-USF-BSN-Java/Canoe-Back-End
#### To set up front end ####
https://github.com/210419-USF-BSN-Java/canoe-front
#### After cloning the project unzip the folder, set up database and import Canoe-Back-End folder to integrated development environment Eclipse/Intellij/Visual Studio ####
#### To set up project in Eclipse ####
File => Open Projects from File System => Directory </br>
choose the location for the project Canoe-Back-End </br>
Select Folder and Finish </br>
Go to src/main/resources </br>
open the application.properties file and change spring.datasource.url, spring.datasource.username, spring.datasource.password as database url, username and password of your database
#### After importing the project and changing DB credentials in properties.application file ####
Right click on project => Run As => Spring Boot APP </br>
In your browser paste the url http://localhost:8085/canoe-travel-app/signup

#### After Opening the application in browser ####
  ##### User #####
- User can signup
- User can login
- User can logout
- User can view homepage
- User can create a new trip
- User can add a destination to trip
- User can save flights to trip
- User can save lodging to trip
- User can save local food options
- User can save tourist attractions to trip
- User can upload and save photos to trip
- User can save/edit/delete/archive trip

##### Admin #####
- Admin can login
- Admin can view all Users
- Admin can freeze User account

## Technology Used ##
Java, Backend Programming Language </br>
HTML + CSS + TypeScript, Angular Frontend Programming Languages </br?
Spring Framewrok, Spring MVC, Spring Data Build Automation and DB Interactivity 
PostgreSQL, Relational Database Management System </br>
AWS RDS, Cloud Based Distributed Relational Database Service </br>
JUnit, Mockito, Unit Testing Framework </br>
Log4j, Logging Utility </br>

## Contributors ##
Thomas Dixon </br>
Felix Nguyen </br>
Aliaksei Ivanchyk </br>
Kevin Cho </br>
Acharya Deveraj 

## Stretch ##
System sends email confirmation of account creation (stretch?) </br>
Admin can view graphs of user data in dashboard </br>
User can upgrade account to premium with extra feature like Covid search, crime data </br>
System adds Amazon travel product search to banner </br>
System sends email confirmation during user signup process </br>
