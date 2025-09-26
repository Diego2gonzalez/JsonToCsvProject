# JsonToCsvProject

---

## Project Overview
**JsonToCsvProject** is a Java desktop application designed to **read JSON files** and **convert them into CSV files**.

The project uses **Gson** for JSON parsing and **OpenCSV** for CSV writing, ensuring a reliable and structured transformation process.


---

## Requirements and Compatibility

- **Java Version:** 17
- **Build Tool:** Maven
- **Dependencies:**
    - Gson (`com.google.gson`)
    - OpenCSV (`com.opencsv.CSVWriter`)
    - JUnit 5 (`org.junit.jupiter`)

---

## Repository Structure

| Folder | Description |
|--------|-------------|
| `src/main/java/JsonReader/` | Main Java code for JSON reading and CSV writing. <br> - `JsonReader.java` <br> - `CsvWriter.java` <br> - `Main.java` |
| `src/test/java/JsonReader/` | JUnit tests for validating JSON reading and CSV writing: <br> - `EmptyTest.java` <br> - `InvalidTest.java` |
| `src/test/resources/` | Sample JSON files for demonstration and testing: <br> - `empty.json` <br> - `invalid.json` <br> - `user.json` |

---

## Project Configuration

- Input and output file paths are entered via console when running `Main.java`.
- Example of configuring paths:


Enter JSON file path: src/test/resources/user.json
Enter CSV file path to save: src/test/resources/user.csv

- You can replace the paths with your own JSON files to test different data.

---

## JSON → CSV Conversion

### Step 1: Reading JSON
The program reads the JSON file using **Gson**.

- **Single object** → converted into a `Map<String,Object>`.
- **Array of objects** → each element converted into a `Map<String,Object>` and stored in a `List<Map<String,Object>>`.

**Algorithm (simplified):**
```text
if JSON is object:
    create a Map and add to List
else if JSON is array:
    for each element:
        convert element to Map
        add Map to List

Step 2: Writing CSV

Retrieve all keys from the first Map → these become the CSV headers.

For each Map in the list:

Iterate over the values in the same order as headers.

Convert each value to a string.

If the value is null, write an empty string "".

Write the headers and rows to a CSV file using OpenCSV.

Algorithm (simplified):

headers = keys from first Map
write headers to CSV

for each Map in List:
    row = []
    for each header:
        value = Map.get(header)
        if value is null: value = ""
        row.add(value)
    write row to CSV

Diagram of Flow (Textual)
JSON File
   │
   ▼
Read JSON with Gson
   │
   ▼
Convert to Map/List
   │
   ▼
Write CSV with OpenCSV
   │
   ▼
CSV File

Sample Input/Output

Input JSON (user.json):

[
  {"name": "Alice", "age": 28, "city": "Paris"},
  {"name": "Bob", "age": 32, "city": "Berlin"},
  {"name": "Charlie", "age": null, "city": "London"}
]


Generated CSV (user.csv):

name,age,city
Alice,28,Paris
Bob,32,Berlin
Charlie,,London

Error Handling

The program handles:

Invalid JSON → prints an error message and exits gracefully.

Empty JSON file → returns an empty list and prints a warning.

File not found → displays the file path error to the user.

This ensures robustness and reliable execution.

JUnit Testing

EmptyTest.java → validates that empty JSON files are handled correctly.

InvalidTest.java → validates that invalid JSON files are handled gracefully.

Tests cover:

JSON reading for objects and arrays.

CSV writing with correct headers and rows.

Consistency of data and error handling.

Run tests using Maven or IDE:

mvn test

Improvements from Previous Sprint

Implemented full JSON → CSV transformation logic.

Documented algorithm in README and supporting PDF.

Added JavaDoc comments for all classes and methods.

Validated program with sample JSON files including empty and invalid cases.

Added JUnit tests for automated verification of functionality.

References

Gson Documentation

OpenCSV Documentation

JUnit 5 Documentation

Notes

Input/output paths are entered via console prompt.

Algorithm handles arrays of objects and null values robustly.

Project structure separates production code and test resources for clarity.