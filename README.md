# TopTrendingTweetsCommandLine

### Problem Statement:
  * Print top 10 trending tweets.

### Pre-requisties to execute:
  * Java JDK/JRE (8 &above).
  
 # Execution:
 * Instead of re-compiling the source code, I have provided a compiled java class (TweetMain.class) for simple exectuion.
   * **Command**: **java TweetMain** (if you have JRE already installed)
 
 * On execution above command user will be seeing following text in the console.
     * Please enter i/p tweet: 
     * {user-input-tweet} for ex: this is my first tweet #tweet [enter]
 * Output will be as below:  
       ` Below are Top 10 Trending Tweets`  
       ` ============================ `  
       ` #tweet  `  
       ` ============================  `  
       ` Please enter i/p tweet : `  
       ` this is my second tweet #newtweet `  
       ` Below are Top 10 Trending Tweets  `  
       `============================ `  
       ` #tweet   `  
       `#newtweet  `   
       ` ============================  `  
       `Please enter i/p tweet :  `  
       `{goes on...}`
 
   Inorder to exit from the application, press [ctrl + c]
 
       
 ### Improvements In future:        
 * Can expose this bussiness logic as REST API, GraphQL etc.,
 * Can include specific time duration to fetch top 10 trending tweets inthat time interval.
 
 ### Limitations:
 * Post Application shutdown, overall tweets data will be earsed, as we haven't integrated any persistent storage yet.
 
 
 
 
 
 
