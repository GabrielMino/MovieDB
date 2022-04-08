# MovieDB
This project has been developed as a technical test for a recruitment process. The objective is to build a movie API, in order to be consumed from the front end.
For the purpose of obtaining the information I have used https://www.themoviedb.org/.

The project is divided into three blocks:

1) Extract the information from the API and persist it in the Database through MYSQL.
To carry out this process: Spring Batch, through which a job can be scheduled. 
The steps of the job are: a) read the data from the api
                          b) proceess the data(convert Dto to an Entity)
                          c) persist in the database
Every time the app is restart the process rerun, so in order to stop the same the annotation (spring.batch.job.enabled=false), should be included in the application.proerties file.

2) Generate two endpoints that bring to front end 
  a) All the movies paginated, by default retuns first page and size 10
     http://localhost:8081/movies/

  Example of the request: JSON File
     {"pageNumber":1,
     "pageSize":10}

  b) Movies paginted filtered by different characteristics(This endpoint needs to be registred)
     http://localhost:8081/filtered/
     
     Boolean adult - filter Ifit  is an adult movie

     String overview - filter if a word/letter exists in the overview

     String year - filter by year of release

     String originalLanguage - filter by the original language of the movie

     String title - filter if a word/letter exists in the title

     Double popularity - filter if the popularity is grater than the select number

     Integer voteAverage - filter if the voteAverage is grater than the select number
    
   Example of the request: 
     {"pageNumber":1,
     "pageSize":10,
     "adult": false,     
     "overview": "kill", 
     "year":"",
     "originalLanguage":"en", 
     "title":"",  
     "popularity":6,
     "voteAverage":7}
     
 3) Security with JWT. 
    a) SignUp
    http://localhost:8081/signup/
    
    {"email":"admin@admin.com",
    "password":"123456"}
    
    b)SignIn
    http://localhost:8081/signin/
    
    {"email":"admin@admin.com",
    "password":"123456"}
    
    return a Bearer Token
    
    c) Use the Bearer token in postman to access to the filtered database
    
    d) To disable the authentication for filtering, in security/config/SecurityConfigurer.java in the column 38 insert "/filtered/"
    
    
   

  
   
  


