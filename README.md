
# ArHackathon  
A Basic Android project using [**Google Poly**](https://poly.google.com/) and [**ARCore**](https://developers.google.com/ar/discover/) made in a 2 hour Hackathon


## Project overview

This project was made as part of a hackathon in a extremely limited time and is intended to show the  use of [**ARCore**](https://developers.google.com/ar/discover/) on Android with the display of model from an online source. For this the app uses [**Google Poly API**](https://developers.google.com/poly/develop/api).

<img src="demo/demo_arhackathon.gif" height="500" alt="Ar Hackatron Demo gif"/>

Code for the display of the ARcore Elements has been sourced and edited from [Novoda](https://github.com/novoda/spikes).

## Architecture
### Libraries
- Kotlin
- RXjava 2 
- Timber
- OkHTTP / RetroFit / GSON
- ARCore

### Modules
This project is made of 3 core modules **BaseApp > Data > App**
- **BaseApp** 			(Base classes and Architecture)
- **Data** 				(API, data mangers and models)
- **App** 					(Activitys, layouts ,assest etc)

The code created for the project uses the MVP design Architecture

### Injection
Instead of using Dagger or alike a method of using Kotlin object and lazy loading objects has been implemented, see Data module arch package for implementation 

