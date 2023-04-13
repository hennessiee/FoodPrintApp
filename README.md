# Food Print Android App

An application with a goal to spread awareness about Pollution and Emissions so people can realize that the food that they eat can cause major damage to the environment if not selected properly




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

[![Now in Android: 55]          // Title
(https://i.ytimg.com/vi/Hc79sDi3f0U/maxresdefault.jpg)] // Thumbnail
(https://www.youtube.com/watch?v=Hc79sDi3f0U "Now in Android: 55")    // Video Link

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
