# Getting started to Develop Your Secure Web Applications

## Overview
All applications must be developed with security in mind so that they do not introduce security vulnerabilities that are subject to security attacks. An attack may cause a stealth of user credential, loss of sensitive data, disruption of the service, and result in a severe damage to the business reputation and revenue.

This secure Java app helps Bluemix Liberty developers starts immediately to develop your secure Java applications that could avoid some common and dangerous security vulnerabilities: Cross-Site Scripting (XSS), Injection, and Directory Traversal.
			 
The BadSerlet.java is an example of insecure coding that may developers may do without care. The GoodServlet.java includes a number of good secure coding practices that prevent common security issues such as input validation, output encoding, secure Http Header settings, Content Security Policy. Using this application as a development starting point and applying the good coding practices to the new APIs, your applications will inherit and extend the necessary defense against these high risk security vulnerabilities and possible attacks.

Check out the Secure Coding Adviser (https://secure-coding-advisor.stage1.mybluemix.net/) for XSS lessons, the theory of XSS attacks and defense, and more bad-code vs good-code examples of XSS and other vulnerabilities. The Secure Coding Advisor will be made available to the Bluemix developers on Bluemix Public shortly. 

## Run the app on Bluemix or locally
	
You may download this starter application, build and deploy it on Bluemix or locally just the same way as you do with the get-started-java sample application - https://github.com/IBM-Bluemix/get-started-java						

## Code against other security vulnearbilities

In the next version, we intend to add more secure code to help the apps prevent other security vulnerabilities and attacks, such as session hijacking, cross-site request forgery, and SQL/command injections.

## Contribute

We are more than happy to accept external contributions to this project, be it in the form of issues and pull requests. If you find a bug or have a useful secure coding pattern to contribute, please report it via the Issues section or fork the project and submit a pull request with your fix or code change! Pull requests will be evaulated on an individual basis based on value add to the sample application.
