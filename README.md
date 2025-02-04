# TwitterBot

A Java-based machine learning application designed to train an AI model capable of generating realistic tweets for a given account. The project leverages **Markov Chains**, **CSV file processing**, and Java's **BufferedReader** to create a fast and efficient tweet generation system.

## Features

- **AI-Powered Tweet Generation**  
  Trains an AI model using Markov Chains to generate realistic tweets based on input data.  

- **Fast Performance**  
  Generates ten custom 300-character tweets in under two seconds.

- **User Input/Output Support**  
  Processes user-provided CSV files containing tweet data and outputs generated tweets in a user-friendly format.

## Technical Details

- **Markov Chains** are used to model the probability of word sequences, enabling the generation of coherent and contextually relevant tweets.
- Java's **BufferedReader** is utilized for efficient reading of large CSV files.
- The system is designed for scalability, allowing rapid processing of large datasets.

## File Descriptions

- **FileLineIterator.java**  
  Implements an iterator for reading lines from a file, used for efficient CSV file parsing.

- **ListNumberGenerator.java**  
  Provides a number generator based on predefined lists, used in testing and debugging the Markov Chain logic.

- **MarkovChain.java**  
  Core implementation of the Markov Chain algorithm, responsible for training the AI model and generating tweet content.

- **NumberGenerator.java**  
  Defines an interface for generating random numbers, supporting modularity in randomization logic.

- **ProbabilityDistribution.java**  
  Models probability distributions for word transitions in the Markov Chain, ensuring realistic tweet generation.

- **RandomNumberGenerator.java**  
  Implements a random number generator, used to select words based on their probabilities in the Markov Chain.

- **TweetParser.java**  
  Parses input CSV files containing tweet data and prepares it for training the Markov Chain model.

- **TwitterBot.java**  
  The main class that integrates all components, trains the AI model, and generates tweets based on user input.

## How to Use

1. Clone this repository to your local machine:
git clone https://github.com/yourusername/TwitterBot.git
cd TwitterBot

2. Prepare a CSV file containing tweets from the desired Twitter account. Ensure that each line in the file represents one tweet.

3. Compile all `.java` files:
javac *.java

4. Run the `TwitterBot` program with your CSV file as input:
java TwitterBot path/to/your/tweets.csv

5. View the generated tweets in the console output. The program will generate ten custom tweets based on the input data.

6. Modify or extend functionality by editing any of the provided files as needed.

## Notes

This project was completed in November/December 2024. It demonstrates efficient use of machine learning techniques and Java programming to solve real-world problems.

