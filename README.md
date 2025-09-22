# JsonToCsvProject

## Project Overview
**JsonToCsvProject** is a Java application designed to read JSON files using **Gson** and convert them into CSV files using **OpenCSV**.  

This repository contains all deliverables for the current Sprint and is organized for easy review.

---

## Repository Structure

| Folder | Description |
|--------|-------------|
| `src/main/java/JsonReader/` | Main Java code for JSON reading and CSV writing.<br>- `JsonReader.java` → JSON parsing logic.<br>- `CsvWriter.java` → CSV writing logic. |
| `src/test/java/JsonReader/` *(tests branch)* | Unit and integration tests.<br>- `JsonReaderTest.java` → Tests JSON reading.<br>- `CsvWriterTest.java` → Tests CSV writing.<br>- `IntegrationTest.java` → Tests full JSON → CSV workflow. |
| `src/test/resources/` | Sample JSON files used for tests:<br>- `user.json` → Valid JSON.<br>- `empty.json` → Empty JSON.<br>- `invalid.json` → Malformed JSON. |
| `README.md` | Project documentation. |
| `.gitignore` | Files and folders excluded from Git. |

---

## Running the Project

### 1. Clone the repository
```bash
git clone https://github.com/yourUsername/JsonToCsvProject.git
cd JsonToCsvProject

2. Open and Build the Project

Open the project in your IDE and build it to compile the code and resolve dependencies.

3. Execute 

Run JsonReader.java and CsvWriter to process JSON and CSV conversion.

To change the input JSON file, modify the path in Main.java:

Map<?, ?> userData = JsonReader.readJson("src/test/resources/user.json");


To change the output CSV file:

CsvWriter.writeCsv("src/test/resources/user.csv", tempList);

Running Tests (Optional)

Unit tests are located in the tests branch. They validate the JSON reading and CSV writing functionality under different scenarios.

Steps:

Switch to the tests branch:

git checkout tests


Run the tests using your IDE or Maven:

mvn test


Notes:

Each test uses a separate JSON file in src/test/resources/ (user.json, empty.json, invalid.json).

All classes and methods are documented with JavaDoc.

The project is structured for easy maintenance and clear separation between production code and test code.


