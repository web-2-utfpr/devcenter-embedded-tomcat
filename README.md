[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://instaclone.herokuapp.com)
# Instaclone

A Java Web Application using Embedded Tomcat
This is a project developed in web 2 classes at UTFPR :)

## Requirements of the image publication application.

* login.
* list the contents.
* insert new contents.
* search for contents.

## Starting up

To start contributing, you can clone and use Netbeans to start the application on localhost.

```
$ git clone https://github.com/web-2-utfpr/instaclone.git
```
## Project Structure

```
instaclone/src/main/java/
          │             │
          │             └───launch
          │             │         main.java
          │             │
          │             └─── servlets
          │             |            UsuarioServlet.java
          │             │
          │             └─── model
          │             │   └───entities
          |             |   |           Usuario.java
          |             |   |
          │             │   └───services
                                      UsuarioService.java
          │             │
          │             └─── controller
          │                          UsuarioController.java
          │
          └───docs
          │       ddl.sql
          │       der.png
          │       diagrams...
           README.md
```
