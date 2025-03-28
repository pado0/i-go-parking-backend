# Backend Boilerplate

### Tech Stack
![Spring](https://img.shields.io/badge/Spring-6DB33F?style=flat-square&logo=Spring&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=flat-square&logo=Kotlin&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=flat-square&logo=PostgreSQL&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=flat-square&logo=Docker&logoColor=white)

### Architecture
Used Hexagonal Architecture to loosen external dependencies and keep the domain clean.

<img src="hexagonal_architecture.png" width="700" alt="hexagonal architecture">


### Module Dependency
Used Multi Module to avoid incorrect dependencies.

<img src="module_dependency.png" width="500" alt="module dependency">

### DB
reader writer replication

### Api response format

### logger policy

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
- [ ] define controller response
- [ ] logger setting
- [ ] log masking
- [ ] exception setting
- [ ] ci/cd process setting
- [ ] package versioning
