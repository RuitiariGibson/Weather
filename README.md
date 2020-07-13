<h1 align="center">Weather Widget</h1>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>

</p>

<p align="center">  
Weather widget is a small desktop application based on the Repository and IOC (Inversion of Control)Pattern.<br>The application uses Dagger libary to achieve IOC. The application fetches data from the [MetaWeather] (https://www.metaweather.com/api/).
Then the data is displayed using JavaFx.
</p>
</br>

<p align="center">
<img src="https://github.com/RuitiariGibson/Weather/blob/master/art/main.png"/>
</p>



## Tech stack & Open-source libraries
- Java jdk 11
- Minimum JavaFx 14
- [RxJava+ RxJavaExtensions](https://reactives.io/) for asynchronous loading of the data from the internet.
- Dagger for dependency injection.
- Architecture
  - Repository pattern
  
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit) - construct the REST APIs and paging network data.
- [Gson](https://github.com/square/gson/) - A modern JSON library for Java.

- Views 
  - [JavaFx](https://openjfx.io/) - An open source client application platform for desktop and embedded systems.
  - [IkonliFontAwesome](https:kordamp.org/ikonli/) -A simple way to include emojis in your desktop applications.


## Architecture
Weather Widget is based on the repository pattern.



## Open API


MetaWeatherApi is used for constructiong using the [MetaWeatherApi](https://www.metaweather.com/api/) for constructing RESTful API.<br>
MetaWeather api provides a RESTful API interface to highly recent weather updates for various locations.

## Find this repository useful? :heart:
Support it by starring this repository. :star: <br>
Note: This repository is incomplete and may have bugs so for any issues (https://github.com/RuitiariGibson/Weather/issues)
And __[follow](https://github.com/RuitiariGibson/)__ me for my next creations! 🤩

##TODO
-Complete the tests
-Add dynamic location feature

# License
```xml
Designed and developed by 2020 Gibson Ruitiari (GibsonRuitiari@gmail.com)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
