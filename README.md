# Backend Boilerplate

### Tech Stack
![Spring](https://img.shields.io/badge/Spring-6DB33F?style=flat-square&logo=Spring&logoColor=white)
![REST API](https://img.shields.io/badge/REST%20API-005571?style=flat-square&logo=rest&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=flat-square&logo=Kotlin&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=flat-square&logo=PostgreSQL&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=flat-square&logo=Docker&logoColor=white)
![Ktlint](https://img.shields.io/badge/Ktlint-orange?style=flat-square&logoColor=white)


### Architecture
Used Hexagonal Architecture to loosen external dependencies and keep the domain clean.

<img src="hexagonal_architecture.png" width="700" alt="hexagonal architecture">


### Module Dependency
Used Multi Module to avoid incorrect dependencies.

<img src="module_dependency.png" width="500" alt="module dependency">

### DB Replication
reader writer replication

### API response format
The API response is defined based on JSON API(https://jsonapi.org/)
~~~
# single response sample
{
    "data": {
        "contentId": 1,
        "likedCount": 971
    }
}
~~~
~~~
# paged reponse sample
{
    "data": {
        "items": [],
        "prevLink": null,
        "nextLint": null,
    }
}
~~~

### logger policy
Used KotlinLogging to express logs concisely in a Spring-Kotlin stack.
Declared logger  outside the class to prevent unnecessary object creation when instantiating the class.
Optimized string operations using the lambda block format in logger.info {}.
~~~
private val logger = KotlinLogging.logger {}

class A {
    logger.info { "[Sample Log]" }
}
~~~

### exception convention

### Code format
<img src="ktlint_plugin.png" width="200" alt="module dependency">

install ktlint plugin in IntellJ and set Distract free & on save option
<img src="ktlint_setting.png" width="500" alt="module dependency">

### Todo List
- [x] gradle setting
- [x] architecture design
- [x] package naming
- [x] docker setting for init
- [x] jpa / db setting
- [x] mvc run check
- [x] lint setting
- [x] define controller response
- [ ] logger setting
- [ ] log masking
- [ ] exception setting
- [ ] ci/cd process setting
- [ ] package versioning
