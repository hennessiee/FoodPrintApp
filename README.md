# Food Print Android App

The objective of the application is to raise awareness regarding the adverse impact of pollution and emissions on the environment, particularly with regard to the selection of food items. The application aims to educate individuals about the significant role that their food choices play in contributing to environmental degradation and to encourage informed decision-making to mitigate this impact.




## Features

- Colorful and Eyecatching UI
- Fill in your own meals to get the emissions of the meals
- Calculation of the emissions from the meals
- Data backed by Research
- Realization of Emissions being used
- Randomly generated facts about Conscious Consumerism
- Available offline, no API calls used


## Installation

To build and run the application, you will need the following tools and libraries:

Android Studio 4.0 or higher
JDK 8 or higher
To install the application:

    1. Clone the repository from Gitlab.
    2. Open the project in Android Studio.
    3. Build the project using the Build menu.
    4. Run the application on an emulator or device.
## Usage

To use this app, you must install it first and run it in a virtual machine or your own Android phone. After that, follow these steps:

1. Select the main components of the meal that you ate or plan to eat.
2.  Fill in the approximate amount of each food item in grams, milliliters for protein and dairy, and pieces or portions for carbohydrates, vegetables, and fruits.
3.  Click the "Next" button, and the app will show insights about the meal you have submitted.e next button, and the app will show the insights about the meal you have submitted.
    
## FAQ

#### Where did we get the data for the emissions of each food item?

We did research on the web about emissions produced by different types of foods and encountered this website:

[Our World in Data]("https://ourworldindata.org/grapher/ghg-per-kg-poore")

From the website above we curated the most common food to use in our application


#### How does the calculation work?

We stored the CO2 and Water Emissions for each kilogram of food item, and calculated the total amount of Emissions by considering the input from the user for each food item.

The average car uses 0.19kg of CO2 per kilometer, so to get the equivalent distance of 1kg of CO2, we need to divide the Emissions amount by 0.19, so 1kg of CO2 is the same as driving a car for 5.2 Kilometers

As for the water, an average 10 minute shower uses about 90 Liters of water, so we just have to divide the Total Water Emissions by 0.11, so 18 Liters of water is the same as showering for 2 minutes.

#### Are the Facts Real?

Yes they are, and backed by research.

## Demo Video

[<img src="https://i.ytimg.com/vi/1XJBgydCXdI/maxresdefault.jpg" width="50%">](https://youtube.com/shorts/1XJBgydCXdI?feature=share
 "Food Print Demo Video")

## Authors

- [@nathanielravindra](https://git.fhict.nl/i477574)
- [@jordanphilbert](https://git.fhict.nl/i481132)


## Feedback

If you have any feedback, please email us at :
- Nathaniel: 477574@student.fontys.nl
- Jordan: 481132@student.fontys.nl


## Task Division

- [@nathanielravindra](https://git.fhict.nl/i477574):
    - Home Page Design
    - Data Storage
    - Emissions Calculation
    - Hardware use
    - Navigation between pages
    - Random Facts Generator
- [@jordanphilbert](https://git.fhict.nl/i481132)
    - Carbon Emissions Design
    - Water Emissions Design
    - Facts Design
    - Creation of GIFs
    - Template Design
