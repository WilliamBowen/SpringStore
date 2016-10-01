SpringStore
=============
The purpose of this project is to project is to take the store project I created and redesign it using Spring and Hibernate. I also will be more thoroughly documenting this project, including the planning and design phases. I will be including design specifications, UI prototypes, etc. in an attempt to be as organized as possible.

Problem Domain
------------------

This project will use a browser based user interface using JSPs. I also want to use Bootstrap for styling the pages. The pages will consist of a home page, a cart, a checkout, a log-in, and a sign-up page. 

The home page will display items for sale in the store. There should be a way to search for items, as well as a way to add items to a cart. If the user is logged in, the home page should display the user's name. From the home page, the user should be able to access the login or sign up page and the cart, and if the user is signed in they should be able to log out. The user should be able to filter items by category. Categories will be determined by the database. 

On the cart page, the user should be able to access the home page, log out, sign in, or check out. The user should also be able to delete items from the cart, or edit the quantity of items. If the user attempts to check out and they are not logged in, they should be redirected to the log in page, after which they should be redirected to the checkout page.

Since this is a mock project with no real functionality, for now the checkout page will just confirm that the user has checked out all the items in their cart. 

The sign up page will allow the user to enter their name, email, username, password, and address to be saved in the database. After signing up, they will be redirected to the last page they visited before coming to the sign up or login page.

The login page will allow the user to log in using their username and password. A failed login attempt will refresh the page with a message. A successful login will take the user back to the last page they visited before logging in. 


I would like to use the MVC design pattern, Specifically I want to use SpringMVC. I will use servlets as my controllers. I would like to store information in a MySQL database. I want to use Hibernate to interact with the database.

